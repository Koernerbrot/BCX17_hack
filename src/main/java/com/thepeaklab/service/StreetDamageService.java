package com.thepeaklab.service;

import org.springframework.scheduling.annotation.Async;

/**
 * created on 16/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public interface StreetDamageService {

    @Async
    void createStreetDamage(double lat, double lng);

}
