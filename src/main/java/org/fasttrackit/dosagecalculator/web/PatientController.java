package org.fasttrackit.dosagecalculator.web;

import org.fasttrackit.dosagecalculator.service.PatientService;
import org.fasttrackit.dosagecalculator.transfer.patient.PatientRequest;
import org.fasttrackit.dosagecalculator.transfer.patient.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientResponse>> getPatients() {
        List<PatientResponse> patients = patientService.findAll();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/cnp/{cnp}")
    public ResponseEntity<List<PatientResponse>> getPatientByCnp(@PathVariable("cnp") String cnp) {
        List<PatientResponse> patients = patientService.getByCnp(cnp);
        if (patients.size() > 0) {
            return new ResponseEntity<>(patients, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@RequestBody @Valid PatientRequest request) {
        PatientResponse patient = patientService.createPatient(request);

        if (null != patient) {
            return new ResponseEntity<>(patient, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable("id") long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
