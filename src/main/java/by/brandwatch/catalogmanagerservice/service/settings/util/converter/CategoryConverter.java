package by.brandwatch.catalogmanagerservice.service.settings.util.converter;

import by.brandwatch.catalogmanagerservice.repository.setting.category.CategoryEntity;
import by.brandwatch.catalogmanagerservice.service.settings.model.CategoryDto;
import by.brandwatch.catalogmanagerservice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter extends MultiConverter<CategoryEntity, CategoryDto> {

    public CategoryDto convertToDTO(CategoryEntity entity) {
        return new CategoryDto(entity.getId(), entity.getName());
    }

    public CategoryEntity convertToEntity(CategoryDto dto) {
        return new CategoryEntity(dto.getId(), dto.getName());
    }
}
