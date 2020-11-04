package com.details.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
