package spring.tutorial.mongo.application.exception;

public class NotFoundError extends RuntimeException {

    public NotFoundError(String element) {
        super(String.format("The entity %s could not be found", element));
    }
}
