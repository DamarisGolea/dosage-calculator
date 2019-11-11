package org.fasttrackit.dosagecalculator.service;

import org.fasttrackit.dosagecalculator.domain.Dose;
import org.fasttrackit.dosagecalculator.persistence.DoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class DoseService {

    private static final String BONE = "bone";
    private static final String THYROID = "thyroid";
    private static final String RENAL = "renal";
    private final DoseRepository doseRepository;

    @Autowired
    public DoseService(DoseRepository doseRepository) {
        this.doseRepository = doseRepository;
    }

    public int getByProcedureAndWeight(String procedureType, int weight) {
        LOGGER.info("Getting dose by procedure and weight: ");
        Dose dose = doseRepository.findByWeight(weight);

        if (null != dose) {
            switch (procedureType) {
                case BONE:
                    return dose.getBoneDose();
                case THYROID:
                    return dose.getThyroidDose();
                case RENAL:
                    return dose.getRenalDose();
                default:
                    throw new IllegalArgumentException("Unknown procedure type: " + procedureType);
            }
        }
        return 0;
    }

}
