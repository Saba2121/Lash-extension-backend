package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.domain.service.DataBaseService;
import pl.saba.backend.domain.service.VisitService;
import pl.saba.backend.http.dtoandroid.VisitDto;
import pl.saba.backend.http.dtoweb.VisitDateDto;

import java.util.List;

@RequestMapping(value = "/api/v1/")
@RestController
public class LashExtVisitsController {

    private final VisitService visitService;

    public LashExtVisitsController(VisitService visitService) {
        this.visitService = visitService;

    }

    //uzywane przez androida
    @PostMapping("/android/visits")
    public ResponseEntity<Void> addVisit(@RequestBody VisitDto visitDto) {
        System.out.println("visit = " + visitDto.getName() + " " + visitDto.getSurname() + " " + visitDto.getNumberPhone()
                + " " + visitDto.getVisitTimestamp() + " " + visitDto.getEffectType() + " " + visitDto.getVariant());

        Boolean visitExist = DataBaseService.visits.stream()
                .anyMatch(visitDto1 -> visitDto1.getVisitTimestamp().equals(visitDto.getVisitTimestamp()));

        if (visitExist) {
            return ResponseEntity.status(434).build();

        } else {
            visitService.addVisit(visitDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }

    }

    @GetMapping("/web/visits")
    public ResponseEntity<List<VisitDateDto>> getVisits() {
        return ResponseEntity.ok(visitService.getAllVisits());
    }

    @DeleteMapping("/web/visits/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable("id") Integer id) {
        visitService.deleteVisit(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
