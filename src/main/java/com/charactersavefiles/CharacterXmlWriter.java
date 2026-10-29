package com.charactersavefiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class CharacterXmlWriter {
    public static void save(List<GameCharacter> characters, Path path)
        throws IOException {

        StringBuilder xml = new StringBuilder();

        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<characters>\n");

        for (GameCharacter character : characters) {
            Map<String, Object> data = character.toDict();

            xml.append("    <character>\n");

            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                xml.append("        <").append(key).append(">");
                xml.append(value);
                xml.append("</").append(key).append(">\n");
            }

            xml.append("    </character>\n");
        }

        xml.append("</characters>\n");

        Files.writeString(path, xml.toString());
    }
}
