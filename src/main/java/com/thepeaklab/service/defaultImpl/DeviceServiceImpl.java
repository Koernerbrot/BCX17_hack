package com.thepeaklab.service.defaultImpl;

import com.thepeaklab.persistence.model.entity.Device;
import com.thepeaklab.persistence.repository.DeviceRepository;
import com.thepeaklab.service.DeviceService;
import com.thepeaklab.service.VersionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device createDevice(String uuid) {

        if (deviceRepository.findByUuid(uuid).isPresent()) throw new EntityExistsException();

        Device device = new Device(uuid);
        device = deviceRepository.save(device);

        return device;
    }
}
