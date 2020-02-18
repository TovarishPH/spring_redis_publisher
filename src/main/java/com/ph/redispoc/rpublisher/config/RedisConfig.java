package com.ph.redispoc.rpublisher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public ChannelTopic channelTopic() {
		return new ChannelTopic("teste");
	}
	
	@Bean
	public RedisTemplate<String, String> redisTemplate() {
		RedisTemplate<String, String> template = new RedisTemplate<String, String>();
		template.setConnectionFactory(this.jedisConnectionFactory());
		//para o caso de uso de objeto RedisTemplate<String, Object>
		template.setValueSerializer(new GenericToStringSerializer<String>(String.class));
		return template;
	}
}
