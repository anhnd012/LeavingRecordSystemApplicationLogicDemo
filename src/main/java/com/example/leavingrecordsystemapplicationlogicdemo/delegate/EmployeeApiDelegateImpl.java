package com.example.leavingrecordsystemapplicationlogicdemo.delegate;


import com.example.leavingrecordsystemapplicationlogicdemo.api.EmployeeApiDelegate;
import com.example.leavingrecordsystemapplicationlogicdemo.model.EmployeeModel;
import com.example.leavingrecordsystemapplicationlogicdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class EmployeeApiDelegateImpl implements EmployeeApiDelegate {
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeModel> createEmployee(EmployeeModel employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }
}
