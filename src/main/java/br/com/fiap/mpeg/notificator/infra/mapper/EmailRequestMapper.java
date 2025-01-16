package br.com.fiap.mpeg.notificator.infra.mapper;

import br.com.fiap.mpeg.notificator.domain.entities.EmailRequest;
import br.com.fiap.mpeg.notificator.infra.entrypoints.queue.model.EmailRequestDTO;

public class EmailRequestMapper {

    private final EmailFileMapper emailFileMapper;

    public EmailRequestMapper(EmailFileMapper emailFileMapper) {
        this.emailFileMapper = emailFileMapper;
    }

    public EmailRequest fromDTOToDomain(EmailRequestDTO emailRequestDTO) {
        return new EmailRequest(
                emailRequestDTO.getRecipientEmail(),
                emailRequestDTO.getRecipientName(),
                emailRequestDTO.getUrl(),
                emailRequestDTO.getProtocol(),
                emailFileMapper.fromListDTOToListDomain(emailRequestDTO.getFiles()));
    }

}
