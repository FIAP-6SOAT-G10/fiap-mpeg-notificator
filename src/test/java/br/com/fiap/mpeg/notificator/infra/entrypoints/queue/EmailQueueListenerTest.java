package br.com.fiap.mpeg.notificator.infra.entrypoints.queue;

import br.com.fiap.mpeg.notificator.application.usecases.EmailSenderUseCase;
import br.com.fiap.mpeg.notificator.domain.entities.EmailRequest;
import br.com.fiap.mpeg.notificator.infra.entrypoints.queue.model.EmailRequestDTO;
import br.com.fiap.mpeg.notificator.infra.mapper.EmailRequestMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import jakarta.validation.Validator;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmailQueueListenerTest {

    @InjectMocks
    private EmailQueueListener emailQueueListener;

    @Mock
    private EmailSenderUseCase emailSenderUseCase;

    @Mock
    private EmailRequestMapper emailRequestMapper;

    @Mock
    private Validator validator;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldThrowConstraintViolationExceptionForInvalidRequest() {
        // Arrange
        EmailRequestDTO emailRequestDTO = mock(EmailRequestDTO.class);
        Set<ConstraintViolation<EmailRequestDTO>> violations = Set.of(mock(ConstraintViolation.class));

        when(validator.validate(emailRequestDTO)).thenReturn(violations);

        // Act & Assert
        assertThrows(ConstraintViolationException.class, () -> emailQueueListener.listen(emailRequestDTO));

        verify(validator, times(1)).validate(emailRequestDTO);
        verifyNoInteractions(emailRequestMapper);
        verifyNoInteractions(emailSenderUseCase);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
