package by.brandwatch.catalogmanagerservice.service.settings.crud;

import by.brandwatch.catalogmanagerservice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.catalogmanagerservice.service.settings.model.MechanismTypeDto;
import by.brandwatch.catalogmanagerservice.service.settings.util.converter.MechanismTypeConverter;
import by.brandwatch.catalogmanagerservice.service.util.constants.SettingType;
import by.brandwatch.catalogmanagerservice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class MechanismTypeCrud extends CrudService<MechanismTypeEntity, MechanismTypeDto> {
    @Autowired
    public MechanismTypeCrud(CrudRepository<MechanismTypeEntity, Long> repository) {
        super(new MechanismTypeConverter(), repository, SettingType.MECHANISM.name());
    }
}
