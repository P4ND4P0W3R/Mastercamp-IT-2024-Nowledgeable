# Java partie 1 - Document

## Document - part 1

On veut faire un logiciel pour faciliter le travail de bibliothécaires.

Un document est décrit par un titre(tittle), le nom de son auteur(author) , l’année de publication(publicationYear) et une liste de références sur d’autres documents (par exemple, des documents traitant du même sujet). Une bibliothèque gère un ensemble de documents.

1. Créer une classe Document qui permet de spécifier à la création le titre, le nom de l'auteur et l'année de publication. On ne gère pas les références pour le moments.

2. Pour ces trois attributs faire un getter en suivant la convention de nommage camelCase

Copier la classe pour l'exercice précédent

```java
class Document {
    private String title;
    private String author;
    private String publicationYear;

    public Document(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }
}
```

## Document - part 2

Reprendre la classe précédente.

Faire en sorte que la classse puis disposer d'une collection de référence vers d'autre instance de Document. Pour cela vous devez :

faire en sorte que la collection de “references” soit vide à la création d'un document

avoir une méthode addReference qui permette d'ajouter une référence à une autre objet et une méthode getReferences qui retourne la collection. Pour le moment on ne se préoccupe du problème de double insertion

N'oubliez pas d'importer java.util.ArrayList pour votre collection.

Copier l'exercice

```java
import java.util.ArrayList;
import java.util.List;

class Document {
    private String title;
    private String author;
    private String publicationYear;
    private List<Document> references;

    public Document(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.references = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void addReference(Document reference) {
        this.references.add(reference);
    }

    public List<Document> getReferences() {
        return references;
    }
}
```

## Document part - 3

Reprendre la classe de l'exercice précédent.

Désormais on ne veut pas que deux références identifiques soit dans un même document. Par la méthode de votre choix, faites en sorte qu'un même document ne puisse pas être deux fois une même référence.

Coder la Test suivante bool test_addReference qui créera plusieurs documents et qui vérifiera qu'un même document ne peut etre ajouté deux fois.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Document {
    private String title;
    private String author;
    private String publicationYear;
    private List<Document> references;

    public Document(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.references = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void addReference(Document reference) {
        if (!this.references.contains(reference)) {
            this.references.add(reference);
        }
    }

    public List<Document> getReferences() {
        return references;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Document document = (Document) obj;
        return title.equals(document.title) && author.equals(document.author) && publicationYear.equals(document.publicationYear);
    }

}

class UnitTest {

    public static boolean test_addReference() {
        Document doc1 = new Document("Title1", "Author1", "2020");
        Document doc2 = new Document("Title2", "Author2", "2021");
        Document doc3 = new Document("Title3", "Author3", "2022");

        doc1.addReference(doc2);
        doc1.addReference(doc2);

        List<Document> references = doc1.getReferences();

        if (references.size() == 1 && references.contains(doc2)) {
            return true;
        } else {
            return false;
        }
    }
}
```

## Document part 4

La classe Document et l'import à déjà été rajouter.

1. Créer une classe Library qui contient une collection de documents vide à l'instanciation, une méthode addDocuments (sans se préocuper du double ajout) et une méthode getDocuments() .

2. Implémenter une méthode searchDocumentByTitle qui renvoie une collection de tous les documents dont le titre contient le terme spécifié.

```java
class Library {
    private List<Document> documents;

    public Library() {
        this.documents = new ArrayList<>();
    }

    public void addDocuments(Document document) {
        this.documents.add(document);
    }

    public List<Document> getDocuments() {
        return this.documents;
    }

    public List<Document> searchDocumentByTitle(String term) {
        List<Document> foundDocuments = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getTitle().contains(term)) {
                foundDocuments.add(doc);
            }
        }
        return foundDocuments;
    }
}
```

## Document part 5

La classe Document et l'import ont déjà été ajoutés

1. Récupérer le code de votre classe Library

1. Implémenter une méthode “getDocumentWithReferences” qui renvoie une collection de tous les documents qui possède une référence à un ou plusieurs documents.

```java
class Library {
    private List<Document> documents;

    public Library() {
        this.documents = new ArrayList<>();
    }

    public void addDocuments(Document document) {
        this.documents.add(document);
    }

    public List<Document> getDocuments() {
        return this.documents;
    }

    public List<Document> searchDocumentByTitle(String term) {
        List<Document> foundDocuments = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getTitle().contains(term)) {
                foundDocuments.add(doc);
            }
        }
        return foundDocuments;
    }

    public List<Document> getDocumentWithReferences() {
        List<Document> documentsWithReferences = new ArrayList<>();
        for (Document doc : documents) {
            if (!doc.getReferences().isEmpty()) {
                documentsWithReferences.add(doc);
            }
        }
        return documentsWithReferences;
    }
}
```
