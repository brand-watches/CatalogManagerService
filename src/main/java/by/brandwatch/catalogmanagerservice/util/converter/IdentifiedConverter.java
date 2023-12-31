package by.brandwatch.catalogmanagerservice.util.converter;

import by.brandwatch.catalogmanagerservice.util.model.dto.IdentifiedDto;
import by.brandwatch.catalogmanagerservice.util.model.entity.IdentifiedEntity;

public class IdentifiedConverter extends MultiConverter<IdentifiedEntity, IdentifiedDto> {

    @Override
    public IdentifiedDto convertToDTO(IdentifiedEntity entity) {
        return new IdentifiedDto(entity.getId(), entity.getName());
    }

    @Override
    public IdentifiedEntity convertToEntity(IdentifiedDto dto) {
        return new IdentifiedEntity(dto.getId(), dto.getName());
    }
}
