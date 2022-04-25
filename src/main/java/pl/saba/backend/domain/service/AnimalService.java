package pl.saba.backend.domain.service;

import org.springframework.stereotype.Service;
import pl.saba.backend.http.dto.AnimalDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    public List<AnimalDto> getAnimals() {

        List<AnimalDto> animals = new ArrayList<>();

        animals.add(new AnimalDto(0, "Dog", "owczarek niemiecki", "Ari", "brown"));
        animals.add(new AnimalDto(1, "Horse", "małopolski", "Karina", "brown"));
        animals.add(new AnimalDto(2, "Cat", "syberyjski", "Zosia", "white"));

        return animals;
    }
}