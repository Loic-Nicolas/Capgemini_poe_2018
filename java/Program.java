package com.nestedlist.classes;

public class Program {

	public static void main(String[] args) {
		
		PersoListe promo = new PersoListe();
		
		promo.add("Sarah");
		promo.add("Assane");
		promo.add("Alex");
		promo.add("Jean");
		promo.add("Safia");
		promo.add("Loic");
		promo.add("Bukhari");
		promo.add("Imad");
		promo.add("Ismael");
		promo.add("Rym");
		promo.add("Cesar");
		
		promo.viewAll();
		
		promo.add("Freddy");
		
		promo.viewAll();
		System.out.println(promo.count());
	}

}
