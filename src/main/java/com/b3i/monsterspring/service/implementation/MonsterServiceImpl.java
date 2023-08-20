package com.b3i.monsterspring.service.implementation;

import com.b3i.monsterspring.domain.Monster;
import com.b3i.monsterspring.dto.MonsterDTO;
import com.b3i.monsterspring.dto.MonsterDTOMapper;
import com.b3i.monsterspring.repository.MonsterRepository;
import com.b3i.monsterspring.service.MonsterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class MonsterServiceImpl implements MonsterService {
    private final MonsterRepository<Monster> monsterRepository;

    @Override
    public MonsterDTO createMonster(Monster monster) {
        return MonsterDTOMapper.fromMonster(monsterRepository.create(monster));
    }
}
