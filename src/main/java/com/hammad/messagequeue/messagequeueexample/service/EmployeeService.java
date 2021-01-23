package com.hammad.messagequeue.messagequeueexample.service;

import com.hammad.messagequeue.messagequeueexample.model.Employee;
import com.hammad.messagequeue.messagequeueexample.repositories.EmployeeRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeService {

    @Value("hammad.queue")
    private String queueName;
    @Value("hammad.exchange")
    private String exchangeName;
    @Value("hammad.routingkey")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee sendMessage(Employee employee)
    {
        rabbitTemplate.convertAndSend(exchangeName,routingKey,employee);
        return employeeRepository.save(employee);
    }

    public Employee receiveMessage()
    {
        Employee employee = (Employee) rabbitTemplate.receiveAndConvert(queueName);
        return employee;
    }

//    @Scheduled(fixedRate = 30000L)
//    public void employeeScheduled()
//    {
//        Employee employee = (Employee) rabbitTemplate.receiveAndConvert(queueName);
//        System.out.println("Fetch Queue in " + new Date().toString());
//        System.out.println(employee.toString());
//    }

    @Scheduled(cron = "0/35 * * * * *")
    public void employeeScheduledCron()
    {
        Employee employee = (Employee) rabbitTemplate.receiveAndConvert(queueName);
        System.out.println("Fetch Queue(Cron Example) in " + new Date().toString());
        System.out.println(employee.toString());
    }
}
