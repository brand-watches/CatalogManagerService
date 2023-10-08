package by.brandwatch.catalogmanagerservice.service.settings;

import by.brandwatch.catalogmanagerservice.service.settings.model.GlobalOptionsDto;
import by.brandwatch.catalogmanagerservice.util.model.dto.IdentifiedDto;
import by.brandwatch.catalogmanagerservice.util.model.entity.IdentifiedEntity;

public interface ISettingService {
    GlobalOptionsDto getGlobalOptions();
    GlobalOptionsDto setGlobalOptions(GlobalOptionsDto globalOptionsDto);
}
