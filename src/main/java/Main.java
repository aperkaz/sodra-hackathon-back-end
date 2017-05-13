import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

import businessClasses.Property;
import dataAccesLayer.DatabaseHandler;
import spark.Request;
import spark.Response;
import spark.resource.AbstractFileResolvingResource;
import spark.resource.ExternalResource;
import spark.staticfiles.MimeType;

public class Main {
	static String projectDir = System.getProperty("user.dir");
	static String staticDir = File.separator + "frontEnd"; 

	public static void main(String[] args) {
		DatabaseHandler handler = DatabaseHandler.getInstance(); // Init
                															// database
		port(4567);
		staticFiles.externalLocation(projectDir + staticDir); 
		
		
		// static resource serving
		get("/", (req, res) -> {
			return serveAltRoute(req, res);
		});

		// API endpoints
		get("/randomProperty", (req, res) -> {
			System.out.println("--\nGET REQ: /randomProperty");
						
			ArrayList<Integer> ids = handler.getAvailablePropertyIds();	
			Random rand = new Random(); 
			int value = rand.nextInt(ids.size()) +1;
					
			Property property = handler.getProperty(value);			
			System.out.println(property.toString() + "\n--");			
			
			res.type("application/json");
			return property.toJson();
		});
		
		get("/property/:id_property", (req, res) -> {
			System.out.println("--\nGET REQ: /property/"+ req.params(":id_property"));
			
			Property property = handler.getProperty(Integer.parseInt(req.params(":id_property")));			
			System.out.println(property.toString() + "\n--");
			
			res.type("application/json");
			return property.toJson();
		});

		// route fallbacks			
		get("/*", (req, res) -> {
			res.redirect("/");
			return null;
		});		
	}

	// serve routes
	public static String serveAltRoute(Request req, Response res) throws IOException {
		File file = new File(projectDir + staticDir + File.separator + "index.html");
		Path path = file.toPath();
		AbstractFileResolvingResource resource = new ExternalResource(projectDir + staticDir + File.separator + "index.html");
		Files.copy(path, res.raw().getOutputStream());
		String content = MimeType.fromResource(resource);
		res.type(content);
		return "";
	}
	
}
