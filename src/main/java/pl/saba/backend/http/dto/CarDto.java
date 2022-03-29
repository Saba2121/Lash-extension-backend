package pl.saba.backend.http.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarDto {
    private Integer id;
    private String name;
    private String model;
    private String color;
    private Integer numberOfDoor;

}