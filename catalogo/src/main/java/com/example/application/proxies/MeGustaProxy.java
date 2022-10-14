package com.example.application.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="MEGUSTA-SERVICE")
public interface MeGustaProxy {
	@PostMapping(path = "/me-gusta")
	String sendLike();
	@PostMapping(path = "/me-gusta")
	String sendLike(@RequestHeader(value = "Authorization", required = true) String authorization);
}
