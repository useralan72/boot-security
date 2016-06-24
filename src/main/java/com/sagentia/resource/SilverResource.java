package com.sagentia.resource;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by AE2 on 24/06/2016.
 */
public class SilverResource extends ResourceSupport{

    private String name;

    public String getName() {
        return name;
    }
}
