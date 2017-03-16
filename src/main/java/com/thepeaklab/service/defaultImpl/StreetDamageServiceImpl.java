package com.thepeaklab.service.defaultImpl;

import com.thepeaklab.persistence.model.entity.StreetDamage;
import com.thepeaklab.persistence.repository.StreetDamageRepository;
import com.thepeaklab.service.StreetDamageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created on 16/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Service
public class StreetDamageServiceImpl implements StreetDamageService {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    StreetDamageRepository streetDamageRepository;

    public StreetDamageServiceImpl(StreetDamageRepository streetDamageRepository) {
        this.streetDamageRepository = streetDamageRepository;
    }

    @Override
    @Async
    public void createStreetDamage(double lat, double lng) {


        if (isNewStreetDamage(lat, lng)) {
            log.info("createStreetDamage() - new street damage will be persisted!");
            StreetDamage damage = new StreetDamage(lat, lng, 1);
            streetDamageRepository.save(damage);
        } else {
            log.info("createStreetDamage() - street damage is already persisted!");
        }

    }

    private boolean isNewStreetDamage(double lat, double lng) {

        double meters = 50;

        double coef = meters * 0.0000089;
        double coef2 = -meters * 0.0000089;


        double max_lat = lat + coef;
        double max_lng = lng + coef / Math.cos(lat * 0.018);
        double min_lat = lat + coef2;
        double min_lng = lng + coef2 / Math.cos(lat * 0.018);

        List<StreetDamage> list = streetDamageRepository.findByLatBetweenAndLngBetween(min_lat, max_lat, min_lng, max_lng);
        boolean isNew = (list.size() == 0);

        return isNew;
    }
}
