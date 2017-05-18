package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TaxCalculator {

	public static char typUmowy = ' ';
	public static double podstawa = 0;

	public static Umowa umowa;

	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("Podaj kwotę dochodu: ");	
			podstawa = Double.parseDouble(br.readLine());
			
			System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
			typUmowy = br.readLine().charAt(0);
			
		} catch (Exception ex) {
			System.out.println("Błędna kwota");
			System.err.println(ex);
			return;
		}
		
		DecimalFormat df00 = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("#");
		
		if (typUmowy == 'P') {
			umowa = new UmowaPraca();
		} else if (typUmowy == 'Z') {
			umowa = new UmowaZlecenie();
		}

		if (umowa != null) {
			umowa.oblicz(new BigDecimal(podstawa));
			System.out.println(umowa);
		}
		else {
			System.out.println("Nieobsugiwany typ umowy");
		}
	}

}
