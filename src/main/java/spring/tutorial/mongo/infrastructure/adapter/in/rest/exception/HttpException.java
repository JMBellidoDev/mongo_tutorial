package spring.tutorial.mongo.infrastructure.adapter.in.rest.exception;

public record HttpException(Integer httpStatus, String code, String message) {
}
