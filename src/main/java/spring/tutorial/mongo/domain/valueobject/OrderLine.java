package spring.tutorial.mongo.domain.valueobject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class OrderLine {
    private Product product;
    private Integer quantity;
    private Double discount;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(product, orderLine.product) && Objects.equals(discount, orderLine.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, discount);
    }
}
