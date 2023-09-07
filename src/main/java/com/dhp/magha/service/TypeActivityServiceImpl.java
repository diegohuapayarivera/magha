package com.dhp.magha.service;

import com.dhp.magha.dto.TypeActivityDTO;
import com.dhp.magha.exception.ResourceNotFoundException;
import com.dhp.magha.model.TypeActivity;
import com.dhp.magha.repository.TypeActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class TypeActivityServiceImpl implements TypeActivityService{

    @Autowired
    private TypeActivityRepository typeActivityRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<TypeActivity> getTypeActivitys() {
        log.info("Get List Type Activitys");
        return this.typeActivityRepository.findAll();
    }

    @Override
    public TypeActivity createTypeActivity(TypeActivityDTO typeActivityDTO) {
        TypeActivity createTypeActivity = modelMapper.map(typeActivityDTO, TypeActivity.class);
        createTypeActivity.setDateCreated(LocalDateTime.now());
        log.info("Type Activity created service -> " + createTypeActivity);
        return this.typeActivityRepository.save(createTypeActivity);
    }

    @Override
    public TypeActivity updateTypeActivity(TypeActivityDTO typeActivityDTO) {
        TypeActivity updateTypeActivity = modelMapper.map(typeActivityDTO, TypeActivity.class);
        updateTypeActivity.setDateUpdated(LocalDateTime.now());
        log.info("Type Activity update service -> " + updateTypeActivity);
        return this.typeActivityRepository.save(updateTypeActivity);
    }

    @Override
    public void deleteTypeActivity(Integer id) {
        TypeActivity deleteTypeActivity = this.typeActivityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));
        this.typeActivityRepository.delete(deleteTypeActivity);
    }
}
