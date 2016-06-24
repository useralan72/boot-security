package com.sagentia.controllers;

import com.sagentia.resource.GoldResource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by AE2 on 24/06/2016.
 */
@RestController
public class RootController {

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public ResourceSupport getRoot() {
        ResourceSupport resourceSupport = new ResourceSupport();
        Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if (roles.contains("GOLD")) {
            resourceSupport.add(linkTo(methodOn(GoldController.class).getGoldResource()).withRel("gold"));
        }
        if (roles.contains("SILVER")) {
            resourceSupport.add(linkTo(methodOn(SilverController.class).getSilverResource()).withRel("silver"));
        }
        return resourceSupport;
    }
}
