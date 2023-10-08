package by.brandwatch.catalogmanagerservice.service.settings.util.converter;

import by.brandwatch.catalogmanagerservice.repository.setting.color.ColorEntity;
import by.brandwatch.catalogmanagerservice.service.settings.model.ColorDto;
import by.brandwatch.catalogmanagerservice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class ColorConverter extends MultiConverter<ColorEntity, ColorDto> {

    public ColorDto convertToDTO(ColorEntity entity) {
        return new ColorDto(entity.getId(), entity.getName(), entity.getFirstColor(), entity.getSecondColor());
    }

    public ColorEntity convertToEntity(ColorDto dto) {
        return new ColorEntity(dto.getId(), dto.getName(), dto.getFirstColor(), dto.getSecondColor());
    }
}
