package com.dhp.magha.service;


import com.dhp.magha.dto.ActivityDTO;
import com.dhp.magha.model.Activity;

import java.util.List;

public interface ActivityService {

    public List<Activity> getActivitys();

    public Activity createActivity(ActivityDTO activityDTO);

    public Activity updateActivity(ActivityDTO activityDTO);

    public void deleteActivity(Integer id);
}
