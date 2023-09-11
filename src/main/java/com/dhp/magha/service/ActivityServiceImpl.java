package com.dhp.magha.service;

import com.dhp.magha.dto.ActivityDTO;
import com.dhp.magha.exception.ResourceNotFoundException;
import com.dhp.magha.model.Activity;
import com.dhp.magha.repository.ActivityRespository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    private ActivityRespository activityRespository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Activity> getActivitys() {
        log.info("Get List Type Activitys");
        return this.activityRespository.findAll();
    }

    @Override
    public Activity createActivity(ActivityDTO activityDTO) {
        Activity createActivity = modelMapper.map(activityDTO, Activity.class);
        createActivity.setDateCreated(LocalDateTime.now());
        log.info("Activity created service -> " + createActivity);
        return this.activityRespository.save(createActivity);
    }

    @Override
    public Activity updateActivity(ActivityDTO activityDTO) {
        Activity updateActivity = modelMapper.map(activityDTO, Activity.class);
        updateActivity.setDateUpdated(LocalDateTime.now());
        log.info("Activity update servide -> " + updateActivity);
        return this.activityRespository.save(updateActivity);
    }

    @Override
    public void deleteActivity(Integer id) throws ResourceNotFoundException{
        Activity deleteActivity = this.activityRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));
        this.activityRespository.deleteById(deleteActivity.getId());
    }
}
