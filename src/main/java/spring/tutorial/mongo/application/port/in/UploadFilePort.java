package spring.tutorial.mongo.application.port.in;

import spring.tutorial.mongo.application.command.UploadFileCommand;

public interface UploadFilePort {
    void apply(UploadFileCommand uploadFileCommand);
}
