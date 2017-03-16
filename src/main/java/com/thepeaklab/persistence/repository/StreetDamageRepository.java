package com.thepeaklab.persistence.repository;

import com.thepeaklab.persistence.model.entity.Acceleration;
import com.thepeaklab.persistence.model.entity.StreetDamage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public interface StreetDamageRepository extends CrudRepository<StreetDamage, Long> {

    @Query("select sd from StreetDamage sd where sd.lat between ?1 and ?2 and sd.lng between ?3 and ?4")
    List<StreetDamage> findByLatBetweenAndLngBetween(double latMin, double latMax, double lngMin, double lngMax);

}
