package spring.tutorial.mongo.infrastructure.adapter.in.rest.exception;

public class ExceptionConstants {
    private ExceptionConstants() {
    }

    public static final String NOT_FOUND_CODE = "element_not_found";
    public static final String NOT_FOUND_MESSAGE = "The searched element could not be found";

    public static final String INTERNAL_SERVER_ERROR_CODE = "internal_server_error";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "An unexpected error has been thrown";
}
