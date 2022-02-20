package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    private String pathToCSV;
    private String pathToOUT;

    private void setPathToCSV(String pathToCSV) {
        this.pathToCSV = pathToCSV;
    }

    private void setPathToOUT(String pathToOUT) {
        this.pathToOUT = pathToOUT;
    }

    private String getPathToCSV() {
        return pathToCSV;
    }

    private String getPathToOUT() {
        return pathToOUT;
    }

    private void write(String data) {
        if ("stdout".equals(getPathToOUT())) {
            System.out.println(data);
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\" + getPathToOUT()))) {
                writer.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void validate(ArgsName argsName) {
        String[] parameters = new String[]{"path", "delimiter", "out", "filter"};
        for (String value : parameters) {
            argsName.get(value);
        }
        setPathToCSV(argsName.get("path"));
        setPathToOUT(argsName.get("out"));
    }

    protected static void handle(ArgsName argsName) {
        CSVReader reader = new CSVReader();
        reader.validate(argsName);
        StringBuilder data = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("src\\main\\resources\\" + reader.getPathToCSV()))) {
            String line = scanner.nextLine();
            String[] header = line.split(";");
            String[] keys = argsName.get("filter").split(",");
            List<Integer> indexes = new ArrayList<>();
            for (String key : keys) {
                for (int j = 0; j < header.length; j++) {
                    if (key.equals(header[j])) {
                        indexes.add(j);
                    }
                }
            }
            indexes.forEach(v -> data.append(header[v]).append(";"));
            data.replace(data.length() - 1, data.length(), "");
            data.append(System.lineSeparator());
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] values = line.split(";");
                indexes.forEach(v -> data.append(values[v]).append(";"));
                data.replace(data.length() - 1, data.length(), "");
                data.append(System.lineSeparator());
            }
            reader.write(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        handle(ArgsName.of(args, 4, "Something went wrong!!!"));
    }
}




