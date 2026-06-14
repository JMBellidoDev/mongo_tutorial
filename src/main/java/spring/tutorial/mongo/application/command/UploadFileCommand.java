package spring.tutorial.mongo.application.command;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileCommand {
    private String orderId;
    private MultipartFile file;
}
