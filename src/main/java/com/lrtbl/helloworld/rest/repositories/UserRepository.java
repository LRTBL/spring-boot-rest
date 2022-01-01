package com.lrtbl.helloworld.rest.repositories;

import com.lrtbl.helloworld.rest.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
}
