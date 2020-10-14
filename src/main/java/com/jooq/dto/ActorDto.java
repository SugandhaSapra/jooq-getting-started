package com.jooq.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
    private Integer actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;

}
