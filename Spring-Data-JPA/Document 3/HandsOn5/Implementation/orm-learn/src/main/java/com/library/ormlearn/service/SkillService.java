package com.library.ormlearn.service;

import com.library.ormlearn.model.Skill;
import com.library.ormlearn.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public Skill getSkill(int id) {
        return skillRepository.findById(id).orElse(null);
    }
}
