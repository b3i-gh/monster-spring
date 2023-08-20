package com.b3i.monsterspring.dto;

import com.b3i.monsterspring.enumeration.Language;
import lombok.Data;

@Data
public class MonsterDTO {
    private Long id;
    private String name;
    private String imageUrl;
    private Boolean owned;
    private Long size;
    private Language lang;
}
