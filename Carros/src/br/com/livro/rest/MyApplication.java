package br.com.livro.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jettison.JettisonFeature;

public class MyApplication extends Application {

//	public Set<Object> getSingletons() {
//		Set<Object> singletons = new HashSet<>();
//		// Driver do Jettison para gerar o JSON.
//		singletons.add(new JettisonFeature());
//		return singletons;
//	}

	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		// Configura o pacote para fazer scan das classes com anotações REST.
		properties.put("jersey.config.server.provider.packages", "br.com.livro");
		return properties;
	}
}
