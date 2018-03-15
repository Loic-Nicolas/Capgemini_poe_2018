package com.nestedlist.classes;

// classe qui définit des listes chaînées
public class PersoListe {
	
	private Item start; 	// item situé au début de la liste
	private Item last; 		// item situé à la fin de la liste
	
	// compte le nombre d'items dans la liste
	public int count () {
		int taille = 0;
		
		if (this.start == null) { 				// si la liste est vide
			return taille; 						// taille = 0
		} else {
			Item current = this.start; 			// on crée un curseur au début de la liste
			do {
				taille++;
				current = current.getSuivant(); // on déplace le curseur de proche en proche
			} while (current != null);
			return taille;
		}
	}
	
	// affiche tous les items de la liste
	public void viewAll () {
		System.out.println("");
		if (this.start == null) { 							// si la liste est vide
			System.out.println("Il n'y a pas de valeur");
		} else {
			Item current = this.start; 						// on crée un curseur au début de la liste
			for (int i = 0; i < this.count(); i++) {
				System.out.println(current.getValeur()); 	// on affiche la valeur de l'élément
				current = current.getSuivant(); 			// on déplace le curseur de proche en proche
			}
		}
	}
	
	// ajoute un élément à la fin de la chaine
	public void add (String value) {
		if (start == null) { 									// si la liste est vide
			this.start = new Item (null, null, value); 			// on crée le début de la chaîne
			this.last = this.start;
		} else {
			Item newItem = new Item (this.last, null, value); 	// on crée un élément
			this.last.setSuivant(newItem); 						// on le chaine au dernier élément de la chaine
			this.last = newItem; 								// le nouvel élément est maintenant le dernier élément de la chaîne
		}
	}
	
	// renvoie l'item à un indice donné
	public Item itemAt (int index) {
		if (index < this.count() && index >= 0) { 	// si l'indice est dans la liste
			Item current = this.start; 				// on crée un curseur au début de la liste
			for (int i = 0; i < index; i++) {
				current = current.getSuivant(); 	// on déplace le curseur de proche en proche
			}
			return current;
		} else { 									// si l'indice est en dehors des bornes de la liste
			System.out.println("Pas un bon indice");
			return null;
		}
	}
	
	// retire l'item à un indice donné
	public void removeAt (int index) {
		if (index == 0) { 												// si on veut supprimer le premier élément de la liste
			start.getSuivant().setPrecedent(null);
			start = start.getSuivant(); 								// on réassigne le début de la liste
		} else if (index == this.count() - 1) { 						// si on veut supprimer le dernier élément de la liste
			last.getPrecedent().setSuivant(null);
			last = last.getPrecedent(); 								// on réassigne la fin de la liste
		} else {
			Item current = itemAt(index);
			current.getPrecedent().setSuivant(current.getSuivant()); 	// on lie le N-1 au N+1
			current.getSuivant().setPrecedent(current.getPrecedent()); 	// on lie le N+1 au N-1
		}
	}
	
	// classe qui définit un élément de la chaine
	class Item {
		// attributs
		private Item precedent; 	// item précédent dans la liste
		private Item suivant; 		// item suivant dans la liste
		private String valeur; 		// valeur contenue par l'item
		
		// constructeurs
		public Item() {
			
		}
		public Item(Item prec, Item suiv, String value) {
			this.precedent = prec;
			this.suivant = suiv;
			this.valeur = value;
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