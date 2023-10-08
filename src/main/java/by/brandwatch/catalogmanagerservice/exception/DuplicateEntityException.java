package by.brandwatch.catalogmanagerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class DuplicateEntityException extends HttpClientErrorException {

    public DuplicateEntityException(String entityName) {
        super(HttpStatus.CONFLICT, "Duplicate entity: " + entityName);
    }
}
