package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

/**
 * Created by student on 12.05.2017.
 */
public abstract class Umowa {


    // składki na ubezpieczenia społeczne
    protected BigDecimal s_emerytalna = new BigDecimal(0); // 9,76% podstawyy
    protected BigDecimal s_rentowa = new BigDecimal(0); // 1,5% podstawy
    protected BigDecimal u_chorobowe = new BigDecimal(0); // 2,45% podstawy
    // składki na ubezpieczenia zdrowotne
    protected BigDecimal kosztyUzyskania = new BigDecimal(111.25);
    protected BigDecimal s_zdrow1 = new BigDecimal(0); // od podstawy wymiaru 9%
    protected BigDecimal s_zdrow2 = new BigDecimal(0); // od podstawy wymiaru 7,75 %
    protected BigDecimal zaliczkaNaPod = new BigDecimal(0);; // zaliczka na podatek dochodowy 18%
    protected BigDecimal kwotaZmiejsz = new BigDecimal(46.33); // kwota zmienjszająca podatek 46,33 PLN
    protected BigDecimal zaliczkaUS = new BigDecimal(0);
    protected BigDecimal zaliczkaUS0 = new BigDecimal(0);
    protected BigDecimal podstawa;
    protected BigDecimal oPodstawa;
    protected BigDecimal podstawaOpodat;
    protected BigDecimal podstawaOpodat0;
    protected BigDecimal podatekPotracony;
    protected BigDecimal wynagrodzenie;


    public  void obliczZaliczke() {
        zaliczkaUS = zaliczkaNaPod.subtract(s_zdrow2).subtract(kwotaZmiejsz);
    }

    public  void obliczPodatek(BigDecimal podstawa) {
        zaliczkaNaPod = new BigDecimal((podstawa.floatValue() * 18) / 100);
    }

    public  BigDecimal obliczonaPodstawa(BigDecimal podstawa) {
        s_emerytalna = new BigDecimal((podstawa.floatValue() * 9.76) / 100);
        s_rentowa = new BigDecimal((podstawa.floatValue() * 1.5) / 100);
        u_chorobowe = new BigDecimal((podstawa.floatValue() * 2.45) / 100);
        return podstawa.subtract(s_emerytalna).subtract(s_rentowa).subtract(u_chorobowe);
    }

    public  void obliczUbezpieczenia(BigDecimal podstawa) {
        s_zdrow1 = new BigDecimal((podstawa.longValue() * 9) / 100);
        s_zdrow2 = new BigDecimal((podstawa.longValue() * 7.75) / 100);
    }

    public abstract void oblicz(BigDecimal podstawa);

}
