package com.charactersavefiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameCharacter warrior = new GameCharacter("Bill", "Warrior", 5, 125, 200, 5000);
        GameCharacter mage = new GameCharacter("Dave", "Mage", 5, 70, 400, 5000);
        GameCharacter archer = new GameCharacter("Stevie", "Archer", 5, 50, 300, 5000);
        GameCharacter rogue = new GameCharacter("Nyla", "Rogue", 5, 100, 75, 5000);

        List<GameCharacter> characters = new ArrayList<>();
        characters.add(warrior);
        characters.add(mage);
        characters.add(archer);
        characters.add(rogue);

        System.out.println("Characters Created: ");

        for (GameCharacter character : characters)
            System.out.println(character);

        System.out.println("Saving character data...");

        try {
            CharacterJsonWriter.save(characters, Path.of("characters.json"));
            System.out.println("Characters saved to JSON successfully!");

            CharacterXmlWriter.save(characters, Path.of("characters.xml"));
            System.out.println("Characters saved to XML successfully");

            String json = Files.readString(Path.of("characters.json"));
            String xml = Files.readString(Path.of("characters.xml"));

            System.out.println("\n===== JSON FILE CONTENTS =====");
            System.out.println(json);

            System.out.println("\n===== XML FILE CONTENTS =====");
            System.out.println(xml);

        } catch (IOException e) {
            System.out.println("File I/O error: " + e.getMessage());
        }
    }
}
