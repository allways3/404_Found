package com.multi.travel_404.config;

import com.multi.travel_404.authenication.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final CustomUserDetailService customUserDeatilService;

    @Autowired
    public SpringSecurityConfig(CustomUserDetailService customUserDeatilService) {
        this.customUserDeatilService = customUserDeatilService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer configure() {
        return (web -> web.ignoring().requestMatchers("/static/**"));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        Map<String, List<String>> permitMap = customUserDeatilService.getPermitListMap();
        List<String> adminList = permitMap.get("adminPermitList");
        List<String> memberList = permitMap.get("memberPermitList");


        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizenHttpRequest -> authorizenHttpRequest
//                        .requestMatchers("/menu/**").authenticated()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("order/**").hasAnyRole("ADMIN", "USER")
//                        .anyRequest().permitAll()

                        .requestMatchers(adminList.toArray(new String[adminList.size()])).hasRole("ADMIN")
                        .requestMatchers(memberList.toArray(new String[memberList.size()])).hasAnyRole("ADMIN", "USER")
                        .anyRequest().permitAll()))
                .formLogin(form -> form
                        .loginPage(("/member/login"))
                        .defaultSuccessUrl("/", true)
                        .failureForwardUrl("/error/login"))
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .logoutSuccessUrl("/"))
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/error/errorPage"));

        return http.build();
    }


}
