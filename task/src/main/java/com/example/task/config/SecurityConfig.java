package com.example.task.config;

import static org.springframework.security.config.Customizer.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.task.service.UsersService;


@Configuration
@EnableMethodSecurity  // ← これで @PreAuthorize が使える
public class SecurityConfig {
	
	private final UsersService userDetailsService;
	
	public SecurityConfig(UsersService userDetailsService) {
	        this.userDetailsService = userDetailsService;
	    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // POSTテストを簡単にするため
            .authorizeHttpRequests(auth -> auth
            	.requestMatchers("/login", "/allTask", "/createTask").permitAll()//認証なしで大丈夫なパス
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults()); // ← フォームログインではなくBasic認証に変更
            //.formLogin(withDefaults());

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}admin123")  // {noop} は平文パスワード指定
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.withUsername("user")
//                .password("{noop}user123")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }
    
    
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    	
    	return configuration.getAuthenticationManager();
    }
    		
    
    //ログイ時に入力したパスワードをハッシュ化し、DBのデータと照合するための処理
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    
}

