package br.com.fiap.mpeg.notificator.infra.entrypoints.queue.model;


import jakarta.validation.constraints.NotBlank;

public class EmailFileDTO {

    @NotBlank(message = "Nome do arquivo não pode ser vazio")
    private String filename;

    @NotBlank(message = "Tipo não pode ser vazio")
    private String status;

    public EmailFileDTO(String filename, String status) {
        this.filename = filename;
        this.status = status;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmailFileDTO{" +
                "filename='" + filename + '\'' +
                ", type='" + status + '\'' +
                '}';
    }
}
