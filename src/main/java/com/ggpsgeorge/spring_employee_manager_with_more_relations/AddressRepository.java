package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
