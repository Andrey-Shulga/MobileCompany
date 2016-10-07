package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import com.epam.as.mobilecomp.entities.WithoutFeeTariff;

/**
 * Created entities plan by type
 */
public class TariffFactory {
    public Tariff getTariff(String tariffType) {
        if (tariffType.equals("fee"))
            return new FeeTariff();
        else if (tariffType.equals("nofee"))
            return new WithoutFeeTariff();
        return null;
    }
}
