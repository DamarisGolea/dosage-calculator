package org.fasttrackit.dosagecalculator.utils;

import org.fasttrackit.dosagecalculator.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class PatientSteps {

//    public Patient getById(long id){
//        Patient patient = patientService.getPatient(id);
//        return  patient;
//    }
//    public Patient createPatient(){
//        PatientRequest request = new PatientRequest();
//        request.setFirstName("Andrew");
//        request.setLastName("Sawyer");
//        request.setCnp("1235676349985");
//        request.setAge(31);
//        request.setWeight(90);
//
//        Patient patient = patientService.createPatient(request);
//
//        assertThat(patient, notNullValue());
//        assertThat(patient.getId(), notNullValue());
//        assertThat(patient.getId(), greaterThan(0L));
//        //asserturi de get
//        return patient;
//    }
}
