/*
    Zadanie 6
    Autor: Rafał Tęcza & Damian Brzoskowski
    Index: s19468 & s18499
*/

package pjwstk.lab4.zadanie6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/assets/words.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");

                line = line.replace(".", "").replace(",", "").toLowerCase();
                String[] words = line.split(" ");

                for(String word : words) {
                    if(!list.contains(word)) {
                        list.add(word);
                    }
                }
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        String outputString = "";
        for(String word : list) {
            outputString = outputString + word + " ";
        }
        System.out.println(outputString + "\n");
        System.out.println("Number of words: " + list.size());

    }
}
