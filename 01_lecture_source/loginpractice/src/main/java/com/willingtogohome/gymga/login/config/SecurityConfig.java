package com.willingtogohome.gymga.login.config;

import com.willingtogohome.gymga.login.common.UserRole;
import com.willingtogohome.gymga.login.config.handler.AuthFailHandler;
import com.willingtogohome.gymga.login.config.handler.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;
    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    /* 비밀번호 암호화에 사용할 객체 BCryptPasswordEncoder bean 등록 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        /* 요청에 대한 권한 체크 */
        http.authorizeHttpRequests( auth -> {
            auth.requestMatchers("/login/auth/login", "/login/auth/regist", "/login/auth/fail", "/", "/main", "/login").permitAll();
            auth.requestMatchers("/admin/*").hasAnyAuthority(UserRole.ADMIN.getRole());
            auth.requestMatchers("/user/*").hasAnyAuthority(UserRole.USER.getRole());
            auth.anyRequest().permitAll();

        }).formLogin( login -> {
            login.loginPage("/login/auth/login");
            login.usernameParameter("userId");
            login.passwordParameter("userPwd");
            login.defaultSuccessUrl("/", true);
            login.successHandler(authSuccessHandler);
            login.failureHandler(authFailHandler);

        }).logout( logout -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"));
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            logout.logoutSuccessUrl("/");

        }).sessionManagement( session -> {
            session.maximumSessions(1);
            session.invalidSessionUrl("/");

        }).csrf( csrf -> csrf.disable());

        return http.build();
    }
}
