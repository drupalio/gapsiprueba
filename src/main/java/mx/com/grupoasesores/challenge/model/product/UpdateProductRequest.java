package mx.com.grupoasesores.challenge.model.product;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateProductRequest {
    private String description;
    private String model;
}
