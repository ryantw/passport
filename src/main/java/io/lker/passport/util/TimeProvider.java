package io.lker.passport.util;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeProvider {
    public static Date now(){
        return new Date();
    }
}
