package br.com.fiap.mpeg.notificator.infra.gateways;

import br.com.fiap.mpeg.notificator.domain.entities.EmailFile;
import br.com.fiap.mpeg.notificator.domain.entities.EmailRequest;
import br.com.fiap.mpeg.notificator.domain.entities.EmailTypeEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EmailRepositoryTest {

    @InjectMocks
    private EmailRepository emailRepository;

    @Mock
    private JavaMailSender mailSender;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSendSimpleMail() {
        // Arrange
        EmailRequest emailRequest = new EmailRequest(
                "recipient@email.com",
                "John Doe",
                "http://example.com",
                "12345",
                List.of(
                        new EmailFile("file1.txt", EmailTypeEnum.SUCCESS),
                        new EmailFile("file2.txt", EmailTypeEnum.ERROR)
                )
        );

        ArgumentCaptor<SimpleMailMessage> messageCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);

        // Act
        emailRepository.sendSimpleMail(emailRequest);

        // Assert
        verify(mailSender, times(1)).send(messageCaptor.capture());
        SimpleMailMessage capturedMessage = messageCaptor.getValue();

        assertEquals("noreply@email.com", capturedMessage.getFrom());
        assertEquals("recipient@email.com", capturedMessage.getTo()[0]);
        assertEquals("Protocolo 12345", capturedMessage.getSubject());

        String expectedBody = """
                Olá John Doe,

                O protocolo 12345 está finalizado.

                Arquivos processados:
                - Arquivo: file1.txt, Status: Sucesso
                - Arquivo: file2.txt, Status: Erro
                """;

        assertEquals(expectedBody, capturedMessage.getText());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
