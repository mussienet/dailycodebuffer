package com.dailycodebuffer.demo.service;

import com.dailycodebuffer.demo.entity.Department;
import com.dailycodebuffer.demo.error.DepartmentNotFoundException;
import com.dailycodebuffer.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(long departmentId) throws DepartmentNotFoundException {
      //  return departmentRepository.findById(departmentId).get();
        Optional<Department> department = departmentRepository.findById(departmentId);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department is Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(long departmentId, Department department) {
       Department depFromDB = departmentRepository.findById(departmentId).get();

       if(Objects.nonNull(department.getDepartmentName()) &&
         !"".equalsIgnoreCase(department.getDepartmentName())) {
           depFromDB.setDepartmentName(department.getDepartmentName());
       }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depFromDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depFromDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depFromDB);
    }

    @Override
    public Department findByDepartmentNameIgnoreCase(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
