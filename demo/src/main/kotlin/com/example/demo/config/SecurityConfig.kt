//package com.example.demo.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//
//
//@Configuration
//@EnableWebSecurity
//class SecurityConfig : WebSecurityConfigurerAdapter() {
//    @Throws(Exception::class)
//    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth
//                .inMemoryAuthentication()
//                .withUser("minholee93").password(passwordEncoder().encode("minholee93")).roles("ADMIN")
//                .and()
//                .withUser("minholee").password(passwordEncoder().encode("minholee")).roles("USER")
//    }
//
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//    }
//
//    @Bean
//    fun passwordEncoder(): PasswordEncoder {
//        return BCryptPasswordEncoder()
//    }
//}