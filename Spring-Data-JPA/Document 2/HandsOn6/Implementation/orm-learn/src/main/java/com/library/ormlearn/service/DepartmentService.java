package com.library.ormlearn.service;

import com.library.ormlearn.model.Department;
import com.library.ormlearn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department getDepartment(int id) {
        return departmentRepository.findById(id).orElse(null);
    }
}