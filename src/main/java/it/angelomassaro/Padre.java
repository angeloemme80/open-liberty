package it.angelomassaro;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/padre")
public class Padre {

	@GET
	@Path("/primo")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject mioServizio() {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		return builder.add("nome", "Angelo")
				.add("cognome", "Massaro")
				.add("eta", 41)
				.add("timestamp", System.currentTimeMillis())
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
	
	
}
