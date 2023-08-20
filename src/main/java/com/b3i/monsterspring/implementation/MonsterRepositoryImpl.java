package com.b3i.monsterspring.implementation;

import com.b3i.monsterspring.domain.Monster;
import com.b3i.monsterspring.exception.ApiException;
import com.b3i.monsterspring.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

import static com.b3i.monsterspring.query.MonsterQuery.COUNT_MONSTER_NAME_QUERY;
import static com.b3i.monsterspring.query.MonsterQuery.INSERT_MONSTER_QUERY;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MonsterRepositoryImpl implements MonsterRepository<Monster> {
    private final NamedParameterJdbcTemplate jdbc;


    @Override
    public Monster create(Monster monster) {
        // check the name is unique
        if(getNameCount(monster.getName().trim().toLowerCase()) > 0)
            throw new ApiException("Name already in use, please use a different name");
        // save new monster
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(monster);
            jdbc.update(INSERT_MONSTER_QUERY, parameters, holder);
            monster.setId(requireNonNull(holder.getKey().longValue()));
            // return the newly created Monster
            return monster;
        } catch (Exception ex){
            throw new ApiException("An error occured. Please try again.");
        }
    }

    @Override
    public Collection<Monster> list(int page, int pageSize) {

        return null;
    }

    @Override
    public Monster get(Long id) {
        return null;
    }

    @Override
    public Monster update(Monster data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getNameCount(String name) {
        return jdbc.queryForObject(COUNT_MONSTER_NAME_QUERY, Map.of("name", name), Integer.class);
    }


    private SqlParameterSource getSqlParameterSource(Monster monster) {
        return new MapSqlParameterSource()
                .addValue("name", monster.getName())
                .addValue("imageUrl", monster.getImageUrl())
                .addValue("owned", monster.getOwned())
                .addValue("size", monster.getSize())
                .addValue("lang", monster.getLang().getLang());
    }
}

