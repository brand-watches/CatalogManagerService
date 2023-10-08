package by.brandwatch.catalogmanagerservice.service.settings.crud;

import by.brandwatch.catalogmanagerservice.repository.setting.color.ColorEntity;
import by.brandwatch.catalogmanagerservice.service.settings.model.ColorDto;
import by.brandwatch.catalogmanagerservice.service.settings.util.converter.ColorConverter;
import by.brandwatch.catalogmanagerservice.service.util.constants.SettingType;
import by.brandwatch.catalogmanagerservice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class ColorCrud extends CrudService<ColorEntity, ColorDto> {
    @Autowired
    public ColorCrud(CrudRepository<ColorEntity, Long> repository) {
        super(new ColorConverter(), repository, SettingType.COLOR.name());
    }
}
