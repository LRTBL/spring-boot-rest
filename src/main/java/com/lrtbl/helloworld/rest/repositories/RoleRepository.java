package com.lrtbl.helloworld.rest.repositories;

import com.lrtbl.helloworld.rest.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
