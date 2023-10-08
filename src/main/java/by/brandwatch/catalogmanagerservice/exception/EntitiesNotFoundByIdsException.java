package by.brandwatch.catalogmanagerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public class EntitiesNotFoundByIdsException extends HttpClientErrorException {

    public EntitiesNotFoundByIdsException(List<Long> invalidIds, String name) {
        super(HttpStatus.NOT_FOUND, "Invalid Ids " + name + ": " + invalidIds.toString());
    }
}
