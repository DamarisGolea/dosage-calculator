package org.fasttrackit.dosagecalculator.web;


import org.fasttrackit.dosagecalculator.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/dosages")
public class DoseController {

    private final DoseService doseService;

    @Autowired
    public DoseController(DoseService doseService) {
        this.doseService = doseService;
    }

    @GetMapping("/getByProcedureAndWeight/{procedureType}/{weight}")
    public ResponseEntity<Integer> getByProcedureAndWeight(@PathVariable("procedureType") String procedureType,
                                                           @PathVariable("weight") int weight) {
        try {
            int dosage = doseService.getByProcedureAndWeight(procedureType, weight);
            if (dosage > 0) {
                return new ResponseEntity<>(dosage, HttpStatus.OK);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
