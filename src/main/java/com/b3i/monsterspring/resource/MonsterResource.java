package com.b3i.monsterspring.resource;

import com.b3i.monsterspring.domain.HttpResponse;
import com.b3i.monsterspring.domain.Monster;
import com.b3i.monsterspring.dto.MonsterDTO;
import com.b3i.monsterspring.service.MonsterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequestMapping(path = "/api/monster")
@RequiredArgsConstructor
public class MonsterResource {
    private final MonsterService monsterService;

    @PostMapping("/insert")
    public ResponseEntity<HttpResponse> saveMonster(@RequestBody @Valid Monster monster){
        MonsterDTO monsterDto = monsterService.createMonster(monster);

        return ResponseEntity.created(getUri()).body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("monster", monsterDto))
                        .message("Monster created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }

    private URI getUri() {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/monster/get/<monsterId>").toUriString());
    }
}
