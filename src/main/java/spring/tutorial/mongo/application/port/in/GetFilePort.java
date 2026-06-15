package spring.tutorial.mongo.application.port.in;

import spring.tutorial.mongo.domain.valueobject.File;

public interface GetFilePort {
    File apply(String orderId);
}
