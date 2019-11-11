package org.fasttrackit.dosagecalculator.service;

import org.fasttrackit.dosagecalculator.domain.Patient;
import org.fasttrackit.dosagecalculator.mapper.PatientMapper;
import org.fasttrackit.dosagecalculator.persistence.PatientRepository;
import org.fasttrackit.dosagecalculator.transfer.patient.PatientRequest;
import org.fasttrackit.dosagecalculator.transfer.patient.PatientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public PatientResponse createPatient(PatientRequest request) {
        LOGGER.info("Creating product: {}", request);

        Patient patient = PatientMapper.transferToDomain(request);
        return PatientMapper.domainToTransfer(patientRepository.save(patient));
    }

    public List<PatientResponse> findAll() {
        LOGGER.info("All patients: ");
        return PatientMapper.domainToTransferList(patientRepository.findAll());
    }

    public void deletePatient(long id) {
        LOGGER.info("Deleting patient {}", id);
        patientRepository.deleteById(id);
    }

    public List<PatientResponse> getByCnp(String cnp) {
        LOGGER.info("Getting patient by cnp: {}", cnp);
        return PatientMapper.domainToTransferList(patientRepository.findByCnp(cnp));
    }
}
