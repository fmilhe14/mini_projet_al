package tp.v2;

import java.util.Iterator;

public interface File<E> extends Iterable<E> {

	/*
	 * Accesseurs
	 */
	E premier();
	File<E> suivants();
	
	default boolean estVide() {
		return this.taille() == 0;
	}
	int taille();
	
	/*
	 * Fabriques
	 */
	File<E> creer();
	
	/*
	 * Services
	 */
	File<E> ajout(E dernierDansFile);
	File<E> retrait();
	File<E> ajout(File<E> secondeFile);
	
	default String representation() {
		// TODO 

		String res = "[ "+this.premier().toString()+" ,";

		File<E> suivants = this.suivants();

		while(!suivants.estVide()){

			res += suivants.premier()+" ," ;
		}

		return res+suivants.premier()+" ]" ;
	}

	default boolean estEgal(File<E> file){
		// TODO

		boolean estEgal = false ;

		if(this.taille() == file.taille()){

			estEgal = this.premier() == file.premier() ;

			File<E> suivants = this.suivants();

			while(estEgal && !this.estVide()){

				suivants = suivants.suivants();
				file = file.retrait() ;

				estEgal = this.premier() == file.premier() ;

			}

			return estEgal;
		}

		return estEgal;
	}
	
	
}