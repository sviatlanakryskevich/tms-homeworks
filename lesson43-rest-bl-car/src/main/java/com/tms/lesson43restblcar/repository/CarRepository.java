package com.tms.lesson43restblcar.repository;
import com.tms.lesson43restblcar.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}
