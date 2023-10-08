package by.brandwatch.catalogmanagerservice.service.settings.crud;

import by.brandwatch.catalogmanagerservice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.catalogmanagerservice.repository.setting.bodyType.BodyTypeRepository;
import by.brandwatch.catalogmanagerservice.service.settings.util.converter.BodyTypeConverter;
import by.brandwatch.catalogmanagerservice.service.settings.model.BodyTypeDto;
import by.brandwatch.catalogmanagerservice.service.util.constants.SettingType;
import by.brandwatch.catalogmanagerservice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BodyTypeCrud extends CrudService<BodyTypeEntity, BodyTypeDto> {

    @Autowired
    public BodyTypeCrud(BodyTypeRepository bodyTypeRepository) {
        super(new BodyTypeConverter(), bodyTypeRepository, SettingType.BODY_TYPE.name());
    }
}
