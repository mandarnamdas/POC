package com.nihilent.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

@Qualifier
@ApplicationScoped
@Retention(RetentionPolicy.RUNTIME)
@Target({
    ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD
})
public @interface InjectString {

    @Nonbinding
    String key();
}
