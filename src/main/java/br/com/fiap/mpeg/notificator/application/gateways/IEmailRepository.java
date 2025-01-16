package br.com.fiap.mpeg.notificator.application.gateways;

import br.com.fiap.mpeg.notificator.domain.entities.EmailRequest;

public interface IEmailRepository {

    void sendSimpleMail(EmailRequest emailRequest);
}
