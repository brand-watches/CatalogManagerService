package by.brandwatch.catalogmanagerservice.service.settings.model;

import by.brandwatch.catalogmanagerservice.util.model.dto.IdentifiedDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyTypeDto extends IdentifiedDto {
    public BodyTypeDto(Long id, String name) {
        super(id, name);
    }
}
