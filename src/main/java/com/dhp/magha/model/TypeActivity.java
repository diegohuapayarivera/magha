package com.dhp.magha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "type_activity")
@Entity
public class TypeActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @NotNull(message = "El campo descripcion es requerido")
    private String description;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
