package com.api.cars.model;

import com.api.cars.dto.CarDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Car {

    public Car(CarDTO data){
        this.modelo = data.modelo();
        this.fabricante = data.fabricante();
        this.dataFabricacao = data.dataFabricacao();
        this.anoModelo = data.anoModelo();
        this.valor = data.valor();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private Date dataFabricacao;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private Integer anoModelo;
}
