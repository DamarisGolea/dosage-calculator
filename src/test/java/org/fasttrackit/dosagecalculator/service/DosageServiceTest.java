package org.fasttrackit.dosagecalculator.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosageServiceTest {

    @Autowired
    private DoseService doseService;

    @Test
    public void testGetByProcedureAndWeight() {
        int dose = doseService.getByProcedureAndWeight("bone", 55);
        Assert.assertEquals(450, dose);
    }

    @Test
    public void testGetByWrongProcedureAndWeight() {
        boolean isWrongProcedure = false;
        try {
            doseService.getByProcedureAndWeight("ciuciu", 61);
        } catch (IllegalArgumentException e) {
            isWrongProcedure = true;
        }

        Assert.assertTrue(isWrongProcedure);
    }

    @Test
    public void testGetByProcedureAndWrongWeight() {
        int dose = doseService.getByProcedureAndWeight("bone", 55000);
        Assert.assertEquals(0, dose);
    }
}
