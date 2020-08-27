package com.bouncer77.CourseProgressMaestro.repository;

import com.bouncer77.CourseProgressMaestro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 */

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
