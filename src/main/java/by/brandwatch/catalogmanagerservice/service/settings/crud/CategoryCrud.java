package by.brandwatch.catalogmanagerservice.service.settings.crud;

import by.brandwatch.catalogmanagerservice.repository.setting.category.CategoryEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.category.CategoryRepository;
import by.brandwatch.catalogmanagerservice.service.settings.model.CategoryDto;
import by.brandwatch.catalogmanagerservice.service.settings.util.converter.CategoryConverter;
import by.brandwatch.catalogmanagerservice.service.util.constants.SettingType;
import by.brandwatch.catalogmanagerservice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryCrud extends CrudService<CategoryEntity, CategoryDto> {

    @Autowired
    public CategoryCrud(CategoryRepository categoryRepository) {
        super(new CategoryConverter(), categoryRepository, SettingType.CATEGORY.name());
    }
}
