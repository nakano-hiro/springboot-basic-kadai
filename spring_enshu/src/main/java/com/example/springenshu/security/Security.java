package com.example.springenshu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class Security {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()); // POSTテストを簡単にするため
//            .authorizeHttpRequests(auth -> auth
//            	.requestMatchers("/login", "/allTask", "/createTask").permitAll()//認証なしで大丈夫なパス
//                .anyRequest().authenticated()
//            )
//            .httpBasic(withDefaults()); // ← フォームログインではなくBasic認証に変更
//            //.formLogin(withDefaults());

        return http.build();
    }

}
