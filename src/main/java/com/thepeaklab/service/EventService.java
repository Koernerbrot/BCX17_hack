package com.thepeaklab.service;

import com.thepeaklab.persistence.model.entity.Device;
import com.thepeaklab.persistence.model.entity.Event;

/**
 * created on 16/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public interface EventService {

    Event checkPastDataForEvents(Device device);
}
