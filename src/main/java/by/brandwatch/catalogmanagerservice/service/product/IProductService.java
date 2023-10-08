package by.brandwatch.catalogmanagerservice.service.product;

import by.brandwatch.catalogmanagerservice.service.product.model.ProductDto;
import by.brandwatch.catalogmanagerservice.service.product.model.ProductViewDto;

import java.util.Set;

public interface IProductService {
    ProductViewDto getProduct(Long id);
    ProductViewDto createProduct(ProductDto product);
    ProductViewDto updateProduct(Long id, ProductDto product);
    void deleteProduct(Set<Long> ids);
}
