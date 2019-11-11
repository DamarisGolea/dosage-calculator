package org.fasttrackit.dosagecalculator.persistence;

import org.fasttrackit.dosagecalculator.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByCnp(String cnp);
}
