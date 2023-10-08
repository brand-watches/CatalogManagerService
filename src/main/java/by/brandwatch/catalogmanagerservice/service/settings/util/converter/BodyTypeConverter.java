package by.brandwatch.catalogmanagerservice.service.settings.util.converter;

import by.brandwatch.catalogmanagerservice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.catalogmanagerservice.service.settings.model.BodyTypeDto;
import by.brandwatch.catalogmanagerservice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class BodyTypeConverter extends MultiConverter<BodyTypeEntity, BodyTypeDto> {

    public BodyTypeDto convertToDTO(BodyTypeEntity entity) {
        return new BodyTypeDto(entity.getId(), entity.getName());
    }

    public BodyTypeEntity convertToEntity(BodyTypeDto dto) {
        return new BodyTypeEntity(dto.getId(), dto.getName());
    }
}
