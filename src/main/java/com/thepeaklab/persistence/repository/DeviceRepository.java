package com.thepeaklab.persistence.repository;

import com.thepeaklab.persistence.model.entity.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public interface DeviceRepository extends CrudRepository<Device, Long> {

    Optional<Device> findByUuid(String uuid);

}
