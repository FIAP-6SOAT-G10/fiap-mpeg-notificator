package br.com.fiap.mpeg.notificator.infra.mapper;

import br.com.fiap.mpeg.notificator.domain.entities.EmailFile;
import br.com.fiap.mpeg.notificator.domain.entities.EmailTypeEnum;
import br.com.fiap.mpeg.notificator.infra.entrypoints.queue.model.EmailFileDTO;

import java.util.List;

public class EmailFileMapper {

    public List<EmailFile> fromListDTOToListDomain(List<EmailFileDTO> files) {
        return files.stream().map(this::fromDTOToDomain).toList();
    }

    public EmailFile fromDTOToDomain(EmailFileDTO file) {
        return new EmailFile(
                file.getFilename(),
                EmailTypeEnum.valueOf(file.getType()));
    }
}
