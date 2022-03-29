package pl.saba.backend.http.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.domain.service.LashExtService;
import pl.saba.backend.http.dto.LashExtDto;

import java.util.List;

@RequestMapping(value = "/api/v1/")
@RestController
public class LashExtController {

    private LashExtService lashExtService;

    public LashExtController(LashExtService lashExtService) {
        this.lashExtService = lashExtService;
    }

    @GetMapping("/styles")
    public ResponseEntity<List<LashExtDto>> getStyles(
            @RequestParam("effect-type") EffectType effectType) {
        List<LashExtDto> styles = lashExtService.getStyles(effectType);
        return ResponseEntity.ok(styles);

    }

}
