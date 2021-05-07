package api.my_market_advisory_security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class GatewaySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails adminUSer = User.withUsername("admin").password(encoder().encode("admin123"))
                .authorities("FULL_PRIVILEGES")
                .roles("ADMIN").build();
        UserDetails regularUser = User.withUsername("aryn").password(encoder().encode("interesting123"))
                .authorities("USER_PRIVILEGES")
                .roles("USER").build();
        manager.createUser(adminUSer);
        manager.createUser(regularUser);

        return manager;
    }

    private PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").hasAnyRole("USER", "ADMIN")
                .antMatchers("/dashboard").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .defaultSuccessUrl("/dashboard", false);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(userDetailsService().loadUserByUsername("admin")).passwordEncoder(encoder());
        auth.inMemoryAuthentication().withUser(userDetailsService().loadUserByUsername("aryn")).passwordEncoder(encoder());
    }
}
