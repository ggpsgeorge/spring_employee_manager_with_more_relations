package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Long id;

    @Column(name = "employee_name", nullable = false)
    String name;

    @Column(name = "employee_email")
    String email;

    @Column(name = "employee_birth_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date birthDate;

    @Column(name = "employee_position")
    String position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_address", referencedColumnName = "address_id")
    Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_department", referencedColumnName = "department_id")
    Department department;

}
