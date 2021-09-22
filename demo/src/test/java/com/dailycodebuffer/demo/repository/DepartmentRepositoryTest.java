package com.dailycodebuffer.demo.repository;

import com.dailycodebuffer.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@DataJpaTest
//@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

//    @MockBean
//    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Department department;

    @BeforeEach
    void setUp() {
         department = Department.builder()
                                          .departmentName("Mechanical Engineering")
                                          .departmentAddress("Massawa")
                                          .departmentCode("I-001")
                                          .build();

        entityManager.persist(department);

    }

    @Test
    @DisplayName("Test department name by id")
    public void whenFindById_thenReturnDepartment() {

//        Mockito.when(departmentRepository.findById(any())).thenReturn(Optional.of(department));
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName(),"Mechanical Engineering");
    }
}