# JS partie 2 - Une todo liste (front et back)

## Objectifs

L'objectif de cette série d'exercice est d'apprendre à prendre en main le javascript côté front et côté back avec JS

Les premiers exercices sont simplements des rappels sur les gestionnaires d'événement front.

Ensuite on fera un petit backend à partir d'un modèle pour renvoyer les donnéees (sans base de données) à un front.

## Todo list - modèle

On veut représenter les données de notre todo list sous forme d'un tableau d'objet. Chaque objet a la structure suivante :

- name: String
- done: Boolean

1. Coder une fonction newTask(tasks, name) qui ajoute au tableau tasks une tache dont le nom est name

2. Coder une fonction getTask(task, iTask) qui renvoie une tache spécifié par l'indice

```js
function newTask(tasks, name) {
  const newTask = {
    name: name,
    done: false,
  };

  tasks.push(newTask);

  return tasks;
}

function getTask(tasks, iTask) {
  if (iTask >= 0 && iTask < tasks.length) {
    return tasks[iTask];
  } else {
    return null;
  }
}
```

## Todo liste - modèle 2

1. Coder une fonction getTasksToBeDone(tasks) qui renvoie toutes les tâches qui sont encore à faire

2. coder une fonction taskWasDone(tasks, iTask) qui met à “done” la tâche

```js
function getTasksToBeDone(tasks) {
  return tasks.filter((task) => !task.done);
}

function taskWasDone(tasks, iTask) {
  if (iTask >= 0 && iTask < tasks.length) {
    tasks[iTask].done = true;
  }
}
```

## Todo list - objectif session

L'objectif de cette série d'exercice est de faire une interface de gestion de liste de tâches (todo liste).

Les premiers exercices pas à pas visent à se rappeler comment faire les événements.

Puis vous devrez faire la todo list sur votre poste avec un frontend JS

## écosystème node et express

En faisant des recherches si besoin, expliquer avec vos mots :

- a quoi sert la commande npm et le fichier package.json
- a quoi sert la librairie express

```txt
La commande npm sert à installer des packages ou à exécuter des scripts définis dans le fichier package.json, qui lui contient les métadonnées sur le projet, c'est-à-dire le nom, la version, les dépendances, les scripts, les configurations.

La librairie Express est un framework web pour Node.js pour concevoir des applications web ou des API. Elle permet notamment d'avoir des router, des middlewares, des templates ou de la gestion d'erreur.
```

## Backend partie 1

Dans cette partie on veut implémenter le backend (serveur) qui renverra des données au frontend.

1. Lancer la commande `nowledgeable get-activity 140892`

2. Dans le dossier de l'exercice lancer la commande npm install. Vérifier qu'un dossier node_modules apparait bien. Vérifier que les librairies du fichier package.json y sont bien

3. Lancer la commande `npm install --save express` et vérifier que le fichier package.json est bien mis à jour

4. Avec node, lancer le fichier app.js. Se rendre sur l'url <http://localhost:3000/sample> et vérifier que le backend renvoie bien du json. Vous pouvez faire de même avec postman si vous le voulez

5. En réutilisant la structure et / ou les fonctions des exercices précédents, faire en sorte d'ajouter un endpoint /task qui permet au backend de renvoyer une liste d'objet représentant différentes tâches. Cette liste de tâche sera stockée dans une variable globale comme la variable sample. Il faudra qu'une des tâches renvoyées ait pour nom “eat”

6. Dans un second terminal, lancer la commande `nowledgeable run-checks`

**RÉPONSE :** [exercice_5/](./exercice_5/)

## Middleware static

On veut qu'express puis servir des fichiers statique stockés dans le fichier /public.

En faisant des recherches si besoin, expliquer avec vos mots :

ce qu'est un middleware en express
comment le middleware “static” s'utilise avec express

```txt
Un middleware est une fonctione qui est appelée pour chaque requête entrante dans l'application Express. Il peut modifier la requête, la réponse ou interrompre le flux normal de la requête.

Le middleware static vérifie qu'un fichier existe dans le dossier /public et si le fichier est trouvé, le middleware l'envoie à la requête sinon la requête est transmise à d'autres middlewares ou à des routes définies dans l'application Express.
```

## index.html

Ajouter un fichier index.html dans votre dossier public et vérifier que vous pouvez afficher la page d'accueil.

Ajouter un titre “Todo list”.

relancer nowledgeable run-checks

## AddEventListener

En faisant des recherches si besoin, expliquer :

- comment associer une fonction à un événement utilisateurs et les principaux utilisateurs existant
- quel événément est dédié à la soumission de formulaire et à quelle balise il faut l'attacher
- à quoi sert event.preventDefault

```txt
Pour associer une fonction à un événement, on peut utiliser la méthode addEventListener. Elle permet de lier une fonction à un évènement sur un élément HTML.

L'événement dédié à la soumission d'un formulaire est submit. Il doit être associé à une balise <form>.

event.preventDefault est une méthode utilisée pour empêcher le comportement par défaut d'un événement, ce qui permet de gérer l'événement de manière personnalisée. Par exemple, on peut empêcher l'action par défaut d'une soumission de formulaire, c'est-à-dire empêcher la page de se rafraîchir.
```

## Envoyer des requêtes HTTP depuis le front

En faisant des recherches si besoin, expliquer :

- A quoi sert la fonction fetch
- Ce qu'elle renvoie
- comment récupérer les données renvoyées du backend sous forme de json

```txt
La fonction fetch sert à effectuer des requêtes HTTP asynchrones vers un serveur, ce qui permet de récupérer ou d'envoyer des données.

La fonction fetch renvoie une promise qui se résout avec une objet Response représentant la réponse de la requête.

Pour récupérer les données du backend sous forme de JSON, on peut utiliser la méthode json() de l'objet Response.
```

## Front et back

En vous inspirant des exercices précédents, modifier votre fichier index.html afin d'avoir un front qui :

- envoie une requete à votre backend pour récupérer la liste des tâches et l'affiche grâce à du JS
- permette de spécifier si une tâche est finie ou non

## Front et Back 2

Ajouter un formulaire d'ajout de tâche à votre fichier index.html. Faire en sorte que lorsqu'il soit soumis, cela envoie une requête à votre backend pour ajouter une tâche. Vérifier que la tâche est bien affichée après raffraichissement de la page.

Faire toutes les améliorations que vous jugez pertinentes :

- Aouter du css pour rendre la page présentable.
- Sortir le js dans un fichier front.js à part
- toute fonctionnalité que vous jugez intéressante
