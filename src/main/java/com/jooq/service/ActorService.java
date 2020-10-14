package com.jooq.service;


import com.jooq.dto.ActorDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jooq.entities.generated.tables.Actor.ACTOR;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final DSLContext dslContext;

    public List<ActorDto> getAllActors() {
        return dslContext.selectFrom(ACTOR)
                .fetchInto(ActorDto.class);
    }

    public void addActor(ActorDto actorDto) {
        dslContext
                .insertInto(ACTOR, ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE)
                .values(actorDto.getActorId(), actorDto.getFirstName(), actorDto.getLastName(),
                        actorDto.getLastUpdate())
                .onConflict()
                .doUpdate()
                .set(ACTOR.FIRST_NAME, actorDto.getFirstName())
                .set(ACTOR.LAST_NAME, actorDto.getLastName())
                .set(ACTOR.LAST_UPDATE, actorDto.getLastUpdate())
                .execute();

    }
}
