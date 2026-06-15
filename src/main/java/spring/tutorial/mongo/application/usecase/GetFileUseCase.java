package spring.tutorial.mongo.application.usecase;

import lombok.RequiredArgsConstructor;
import spring.tutorial.mongo.application.exception.NotFoundError;
import spring.tutorial.mongo.application.port.in.GetFilePort;
import spring.tutorial.mongo.application.port.out.OrderManagerPort;
import spring.tutorial.mongo.common.UseCase;
import spring.tutorial.mongo.domain.valueobject.File;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class GetFileUseCase implements GetFilePort {

    private final OrderManagerPort orderManagerPort;

    @Override
    public File apply(String orderId) {
        Optional<File> fileOpt = orderManagerPort.findFileByOrderId(orderId);
        return fileOpt.orElseThrow(() -> new NotFoundError("Order"));
    }
}
