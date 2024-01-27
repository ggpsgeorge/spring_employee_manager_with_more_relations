package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address finAddress(Long address_id) {
        return addressRepository.findById(address_id).get();
    }
}
