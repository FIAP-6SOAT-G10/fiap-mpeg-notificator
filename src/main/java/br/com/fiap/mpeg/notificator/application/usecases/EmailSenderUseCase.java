package br.com.fiap.mpeg.notificator.application.usecases;

import br.com.fiap.mpeg.notificator.application.gateways.IEmailRepository;
import br.com.fiap.mpeg.notificator.domain.entities.EmailRequest;

public class EmailSenderUseCase {

    private final IEmailRepository emailRepository;

    public EmailSenderUseCase(IEmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public void sendSimpleMail(EmailRequest emailRequest) {
        emailRepository.sendSimpleMail(emailRequest);
    }
}
