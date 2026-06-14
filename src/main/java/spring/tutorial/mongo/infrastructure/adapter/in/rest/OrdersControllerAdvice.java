package spring.tutorial.mongo.infrastructure.adapter.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import spring.tutorial.mongo.application.exception.NotFoundError;
import spring.tutorial.mongo.infrastructure.adapter.in.rest.exception.ExceptionConstants;
import spring.tutorial.mongo.infrastructure.adapter.in.rest.exception.HttpException;

@ControllerAdvice
public class OrdersControllerAdvice {

    @ExceptionHandler(NotFoundError.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public HttpException handleNotFoundError(NotFoundError notFoundError) {
        return new HttpException(HttpStatus.NOT_FOUND.value(),
                ExceptionConstants.NOT_FOUND_CODE,
                ExceptionConstants.NOT_FOUND_MESSAGE);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public HttpException handleGenericException(Exception exception) {
        return new HttpException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ExceptionConstants.INTERNAL_SERVER_ERROR_CODE,
                ExceptionConstants.INTERNAL_SERVER_ERROR_MESSAGE);
    }
}
