package com.example.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crm.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
