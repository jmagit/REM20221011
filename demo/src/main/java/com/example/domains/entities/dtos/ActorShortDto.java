package com.example.domains.entities.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface ActorShortDto {
	@Value("#{target.actorId}")
	int getId();
	@Value("#{target.lastName + ', ' + target.firstName}")
	String getNombre();
}
