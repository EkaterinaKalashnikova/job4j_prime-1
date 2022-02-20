package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<String, List<FileProperty>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toAbsolutePath().toString());
        map.putIfAbsent(file.toFile().getName() + attrs.size(), new ArrayList<>());
        List<FileProperty> list = map.get(file.toFile().getName() + attrs.size());
        list.add(fileProperty);
        return super.visitFile(file, attrs);
    }

    public List<FileProperty> duplicateFiles() {
        List<FileProperty> array = new ArrayList<>();
        for (Map.Entry<String, List<FileProperty>> m : map.entrySet()) {
            if (m.getValue().size() > 1) {
                array.addAll(m.getValue());
            }
        }
        return array;
    }
}

