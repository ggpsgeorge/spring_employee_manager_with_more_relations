package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id")
    Long id;

    @Column(name = "address_street")
    String street;

    @Column(name = "address_house_number")
    int houseNumber;

    @Column(name = "address_zipcode")
    String zipCode;

    @OneToOne(mappedBy = "address")
    Employee employee;
}
