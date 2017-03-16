package com.thepeaklab.service.defaultImpl;

import com.thepeaklab.persistence.model.entity.Acceleration;
import com.thepeaklab.persistence.model.entity.Device;
import com.thepeaklab.persistence.model.entity.VehicleState;
import com.thepeaklab.persistence.repository.DeviceRepository;
import com.thepeaklab.persistence.repository.VehicleStateRepository;
import com.thepeaklab.service.DeviceService;
import com.thepeaklab.service.VersionService;
import com.thepeaklab.web.dto.SensorDataDto;
import com.thepeaklab.web.dto.SensorDataListDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    DeviceRepository deviceRepository;

    VehicleStateRepository vehicleStateRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository, VehicleStateRepository vehicleStateRepository) {
        this.deviceRepository = deviceRepository;
        this.vehicleStateRepository = vehicleStateRepository;
    }

    @Override
    @Transactional
    public Device createDevice(String uuid) {

        if (deviceRepository.findByUuid(uuid).isPresent()) throw new EntityExistsException();

        Device device = new Device(uuid);
        device = deviceRepository.save(device);

        return device;
    }

    @Override
    @Transactional
    public Device addSensorData(String uuid, SensorDataListDto listDto) {

        Device device = this.deviceRepository.findByUuid(uuid).orElseThrow(EntityNotFoundException::new);
        List<VehicleState> states = device.getStates();

        for (SensorDataDto dto : listDto.getList()) {
            Acceleration acceleration = new Acceleration(dto.getAccelerationX(), dto.getAccelerationY(), dto.getAccelerationZ());
            VehicleState vehicleState = new VehicleState(dto.getPositionLat(), dto.getPositionLng(), dto.getSpeed(), dto.getHeading(), acceleration);
            states.add(vehicleState);
        }

        device.setStates(states);

        return deviceRepository.save(device);
    }
}
