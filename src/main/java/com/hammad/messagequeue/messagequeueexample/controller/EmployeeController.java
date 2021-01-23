package com.hammad.messagequeue.messagequeueexample.controller;

import com.hammad.messagequeue.messagequeueexample.model.Employee;
import com.hammad.messagequeue.messagequeueexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody Employee employee)
    {
        Employee emp = employeeService.sendMessage(employee);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @GetMapping("/receive")
    public ResponseEntity<?> receiveMessage()
    {
        Employee employee = employeeService.receiveMessage();
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
}
