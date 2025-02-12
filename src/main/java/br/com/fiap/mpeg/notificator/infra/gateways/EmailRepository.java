package br.com.fiap.mpeg.notificator.infra.gateways;

import br.com.fiap.mpeg.notificator.application.gateways.IEmailRepository;
import br.com.fiap.mpeg.notificator.domain.entities.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailRepository implements IEmailRepository {

    private final JavaMailSender mailSender;

    public EmailRepository(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleMail(EmailRequest emailRequest) {
        var message = new SimpleMailMessage();
        message.setFrom("noreply@email.com");
        message.setTo(emailRequest.getRecipientEmail());
        message.setSubject("Protocolo " + emailRequest.getProtocol());
        message.setText(formatBody(emailRequest));
        System.out.println("Enviando mensagem");
        mailSender.send(message);
    }

    private String formatBody(EmailRequest emailRequest) {
        StringBuilder body = new StringBuilder();
        body.append("Olá ").append(emailRequest.getRecipientName())
                .append(",\n\n")
                .append("O protocolo ").append(emailRequest.getProtocol())
                .append(" está finalizado.\n")
                .append("URL de acesso ").append(emailRequest.getUrl());

        if (emailRequest.getFiles() != null && !emailRequest.getFiles().isEmpty()) {
            body.append("\n\nArquivos processados:\n");
            emailRequest.getFiles().forEach(file ->
                    body.append("- Arquivo: ").append(file.getFilename())
                            .append(", Status: ").append(file.getType().getDescription())
                            .append("\n")
            );
        }

        return body.toString();
    }
}
