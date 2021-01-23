package com.hammad.messagequeue.messagequeueexample.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;
    private String name;
    private int salary;
    private int age;

    public Employee() {}

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
