# Partie Python 1 - les bases

## 1. Chaine miroire

Écrire une fonction mirror(string) qui retourne le miroir d'un mot. C’est-à-dire la valeur obtenue en lisant le mot de droite à gauche.

Par exemple, le miroir de « abcd » est « dcba ».

```py
def mirror(string):
    return string[::-1]
```

## 2. Palindrome

Écrire une fonction palindrome(string) qui retourne True si string est un palindrome et false sinon.

La fonction mirror de l'exercice précédent est mise à votre disposition sans que le code soit visible

```py
def palindrome(string):
    if string == mirror(string):
        return True
    else:
        return False
```

## 3. Génération d'un palindrome

Une conjecture annonce qu’à partir de tout nombre si on l’additionne avec son miroir puis si l’on reproduit itérativement cette même opération avec le résultat de la somme, on obtient un palindrome après un nombre fini d’étapes (éventuellement nul).

Exemple avec 168 :

168 + 861 = 1029 + 9201 = 10230 + 03201 = 13431 est un palindrome

On veut se baser sur cette conjecture pour créer des palindromes.

Créer une fonction generate_palindrome(nombre_entree) qui prend en entrée un nombre et qui retourne un palindrome à partir du nombre en entrée. Le nombre en entrée devra être retournée sous forme de string

Les fonctions des exercices précédentes sont mises à votre disposition

- is_palindrome
- mirror

sont mis à disposition

```py
def generate_palindrome(nombre_entree):
    while is_palindrome(str(nombre_entree)) == False:
        nombre_entree = nombre_entree + int(mirror(str(nombre_entree)))
    return(str(nombre_entree))
```

## 4. Crible érathostène

On veut un moyen d'obtenir une liste de nombre premiers. Pour cela on peut utiliser l'algorithme du crible d'ératostène.

Ce dernier initialise un tableau « crible » de booléens à vrai (de l’indice 2 à l’indice n) puis teste chaque nombre « i » du tableau ainsi : si crible(i) est vrai alors « i » est premier et on barre (c.à.d. on marque à faux) tous les multiples de i. Il est inutile de barrer les multiples des nombres non premiers.

1. créer une fonction eratostene(n) qui retourne le liste des n premiers nombres premiers en utilisant l'algorithme du crible d'ératosthène.

2. Créer une fonction test_eratostene qui test votre fonction eratostene.

```py
def eratostene(n):
    if n < 2:
        return []

    crible = [True] * (n + 1)
    crible[0] = crible[1] = False

    for i in range(2, int(n**0.5) + 1):
        if crible[i]:
            for j in range(i * i, n + 1, i):
                crible[j] = False

    return [i for i in range(2, n + 1) if crible[i]]

def test_eratostene():
    assert eratostene(1) == [], "Test échoué pour n=1"
    assert eratostene(2) == [2], "Test échoué pour n=2"
    assert eratostene(10) == [2, 3, 5, 7], "Test échoué pour n=10"
    assert eratostene(20) == [2, 3, 5, 7, 11, 13, 17, 19], "Test échoué pour n=20"
    assert eratostene(30) == [2, 3, 5, 7, 11, 13, 17, 19, 23, 29], "Test échoué pour n=30"

    print("Tous les tests ont réussi!")
```

## 5. Carré magique

La définition est extraite de [l'article Wikipedia sur le carré magique](<https://fr.wikipedia.org/wiki/Carr%C3%A9_magique_(math%C3%A9matiques)>): en mathématiques, un carré magique d’ordre « n » est composé de « n x n » entiers strictement positifs, écrits sous la forme d’un tableau carré (matrice). Ces nombres sont disposés de sorte que leurs sommes sur chaque rangée, sur chaque colonne et sur chaque diagonale principale soient égales. On nomme alors constante magique, la valeur de ces sommes.

Un exemple de carré magique :

```md
1 8 11 14
15 10 5 4  
 6 3 16 9
12 13 2 7
```

1. créer une variable magical_square1 contenant une list double avec l'exemple de carré magique ci-dessus

2. Créer une deuxième liste affectée à la variable « carre_pas_mag» qui ne soit pas magique à partir du carré magique : en changeant le 1 en 10

3. Créer une fonction qui affiche la liste comme un carré.

4. Créer une fonction has_all_row_same_sum qui teste si toutes les lignes d'un carrés ont la même somme. Elle renvoie False si ce n'est pas vrai et la somme d'une des ligne si c'est vrai

5. Créer une fonction has_all_columns_same_sum qui fait la même chose pour les colonnes

6. créer une fonction has_same_diagonals qui fait de même pour les diagonales

7. Créer une fonction is_square_magical(square) qui renvoie un booléen indiquant si un carré est magique ou non

```py
magical_square1 = [
    [1, 8, 11, 14],
    [15, 10, 5, 4],
    [6, 3, 16, 9],
    [12, 13, 2, 7]
]

carre_pas_mag = [
    [10, 8, 11, 14],
    [15, 10, 5, 4],
    [6, 3, 16, 9],
    [12, 13, 2, 7]
]

def afficher_carre(carre):
    for ligne in carre:
        print(" ".join(map(str, ligne)))

def has_all_row_same_sum(carre):
    somme_reference = sum(carre[0])
    for ligne in carre:
        if sum(ligne) != somme_reference:
            return False
    return somme_reference

def has_all_columns_same_sum(carre):
    taille = len(carre)
    somme_reference = sum(carre[i][0] for i in range(taille))
    for j in range(taille):
        somme_colonne = sum(carre[i][j] for i in range(taille))
        if somme_colonne != somme_reference:
            return False
    return somme_reference

def has_same_diagonals(carre):
    taille = len(carre)
    somme_diagonale1 = sum(carre[i][i] for i in range(taille))
    somme_diagonale2 = sum(carre[i][taille - 1 - i] for i in range(taille))
    if somme_diagonale1 != somme_diagonale2:
        return False
    return somme_diagonale1

def is_square_magical(carre):
    somme_lignes = has_all_row_same_sum(carre)
    somme_colonnes = has_all_columns_same_sum(carre)
    somme_diagonales = has_same_diagonals(carre)

    if not somme_lignes or not somme_colonnes or not somme_diagonales:
        return False
    return somme_lignes == somme_colonnes == somme_diagonales
```

## 6. Liste versus tuple

En faisant des recherches, expliquer **avec vos mots** la différence entre un tuple et une liste. Si possible expliquer des cas d'utilisation typique de tuples en python

```txt
Un tuple est immuable alors qu'une liste ne l'est pas. C'est à dire qu'on ne peut pas modifier un tuple.

On peut utiliser un tuple pour des valeurs qui ne changeront plus comme des coordonnées (x, y) ou comme clé dans un dictionnaire.
Une liste peut être utilisée pour toute autre forme de collection de donnée modifiable.
```

## 7. Gestion de comptes - 1

Un responsable de banque souhaite gérer les comptes de ces clients avec un logiciel. On vous demande de faire un programme python pour cela.

1. Créez une liste « customers» contenant les tuples «(1, Paul), (2, Ali), (3, Julia), (4, Noah), (5, Janet) ».

2. Créer une seconde liste « accounts» contenant le solde de chaque compte. Le solde du compte courant est un réel aléatoire entre 0 et 10 000 arrondie à 2 chiffres après la virgule.

3. Créez une fonction « max_balance(customers, accounts) » qui retourne le client avec le plus grand solde.

```py
import random

customers = [(1, "Paul"), (2, "Ali"), (3, "Julia"), (4, "Noah"), (5, "Janet")]

accounts = [round(random.uniform(0, 10000), 2) for _ in range(len(customers))]

def max_balance(customers, accounts):
    max_index = accounts.index(max(accounts))
    return customers[max_index]
```

## 8. Gestion de comptes - 2

Les variables customers et account de l'exercice précédent ont été recréées (mais ne sont pas visible par vous).

1. Créez une fonction « Stockage_Dict(clients,compte_courant) → dict » qui retourne un dictionnaire contenant trois items :

   - la liste des clients avec la clé “clients”
   - la liste de compte_courant avec la clé “compte_courant”
   - une liste de compte_epargne avec la clé compte_epargne

   Les montants dans les compte épargne seront des nombre aléatoire entre 0 et 40 000

2. Créez une fonction « Max_Dic (dico) → tuple » qui prend en paramètres le dictionnaire contenant les clients et leurs comptes. Cette fonction retourne le client ayant le solde maximal, c’est-à-dire la somme de ces deux comptes est maximale.
3. Le client « Paul » a reçu un virement de 500 euros dans son compte, les autres clients ont tous reçu un prélèvement de 3000 euros. Créer une fonction « M_A_J (dico) → dict » qui met à jour les comptes des clients et qui retourne le nouveau dictionnaire.
4. Écrire une fonction “Ajout_Decouvert” qui ajoute un item dans le dictionnaire. L’item corresponds à « découvert : liste », la valeur de l’item est une liste stockant les clients à découvert (i.e. compte_courant < 0 ).

## 9. Lecture dans un fichier

On dispose d'un fichier grades.txt contenant des notes de différents étudiants. Le format du fichier est le suivant :

Paul: 10, 11, 15

Jennifer: 11, 13, 14

etc.etc.

1. Faire une fonction parse_grades(path) qui renvoie une liste de dictionnaire. Chaque dictionnaire devra avoir la structure suivante :

   ```json
   {

       student_name: lenom,

       grades: liste de notes

   }
   ```

   Penser à fermer votre fichier que ce soit manuellement ou automatiquement grace à with

2. Utiliser la fonction et stocker le résultat dans une variable student_grades

```py
def parse_grades(path):
    students_grades = []

    with open(path, 'r') as file:
        for line in file:
            student_name, grades_str = line.split(':')
            grades = list(map(int, grades_str.split(',')))
            students_grades.append({
                'student_name': student_name.strip(),
                'grades': grades
            })

    return students_grades

file_path = 'grades.txt'
student_grades = parse_grades(file_path)
```

## 10. Ecriture dans un fichier

On dispose toujours d'une liste de dictionnaire avec le même format que précédemment.

1. Faire une fonction compute_average_grades(student_grades) qui renvoie une liste de dictionnaire contenant cette fois ci la moyenne des notes et non plus la liste des notes

2. Faire une fonction save_average_grades(data, path) qui sauvegarde dans un fichier les données de note moyenne au format suivant :

   NomEtudiant: note_moyenne,

   NomEtudiant: note_moyenne

```py
def compute_average_grade(student_grades):
    average_grades = []

    for student in student_grades:
        student_name = student['student_name']
        grades = student['grades']
        average_grade = sum(grades) / len(grades)
        average_grades.append({
            'student_name': student_name,
            'average_grade': average_grade
        })

    return average_grades

def save_average_grades(data, path):
    with open(path, 'w') as file:
        for entry in data:
            file.write(f"{entry['student_name']}: {entry['average_grade']}\n")
```
