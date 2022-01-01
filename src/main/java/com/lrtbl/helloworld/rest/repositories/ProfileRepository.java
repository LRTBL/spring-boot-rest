package com.lrtbl.helloworld.rest.repositories;

import com.lrtbl.helloworld.rest.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
