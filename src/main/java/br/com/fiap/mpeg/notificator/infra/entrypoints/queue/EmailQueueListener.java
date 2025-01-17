package br.com.fiap.mpeg.notificator.infra.entrypoints.queue;

import br.com.fiap.mpeg.notificator.application.usecases.EmailSenderUseCase;
import br.com.fiap.mpeg.notificator.infra.entrypoints.queue.model.EmailRequestDTO;
import br.com.fiap.mpeg.notificator.infra.mapper.EmailRequestMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;
import jakarta.validation.Validator;

import java.util.Set;

@Component
public class EmailQueueListener {

    private final EmailSenderUseCase emailSenderUseCase;
    private final EmailRequestMapper emailRequestMapper;
    private final Validator validator;

    public EmailQueueListener(EmailSenderUseCase emailSenderUseCase, EmailRequestMapper emailRequestMapper, Validator validator) {
        this.emailSenderUseCase = emailSenderUseCase;
        this.emailRequestMapper = emailRequestMapper;
        this.validator = validator;

    }

    @SqsListener("${aws.sqs.order-payment-updates-queue}")
    public void listen(EmailRequestDTO emailRequestDTO) {
        Set<ConstraintViolation<EmailRequestDTO>> violations = validator.validate(emailRequestDTO);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException("Validation failed", violations);
        }

        emailSenderUseCase.sendSimpleMail(emailRequestMapper.fromDTOToDomain(emailRequestDTO));
    }
}
