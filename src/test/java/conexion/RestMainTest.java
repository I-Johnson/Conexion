package conexion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestMainTest {
	RestMain server;
	
	public IDGenerator idGenerator;
	
	public Skill cloudComputing;
	public Skill springMVC;
	public Skill mern;
	
	public Person KMiles;
	public Person RWilliams;
	
	public Employer Netflix;
	
	public Job SWEAssociate_Job;
	public Job SWESenior_Job;
	
	@BeforeEach
	void beforeEach() {
		server = new RestMain();
		idGenerator = new IDGenerator();
	}

	@Test
	void test() {
	     server.clearCache();
	     
	     // /Conexion
	     server.makeDesc();
	     
	     server.makeClass("page"); // /page
	     server.makeClass("posts"); // /posts
	     server.makeClass("skill"); // /skill
	     server.makeClass("user"); // /user
	     server.makeClass("person");// /person
	     server.makeClass("employer"); // /employer
	     server.makeClass("job"); // /job
	     
	     
	     
	     cloudComputing = new Skill(idGenerator, "Cloud Computing");
		 springMVC = new Skill(idGenerator, "Spring MVC");
		 mern = new Skill(idGenerator, "MERN");
	     
		 RWilliams = new Person(idGenerator, "Robin", "Williams", "robin@princeton.edu", "GreatestActor", 4, 
					"Masters", "PrincetonU", "Computer Science");
		 
		 KMiles = new Person(idGenerator, "Ken Miles", "FordIsBest", "Miles@ford.com", "Best Driver", 1, 
					"Bachelors", "Centre University", "Computer Science");
		 
		 Netflix = new Employer(idGenerator, "Netflix", "No Sharing", "careers@netflix.com", "Finest Software Engineering", "Headquarters");
	     
//		 server.addPage(KMiles);
//		 server.getPage(KMiles);
//	     assertEquals(server.addPage(mern), server.getPage(mern));
		 
	     System.out.println(server.addPage(mern));
	     System.out.println(server.getPage(mern));
	     
	     
	     mern.addEditor(KMiles);
	     
	     server.updatePage(mern);
	     server.removePage(mern);
	     
	}
	
//	@Test
//    void testGetUsers() {
//        // Perform the HTTP request
//        String response = given()
//                .get("http://localhost:8080/users")
//                .then()
//                .statusCode(200)
//                .extract()
//                .body()
//                .asString();
//
//        // Assert the response
//        assertThat(response, equalTo("[{\"id\": 1, \"name\": \"John Doe\"}, {\"id\": 2, \"name\": \"Jane Doe\"}]"));
//    }
	
	

}
