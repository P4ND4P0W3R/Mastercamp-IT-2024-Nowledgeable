import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemResource {
    private List<FileSystemResource> resources;

    public Folder(String name) {
        super(name);
        this.resources = new ArrayList<>();
    }

    public void addResource(FileSystemResource resource) {
        if (resource != this) {
            resources.add(resource);
            System.out.println(resource.getName());
        }
    }

    public int getSize() {
        int totalSize = 0;
        for (FileSystemResource resource : resources) {
            if (resource instanceof File) {
                totalSize += ((File) resource).getSize();
            } else if (resource instanceof Folder) {
                totalSize += ((Folder) resource).getSize();
            }
        }
        return totalSize;
    }
}
