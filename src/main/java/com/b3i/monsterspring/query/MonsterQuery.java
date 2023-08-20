package com.b3i.monsterspring.query;

public class MonsterQuery {
    public static final String COUNT_MONSTER_NAME_QUERY = "SELECT COUNT(*) FROM monster WHERE name = :name";
    public static final String INSERT_MONSTER_QUERY = "INSERT INTO monster (name, image_url, owned, size, lang) VALUES(:name, :imageUrl, :owned, :size, :lang)";
}
