package by.brandwatch.catalogmanagerservice.service.settings.util.converter;

import by.brandwatch.catalogmanagerservice.repository.setting.brand.BrandEntity;
import by.brandwatch.catalogmanagerservice.service.settings.model.BrandDto;
import by.brandwatch.catalogmanagerservice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class BrandConverter extends MultiConverter<BrandEntity, BrandDto> {
    public BrandDto convertToDTO(BrandEntity entity) {
        return new BrandDto(entity.getId(), entity.getName());
    }

    public BrandEntity convertToEntity(BrandDto dto) {
        return new BrandEntity(dto.getId(), dto.getName());
    }
}
