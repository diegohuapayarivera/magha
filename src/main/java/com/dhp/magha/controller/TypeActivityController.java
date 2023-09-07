package com.dhp.magha.controller;


import com.dhp.magha.dto.TypeActivityDTO;
import com.dhp.magha.model.TypeActivity;
import com.dhp.magha.service.ActivityService;
import com.dhp.magha.service.TypeActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeActivitys")
@Slf4j
public class TypeActivityController {

    private TypeActivityService typeActivityService;

    public TypeActivityController(TypeActivityService typeActivityService) {
        this.typeActivityService = typeActivityService;
    }

    @GetMapping
    public ResponseEntity<List<TypeActivity>> getTypeActivitys() {
        log.info("Type Activity get List controller -> " + this.typeActivityService.getTypeActivitys());
        return new ResponseEntity<>(this.typeActivityService.getTypeActivitys(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TypeActivity> createTypeActivity(@RequestBody TypeActivityDTO typeActivityDTO) {
        log.info("Type Activity create controller -> " + this.typeActivityService.createTypeActivity(typeActivityDTO));
        return new ResponseEntity<>(this.typeActivityService.createTypeActivity(typeActivityDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TypeActivity> updateTypeActivity(@RequestBody TypeActivityDTO typeActivityDTO){
        log.info("Type Activity update controller -> " + this.typeActivityService.updateTypeActivity(typeActivityDTO));
        return new ResponseEntity<>(this.typeActivityService.updateTypeActivity(typeActivityDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> deleteActivity(@PathVariable Integer idDelete){
        log.info("Activity delete controller -> " + idDelete);
        this.typeActivityService.deleteTypeActivity(idDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
