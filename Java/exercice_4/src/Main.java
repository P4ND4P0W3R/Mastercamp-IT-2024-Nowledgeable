public class Main {
    public static void main(String[] args) {
        Folder project = new Folder("project");
        Folder src = new Folder("src");
        Folder classes = new Folder("classes");

        File mainJS = new File("main.js", 100);
        File testJS = new File("test.js", 200);
        File readme = new File("readme.md", 50);

        project.addResource(src);
        project.addResource(readme);
        src.addResource(mainJS);
        src.addResource(testJS);
        src.addResource(classes);

        System.out.println("project");
    }
}

