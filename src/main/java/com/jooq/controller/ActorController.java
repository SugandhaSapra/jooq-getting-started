package com.jooq.controller;

import com.jooq.dto.ActorDto;
import com.jooq.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;

    @GetMapping
    public List<ActorDto> getBooks() {
        return this.actorService.getAllActors();
    }

    @PostMapping
    public void postBook(@RequestBody ActorDto actor) {
        this.actorService.addActor(actor);
    }
}
