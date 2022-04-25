package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.saba.backend.domain.repository.LashExtImageRepository;
import pl.saba.backend.http.dto.LashExtVariantImageDto;


@RequestMapping(value = "/api/v1/")
@RestController
public class LashExtImageController {

    @PostMapping("/variant-image")
    public ResponseEntity<Void> addImage(@RequestBody LashExtVariantImageDto lashExtVariantImageDto) {
        LashExtImageRepository.variantToImageBase64Map.put(lashExtVariantImageDto.getVariant(),
                lashExtVariantImageDto.getImage());
        System.out.println("variant image " + lashExtVariantImageDto.getVariant() + " " + lashExtVariantImageDto.getImage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
