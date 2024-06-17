# Système de fichier et Service DNS - all

## Partie 1 - Simulation d'un système de fichier

L'objectif du prochain exercice est de simuler en Java un système de fichier et de dossier. Puis il faudra compiler et executer le programme sur sa propre machine

## Classe abstraite

En faisant des recherches si besoin, expliquer avec vos mots :

- ce qu'est une classe abstraite
- interface
- et leurs intérêts respectifs

```txt
une classe abstraite ne peux pas être instanciée directement.
une interface continent uniquement des déclarations de méthodes abstraites et de constantes
```

## Système de fichier 1

On veut simuler le fonctionnement d’un système de fichiers. Un fichier (File) est représenté par son nom et sa taille. Un répertoire (Folder) est défini par son nom et peut contenir des fichiers et/ou des répertoires. La base de l’arborescence du système de fichier est le répertoire racine.

0. Créer une classe Abstract FileSystemResource.

1. Créer une classe File qui hérite de FileSystemResource et qui spécifier le nom d'un fichier et sa taille avec le getter correspondant (attributs en anglais)

2. Créer une classe Folder qui hérite de FileSystemResource. Il doit être possible de spécifier le nom d'un dossier mais pas sa taille (qui sera calculée par une méthode). Le constructeur permet d'initialiser une collection qui pourra contenir à la fois des fichiers et des dossiers.

3. Ajouter une méthode addResource qui permettra d'ajouter à un dossier un fichier ou un dossier. Faire en sorte qu'un dossier ne puisse pas s'ajouter à lui-même

4. Ajouter une méthode getSize à Folder pour calculer la taille d'un dossier.

```java
import java.util.ArrayList;
abstract class FileSystemRessource
{

    private String name;

    FileSystemRessource(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getSize();

}


class File extends FileSystemRessource
{
    private double size;

    File(String name, double size)
    {
        super(name);
        this.size = size;
    }


    @Override
    public double getSize()
    {
        return this.size;
    }
}

class Folder extends FileSystemRessource
{
    private ArrayList<FileSystemRessource> collection;


    Folder(String name)
    {
        super(name);
        this.collection = new ArrayList<>();
    }

    public void addResource(FileSystemRessource ressource)
    {
        if(ressource != this)
        {
            this.collection.add(ressource);
        }
    }

    @Override
    public double getSize()
    {
        float resultat = 0;
        double size;
        for(int i =0; i < collection.size();i++)
        {
            size = collection.get(i).getSize();
            resultat += size;
        }
        return resultat;
    }
}
```

## compilation java et arguments

En faisant des recherches si besoins, expliquer avec vos mots :

- la différence entre les commande java, javac et jar
- à quoi sert l'argument -cp et avec quelle commande elle est utilisée
- a quoi sert le fichier manifest.txt et ce qu'il faut y mettre dedans

```txt
Javac est le compiler de Java, il crée un fichier .class pour chaque fichier source .java compilé sans erreur.

Java est l'interpréteur, il analyse les fichiers .class et les execute.

Jar est un format de compression des fichiers compilés ayant pour but d'être expédiés ou partagés.

`java -cp` exectue et archive le fichier spécifié après
`javac -cp` compile et archive le fichier spécifié après

Créé en même temps qu'un .jar, le manifest sert à informer ou définir toute sorte d'information relatives à l'archivage du fichier, que cela concerne les packages ou la sécurité du ficher concerné.
```

## Système de fichier 2

Il est temps de compiler ses premiers programmes java soi-même.

1. Lancer la commande `nowledgeable get-activity 140871`

2. Dans le dossier récupéré, créer un dossier src et un dossier classes.

3. Mettre dans le dossier src vos classes java. Penser à passer vos classes en public

4. Ajouter un fichier Main.java avec une classe et une méthode main. La méthode Main devra Instancier plusieurs objets Fichier et Dossier. Il faudra que ça instancie la hierarchie suivante et que cela affiche. Pour vous implémenterez les méthodes toString des classes quand c'est nécessaire

   ```md
   project/

   src/

       main.js

       test.js

   readme.md
   ```

5. Compiler les sources en incluant les informations de débogage et de façon à placer les .class dans le répertoire classes (cf. [documentation de javac](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javac.html)).

6. Exécuter le programme (cf. [documentation de java](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javac.html)).

7. Créer une archive Java «filesystem .jar » pour le programme (cf. [documentation de jar](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/jar.html)) et exécuter à nouveau le programme à partir de l’archive. Le fichier manifest.txt devra être à la racine du dossier exercice

8. Lancer nowledgeable run-checks

**RÉPONSE :** [exercice_11/](./exercice_4/)

## DNS

A quoi sert un Domain Name service ?
Quelle ligne de commande de votre os vous permet de requêter un DNS ?

Faire une requête DNS pour le nom de domaine google.com ou nowledgeable.com

A quoi sert le fichier hosts présents dans de nombreux systèmes d'exploitation ?

```txt
Un Domain Name System  est un système qui traduit les noms de domaine pour les humains en adresses IP numériques utilisées par les ordinateurs pour communiquer sur un réseau tel qu'Internet. En d'autres termes, le DNS permet de mapper les noms de domaine (comme google.com) aux adresses IP correspondantes (telles que 172.217.12.78).

La ligne de commande  pour effectuer une requête DNS est nslookup.
```

## Domain name server

L'objectif des prochains exercice est de réaliser un outils en ligne de commande cli (command line interface) permettant de simuler l'interrogation d'un DNS (Domain Name Server)

Un DNS convertit une adresse IP (« 192.168.0.1» par exemple) en un nom qualifié de machine (« machine.domaine.local» par exemple) et inversement. Un nom qualifié comporte le nom de la machine (avant le premier '.') et un nom de domaine (après le premier '.')

Les premiers exercice seront à faire sur nowledgeable directement. Puis ensuite sur votre poste en ligne de commande.

## DNS

Notre système simulé utilisera un fichier comme base de données des différentes entrées dns.

1. Créer une classe DNSItem qui permettra de stocker une entrée DNS.
   Il faudra pouvoir spécifier à la création d'un objet l'ip et le nom de domaine correspondant.

2. Il faudra avoir les getter getIp and getDns

Bonus : faire en sorte que si le format de l'IP est incorrect, le constructeur génère une Exception

```java
import java.util.regex.Pattern;

class DNSItem {
    private String ip;
    private String dns;

    public DNSItem(String ip, String dns) {

        this.ip = ip;
        this.dns = dns;
    }

    public String getIp() {
        return ip;
    }

    public String getDns() {
        return dns;
    }
}
```

## DNS 2

Notre simulateur de DNS devra pouvoir récupérer les entrées DNS depuis un fichier.

Faire une classe DNSParser avec une méthode parseSingleEntry(String entry) qui parse une entrée au format “nom.de.domaine adresse.ip”

La classe DNSItem de l'exercice est mis à votre disposition

```java
class DNSParser {
    String ip;
    String dns;

    public DNSParser() {

    }

    public static DNSItem parseSingleEntry(String entry) {
        String[] parts = entry.split("\\s+");
        String dns = parts[0];
        String ip = parts[1];
        return new DNSItem(dns, ip);
    }
}
```

## Lecture dans un fichier en java

En faisant des recherches si besoin, préciser les fonctions Java standard permettant de lire le contenu d'un fichier texte

```txt
"BufferedReader" avec "FileReader". C'est une classe pour lire le texte d'un fichier en utilisant un tanpon.

"Files.readAllLines". La classe Files fournit les méthodes utiles pour lire tout le contenu d'un fichier en une seule fois. "ReadLines" permet de faire ligne par ligne.

"Scanner" peut être utilisé pour lire le contenu d'un fichier, très utile lorsque qu'on souhaite analyser le contenu du fichier ligne par ligne, ou mot par mot.

"Files.lines". "Files.lines" renvoie un flux de lignes à partir d'un fichier, permettant des opérations de traitement de flux.
```

## Récupéreration des paramètre d'une ligne de commade en Java

En faisant des recherches si besoin, expliquer avec vos mots :

- comment récupérer les arguments en java d'une ligne de commande. Exemple java -jar app.jar bla bli blou. Comment récupérer dans le programme les valeurs passées après app. jar ?

```txt
Pour récupérer les arguments en Java d'une ligne de commande, il faut utiliser le tableau de String args que l'on passe à la méthode main.

Il suffit donc de parcourir le tableau en utilisant une for loop.
```

**RÉPONSE :** [exercice_11/](./exercice_11/)
