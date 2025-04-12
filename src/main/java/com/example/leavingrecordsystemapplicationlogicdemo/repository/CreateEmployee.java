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
        Integer empId = dsl.insertInto(EMPLOYEE)
                .set(EMPLOYEE.NAME, employeeModel.getName())
                .set(EMPLOYEE.EMAIL, employeeModel.getEmail())
                .set(EMPLOYEE.MOBILE, employeeModel.getMobile())
                .set(EMPLOYEE.E_POSITION, employeeModel.getPosition())
                .set(EMPLOYEE.STATUS, employeeModel.getStatus())
                .set(EMPLOYEE.MANAGER_ID, employeeModel.getManagerId())
                .returning(EMPLOYEE.ID)
                .fetchOne()
                .get(EMPLOYEE.ID);

        return dsl.select(EMPLOYEE.NAME, EMPLOYEE.EMAIL, EMPLOYEE.MOBILE, EMPLOYEE.STATUS, EMPLOYEE.E_POSITION, EMPLOYEE.MANAGER_ID)
                .from(EMPLOYEE)
                .where(EMPLOYEE.ID.eq(empId))
                .fetchOne(record -> new EmployeeModel(
                        record.get(EMPLOYEE.NAME),
                        record.get(EMPLOYEE.EMAIL),
                        record.get(EMPLOYEE.MOBILE),
                        record.get(EMPLOYEE.E_POSITION),
                        record.get(EMPLOYEE.STATUS)
                ));
    }
}
