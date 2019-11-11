package org.fasttrackit.dosagecalculator.mapper;

import org.fasttrackit.dosagecalculator.domain.Patient;
import org.fasttrackit.dosagecalculator.transfer.patient.PatientRequest;
import org.fasttrackit.dosagecalculator.transfer.patient.PatientResponse;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {

    public static Patient transferToDomain(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setCnp(patientRequest.getCnp());
        patient.setAge(patientRequest.getAge());
        patient.setWeight(patientRequest.getWeight());

        return patient;
    }

    public static PatientResponse domainToTransfer(Patient patient) {
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patient.getId());
        patientResponse.setFirstName(patient.getFirstName());
        patientResponse.setLastName(patient.getLastName());
        patientResponse.setCnp(patient.getCnp());
        patientResponse.setAge(patient.getAge());
        patientResponse.setWeight(patient.getWeight());

        return patientResponse;
    }

    public static List<PatientResponse> domainToTransferList(List<Patient> patients) {
        List<PatientResponse> patientResponses = new ArrayList<>();
        for (Patient patient : patients) {
            patientResponses.add(domainToTransfer(patient));
        }
        return patientResponses;
    }


}
