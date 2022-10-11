package com.example.application.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="MEGUSTA-SERVICE")
public interface MeGustaProxy {
	@PostMapping(path = "/me-gusta")
	String sendLike();
}
