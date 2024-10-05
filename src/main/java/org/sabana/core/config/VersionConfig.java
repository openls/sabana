package org.sabana.core.config;

import org.sabana.core.entity.ApplicationVersion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class VersionConfig {
    @Value("${project.version}")
    private String version;
    @Value("${project.version.name}")
    private String name;
    @Value("${project.version.build_date}")
    private String buildDate;
    @Value("${project.version.build_time}")
    private String buildTime;

    @Bean
    public ApplicationVersion appVersion() {
        return ApplicationVersion.newInstance()
            .withVersion(version)
            .withName(name)
            .withBuildDate(buildDate)
            .withBuildTime(buildTime);
    }
}
