package com.lrtbl.helloworld.rest.repositories;

import com.lrtbl.helloworld.rest.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
