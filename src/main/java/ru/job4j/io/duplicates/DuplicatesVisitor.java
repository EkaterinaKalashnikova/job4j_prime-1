package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Set<FileProperty> unicElement = new HashSet<>();
    List<FileProperty> array = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
        if (unicElement.contains(fileProperty)) {
            array.add(fileProperty);
            FileProperty property = unicElement.stream().filter(array -> Objects.equals(array, fileProperty)).findFirst().get();
            System.out.println(property.getName());
            System.out.println(file.toAbsolutePath());
        }
        unicElement.add(fileProperty);
        return super.visitFile(file, attrs);
    }
}

