package com.ph.redispoc.rpublisher.service;

import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.ph.redispoc.rpublisher.config.RedisConfig;

@Service
public class RedisPublisherService {

	private RedisConfig config;
	
	public RedisPublisherService(RedisConfig config) {
		super();
		this.config = config;
	}

	/**
	 * Publica mensgem em um canal(topico)
	 * @param topic canal
	 * @param message mensagem
	 */
	public void publish(String topic, String message) {
		this.config.redisTemplate().convertAndSend(this.getTopic(topic), message);
		System.out.println("Mensagem enviada através do publisher para o canal " + topic + ".");
	}
	
	/**
	 * Cria um novo topico(canal) para envio da mensagem
	 * @param topic canal
	 * @return string com o nome do canal para publicação da mensagem
	 */
	private String getTopic(String topic) {
		return new ChannelTopic(topic).toString();
	}
}
