package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.domain.service.DataBaseService;
import pl.saba.backend.http.dto.VisitDto;

import java.util.List;


@RequestMapping(value = "/api/v1/")
@RestController
public class VisitsController {


    @PostMapping("/visits")
    public ResponseEntity<Void> addVisit(@RequestBody VisitDto visitDto) {
        System.out.println("visit = " + visitDto.getName() + " " + visitDto.getSurname() + " " + visitDto.getNumberPhone()
                + " " + visitDto.getVisitTimestamp() + " " + visitDto.getEffectType() + " " + visitDto.getVariant());


        Boolean visitExist = DataBaseService.visits.stream()
                .anyMatch(visitDto1 -> visitDto1.getVisitTimestamp().equals(visitDto.getVisitTimestamp()));

        if (visitExist) {
            return ResponseEntity.status(434).build();

        } else {
            DataBaseService.visits.add(visitDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }

//        Optional<VisitDto> visitDtoOpt = visits.stream()
//                 .filter(visitDto1 -> visitDto1.getVisitTimestamp().equals(visitDto.getVisitTimestamp()))
//                 .findFirst();

//        Boolean visitExist = visits.stream()
//                .filter(visitDto1 -> visitDto1.getVisitTimestamp().equals(visitDto.getVisitTimestamp()))
//                .findFirst()
//                .isPresent();

    }

    @GetMapping("/visits")
    public ResponseEntity<List<VisitDto>> getVisits() {
        return ResponseEntity.ok(DataBaseService.visits);
    }


}
