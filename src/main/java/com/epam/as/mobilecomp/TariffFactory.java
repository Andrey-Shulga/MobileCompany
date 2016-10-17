package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import com.epam.as.mobilecomp.entities.WithoutFeeTariff;

/**
 * Created tariff plan by type
 */
public class TariffFactory {

    public Tariff getTariff(String tariffType) {

        switch (tariffType) {
            case "fee":
                return new FeeTariff();
            case "nofee":
                return new WithoutFeeTariff();
            default:
                return null;
        }
    }
}
