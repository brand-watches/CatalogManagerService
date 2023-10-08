package by.brandwatch.catalogmanagerservice.service.settings.util.converter;

import by.brandwatch.catalogmanagerservice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.catalogmanagerservice.service.settings.model.MechanismTypeDto;
import by.brandwatch.catalogmanagerservice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class MechanismTypeConverter extends MultiConverter<MechanismTypeEntity, MechanismTypeDto> {

    public MechanismTypeDto convertToDTO(MechanismTypeEntity entity) {
        return new MechanismTypeDto(entity.getId(), entity.getName());
    }

    public MechanismTypeEntity convertToEntity(MechanismTypeDto dto) {
        return new MechanismTypeEntity(dto.getId(), dto.getName());
    }
}
