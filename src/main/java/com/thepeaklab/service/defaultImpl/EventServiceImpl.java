package com.thepeaklab.service.defaultImpl;

import com.thepeaklab.persistence.model.entity.Device;
import com.thepeaklab.persistence.model.entity.Event;
import com.thepeaklab.persistence.model.entity.EventValue;
import com.thepeaklab.persistence.model.entity.VehicleState;
import com.thepeaklab.persistence.model.enums.EventType;
import com.thepeaklab.persistence.repository.DeviceRepository;
import com.thepeaklab.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * created on 16/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Service
public class EventServiceImpl implements EventService {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    DeviceRepository deviceRepository;

    public EventServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Event> checkPastDataForEvents(Device device, int valuesToCheck) {

        int valuesToAvg = 50;
        double w = 0.4;

        List<Event> events = new ArrayList<>();

        if (device == null) throw new InvalidParameterException();

        List<VehicleState> sortedStates = device.getStates();

        sortedStates.sort((s1, s2) -> s1.getCreatedDate().after(s2.getCreatedDate()) ? -1 : 1);

        if (sortedStates.size() > valuesToAvg) {
            for (int j = 0; j < valuesToCheck; j++) {

                List<VehicleState> states = sortedStates.subList(j, valuesToAvg + j);

                // CALCULATE THE EXPONENTIAL WEIGHTED AVERAGE
                // weight of last value
                double sf = (double) 2 / ((double) (valuesToAvg + 1));
                // moving average
                double ma = 0;

                for (int i = 1; i < valuesToAvg; i++) {
                    VehicleState state = states.get(i);
                    ma += state.getAcceleration().getY();
                }
                ma = ma / valuesToAvg - 1;

                // exponential moving average
                double ema = ma + (sf * (states.get(0).getAcceleration().getY() - ma));

                // CALCULATE THE VARIANCE
                double emaSum = 0;
                for (int i = 0; i < valuesToAvg; i++) {
                    VehicleState state = states.get(i);
                    emaSum += Math.pow(state.getAcceleration().getY() - ema, 2);
                }
                double v = emaSum / valuesToAvg;

                // standard deviation
                double sd = Math.sqrt(v);
                sd *= 2.75;

                log.info("sf=" + sf + " ma=" + ma + " ema=" + ema + " sd=" + sd + " ema+sd=" + (ema + sd));
                log.info("acc z = " + states.get(0).getAcceleration().getY());
                log.info((ema + sd) < states.get(0).getAcceleration().getY() || (ema - sd) > states.get(0).getAcceleration().getY() ? "true" : "false");
                // add raod bump event if value is over or under the average +/- the standard deviation

                boolean eventHappened = ((ema + sd) < states.get(0).getAcceleration().getY()) || ((ema - sd) > states.get(0).getAcceleration().getY());

                if (eventHappened) {
                    events.add(new Event(EventType.ROAD_BUMP, new EventValue(states.get(0).getPositionLat(), states.get(0).getPositionLng())));
                }
            }

            events.forEach(device::addEvent);
            deviceRepository.save(device);

        }
        return events;
    }
}


