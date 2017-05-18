package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by student on 12.05.2017.
 */
public class UmowaPraca extends Umowa {


    @Override
    public void oblicz(BigDecimal podstawa) {
        this.podstawa = podstawa;

        oPodstawa = obliczonaPodstawa(podstawa);
        obliczUbezpieczenia(oPodstawa);
        podstawaOpodat = oPodstawa.subtract(kosztyUzyskania);
        podstawaOpodat0 = podstawa.setScale(0);
        obliczPodatek(podstawaOpodat0);
        podatekPotracony = zaliczkaNaPod.subtract(kwotaZmiejsz);
        obliczZaliczke();
        zaliczkaUS0 = zaliczkaUS.setScale(0);
        wynagrodzenie = podstawa.subtract((s_emerytalna.add(s_rentowa).add( u_chorobowe)).add( s_zdrow1).add(zaliczkaUS0));

    }


    @Override
    public String toString() {
        return "UMOWA O PRACĘ" + System.lineSeparator()
                + "Podstawa wymiaru składek " + podstawa + System.lineSeparator() +
                "Składka na ubezpieczenie emerytalne "
                + s_emerytalna.toString() + System.lineSeparator() +
                "Składka na ubezpieczenie rentowe    "
                + s_rentowa.toString() + System.lineSeparator() +
                "Składka na ubezpieczenie chorobowe  "
                + u_chorobowe.toString() + System.lineSeparator() +
                "Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
                + oPodstawa + System.lineSeparator() +
                "Składka na ubezpieczenie zdrowotne: 9% = "
                + s_zdrow1.toString() + " 7,75% = " + s_zdrow2.toString() + System.lineSeparator()
                + "Koszty uzyskania przychodu w stałej wysokości "
                + kosztyUzyskania.toString() + System.lineSeparator() +
                "Podstawa opodatkowania " + podstawaOpodat.toString()
                + " zaokrąglona " + podstawaOpodat0.toString() + System.lineSeparator()
                + "Zaliczka na podatek dochodowy 18 % = "
                + zaliczkaNaPod.toString() + System.lineSeparator() +
                "Kwota wolna od podatku = " + kwotaZmiejsz.toString() + System.lineSeparator() +
                "Podatek potrącony = "
                + podatekPotracony.toString() + System.lineSeparator() +
                "Zaliczka do urzędu skarbowego = "
                + zaliczkaUS.toString() + " po zaokrągleniu = "
                + zaliczkaUS0.toString() + System.lineSeparator() +
                "Pracownik otrzyma wynagrodzenie netto w wysokości = "
                + wynagrodzenie.toString();
    }
}
