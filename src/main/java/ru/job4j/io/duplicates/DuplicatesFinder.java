package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static List<FileProperty> finder(DuplicatesVisitor duplicateVisitor) throws IOException {
        Files.walkFileTree(Path.of("./"), duplicateVisitor);
        return duplicateVisitor.duplicateFiles();
    }

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicateVisitor = new DuplicatesVisitor();
        List<FileProperty> fileProperties = finder(duplicateVisitor);
        for (FileProperty fileProperty : fileProperties) {
            System.out.println(fileProperty.getName());
        }
    }
}
