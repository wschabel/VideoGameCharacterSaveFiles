package com.charactersavefiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class CharacterJsonWriter {
    public static void save(List<GameCharacter> characters, Path path) throws IOException {
        StringBuilder json = new StringBuilder();

        json.append("[\n");

        for (int i = 0; i < characters.size(); i++) {
            Map<String, Object> data = characters.get(i).toDict();

            json.append(" {\n");

            int fieldIndex = 0;

            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                json.append("    \"").append(key).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if (fieldIndex < data.size() - 1) {
                    json.append(",");
                }

                json.append("\n");
                fieldIndex++;
            }

            json.append(" }");

            if (i < characters.size() - 1) {
                json.append(",");
            }

            json.append("\n");
        }

        json.append("]\n");

        Files.writeString(path, json.toString());
    }
}
