package br.com.fiap.mpeg.notificator.domain.entities;

public class EmailFile {

    private String filename;
    private EmailTypeEnum type;

    public EmailFile(String filename, EmailTypeEnum type) {
        this.filename = filename;
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public EmailTypeEnum getType() {
        return type;
    }

    public void setType(EmailTypeEnum type) {
        this.type = type;
    }
}
