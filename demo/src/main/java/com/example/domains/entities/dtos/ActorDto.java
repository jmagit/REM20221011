package com.example.domains.entities.dtos;

import com.example.domains.entities.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ActorDto {
	@JsonProperty("id")
	private int actorId;
	@JsonProperty("nombre")
	private String firstName;
	@JsonProperty("apellidos")
	private String lastName;
	
	public static ActorDto from(Actor target) {
		return new ActorDto(
				target.getActorId(),
				target.getFirstName(),
				target.getLastName());
	}
	
	public static Actor from(ActorDto target) {
		return new Actor(
				target.getActorId(),
				target.getFirstName(),
				target.getLastName());
	}

}
