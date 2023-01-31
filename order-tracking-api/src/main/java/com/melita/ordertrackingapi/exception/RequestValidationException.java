package com.melita.ordertrackingapi.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class RequestValidationException extends ResponseStatusException {
    public RequestValidationException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
