package com.ph.redispoc.rpublisher.service;

import org.springframework.stereotype.Service;

import com.ph.redispoc.rpublisher.config.RedisConfig;

@Service
public class RedisPublisherService {

	private RedisConfig config;
	
	public RedisPublisherService(RedisConfig config) {
		super();
		this.config = config;
	}

	public void publish(String message) {
		this.config.redisTemplate().convertAndSend(this.config.channelTopic().getTopic(), message);
		System.out.println("Mensagem enviada através do publisher.");
	}
}
