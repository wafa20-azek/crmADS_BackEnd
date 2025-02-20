package org.example.repository;

import org.example.model.Activity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActivityRepository extends CrudRepository<Activity,Long> {
    @Query("SELECT a FROM Activity a JOIN a.participants p WHERE p.id = :contactId")
    List<Activity> findActivitiesByContactId(Long contactId);

}
