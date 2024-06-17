# Final quiz answers

## Quel est le résultat de cette expression booléenne : (5 > 3) or (1 > 7) and (9 > 4) ?

### Réponse

L'expression booléenne (5 > 3) or (1 > 7) and (9 > 4) est évaluée comme suit :

(5 > 3) est True car 5 est supérieur à 3.
(1 > 7) est False car 1 n'est pas supérieur à 7.
(9 > 4) est True car 9 est supérieur à 4.
Ensuite, l'opérateur and est évalué avant l'opérateur or en raison de la précédence des opérateurs en Python. Donc, (1 > 7) and (9 > 4) est évalué en premier et donne False car les deux conditions doivent être vraies pour que and renvoie True.

Enfin, True or False donne True. Donc, le résultat de l'expression booléenne (5 > 3) or (1 > 7) and (9 > 4) est True.

## Quelle instruction à utiliser pour extraire les valeurs 2, 3, 4 et 5 de la liste = [1,1,2,3,4,5,6] en utilisant la notation de slicing ?

### Propositions

- [ ] liste[3:6]
- [x] liste[2:6]
- [ ] liste[2:7]
- [ ] liste[3:4]

### Réponse

Pour extraire les valeurs 2, 3, 4 et 5 de la liste = [1,1,2,3,4,5,6] en utilisant la notation de slicing, vous devez utiliser l'instruction suivante :

```python
liste[2:6]
```

Cela renvoie les éléments de l'indice 2 (inclus) à l'indice 6 (exclus).

## Comment peut-on trier une liste de nombres dans l’ordre décroissant?

### Propositions

- [x] En utilisant la méthode sort() avec le paramètre reverse=True.
- [ ] En utilisant la fonction sort() avec le paramètre reverse=False.
- [ ] En utilisant la fonction sorted() avec le paramètre reverse=True.
- [ ] En utilisant la fonction sorted() avec le paramètre reverse=False.

### Réponse

Pour trier une liste de nombres dans l'ordre décroissant, vous pouvez utiliser la fonction sorted() avec le paramètre reverse=True. Voici comment :

```python
sorted_list = sorted(original_list, reverse=True)
```

Cela retournera une nouvelle liste triée dans l'ordre décroissant. Si vous voulez trier la liste originale en place, vous pouvez utiliser la méthode sort() de la liste avec le paramètre reverse=True :

```py
original_list.sort(reverse=True)
```

## Quelle instruction de liste en compréhension permet de générer les nombres pairs de 1 à 10 ?

### Propositions

- [ ] [ x f or x in range(1, 10) if x%2 == 1 ]
- [ ] [ x f or x in range(1, 11) if x%2 == 1 ]
- [ ] [ x f or x in range(1, 10) if x%2 == 0 ]
- [x] [ x f or x in range(1, 11) if x%2 == 0 ]

### Réponse

Pour générer les nombres pairs de 1 à 10 en utilisant une liste en compréhension, vous devez utiliser l'instruction suivante :

```python
[ x for x in range(1, 11) if x%2 == 0 ]
```

Cela génère une liste de tous les nombres pairs entre 1 et 10 inclus.

## Comment rajouter un élément (”age”, 101) à un dictionnaire existant ”dico” ?

### Propositions

- [ ] dico.add(”age”,101)
- [x] dico[”age”] = 101
- [ ] dico.append(”age”, 101)

### Réponse

Pour ajouter un élément ("age", 101) à un dictionnaire existant "dico" en Python, vous devez utiliser l'instruction suivante :

```py
dico["age"] = 101
```

Cela ajoute une nouvelle paire clé-valeur au dictionnaire avec "age" comme clé et 101 comme valeur.

## Qu’afficherai l’instruction ”mystere(6)” ?

On dispose de la fonction suivante. Répondre à la question ci-contre.

```python
def mystere(n):
    if n == 0:

    return 0

elif n == 1:

    return 1

else :

    return mystere(n - 1) + mystere(n - 2)
```

### Réponse

La fonction mystere(n) est une implémentation de la suite de Fibonacci. Elle renvoie le n-ième nombre de la suite de Fibonacci, où les deux premiers nombres sont 0 et 1, et chaque nombre suivant est la somme des deux précédents.

L'instruction mystere(6) renvoie le 6ème nombre de la suite de Fibonacci. Les six premiers nombres de la suite de Fibonacci sont : 0, 1, 1, 2, 3, 5. Donc, mystere(6) affiche 8.

## Quelle est la différence entre l’instruction ”{v: k for k, v in d.items()}” et ”{v for k, v in d.items()}” ?

### Propositions

- [x] La première expression crée un nouveau dictionnaire avec les valeurs de d comme clés et les clés de d comme valeurs, tandis que la seconde expression crée un ensemble contenant les valeurs de d.
- [ ] La seconde expression crée un nouveau dictionnaire avec les valeurs de d comme clés et les clés de d comme valeurs, tandis que la première expression crée un ensemble contenant les valeurs de d.
- [ ] Il n’y a pas de différence entre les deux expressions.

## Qu’affiche le code Fonctions question 1 ?

```java
class A {
    public static int a;

    public int b;

    public A(){a++ ; b = a; }
}

A x=new A(); A y=new A(); A z=x;

Systeme.out.printIn(z.a + " et " + z.b)
```

### Propositions

- [ ] 1 et 2
- [ ] 2 et 2
- [x] 2 et 1
- [ ] 3 et 2

### Réponse

Le code affiche :

2 et 1

Voici pourquoi :

- Lorsque x est créé, a est incrémenté de 1 (donc a vaut 1) et b est défini comme a (donc b de x vaut 1).
- Lorsque y est créé, a est à nouveau incrémenté de 1 (donc a vaut maintenant 2) et b est défini comme a (donc b de y vaut 2).
- z est défini comme x, donc z.a est a (qui est une variable statique et vaut 2) et z.b est b de x (qui vaut 1).

## Qu’affiche le code Fonction question 2 ?

```java
class A {
    public int x;

    public A() {

        x=5;

    }
}

class B extends A{
    public B() {x++;}

    public B(int i) {this(); x=x+i;}

    public B(String s) {super(); x--;}
}

B b1=new B(); B b2=new B(2023); B b3=new B("AB");

System.out.printIn(b1.x + " et " + b2.x + " et " + b3.x)
```

### Propositions

- [ ] 5 et 2028 et 4
- [ ] 6 et 2028 et 5
- [x] 6 et 2029 et 4
- [ ] 5 et 2029 et 4

### Réponse

Le code affiche :

6 et 2029 et 4

- Pour b1, le constructeur sans argument de B est appelé, qui appelle le constructeur sans argument de A (via this()), définissant x à 5, puis x est incrémenté de 1, donc b1.x vaut 6.
- Pour b2, le constructeur de B avec un argument int est appelé, qui appelle le constructeur sans argument de B (via this()), définissant x à 6, puis x est augmenté de i (2023), donc b2.x vaut 2029.
- Pour b3, le constructeur de B avec un argument String est appelé, qui appelle le constructeur sans argument de A (via super()), définissant x à 5, puis x est décrémenté de 1, donc b3.x vaut 4

## Qu’est-ce qu’un objet en Java ?

### Propositions

- [ ] Un type primitif
- [x] Une instance d’une classe
- [ ] Un modèle de base pour créer des classe
- [ ] Un mot clé réservé

## Quelle est la différence entre une classe abstraite et une interface en Java ?

### Propositions

- [ ] Une classe abstraite peut être instanciée, tandis qu’une interface ne peut pas l’être
- [ ] Une classe abstraite ne peut pas avoir de méthodes, tandis qu’une interface peut en avoir
- [x] Une classe abstraite peut implémenter plusieurs interfaces, tandis qu’une interface ne peut pas en implémenter
- [ ] Une classe abstraite peut hériter d’une autre classe, tandis qu’une interface ne peut pas le faire

## Quelle est la différence entre une ArrayList et un tableau en Java ?

### Propositions

- [ ] Une ArrayList est une structure de données dynamique, tandis qu’un tableau a une taille fixe.
- [ ] Une ArrayList ne peut contenir que des types primitifs, tandis qu’un tableau peut contenir des objets.
- [x] Un tableau est une structure de données dynamique, tandis qu’une ArrayList a une taille fixe.
- [ ] Il n’y a pas de différence entre une ArrayList et un tableau.

## Le polymorphisme en Java est

### Propositions

- [ ] La capacité d’une classe d’hériter de plusieurs classes
- [ ] La possibilité d’une classe à implémenter plusieurs interfaces
- [x] La capacité d’un objet à prendre plusieurs formes ou types

## Quelle est la méthode principale utilisée pour lancer un programme Java ?

### Propositions

- [x] Main()
- [ ] Run()
- [ ] Start()
- [ ] Execute()

## Que renvoie l’opérateur typeof lorsqu’il est utilisé avec une fonction ?

### Propositions

- [ ] ”object”
- [ ] ”undefined”
- [x] ”function”
- [ ] ”string”

## Quelle est la syntaxe correcte pour référencer un script externe nommé app.js dans une page ?

### Propositions

- [ ] link=”app.js”
- [ ] href=”app.js”
- [x] src=”app.js

## Quel est l’opérateur utilisé pour la comparaison stricte des valeurs et des types en JavaScript ?

### Propositions

- [ ] =
- [ ] ==
- [x] ===
- [ ] ====

## Quelle est la méthode utilisée pour ajouter un nouvel élément à la fin d’un tableau en JavaScript ?

### Propositions

- [x] push()
- [ ] pop()
- [ ] shift()
- [ ] unshift()

La méthode utilisée pour ajouter un nouvel élément à la fin d'un tableau en JavaScript est push().

## Quelle méthode permet de lier un événement à un élément du DOM en JavaScript ?

### Propositions

- [ ] attachEvent()
- [x] addEventListener()
- [ ] setEventListener()
- [ ] bindEvent()

## Quelle instruction me permet de modifier l’élément HTML < p > Hello < /p > ?

### Propositions

- [ ] document.getElementsByTagName(”p”).innerHTML
- [ ] document.getElementsByTag(”p”).content
- [ ] document.getElementsByName(”p”).innerHTML
- [ ] document.getElementsById(”p”).content

### Réponse

Aucune des options fournies n'est correcte pour modifier l'élément HTML \<p>Hello\</p>.

La bonne instruction serait :

```js
document.getElementsByTagName("p")[0].innerHTML = "Nouveau texte";
```

Cela sélectionne le premier élément \<p> dans le document et change son contenu HTML en "Nouveau texte". Notez que getElementsByTagName renvoie une collection d'éléments, donc vous devez spécifier un index, même si vous savez qu'il n'y a qu'un seul élément \<p>.

## Quelle est la méthode utilisée pour effectuer une requête HTTP asynchrone avec la gestion des promesses en JavaScript ?

### Propositions

- [ ] ajax()
- [ ] request()
- [x] fetch()
- [ ] get()
