package com.interswitch.model;


import java.math.BigDecimal;
import java.util.Date;

public class Salary {

    private Long id;

    private long employeeId;

    private BigDecimal amount;

    private Long departmentId;

    public Salary(long employeeId, BigDecimal amount, Date date) {
        this.employeeId = employeeId;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId(){
        return departmentId;
    }

}
