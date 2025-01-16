package br.com.fiap.mpeg.notificator.infra.entrypoints.rest;

import br.com.fiap.mpeg.notificator.infra.entrypoints.queue.EmailQueueListener;
import br.com.fiap.mpeg.notificator.infra.entrypoints.queue.model.EmailRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailQueueListener emailQueueListener;

    public EmailController(EmailQueueListener emailQueueListener) {
        this.emailQueueListener = emailQueueListener;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendSimpleMail(@RequestBody EmailRequestDTO emailRequestDTO) {
        emailQueueListener.listen(emailRequestDTO);
    }
}
