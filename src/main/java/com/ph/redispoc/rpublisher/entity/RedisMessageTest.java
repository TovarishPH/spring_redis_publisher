package com.ph.redispoc.rpublisher.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisMessageTest {

	private List<String> topicos;
	
	private String message;
}
