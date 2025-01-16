package br.com.fiap.mpeg.notificator.domain.entities;

public enum EmailTypeEnum {
    ERROR("Erro"),
    SUCCESS("Sucesso");

    private final String description;

    EmailTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
