package conexion;

import org.springframework.web.client.RestClient;

public class RestMain {

	RestClient client = RestClient.create();
    String uriBase = "http://localhost:3500";
	
    public static void main(String[] args) {
        
//
        IDGenerator idGenerator = new IDGenerator(); // Initialize IDGenerator

        // Creating a Skill
        Skill skill = new Skill(idGenerator, uriBase);

        // Now you can interact with the skill similar to what you did with pages
        // For example:
        String response = client.post()
                .uri(uriBase + "/page/skill")
                .body(skill.getDesc()) // Assuming getDesc() returns the description
                .retrieve()
                .body(String.class);
        System.out.println(response);

        // Similarly, you can perform operations on other pages or skills
    }
}

