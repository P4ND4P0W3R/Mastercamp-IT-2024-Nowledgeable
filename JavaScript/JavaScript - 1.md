# Introduction à Javascript 8 : les objets

## Création objet JS

Le code suivant permet de créer un objet JS avec une clé et une valeur.

1. Modifier le code pour qu'il possède également une clé age avec la valeur 30

2. Créer un objet vide et le stocker dans une variable nommée data2

```js
let data = {
  name: "Paul",
  age: 30,
};
let data2 = {};
```

## Objet JS - modification

On a créé pour vous une variable nommée data qui contient un objet.

Ajouter une clé nommée “city” avec la valeur “Paris”

Vous pouvez utiliser la syntaxe suivant

data["clé"] = valeur pour ajouter une nouvelle clé et valeur à un objet existant

afficher le contenu de data avant et après modification de l'objet

```js
console.log(data); //existe déjà
data["city"] = "Paris";
console.log(data);
```

## Objet JS - suppression de clé

On a créé pour vous une variable nommée data qui contient un objet.

1. Afficher l'objet data

2. Avec le mot clé delete, supprimer la clé age de l'objet

3. Afficher à nouveau la variable data

```js
console.log(data); //existe déjà
console.log(delete data.age);
```

## Objet JS - boucles for et objet

Boucle sur des objets.

Le code suivant permet de faire une boucle qui itère sur l'objet data.

A votre avis que va afficher l'objet, les clé ou les valeurs ?

Exécuter le code pour vérifier.

Essayer de faire une boucle qui affiche les valeurs de l'objet

```js
let data = {
  age: 30,
  name: "Paul",
  city: "Paris",
};

for (let v in data) {
  console.log(data[v]);
}
```

## Objet JS - Object.keys et Object.values

On dispose d'une variable data qui contient un objet

Il existe deux fonctions très pratiques mise à disposition par javascript : Object.keys et Object.values

1. Avec la méthode Object.keys récupérer toutes les clés de data et stocker le résultat dans une variable nommée dataKeys
2. Avec la méthode Object.values récupérer toutes les valeurs de data et stocker le résultat dans dataValues
3. Afficher dataValues et dataKeys

```js
let data = {
  age: 30,
  name: "Paul",
  city: "Paris",
};
dataKeys = Object.keys(data);
dataValues = Object.values(data);

console.log(dataKeys);
console.log(dataValues);
```

## Objet JS - fusion d'objet

Avec une boucle for, coder une fonction merge_objects(obj1, obj2) qui retourne un objet qui contient à la fois les clé et valeurs de obj1 et obj2.

```js
function merge_objects(obj1, obj2) {
  let mergedObj = {};
  for (let key in obj1) {
    mergedObj[key] = obj1[key];
  }
  for (let key in obj2) {
    mergedObj[key] = obj2[key];
  }
  return mergedObj;
}
```

## Position 1

On suppose qu'on dispose de points représentés par des coordonnées x et y.

Faire une fonction add_positions(position1, position2) qui prend deux obj contenant des position (x, et y) et qui va retourner un nouvel objet dont les coordonnés sont la somme des coordonnés des deux objets passés en arguments

```js
function add_positions(position1, position2) {
  let newPosition = {};
  newPosition.x = position1.x + position2.x;
  newPosition.y = position1.y + position2.y;
  return newPosition;
}
```

## Position 2

On dispose d'un tableau d'objet.

Chaque objet contient les clé x et y représentant des coordonnées

Faire une fonction get_max_y_position(objects) qui prend un tableau d'objet et qui retourne l'objet dont la coordonnée y est la maximum

```js
function get_max_y_position(objs) {
  let max = Math.log(0);
  let objj = {};
  console.log(max);
  for (let i = 0; i < Object.keys(objs).length; i++) {
    console.log(objs[i]);
    if (objs[i]["y"] > max) {
      max = objs[i]["y"];
      objj = objs[i];
    }
  }
  return objj;
}
```
