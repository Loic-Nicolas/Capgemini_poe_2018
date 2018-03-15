package com.nestedlist.classes;

public class PersoListe {
	
	private Item start;
	private Item last;
	
	// ajoute un élément à la fin de la chaine
	public void add (String value) {
		if (start == null) {
			this.start = new Item (null, null, value);
			this.last = this.start;
		} else {
			Item newItem = new Item(this.last, null, value);
			this.last.setSuivant(newItem);
			this.last = newItem;
		}
	}
	
	// renvoie l'item à un indice donné
	public Item itemAt (int index) {
		if (index < this.count() && index >= 0) {
			Item current = this.start;
			for (int i = 0; i < index; i++) {
				current = current.getSuivant();
			}
			return current;
		} else {
			System.out.println("Pas un bon indice");
			return null;
		}
	}
	
	// retire l'item à un indice donné
	public void removeAt (int index) {
		if (index == 0) {
			start.getSuivant().setPrecedent(null);
			start = start.getSuivant();
		} else if (index == this.count() - 1) {
			last.getPrecedent().setSuivant(null);
			last = last.getPrecedent();
		} else {
			Item current = itemAt(index);
			current.getPrecedent().setSuivant(current.getSuivant());
			current.getSuivant().setPrecedent(current.getPrecedent());
		}
	}
	
	// affiche tous les items de la liste
	public void viewAll () {
		System.out.println("");
		if (this.start == null) {
			System.out.println("Il n'y a pas de valeur");
		} else {
			Item current = this.start;
			for (int i = 0; i < this.count(); i++) {
				System.out.println(current.getValeur());
				current = current.getSuivant();
			}
		}
	}
	
	// compte le nombre d'items dans la liste
	public int count () {
		int taille = 0;
		
		if (this.start == null) {
			return taille;
		} else {
			Item current = this.start;
			do {
				taille++;
				current = current.getSuivant();
			} while (current != null);
			return taille;
		}
	}
	
	// classe qui contient un élément de la chaine
	class Item {
		// attributs
		private Item precedent;
		private Item suivant;
		private String valeur;
		
		// constructeurs
		public Item() {
			
		}
		public Item(Item prec, Item suiv, String val) {
			this.precedent = prec;
			this.suivant = suiv;
			this.valeur = val;
		}
		
		// getters et setters
		public Item getPrecedent() {
			return precedent;
		}
		public void setPrecedent(Item precedent) {
			this.precedent = precedent;
		}
		public Item getSuivant() {
			return suivant;
		}
		public void setSuivant(Item suivant) {
			this.suivant = suivant;
		}
		public String getValeur() {
			return valeur;
		}
		public void setValeur(String valeur) {
			this.valeur = valeur;
		}
		
	}
}