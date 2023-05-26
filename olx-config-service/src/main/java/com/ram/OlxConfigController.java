package com.ram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlxConfigController {

	@Autowired
	OlxConfigData data;

	@GetMapping("/olx/config")
	public OlxConfigData getData()
	{
		return data;
	}
}