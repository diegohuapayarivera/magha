package com.dhp.magha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivityDTO {

    private Integer id;
    private int typeActivity;
    private String description;
    private int level;

}
