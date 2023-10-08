package by.brandwatch.catalogmanagerservice.service.product.impl;

import by.brandwatch.catalogmanagerservice.exception.EntitiesNotFoundByIdsException;
import by.brandwatch.catalogmanagerservice.repository.product.ProductEntity;
import by.brandwatch.catalogmanagerservice.repository.product.ProductRepository;
import by.brandwatch.catalogmanagerservice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.brand.BrandEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.category.CategoryEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.color.ColorEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.catalogmanagerservice.service.product.IProductService;
import by.brandwatch.catalogmanagerservice.service.product.model.ProductDto;
import by.brandwatch.catalogmanagerservice.service.product.model.ProductViewDto;
import by.brandwatch.catalogmanagerservice.service.product.util.converter.ProductConverter;
import by.brandwatch.catalogmanagerservice.service.settings.crud.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    private final BodyTypeCrud bodyTypeCrud;
    private final BrandCrud brandCrud;
    private final CategoryCrud categoryCrud;
    private final ColorCrud colorCrud;
    private final MechanismTypeCrud mechanismTypeCrud;

    private final String ENTITY_NAME = "Продукты";

    @Autowired
    public ProductService(
            ProductRepository productRepository,
            ProductConverter productConverter,
            BodyTypeCrud bodyTypeCrud,
            BrandCrud brandCrud,
            CategoryCrud categoryCrud,
            ColorCrud colorCrud,
            MechanismTypeCrud mechanismTypeCrud
    ) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.bodyTypeCrud = bodyTypeCrud;
        this.brandCrud = brandCrud;
        this.categoryCrud = categoryCrud;
        this.colorCrud = colorCrud;
        this.mechanismTypeCrud = mechanismTypeCrud;
    }

    public ProductViewDto getProduct(Long id){
        Optional<ProductEntity> productEntity = this.productRepository.findById(id);
        if (productEntity.isPresent()) {
            return productConverter.convertToViewDTO(productEntity.get());
        } else {
            throw new EntitiesNotFoundByIdsException(List.of(id), this.ENTITY_NAME);
        }

    }

    @Transactional
    public ProductViewDto createProduct(ProductDto product) {
       ProductEntity productEntity = this.getProductEntity(product);
        ProductEntity savedEntity = this.productRepository.save(productEntity);
        return this.productConverter.convertToViewDTO(savedEntity);
    }

    @Transactional
    public ProductViewDto updateProduct(Long id, ProductDto product) {
        if (!this.productRepository.existsById(id)) {
            throw new EntitiesNotFoundByIdsException(List.of(id), this.ENTITY_NAME);
        }
        ProductEntity productEntity = this.getProductEntity(product);
        productEntity.setId(id);
        ProductEntity savedEntity = this.productRepository.save(productEntity);
        return this.productConverter.convertToViewDTO(savedEntity);
    }

    @Transactional
    public void deleteProduct(Set<Long> ids) {
        if (this.productRepository.existsAllByIdIn(ids)) {
            this.productRepository.deleteAllById(ids);
        } else {
            throw new EntitiesNotFoundByIdsException(ids.stream().toList(), this.ENTITY_NAME);
        }
    }

    private ProductEntity getProductEntity(ProductDto product) {
        BodyTypeEntity bodyTypeEntity = bodyTypeCrud.getEntityById(product.getBodyTypeId());
        BrandEntity brandEntity = brandCrud.getEntityById(product.getBrandId());
        CategoryEntity categoryEntity = categoryCrud.getEntityById(product.getCategoryId());
        ColorEntity colorEntity = colorCrud.getEntityById(product.getColorId());
        MechanismTypeEntity mechanismTypeEntity = mechanismTypeCrud.getEntityById(product.getMechanismTypeId());
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImages(),
                categoryEntity,
                brandEntity,
                colorEntity,
                mechanismTypeEntity,
                bodyTypeEntity
        );
    }
}
