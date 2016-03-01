package com.nihilent.common;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class InjectStringService {

    @Produces
    @InjectString(key = "")
    public String getKeyValue(InjectionPoint ip) {
        InjectString injectString = ip.getAnnotated().getAnnotation(InjectString.class);
        String key = injectString.key();
        if (key.equals("1")) {
            return "Hi Mandar";
        } else {
            return "Wrong key";
        }
    }
}
