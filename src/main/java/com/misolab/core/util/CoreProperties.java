package com.misolab.core.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component
@PropertySources({
        @PropertySource("classpath:/core.properties"),
        @PropertySource(value = "classpath:/core-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
@ConfigurationProperties("core")
public class CoreProperties {

    String sample;

    @Value("${ldap.providerUrl}")
    String PROVIDER_URL;

    @Value("${ldap.principal}")
    String PRINCIPAL;

}
