package by.brandwatch.catalogmanagerservice.service.util.converter;

import by.brandwatch.catalogmanagerservice.util.converter.MultiConverter;
import by.brandwatch.catalogmanagerservice.util.model.dto.IdentifiedDto;
import by.brandwatch.catalogmanagerservice.util.model.entity.IdentifiedEntity;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SimpleSettingConverter extends MultiConverter<IdentifiedEntity, IdentifiedDto> {

    public IdentifiedDto convertToDto(IdentifiedEntity entity) {
        return new IdentifiedDto(entity.getId(), entity.getName());
    }

    public IdentifiedEntity convertToEntity(IdentifiedDto dto) {
        return new IdentifiedEntity(dto.getId(), dto.getName());
    }
}
