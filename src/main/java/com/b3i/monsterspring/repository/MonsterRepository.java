package com.b3i.monsterspring.repository;

import com.b3i.monsterspring.domain.Monster;

import java.util.Collection;

public interface MonsterRepository<T extends Monster> {
    /* Basic CRUD operations */
    T create(T  data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    /* More complex operations */
}
