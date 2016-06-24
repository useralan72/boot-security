package com.sagentia.controllers;

import com.sagentia.resource.SilverResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AE2 on 24/06/2016.
 */
@RestController
public class SilverController {

    @RequestMapping(value = "/silver", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ROLE_SILVER')")
    public SilverResource getSilverResource() {
        SilverResource silverResource = new SilverResource();
        return silverResource;
    }
}
