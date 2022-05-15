package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.domain.service.DataBaseService;
import pl.saba.backend.domain.service.StyleService;
import pl.saba.backend.http.dto.LashExtDto;

import java.util.List;

@RequestMapping(value = "/api/v1/")
@RestController
public class LashExtStylesController {

    private final StyleService styleService;

    public LashExtStylesController(StyleService styleService) {
        this.styleService = styleService;
    }

    @GetMapping("/styles")
    public ResponseEntity<List<LashExtDto>> getStyles(@RequestParam("effect-type") EffectType effectType) {
        List<LashExtDto> styles = DataBaseService.getFilteredStyles(effectType);
        return ResponseEntity.ok(styles);
    }

    @PostMapping("/styles")
    public ResponseEntity<Void> addStyle(@RequestBody LashExtDto lashExtDto) {
        styleService.addStyle(lashExtDto);
        System.out.println("styles: " + lashExtDto.getLashExtName() + " " + lashExtDto.getLashExtPrice()
                + " " + lashExtDto.getLashExtVariant() + " " + lashExtDto.getLashExtTime() + " " + lashExtDto.getLashExtImageBase64()
                + " " + lashExtDto.getEffectType());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
