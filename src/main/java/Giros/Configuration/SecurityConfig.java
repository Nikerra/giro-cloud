package Giros.Configuration;

import Giros.dao.Entity.User;
import Giros.dao.Repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService uds (UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        (authorize) -> authorize
                                .requestMatchers(new AntPathRequestMatcher("/design", "/orders")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/register")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/*.css")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/*.jpg")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/*.png")).permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/"));
        return http.build();
    }
}
