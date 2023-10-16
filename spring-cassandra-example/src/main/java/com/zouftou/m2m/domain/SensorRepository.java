package com.zouftou.m2m.domain;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface SensorRepository extends CrudRepository<Sensor, UUID> {

    @Query("SELECT * FROM sensor WHERE name =:name ALLOW FILTERING")
    Optional<Sensor> findByName(String name);
}
