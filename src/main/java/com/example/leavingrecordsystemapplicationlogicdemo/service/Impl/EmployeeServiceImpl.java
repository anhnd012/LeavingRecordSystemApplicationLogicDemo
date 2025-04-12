package com.example.leavingrecordsystemapplicationlogicdemo.service.Impl;

import com.example.leavingrecordsystemapplicationlogicdemo.model.EmployeeModel;
import com.example.leavingrecordsystemapplicationlogicdemo.repository.CreateEmployee;
import com.example.leavingrecordsystemapplicationlogicdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final DSLContext dslContext;

    @Override
    public EmployeeModel createEmployee(EmployeeModel employee) {
        var createEmployee = new CreateEmployee(dslContext);
        return createEmployee.execute(employee);
    }
}
