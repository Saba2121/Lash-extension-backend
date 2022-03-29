package pl.saba.backend.http.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.saba.backend.http.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/v1/")
@RestController
public class CarsController {

    private final List<CarDto> cars;

    public CarsController() {
        cars = new ArrayList<>();

    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getCars() {
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/cars")
    public ResponseEntity<Void> addCar(@RequestBody CarDto carDto) {
        cars.add(carDto);
        System.out.println("car4 = " + carDto.getName() + " " + carDto.getModel() + " " + carDto.getColor() +
                " " + carDto.getNumberOfDoor());
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Integer id) {

        Optional<CarDto> carDtoOpt = cars.stream()
                .filter(carDto1 -> carDto1.getId().equals(id))
                .findFirst();
        carDtoOpt.ifPresent(carDto -> cars.remove(carDto));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}


































