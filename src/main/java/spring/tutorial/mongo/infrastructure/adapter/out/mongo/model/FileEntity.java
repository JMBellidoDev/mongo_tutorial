package spring.tutorial.mongo.infrastructure.adapter.out.mongo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileEntity {
    private String fileName;
    private String contentType;
    private byte[] content;
}
