package it.angelomassaro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.RateLimiter;

import io.openliberty.sample.system.SystemConfig;

@RequestScoped
@Path("/padre")
public class Padre {

	@Inject
	SystemConfig systemConfig;
	
    private static final int    PERMITS_CONSUMED 	= 20;
	private Logger logger = LoggerFactory.getLogger(Padre.class);
	
	/*
	 * Esempio di come limitare l'utilizzo di metodi e servizi attraverso l'oggetto RateLimiter
	 */
    
	@GET
	@Path("/primo")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject mioServizio() {        
        
		double slept = Padre.metodoDiBusiness(systemConfig.limiter);
		//systemConfig.limiter.acquire();
        
		JsonObjectBuilder builder = Json.createObjectBuilder();
		return builder.add("nome", "Angelo")
				.add("cognome", "Massaro")
				.add("eta", 41)
				.add("timestamp", System.currentTimeMillis())
				.add("slept",slept)
                .build();
	}
	
	@GET
	@Path("/secondo")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject secondo() {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		return builder.add("nome", "Angela")
				.add("cognome", "Russo")
				.add("eta", 41)
				.add("timestamp", System.currentTimeMillis())
                .build();
	}
	
	
	public static double metodoDiBusiness(RateLimiter limiter) {
		double slept = limiter.acquire();
		System.out.println("DENTRO IL METODO DI BISINESS: " + slept);
		return slept;
	}
	
}
