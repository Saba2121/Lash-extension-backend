package pl.saba.backend.http.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.http.dto.AnimalDto;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/api/v1/")
@RestController
public class AnimalsController {

    private List<AnimalDto> animals = new ArrayList<>();


    @GetMapping("/animals")
    public ResponseEntity<List<AnimalDto>> getAnimals() {
        return ResponseEntity.ok(animals);
    }

    @PostMapping("/animals")
    public ResponseEntity<Void> addAnimal(@RequestBody AnimalDto animalDto) {
        animals.add(animalDto);
        System.out.println("animals = " + animalDto.getType() + " " + animalDto.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @DeleteMapping("/animals/{id}")
//    public ResponseEntity<Void> deleteAnimal(@PathVariable("id") Integer id){
//
//        Optional <AnimalDto> animalDtoOpt = animals.stream()
//                .filter(animalDto1 -> animalDto1.getId().equals(id))
//                .findFirst();
//        animalDtoOpt.ifPresent(animalDto -> animals.remove(animalDto));
//
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }


}