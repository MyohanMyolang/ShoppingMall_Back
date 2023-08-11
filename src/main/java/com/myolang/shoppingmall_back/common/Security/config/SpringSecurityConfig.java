package com.myolang.shoppingmall_back.common.Security.config;

import com.myolang.shoppingmall_back.Member.entity.MemberRole;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {

  @Bean
  @ConditionalOnMissingBean(UserDetailsService.class)
  InMemoryUserDetailsManager inMemoryUserDetailsManager() {
    String generatedPassword = "test";
    return new InMemoryUserDetailsManager(User.withUsername("user").password(generatedPassword)
      .roles(MemberRole.LoginUser.getRoleName()).build());
  }

  @Bean
  @ConditionalOnMissingBean(AuthenticationEventPublisher.class)
  DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(ApplicationEventPublisher delegate) {
    return new DefaultAuthenticationEventPublisher(delegate);
  }
}
