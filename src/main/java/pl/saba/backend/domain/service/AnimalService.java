package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.http.dto.AnimalDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    public List<AnimalDto> getAnimals() {

        List<AnimalDto> animals = new ArrayList<>();
        animals.add(new AnimalDto("Dog", "Reksio"));
        animals.add(new AnimalDto("Horse", "Karina"));
        animals.add(new AnimalDto("Cat", "Zosia"));

        return animals;
    }
}