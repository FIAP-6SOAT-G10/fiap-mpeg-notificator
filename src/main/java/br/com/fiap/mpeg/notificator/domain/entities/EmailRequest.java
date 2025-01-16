package br.com.fiap.mpeg.notificator.domain.entities;

import java.util.List;

public class EmailRequest {

    private String recipientEmail;
    private String recipientName;
    private String url;
    private String protocol;
    private List<EmailFile> files;

    public EmailRequest(String recipientEmail, String recipientName, String url, String protocol, List<EmailFile> files) {
        this.recipientEmail = recipientEmail;
        this.recipientName = recipientName;
        this.url = url;
        this.protocol = protocol;
        this.files = files;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public List<EmailFile> getFiles() {
        return files;
    }

    public void setFiles(List<EmailFile> files) {
        this.files = files;
    }
}
