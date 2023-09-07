package com.dhp.magha.service;


import com.dhp.magha.dto.TypeActivityDTO;
import com.dhp.magha.model.TypeActivity;

import java.util.List;

public interface TypeActivityService {

    public List<TypeActivity> getTypeActivitys();

    public  TypeActivity createTypeActivity(TypeActivityDTO typeActivityDTO);

    public TypeActivity updateTypeActivity(TypeActivityDTO typeActivityDTO);

    public void deleteTypeActivity(Integer id);

    public void validateTypeActivityExist(Integer id);
}
