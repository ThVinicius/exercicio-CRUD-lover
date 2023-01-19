package com.api.cars.controller;

import com.api.cars.dto.CarDTO;
import com.api.cars.model.Car;
import com.api.cars.repository.CarRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void addCar(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));

        System.out.println("Modelo: " + req.modelo());
        System.out.println("Fabricante: " + req.fabricante());
        System.out.println("Valor: " + req.valor());
    }

    @GetMapping
    public List<Car> listAll(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req){
        Optional<Car> carOptional = repository.findById(id);

        if (carOptional.isPresent()){
            var car =  new Car();
            BeanUtils.copyProperties(req, car);
            car.setId(carOptional.get().getId());

            repository.save(car);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
