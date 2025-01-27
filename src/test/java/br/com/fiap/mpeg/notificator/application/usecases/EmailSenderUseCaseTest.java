package br.com.fiap.mpeg.notificator.application.usecases;

import br.com.fiap.mpeg.notificator.application.gateways.IEmailRepository;
import br.com.fiap.mpeg.notificator.domain.entities.EmailFile;
import br.com.fiap.mpeg.notificator.domain.entities.EmailRequest;
import br.com.fiap.mpeg.notificator.domain.entities.EmailTypeEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EmailSenderUseCaseTest {

    @InjectMocks
    private EmailSenderUseCase emailSenderUseCase;

    @Mock
    private IEmailRepository emailRepository;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCallSendSimpleMailFromRepository() {
        // Arrange
        EmailRequest emailRequest = new EmailRequest(
                "test@example.com",
                "Test User",
                "http://example.com",
                "12345",
                List.of(new EmailFile("file.txt", EmailTypeEnum.SUCCESS))
        );

        // Act
        emailSenderUseCase.sendSimpleMail(emailRequest);

        // Assert
        verify(emailRepository, times(1)).sendSimpleMail(emailRequest);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
