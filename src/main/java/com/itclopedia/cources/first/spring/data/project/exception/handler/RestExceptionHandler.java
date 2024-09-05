package com.itclopedia.cources.first.spring.data.project.exception.handler;

import com.itclopedia.cources.first.spring.data.project.dto.ErrorDto;
import com.itclopedia.cources.first.spring.data.project.exception.EntityNotFoundException;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleInternalDboException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ErrorDto.builder()
                .result(HttpStatus.NOT_FOUND.value())
                .description(ex.getMessage())
                .build(),
                HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(@Nonnull Exception ex,
                                                             @Nullable Object body,
                                                             @Nonnull HttpHeaders headers,
                                                             @Nonnull HttpStatusCode statusCode,
                                                             @Nonnull WebRequest request) {
        return new ResponseEntity<>(ErrorDto.builder()
                .result(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .description(ex.getMessage())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
