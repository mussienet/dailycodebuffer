package com.dailycodebuffer.demo.service;

import com.dailycodebuffer.demo.entity.Department;
import com.dailycodebuffer.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

  public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(long departmentId);

   public Department updateDepartment(long departmentId, Department department);

   public Department findByDepartmentNameIgnoreCase(String departmentName);
}
