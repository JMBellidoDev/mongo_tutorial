package spring.tutorial.mongo.application.exception;

public class UnexpectedError extends RuntimeException {

    public UnexpectedError(String message) {
        super(message);
    }
}
