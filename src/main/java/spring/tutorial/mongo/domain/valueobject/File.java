package spring.tutorial.mongo.domain.valueobject;

import lombok.Data;

@Data
public class File {
    private String fileName;
    private String contentType;
    private byte[] content;
}
