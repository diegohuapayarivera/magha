package com.dhp.magha.controller;

import com.dhp.magha.dto.ActivityDTO;
import com.dhp.magha.model.Activity;
import com.dhp.magha.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activitys")
@Slf4j
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getActivitys(){
        log.info("Activity get List -> " + this.activityService.getActivitys());
        return new ResponseEntity<>(this.activityService.getActivitys(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Activity> createActivity(@RequestBody ActivityDTO activityDTO){
        log.info("Activity create controller -> " + activityDTO.toString());
        return new ResponseEntity<>(this.activityService.createActivity(activityDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Activity> updateActivity(@RequestBody ActivityDTO activityDTO){
        log.info("Activity update controller -> "+ activityDTO);
        return new ResponseEntity<>(this.activityService.updateActivity(activityDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> deleteActivity(@PathVariable Integer idDelete){
        log.info("Activity delete controller -> " + idDelete);
        this.activityService.deleteActivity(idDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
