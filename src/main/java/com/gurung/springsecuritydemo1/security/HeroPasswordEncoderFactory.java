package com.gurung.springsecuritydemo1.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;

import java.util.HashMap;
import java.util.Map;

public class HeroPasswordEncoderFactory {

    public static PasswordEncoder createDelegatingPasswordEncoder() {
        String encodingId = "bcrypt";
        String endoing15id="bcryptNew";
        Map<String, PasswordEncoder> encoders = new HashMap();
        encoders.put(encodingId, new BCryptPasswordEncoder());
        encoders.put(endoing15id, new BCryptPasswordEncoder(15));
        encoders.put("ldap", new LdapShaPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("sha256", new StandardPasswordEncoder());
        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

    // don't instantiate class
    private HeroPasswordEncoderFactory() {
    }
}
