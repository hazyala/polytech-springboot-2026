package pollytech.aisw._026example.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    // 암호화 설정
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 사용자 정보 등록 설정
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.builder()
                .username("guest")
                .password(passwordEncoder().encode("g1234"))
                .roles("USER")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password(passwordEncoder().encode("m1234"))
                .roles("MANAGER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("a1234"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, manager, admin);
    }

    // 특정 URI에 접근할 수 있는 접근 권한 설정
    @Bean
    SecurityFilterChain examMethod01(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/exam10_01/member/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/exam10_01/manager/**").hasRole("MANAGER")
                        .requestMatchers("/exam10_01/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
        ).formLogin(
                formLogin -> formLogin
                        .loginPage("/exam10_01/exam05")
                        .loginProcessingUrl("/exam10_01/exam05")
                        .defaultSuccessUrl("/exam10_01/admin/")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .failureForwardUrl("/exam10_01/loginfailed")
                )
        //로그아웃 설정
        .logout(logout -> logout
                        .logoutUrl("exam10_1/logout")
                        .logoutSuccessUrl("/exam10_01/exam05")
                );

        return http.build();
    }
}
