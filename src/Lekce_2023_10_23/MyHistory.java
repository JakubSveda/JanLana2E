package Lekce_2023_10_23;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class MyHistory {
    String fileName;
    LinkedHashSet<String> memory;

    public MyHistory(String fileName) {
        this.fileName = fileName;
        this.memory = new LinkedHashSet<>();
    }

    public void read() throws IOException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext())
                addLine(scanner.nextLine());
        } catch (Exception ignored) {
        }
    }

    public void save() throws IOException {
        Files.write(Paths.get(fileName), toString().getBytes());
    }

    public void addLine(String str) {
        memory.add(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : memory)
            sb.append(str).append("\n");

        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        MyHistory mh = new MyHistory("soubor.txt");
        mh.read();
        System.out.println(mh);
    }
}

