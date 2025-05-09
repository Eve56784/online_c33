package file_operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IOOperations {
    public static List<File> getFileList(String path) {
        File directory = new File(path);
        if(!directory.exists() || !directory.isDirectory()) return List.of();
        File files[] = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        return files!=null?List.of(files):List.of();
    }

    public static void moveFileToArchive(File file, String archPath) throws IOException {
        if (!file.getName().endsWith(".txt")) return;
        Files.createDirectories(Paths.get(archPath));
        Path target = Paths.get(archPath, file.getName());
        int counter = 1;
        while(Files.exists(target)) {
            String fileName = file.getName();
            String name = fileName.substring(0, fileName.lastIndexOf('.'));
            String extension = ".txt";
            target = Paths.get(archPath, name + "_" + counter + extension);
            counter++;
        }
        Files.move(file.toPath(), target);
    }
}
