package com.b3i.monsterspring.domain;

import com.b3i.monsterspring.enumeration.Language;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.URL;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class Monster {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @URL(message = "invalid url")
    private String imageUrl;
    private Boolean owned;
    private Long size;
    private Language lang;
}
