package com.java_springboot.configs;

import org.springframework.context.annotation.Configuration;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorAwareImplConfig implements AuditorAware<String>  {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System User Example");
    }
}