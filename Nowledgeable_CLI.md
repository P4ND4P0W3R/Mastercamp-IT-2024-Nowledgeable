# Prise en main ligne de commande nowledgeable

## Prise en main ligne de nowledgeable cli

1. Se rendre sur [nowledgeable.com/client](nowledgeable.com/client) et télécharger la ligne de commande cli
2. Aller sur [nowledgeable.com/profile](nowledgeable.com/profile) et récupérer le token d'identification
3. lancer la commande `nowledgeable login --with-token` et mettre le token
4. Lancer la commande `nowledgeable get-activity 140840` pour récuperer l'exercice
5. lancer nowledgeable run-checks et vérifier que tout est ok

## Vérification installation python

1. Si ce n'est pas déjà fait ,installer python avec ou sans pycharm
2. Vérifier que vous pouvez lancer les commandes `python -V` et `pip -V` (ou python3 -V / pip3 -V) . Si ce n'est pas le cas il faut configurer votre variable d'environnement PATH
3. télécharger l'activité avec la commande `nowledgeable get-activity 140841`
4. lancer nowledgeable run-checks dans le terminal
