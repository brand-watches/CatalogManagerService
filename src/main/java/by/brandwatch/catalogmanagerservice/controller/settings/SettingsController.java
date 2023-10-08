package by.brandwatch.catalogmanagerservice.controller.settings;

import by.brandwatch.catalogmanagerservice.exception.DuplicateEntityException;
import by.brandwatch.catalogmanagerservice.exception.EntitiesNotFoundByIdsException;
import by.brandwatch.catalogmanagerservice.service.settings.ISettingService;
import by.brandwatch.catalogmanagerservice.service.settings.model.GlobalOptionsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    private final ISettingService settingService;

    @Autowired
    public SettingsController(ISettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping("")
    public GlobalOptionsDto get(){
        return settingService.getGlobalOptions();
    }

    @PostMapping("")
    public ResponseEntity<GlobalOptionsDto> set(@RequestBody GlobalOptionsDto globalOptionsDto) {
        try {
            return ResponseEntity.ok(settingService.setGlobalOptions(globalOptionsDto));
        } catch (DuplicateEntityException | EntitiesNotFoundByIdsException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getStatusText(), e);
        }
    }


}
