Mini-projet Architecture Logicielle

François Milhem
Clovis Monmousseau
Antoine Diab Maalouf

Principe de conception suivi pour les interfaces et les classes d'implémentation:
Patron Etat

Principes de nommage suivis :
Les interfaces représentant l'Etat d'une file sont préfixés du nom "Etat"
Les classes qui implémentent les interfaces d'Etat sont préfixé par le type d'état que l'on implémente
et suffixé par le type de liste qu'on utilise pour représenter l'état.
Enfin, les classes préfixées par File et suffixé par l'état représentent les files et l'état
qu'elles utilisent pour être implémenter.


Complexité des opérations:

FileMutable : ajout O(1) - retrait O(1) - taille O(1)

Tests :
Classe v5.Test , compare la vitesse entre la File mutable et la File Immutable en terme d'ajout et de
retrait

