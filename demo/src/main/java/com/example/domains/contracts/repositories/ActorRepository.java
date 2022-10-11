package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDto;
import com.example.domains.entities.dtos.ActorShortDto;

@RepositoryRestResource(exported = false)
public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {
	List<Actor> findTop10ByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
	List<Actor> findTop10ByFirstNameStartingWith(String prefijo, Sort orden);
	List<Actor> findByActorIdGreaterThan(int min);

	@Query(value = "SELECT a FROM Actor a WHERE a.actorId > ?1")
	List<Actor> recuperaNuevosJPQL(int min);

	@Query(value = "SELECT * FROM actor WHERE actor_id > ?1", nativeQuery = true)
	List<Actor> recuperaNuevosSQL(int min);
	

	@Query(value = "SELECT a FROM Actor a WHERE a.actorId > ?1")
	List<ActorDto> recuperaDtos(int min);

	@Query(value = "SELECT a FROM Actor a WHERE a.actorId > ?1")
	List<ActorShortDto> recuperaShort(int min);
	
	<T> List<T> findByActorIdIsNotNull(Class<T> tipo);
	<T> List<T> findByActorIdIsNotNull(Sort orden, Class<T> tipo);
	<T> Page<T> findByActorIdIsNotNull(Pageable page, Class<T> tipo);

}
