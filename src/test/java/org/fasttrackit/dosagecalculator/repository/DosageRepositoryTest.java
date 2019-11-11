package org.fasttrackit.dosagecalculator.repository;

import org.fasttrackit.dosagecalculator.domain.Dose;
import org.fasttrackit.dosagecalculator.persistence.DoseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosageRepositoryTest {

    @Autowired
    private DoseRepository doseRepository;

    @Test
    public void testGetByWeight() {
        Dose dose = doseRepository.findByWeight(55);
        Assert.assertEquals(450, dose.getBoneDose());
    }

    @Test
    public void testGetByNotExistingWeight() {
        Dose dose = doseRepository.findByWeight(55000);
        Assert.assertNull(dose);
    }

}
