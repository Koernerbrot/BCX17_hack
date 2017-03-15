package com.thepeaklab.service.defaultImpl;

import com.thepeaklab.service.VersionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * created on 15/03/2017
 *
 * @author David Reiher (dreiher23@gmail.com, dr@thepeaklab.com)
 */
@Service
public class VersionServiceImpl implements VersionService {

    @Value("${app.version}")
    private String appVersion;

    @Override
    public String getVersion() {
        return appVersion;
    }

}
