package org.fasttrackit.dosagecalculator.service;

import org.fasttrackit.dosagecalculator.transfer.patient.PatientRequest;
import org.fasttrackit.dosagecalculator.transfer.patient.PatientResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void testCreatePatient() {
        PatientResponse patient = patientService.createPatient(createPatient("Test1", "Test1L", "1234557", 54, 87));
        Assert.assertEquals("Test1", patient.getFirstName());
        Assert.assertEquals("Test1L", patient.getLastName());
        Assert.assertEquals("1234557", patient.getCnp());
        Assert.assertEquals(54, patient.getAge());
        Assert.assertEquals(87, patient.getWeight());
    }

    @Test
    public void testFindAll() {
        List<PatientResponse> patients = patientService.findAll();
        assertThat(patients.size(), is(greaterThanOrEqualTo(1)));
    }


    // test pentru cnp - folosesti cnp`ul creat
    // test pentru delete -> citesti dupa cnp, folosesti id`ul ca sa stergi pacientul -> mai cauti o data dupa cnp -> verific sa nu vina nimic


    private PatientRequest createPatient(String firstName, String lastName, String cnp, int age, int weight) {

        PatientRequest patient = new PatientRequest();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setCnp(cnp);
        patient.setAge(age);
        patient.setWeight(weight);

        return patient;
    }

//    @Test
//    public void testGetByCnp() {
//        List<PatientResponse> patient = patientService.getByCnp("1234557");
//        assertThat(patient).i;
//   }
}
