package com.charactersavefiles;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameCharacter {
    private String name;
    private String characterClass;
    private int level;
    private int health;
    private int attackPower;
    private int gold;

    public GameCharacter(String name, String characterClass, int level, int health, int attackPower, int gold)
    {
        this.name = name;
        this.characterClass = characterClass;
        this.level = level;
        this.health = health;
        this.attackPower = attackPower;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getGold() {
        return gold;
    }

    @Override
    public String toString() {
        return name + " | " + characterClass
                + " | Level " + level
                + " | Health: " + health
                + " | Attack: " + attackPower
                + " | Gold: " + gold;
    }

    public Map<String, Object> toDict() {
        Map<String, Object> data = new LinkedHashMap<>();

        data.put("name", name);
        data.put("characterClass", characterClass);
        data.put("level", level);
        data.put("health", health);
        data.put("attackPower", attackPower);
        data.put("gold", gold);

        return data;
    }

    public static GameCharacter fromDict(Map<String, Object> data) {
        return new GameCharacter(
                (String) data.get("name"),
                (String) data.get("characterClass"),
                ((Number) data.get("level")).intValue(),
                ((Number) data.get("health")).intValue(),
                ((Number) data.get("attackPower")).intValue(),
                ((Number) data.get("gold")).intValue()
        );
    }
}
