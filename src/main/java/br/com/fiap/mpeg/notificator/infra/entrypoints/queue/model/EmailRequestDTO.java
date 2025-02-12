package br.com.fiap.mpeg.notificator.infra.entrypoints.queue.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class EmailRequestDTO {

    @NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Email com formato inválido")
    private String recipientEmail;

    @NotBlank(message = "Nome não pode ser vazio")
    private String recipientName;

    private String url;

    @NotBlank(message = "Protocolo não pode ser vazio")
    private String protocol;

    @NotEmpty(message = "Lista de arquivos não pode ser vazio")
    private List<EmailFileDTO> files;

    public EmailRequestDTO(String recipientEmail, String recipientName, String url, String protocol, List<EmailFileDTO> files) {
        this.recipientEmail = recipientEmail;
        this.recipientName = recipientName;
        this.url = url;
        this.protocol = protocol;
        this.files = files;
    }

    public @NotBlank(message = "Email não pode ser vazio") @Email(message = "Email com formato inválido") String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(@NotBlank(message = "Email não pode ser vazio") @Email(message = "Email com formato inválido") String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public @NotBlank(message = "Nome não pode ser vazio") String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(@NotBlank(message = "Nome não pode ser vazio") String recipientName) {
        this.recipientName = recipientName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public @NotBlank(message = "Protocolo não pode ser vazio") String getProtocol() {
        return protocol;
    }

    public void setProtocol(@NotBlank(message = "Protocolo não pode ser vazio") String protocol) {
        this.protocol = protocol;
    }

    public @NotEmpty(message = "Lista de arquivos não pode ser vazio") List<EmailFileDTO> getFiles() {
        return files;
    }

    public void setFiles(@NotEmpty(message = "Lista de arquivos não pode ser vazio") List<EmailFileDTO> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "EmailRequestDTO{" +
                "recipientEmail='" + recipientEmail + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", url='" + url + '\'' +
                ", protocol='" + protocol + '\'' +
                ", files=" + files +
                '}';
    }
}
