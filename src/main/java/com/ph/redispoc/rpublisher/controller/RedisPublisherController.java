package com.ph.redispoc.rpublisher.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ph.redispoc.rpublisher.entity.RedisMessageTest;
import com.ph.redispoc.rpublisher.service.RedisPublisherService;

@RestController()
@RequestMapping("/redis")
public class RedisPublisherController {

	private RedisPublisherService service;
	
	public RedisPublisherController(RedisPublisherService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public void sendMessage(@RequestBody RedisMessageTest redisMessage) {
		this.service.publish(redisMessage.getMessage());
	}
}
