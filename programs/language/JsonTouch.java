package language;

import javax.json.*;

public class JsonTouch {
 public static void main(String [] args){
	 JsonBuilderFactory factory = Json.createBuilderFactory(null);
	 JsonObject value = factory.createObjectBuilder()
	     .add("firstName", "John")
	     .add("lastName", "Smith")
	     .add("age", 25)
	     .add("address", factory.createObjectBuilder()
	         .add("streetAddress", "21 2nd Street")
	         .add("city", "New York")
	         .add("state", "NY")
	         .add("postalCode", "10021"))
	     .add("phoneNumber", factory.createArrayBuilder()
	         .add(factory.createObjectBuilder()
	             .add("type", "home")
	             .add("number", "212 555-1234"))
	         .add(factory.createObjectBuilder()
	             .add("type", "fax")
	             .add("number", "646 555-4567")))
	     .build();
	 
	 System.out.println(value);
	 
 }
}
