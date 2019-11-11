package org.fasttrackit.dosagecalculator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


/**
 * For populating the Dose Table with Standard values
 * <p>
 * INSERT INTO dose (id, min_weight, max_weight, bone_dose, thyroid_dose, renal_dose)
 * VALUES
 * (1, 0,50,400,90,100),
 * (2, 51,60,450,100,110),
 * (3, 61,70,500,120,120),
 * (4, 71,80,550,140,140),
 * (5, 81,90,650,150,150),
 * (6, 91,100,700,160,160),
 * (7, 101,150,740,185,185);
 */
@Entity
public class Dose {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private int minWeight;
    @NotNull
    private int maxWeight;
    private int boneDose;
    private int thyroidDose;
    private int renalDose;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getBoneDose() {
        return boneDose;
    }

    public void setBoneDose(int boneDose) {
        this.boneDose = boneDose;
    }

    public int getThyroidDose() {
        return thyroidDose;
    }

    public void setThyroidDose(int thyroidDose) {
        this.thyroidDose = thyroidDose;
    }

    public int getRenalDose() {
        return renalDose;
    }

    public void setRenalDose(int renalDose) {
        this.renalDose = renalDose;
    }

    @Override
    public String toString() {
        return "Dose{" +
                "id=" + id +
                ", minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                ", boneDose=" + boneDose +
                ", thyroidDose=" + thyroidDose +
                ", renalDose=" + renalDose +
                '}';
    }
}
