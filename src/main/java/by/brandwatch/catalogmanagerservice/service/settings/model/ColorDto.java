package by.brandwatch.catalogmanagerservice.service.settings.model;

import by.brandwatch.catalogmanagerservice.util.model.dto.IdentifiedDto;
import lombok.*;


@Getter
@Setter
public class ColorDto extends IdentifiedDto {
    public String firstColor;

    public String secondColor;

    public ColorDto(Long id, String name, String firstColor, String secondColor) {
        super(id, name);
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }
}


