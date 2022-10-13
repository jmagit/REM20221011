package com.example.domains.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.domains.entities.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "Actor (corta)", description = "Permite la consulta y edición de actores")
@Data @AllArgsConstructor @NoArgsConstructor
public class ActorDto {
	@JsonProperty("id")
	private int actorId;
	@JsonProperty("nombre")
	@NotBlank
	@Size(max = 50)
	private String firstName;
	@JsonProperty("apellidos")
	@Schema(maxLength = 50, required = true, description = "Apellidos del actor")
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
