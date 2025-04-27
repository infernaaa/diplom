package com.example.diplom_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize

                        // Общедоступные эндпоинты
                        .requestMatchers("/**").permitAll()

                        // Эндпоинты только для пользователей
                        .requestMatchers("/user/**").hasRole("USER")

                        // Эндпоинты только для админов
                        .requestMatchers("/**").hasRole("ADMIN")

                        // Все остальные запросы требуют аутентификации
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", false)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    // Если вы используете базу данных, замените этот бин на свою реализацию UserDetailsService
    @Bean
    public UserDetailsService userDetailsService() {
        // Админ (одна учетка)
        UserDetails admin = User.builder()
                .username("postgres")
                .password(passwordEncoder().encode("0000")) // замените на реальный пароль
                .roles("ADMIN")
                .build();

        // Пример пользователя (в реальном приложении пользователи будут загружаться из БД)
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("userPassword")) // замените на реальный пароль
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}