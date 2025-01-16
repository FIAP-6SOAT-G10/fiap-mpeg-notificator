package br.com.fiap.mpeg.notificator.infra.config;

import br.com.fiap.mpeg.notificator.application.gateways.IEmailRepository;
import br.com.fiap.mpeg.notificator.application.usecases.EmailSenderUseCase;
import br.com.fiap.mpeg.notificator.infra.entrypoints.queue.EmailQueueListener;
import br.com.fiap.mpeg.notificator.infra.gateways.EmailRepository;
import br.com.fiap.mpeg.notificator.infra.mapper.EmailFileMapper;
import br.com.fiap.mpeg.notificator.infra.mapper.EmailRequestMapper;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class EmailConfig {

    @Bean
    public IEmailRepository buildEmailRepository(JavaMailSender mailSender) {
        return new EmailRepository(mailSender);
    }

    @Bean
    public EmailSenderUseCase buildEmailSenderUseCase(IEmailRepository emailRepository) {
        return new EmailSenderUseCase(emailRepository);
    }

    @Bean
    public EmailRequestMapper buildEmailRequestMapper(EmailFileMapper emailFileMapper) {
        return new EmailRequestMapper(emailFileMapper);
    }

    @Bean
    public EmailFileMapper buildEmailFileMapper() {
        return new EmailFileMapper();
    }

    @Bean
    public EmailQueueListener buildEmailQueueListener(EmailSenderUseCase emailSenderUseCase, EmailRequestMapper emailRequestMapper, Validator validator) {
        return new EmailQueueListener(emailSenderUseCase, emailRequestMapper, validator);
    }
}
