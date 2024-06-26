package com.ggpsgeorge.spring_employee_manager_with_more_relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/addresses")
public class AddressController {
    
    @Autowired AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        return ResponseEntity.ok().body(addressService.saveAddress(address));
    }

    @GetMapping("/{address_id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long address_id){
        return ResponseEntity.ok().body(addressService.finAddress(address_id));
    }

}
