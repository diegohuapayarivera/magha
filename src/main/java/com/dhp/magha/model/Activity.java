package com.dhp.magha.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activity")
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El campo typeActivity es requerido")
    private int typeActivity;

    @NotNull(message = "El campo description es requerido")
    @Size(max = 200, message
            = "El campo description debe ser menor a 200 caracteres")
    private String description;

    @NotNull(message = "El campo level es requerido")
    @Max(value = 5)
    @Min(value = 1)
    private int level;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
