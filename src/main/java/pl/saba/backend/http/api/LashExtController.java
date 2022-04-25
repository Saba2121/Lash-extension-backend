package pl.saba.backend.http.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.saba.backend.domain.model.EffectType;
import pl.saba.backend.domain.service.LashExtRepository;
import pl.saba.backend.http.dto.LashExtDto;

import java.util.List;

@RequestMapping(value = "/api/v1/")
@RestController
public class LashExtController {

    private LashExtRepository lashExtRepository;

    public LashExtController(LashExtRepository lashExtRepository) {
        this.lashExtRepository = lashExtRepository;
    }

    @GetMapping("/styles")
    public ResponseEntity<List<LashExtDto>> getStyles(
            @RequestParam("effect-type") EffectType effectType) {
        List<LashExtDto> styles = lashExtRepository.getStyles(effectType);
        return ResponseEntity.ok(styles);

    }

}
