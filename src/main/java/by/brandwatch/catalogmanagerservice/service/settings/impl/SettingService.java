package by.brandwatch.catalogmanagerservice.service.settings.impl;

import by.brandwatch.catalogmanagerservice.service.settings.ISettingService;
import by.brandwatch.catalogmanagerservice.service.settings.crud.*;
import by.brandwatch.catalogmanagerservice.service.settings.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SettingService implements ISettingService {

    private final CategoryCrud categoryCrud;

    private final BodyTypeCrud bodyTypeCrud;

    private final BrandCrud brandCrud;

    private final ColorCrud colorCrud;

    private final MechanismTypeCrud mechanismTypeCrud;

    @Autowired
    public SettingService(
            CategoryCrud categoryCrud,
            BodyTypeCrud bodyTypeCrud,
            BrandCrud brandCrud,
            ColorCrud colorCrud,
            MechanismTypeCrud mechanismTypeCrud
    ) {
        this.categoryCrud = categoryCrud;
        this.bodyTypeCrud = bodyTypeCrud;
        this.brandCrud = brandCrud;
        this.colorCrud = colorCrud;
        this.mechanismTypeCrud = mechanismTypeCrud;
    }

    public GlobalOptionsDto getGlobalOptions() {
        List<CategoryDto> categoryEntities = categoryCrud.getAll();
        List<BodyTypeDto> bodyTypeEntities = bodyTypeCrud.getAll();
        return new GlobalOptionsDto(
                categoryEntities.toArray(new CategoryDto[0]),
                bodyTypeEntities.toArray(new BodyTypeDto[0]),
                brandCrud.getAll().toArray(new BrandDto[0]),
                colorCrud.getAll().toArray(new ColorDto[0]),
                mechanismTypeCrud.getAll().toArray(new MechanismTypeDto[0])
        );
    }

    public GlobalOptionsDto setGlobalOptions(GlobalOptionsDto globalOptionsDto) {
        categoryCrud.update(globalOptionsDto.getCategoryDtos());
        bodyTypeCrud.update(globalOptionsDto.getBodyTypeDtos());
        brandCrud.update(globalOptionsDto.getBrandDtos());
        colorCrud.update(globalOptionsDto.getColorDtos());
        mechanismTypeCrud.update(globalOptionsDto.getMechanismTypeDtos());
        return this.getGlobalOptions();
    }
}
