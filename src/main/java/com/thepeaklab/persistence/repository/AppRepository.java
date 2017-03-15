package com.thepeaklab.persistence.repository;

import com.thepeaklab.persistence.model.entity.App;
import org.springframework.data.repository.CrudRepository;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
public interface AppRepository extends CrudRepository<App, Long> {


}
