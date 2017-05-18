package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by student on 12.05.2017.
 */
public class UmowaZlecenie extends Umowa {

    @Override
    public void oblicz(BigDecimal podstawa) {
        this.podstawa = podstawa;
        oPodstawa = obliczonaPodstawa(podstawa);
        obliczUbezpieczenia(oPodstawa);
        kwotaZmiejsz = new BigDecimal(0);
        kosztyUzyskania = new BigDecimal((oPodstawa.floatValue() * 20) / 100);
        podstawaOpodat = oPodstawa.subtract(kosztyUzyskania);
        podstawaOpodat0 = podstawaOpodat.setScale(0, BigDecimal.ROUND_HALF_DOWN);
        obliczPodatek(podstawaOpodat0);
        podatekPotracony = zaliczkaNaPod;
        obliczZaliczke();
        zaliczkaUS0 = zaliczkaUS.setScale(0, BigDecimal.ROUND_HALF_DOWN);
        wynagrodzenie = podstawa.subtract((s_emerytalna.add(s_rentowa).add(u_chorobowe).add(s_zdrow1).add(zaliczkaUS0)));

    }


    @Override
    public String toString() {
        return "UMOWA-ZLECENIE" +
                "Podstawa wymiaru składek " + podstawa.toString() + System.lineSeparator() +
                "Składka na ubezpieczenie emerytalne "
                + s_emerytalna.toString() + System.lineSeparator()+ System.lineSeparator() +
                "Składka na ubezpieczenie rentowe    "
                + s_rentowa.toString() + System.lineSeparator() + System.lineSeparator() +
                "Składka na ubezpieczenie chorobowe  "
                + u_chorobowe.toString() + System.lineSeparator() + System.lineSeparator()+
                "Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
                + oPodstawa.toString() + System.lineSeparator() + System.lineSeparator()+
                "Składka na ubezpieczenie zdrowotne: 9% = "
                + s_zdrow1.toString() + " 7,75% = " + s_zdrow2.toString() + System.lineSeparator()+
                "Koszty uzyskania przychodu (stałe) "
                + kosztyUzyskania.toString() + System.lineSeparator()+
                "Podstawa opodatkowania " + podstawaOpodat
                + " zaokrąglona " + podstawaOpodat0.toString() + System.lineSeparator() +
                "Zaliczka do urzędu skarbowego = "
                + zaliczkaUS.toString() + " po zaokrągleniu = "
                + zaliczkaUS0.toString() + System.lineSeparator()+
                "Podatek potrącony = "
                + podatekPotracony.toString() + System.lineSeparator() +
                "Zaliczka na podatek dochodowy 18 % = "
                + zaliczkaNaPod.toString() + System.lineSeparator() +
                "Pracownik otrzyma wynagrodzenie netto w wysokości = "
                + wynagrodzenie.toString();



    }
}
