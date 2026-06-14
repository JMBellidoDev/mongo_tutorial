package spring.tutorial.mongo.application.usecase;

import lombok.RequiredArgsConstructor;
import spring.tutorial.mongo.application.command.UploadFileCommand;
import spring.tutorial.mongo.application.port.in.UploadFilePort;
import spring.tutorial.mongo.application.port.out.OrderManagerPort;
import spring.tutorial.mongo.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class UploadFileUseCase implements UploadFilePort {

    private final OrderManagerPort orderManagerPort;

    @Override
    public void apply(UploadFileCommand uploadFileCommand) {
        orderManagerPort.uploadFile(uploadFileCommand);
    }
}
