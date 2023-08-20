package com.b3i.monsterspring.service;

import com.b3i.monsterspring.domain.Monster;
import com.b3i.monsterspring.dto.MonsterDTO;

import java.util.Collection;

public interface MonsterService {
    MonsterDTO createMonster(Monster monster);

}
