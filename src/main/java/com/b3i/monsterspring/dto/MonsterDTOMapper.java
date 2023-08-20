package com.b3i.monsterspring.dto;

import com.b3i.monsterspring.domain.Monster;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MonsterDTOMapper {
    public static MonsterDTO fromMonster(Monster monster) {
        MonsterDTO monsterDTO = new MonsterDTO();
        BeanUtils.copyProperties(monster, monsterDTO);
        return monsterDTO;
    }

    public static Monster toMonster(MonsterDTO monsterDTO) {
        Monster monster = new Monster();
        BeanUtils.copyProperties(monsterDTO, monster);
        return monster;
    }

}
