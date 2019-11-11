package org.fasttrackit.dosagecalculator.persistence;

import org.fasttrackit.dosagecalculator.domain.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DoseRepository extends JpaRepository<Dose, Long> {

    @Query("SELECT d from Dose d where :weight between d.minWeight and d.maxWeight")
    Dose findByWeight(@Param("weight") Integer weight);
}
