package ca.n4dev.collector.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

/**
 *
 * SecurityConfiguration.java
 * TODO(rguillemette) Add description.
 *
 * @author shaika-dzari
 * @since 2.0.0 - Jul 10 - 2019
 *
 */
@Configuration
@EnableWebSecurity
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Bean
    override fun userDetailsService() : UserDetailsService {
        // ensure the passwords are encoded properly
        var users = User.withDefaultPasswordEncoder()
        var manager = InMemoryUserDetailsManager()

        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());

        return manager;
    }

    override fun configure( http: HttpSecurity) : Unit {

        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .httpBasic()
    }


}