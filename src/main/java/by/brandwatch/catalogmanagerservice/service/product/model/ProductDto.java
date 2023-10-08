package by.brandwatch.catalogmanagerservice.service.product.model;

import by.brandwatch.catalogmanagerservice.util.model.dto.IdentifiedDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class ProductDto extends IdentifiedDto {
    private final String description;
    private final List<String> images;
    private final Long categoryId;
    private final Long brandId;
    private final Long colorId;
    private final Long mechanismTypeId;
    private final Long bodyTypeId;
}
