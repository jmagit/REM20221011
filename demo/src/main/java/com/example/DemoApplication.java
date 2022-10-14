package com.example;

import java.util.TreeMap;

import javax.transaction.Transactional;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.RestTemplate;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.contracts.services.ActorService;
import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDto;
import com.example.domains.entities.dtos.ActorShortDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(title = "Microservicio: Demos",  version = "1.0",
                description = "**Demos** de Microservicios.",
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html"),
                contact = @Contact(name = "Javier Martín", url = "https://github.com/jmagit", email = "support@example.com")
        ),
        externalDocs = @ExternalDocumentation(description = "Documentación del proyecto", url = "https://github.com/jmagit/curso")
)
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.example.application.proxies")
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Primary
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplateLB() {
		return new RestTemplate();
	}
	
//    @Bean
//    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
//            LoadBalancerClientFactory loadBalancerClientFactory) {
//        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//        name = "CATALOGO-SERVICE";
//        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
//    }
	@Bean
	public OpenApiCustomiser sortSchemasAlphabetically() {
	    return openApi -> {
	        var schemas = openApi.getComponents().getSchemas();
	        openApi.getComponents().setSchemas(new TreeMap<>(schemas));
	    };
	}

	@Autowired
	ActorRepository dao;
	@Autowired
	ActorService srv;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		System.out.println("Hola mundo");
//		dao.findAll().forEach(System.out::println);
//		var item = dao.findById(1111);
//		if(item.isPresent()) {
//			System.out.println(item.get());
//		} else {
//			System.out.println("No encontrado");
//		}
//		var item = new Actor(0, "Pepito", "Grillo");
//		dao.save(item);
//		dao.findAll().forEach(System.out::println);
//		var item = dao.findById(204);
//		if(item.isPresent()) {
//			var actor = item.get();
//			actor.setFirstName(actor.getFirstName().toUpperCase());
//			dao.save(actor);
//			dao.findAll().forEach(System.out::println);
//		} else {
//			System.out.println("No encontrado");
//		}
//		dao.deleteById(204);
//		dao.findTop10ByFirstNameStartingWithOrderByLastNameDesc("P").forEach(System.out::println);
//		dao.findTop10ByFirstNameStartingWith("P", Sort.by("firstName")).forEach(System.out::println);
//		dao.findByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.recuperaNuevosJPQL(200).forEach(System.out::println);
//		dao.recuperaNuevosSQL(200).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThan(root.get("actorId"), 200)).forEach(System.out::println);
//		var item = dao.findById(1);
//		if(item.isPresent()) {
//			System.out.println(item.get());
//			item.get().getFilmActors().forEach(ele -> System.out.println(ele.getFilm().getTitle()));
//		} else {
//			System.out.println("No encontrado");
//		}
//		var item = new Actor(0, null, "12345678Z");
//		if(item.isInvalid())
//			System.out.println(item.getErrorsMessage());
//		else
//			dao.save(item);
//		dao.findAll(PageRequest.of(1, 10)).getContent().forEach(System.out::println);
//		dao.findAll().forEach(ele -> System.out.println(ActorDto.from(ele)));
//		var dto = new ActorDto(111, "kk", "kkkk");
//		var item = ActorDto.from(dto);
//		if(item.isInvalid())
//			System.out.println(item.getErrorsMessage());
//		dao.recuperaDtos(190).forEach(System.out::println);
//		dao.recuperaShort(190).forEach(ele -> System.out.println(ele.getId() + " " + ele.getNombre()));
//		dao.findByActorIdIsNotNull(ActorDto.class).forEach(System.out::println);
//		dao.findByActorIdIsNotNull(ActorShortDto.class).forEach(ele -> System.out.println(ele.getId() + " " + ele.getNombre()));
//		srv.getByProjection(ActorShortDto.class).forEach(ele -> System.out.println(ele.getId() + " " + ele.getNombre()));
	}

}
