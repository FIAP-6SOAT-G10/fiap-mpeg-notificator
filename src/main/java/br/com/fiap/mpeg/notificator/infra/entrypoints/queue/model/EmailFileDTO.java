package br.com.fiap.mpeg.notificator.infra.entrypoints.queue.model;


import jakarta.validation.constraints.NotBlank;

public class EmailFileDTO {

    @NotBlank(message = "Nome do arquivo não pode ser vazio")
    private String filename;

    @NotBlank(message = "Tipo não pode ser vazio")
    private String type;

    public EmailFileDTO(String filename, String type) {
        this.filename = filename;
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EmailFileDTO{" +
                "filename='" + filename + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
