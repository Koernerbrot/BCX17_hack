package com.thepeaklab.web.controller;

import com.thepeaklab.service.VersionService;
import com.thepeaklab.web.dto.VersionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@RestController
@RequestMapping("/app")
public class AppController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    VersionService versionService;

    public AppController(VersionService versionService) {
        this.versionService = versionService;
    }

    @GetMapping("/version")
    @ResponseStatus(HttpStatus.OK)
    public VersionDto getVersion() {

        log.info("getVersion() - API path /app/version called");
        return new VersionDto(this.versionService.getVersion());

    }

}
