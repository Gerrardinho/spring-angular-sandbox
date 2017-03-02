package org.luger.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

/**
 * Created by gerardo8.
 */
@EnableWebSecurity
class SecurityConfig {

    @Configuration
    @Order(Ordered.HIGHEST_PRECEDENCE)
    class AppSecurityConfig : WebSecurityConfigurerAdapter() {

        @Throws(Exception::class)
        override fun configure(http: HttpSecurity) {
            http
                    .httpBasic()
                        .and()
                    .authorizeRequests()
                        .antMatchers("/assets/*", "/", "/login", "/register").permitAll()
                        .antMatchers("/api/users/{userId}").access("@authz.check(#userId,principal)")
                        .anyRequest().hasRole("USER")
                        .and()
                    .csrf()
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        }

    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}