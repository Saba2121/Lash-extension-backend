package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.domain.service.LashExtService;
import pl.saba.backend.http.dtoandroid.LashExtDto;

import java.util.List;

@RequestMapping(value = "/api/v1/")
@RestController
public class LashExtServicesController {

    private final LashExtService lashExtService;

    public LashExtServicesController(LashExtService lashExtService) {
        this.lashExtService = lashExtService;
    }

    //uzywane przez androida
    @GetMapping("/android/styles")
    public ResponseEntity<List<LashExtDto>> getStyles(@RequestParam("effect-type") EffectType effectType) {
        List<LashExtDto> styles = lashExtService.getAllFilteredStyles(effectType);
        return ResponseEntity.ok(styles);
    }

    @PostMapping("/web/styles")
    public ResponseEntity<Void> addStyle(@RequestBody LashExtDto lashExtDto) {
        lashExtService.addStyle(lashExtDto);
        System.out.println("styles: " + lashExtDto.getLashExtName() + " " + lashExtDto.getLashExtPrice()
                + " " + lashExtDto.getLashExtVariant() + " " + lashExtDto.getLashExtTime() + " " + lashExtDto.getLashExtImageBase64()
                + " " + lashExtDto.getEffectType());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/web/styles/{id}")
    public ResponseEntity<Void> deleteStyle(@PathVariable("id") Integer id) {
        lashExtService.deleteStyle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
