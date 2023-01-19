package com.api.cars.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;

public record CarDTO(
        @NotBlank String modelo,

        @NotBlank String fabricante,

        @NotNull @Past Date dataFabricacao,

        @NotNull double valor,

        @NotNull @Min(1700) Integer anoModelo) {
}
