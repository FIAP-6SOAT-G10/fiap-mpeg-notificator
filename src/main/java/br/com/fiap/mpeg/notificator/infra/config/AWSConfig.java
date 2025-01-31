package br.com.fiap.mpeg.notificator.infra.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    static {
        System.setProperty("aws.region", "us-east-1");
    }

}
