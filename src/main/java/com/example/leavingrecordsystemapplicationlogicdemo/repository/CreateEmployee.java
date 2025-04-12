package com.example.leavingrecordsystemapplicationlogicdemo.repository;

import com.example.leavingrecordsystemapplicationlogicdemo.model.EmployeeModel;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.example.jooq.tables.Employee.EMPLOYEE;

@RequiredArgsConstructor
@Repository
public class CreateEmployee {
    private final DSLContext dsl;

    public EmployeeModel execute(EmployeeModel employeeModel) {
        return dsl.insertInto(EMPLOYEE)
                .set(EMPLOYEE.NAME, employeeModel.getName())
                .set(EMPLOYEE.EMAIL, employeeModel.getEmail())
                .set(EMPLOYEE.MOBILE, employeeModel.getMobile())
                .set(EMPLOYEE.E_POSITION, employeeModel.getPosition())
                .set(EMPLOYEE.STATUS, employeeModel.getStatus())
                .set(EMPLOYEE.MANAGER_ID, employeeModel.getManagerId())
                .returningResult(EMPLOYEE.NAME,
                        EMPLOYEE.EMAIL,
                        EMPLOYEE.MOBILE,
                        EMPLOYEE.E_POSITION,
                        EMPLOYEE.STATUS,
                        EMPLOYEE.MANAGER_ID)
                .fetchOneInto(EmployeeModel.class);
    }
}
