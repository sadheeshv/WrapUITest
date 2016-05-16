package com.wrap.auto.sampleproject.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class EnvironmentConfigLoader {

	private static EnvironmentConfigLoader configLoader;
	private static EnvironmentConfig config;

	public EnvironmentConfig getConfig() {
		return config;
	}

	private EnvironmentConfigLoader() {
	}

	public static EnvironmentConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new EnvironmentConfigLoader();
			configLoader.loadProperties();
		}
		return configLoader;
	}

	public void loadProperties() {
		InputStream input = null;
		try {
			input = new FileInputStream(new File(
					"src/test/resource/automation-conf.yaml"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					"Failed to get the config information for thet tests"
							+ e.getMessage());
		}

		Yaml yaml = new Yaml(new Constructor(EnvironmentConfig.class));
		config = (EnvironmentConfig) yaml.load(input);
		System.out.println(config.getBaseUrl()); // will be moved to logger as info.
		System.out.println(config.getUserName());// will be moved to logger as info.

	}
}
