package com.itclopedia.cources.first.spring.data.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityType, Number id) {
        super(String.format(ExceptionMessages.ENTITY_IS_NOT_FOUND, entityType, id));
    }

}
