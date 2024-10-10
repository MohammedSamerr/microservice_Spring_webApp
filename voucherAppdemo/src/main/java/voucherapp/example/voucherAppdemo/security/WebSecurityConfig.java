package voucherapp.example.voucherAppdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic();
        http.authorizeRequests()
                 .requestMatchers(HttpMethod.GET,"/voucherApi/vouchers/**")
                 .hasAnyRole("USER","ADMIN")
                 .requestMatchers(HttpMethod.POST,"/voucherApi/vouchers")
                 .hasRole("ADMIN").and()
                 .esrf().disable();
                 return null;
    }
}
