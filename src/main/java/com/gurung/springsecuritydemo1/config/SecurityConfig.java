package com.gurung.springsecuritydemo1.config;

import com.gurung.springsecuritydemo1.security.HeroPasswordEncoderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author bir
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> {
                    authorize.antMatchers(HttpMethod.GET, "/hello/get-hello", "/hello/get-hello-message/**").permitAll();
//                            .mvcMatchers(HttpMethod.GET,"/hello/get-hello-message/{message}").permitAll();
                })
                .authorizeRequests((requests) -> {
                    ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) requests.anyRequest()).authenticated();
                });
        http.formLogin();
        http.httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return HeroPasswordEncoderFactory.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("spring")
                .password("{bcrypt}$2a$10$6i5O6kxrGsJ8kpz6poTQkuTSfhl9tGD3Gv1AnXVi1aV/bmHRsYRDi")
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("{sha256}15291425bffe8e1157c10da0b64c290ae19954de25d676efb5ffe31ce2ce9ef81ed695b8d29816bd")
                .roles("USER")
                .and()
                .withUser("scott")
                .password("{ldap}{SSHA}wfhNrs1yQANKWhOwGAsSIpC0xwXkHfvKmHQ91Q==")
                .roles("CUSTOMER");
    }
    //    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("spring")
//                .password("boot")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }
}
