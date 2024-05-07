package conexion;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class RestMainTest {
	RestMain server;
	public IDGenerator idGenerator;
	
	public Skill cloudComputing;
	public Skill springMVC;
	public Skill mern;
	public Skill someSkill;
	 
	public Person KMiles;
	public Person RWilliams;
	public Person Sundar;
	
	public Employer Netflix;
	
	public Job SWEAssociate_Job;
	
	public Post SWESenior_Job_Article;
	
	public Post RWilliamsPost1;
	public Post SWE_Principles_Post;
	
	public Job NetflixJob1;
	public Job NetflixJob2;
	public Job NetflixJob3;
	
	public RecommendAll recommendAll;
	public RecommendBest recommendBest;
	public RecommendSkilled recommendSkilled;

	
	@BeforeEach
	void setUp() throws Exception{
		server = new RestMain(); 
		idGenerator = new IDGenerator();
		

	}
	
	public void testPageRemoval(String id, RestMain server) {
		boolean pageRemoved = false;
		try {
			server.getSkill(id);
			pageRemoved = false;
		}
		catch(RestClientException e) {
			pageRemoved = true;
		}
		try {
			server.getPost(id);
			pageRemoved = false;
		}
		catch(RestClientException e) {
			pageRemoved = true;
		}
		try {
			server.getEmployer(id);
			pageRemoved = false;
		}
		catch(RestClientException e) {
			pageRemoved = true;
		}
		try {
			server.getJob(id);
			pageRemoved = false;
		}
		catch(RestClientException e) {
			pageRemoved = true;
		}
		try {
			server.getPerson(id);
			pageRemoved = false;
		}
		catch(RestClientException e) {
			pageRemoved = true;
		}
		
		assertEquals(true, pageRemoved);
	}
	


	@Test
	void Test() {

	     server.clearCache();
	     server.makeDesc();
	     server.makeClass("Page"); // /page
	     server.makeClass("Post"); // /posts
	     server.makeClass("Skill"); // /skill
	     server.makeClass("User"); // /user
	     server.makeClass("Person");// /person
	     server.makeClass("Employer"); // /employer
	     server.makeClass("Job"); // /job
	     server.makeClass("pageCounter");
	     
	     RestClient client = RestClient.create();
	     
	     PageCounter contedorDePaginasTest = new PageCounter();

	     String contedorDePaginasTestJson;
	     ObjectMapper objectMapper = new ObjectMapper();
	     
	     
	     try {
				contedorDePaginasTestJson = objectMapper.writeValueAsString(contedorDePaginasTest);
				@SuppressWarnings("unused")
				String response = client.post()
						.uri("http://localhost:9000/v1/Conexion/pageCounter/1")
						.contentType(MediaType.APPLICATION_JSON)
						.body(contedorDePaginasTestJson)
						.retrieve()
						.body(String.class);
//				System.out.println(response);
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
			cloudComputing = new Skill(idGenerator, "Cloud Computing");
			springMVC = new Skill(idGenerator, "Spring MVC");
			mern = new Skill(idGenerator, "MERN");
			someSkill = new Skill(idGenerator, "SomeSkill");
			
			RWilliams = new Person(idGenerator, "Robin", "Williams", "robin@princeton.edu", "GreatestActor", 4, 
					"Masters", "PrincetonU", "Computer Science");
			
			RWilliams.addSkill(cloudComputing);
			RWilliams.addSkill(mern);
			RWilliams.addSkill(springMVC);
			
			 
			RWilliamsPost1 = RWilliams.post("Centre College Good", "March 31st", "no_body_available");
			
			
			
			KMiles = new Person(idGenerator, "Ken Miles", "FordIsBest", "Miles@ford.com", "Best Driver", 1, 
			"Bachelors", "Centre University", "Computer Science");

			KMiles.getSkills().add(springMVC.getPageID());
			KMiles.addSkill(cloudComputing);
			
			SWESenior_Job_Article = KMiles.post("Have fun in life", "March 31", "BODY");
//			KMiles.po
			
			
			Netflix = new Employer(idGenerator, "Netflix", "No Sharing", "careers@netflix.com", "Finest Software Engineering", "Headquarters");
			
//			SWEAssociate_Job = new Job(idGenerator, "Software Engineering Associate", "April 1", "JobDesc", Netflix.getPageID(), 2, "Bachelors", "Computer Science");
			
			NetflixJob1 = Netflix.postJob(3, "Masters", "Computer Science", "SWE Senior", "April1", "job Description");
			NetflixJob1.addSkill(cloudComputing);
			NetflixJob1.addSkill(mern);
			NetflixJob1.addSkill(springMVC);
			
			
			NetflixJob2 = Netflix.postJob(1, "Bachelors", "Computer Science", "SWE Associate", "May 20", "job Description");
			NetflixJob2.addSkill(springMVC);
			
			NetflixJob3 = Netflix.postJob(4, "Masters", "Computer Science", "SWE Principal", "April 18", "job Description");
			NetflixJob3.addSkill(cloudComputing);
			NetflixJob3.addSkill(mern);
			
//			Netflix.addPost(SWEAssociate_Job);
			
//			Netflix.addPost(SWESenior_Job_Article); 
			
			cloudComputing.addPost(SWESenior_Job_Article);
		// do it
		 Sundar = new Person(idGenerator, "Sundar", "sundar@google.com", "1234", "CEO", 21, "Centre College", "Masters", "Computer Science");

		 //Job
		 SWEAssociate_Job  = Netflix.postJob(2, "Bachelors", "Computer Science", "Software Engineering Associate", "May 11", "Job Desc");
		 SWE_Principles_Post = Sundar.post("SWE Job Article", "March 31", "BODY");
				 
		server.addPage(mern);
		server.addPage(SWESenior_Job_Article);
		server.addPage(Sundar); 
		server.addPage(Netflix);
		server.addPage(SWEAssociate_Job);
		server.addPage(SWE_Principles_Post);
		server.addPage(KMiles);
		server.addPage(RWilliams);
		server.addPage(springMVC);
		server.addPage(NetflixJob1);
		server.addPage(NetflixJob2);
		server.addPage(NetflixJob3);
		server.addPage(SWEAssociate_Job);
		server.addPage(cloudComputing);
		server.updatePage(RWilliams);
		server.updatePage(NetflixJob1);
		server.updatePage(SWEAssociate_Job);
				 
		 //Test all the GET METHOD is working for all the classes. 
		 assertTrue(mern.equals(server.getSkill(mern.getPageID()).data()));
		 assertTrue(Sundar.equals(server.getPerson(Sundar.getPageID()).data()));
		 assertTrue(Netflix.equals(server.getEmployer(Netflix.getPageID()).data()));
		 assertTrue(SWEAssociate_Job.equals(server.getJob(SWEAssociate_Job.getPageID()).data()));
		 assertTrue(SWE_Principles_Post.equals(server.getPost(SWE_Principles_Post.getPageID()).data()));
		 
	
		 
		 
//				 Put Test
		 // change username
		 Sundar.setUserName("Sundar222");
		 server.updatePage(Sundar);
		 assertEquals(Sundar.getUserName(), server.getPerson(Sundar.getPageID()).data().getUserName());
		 
		 
		 //Test get all methods
		 ArrayList<Skill> allSkills = server.getAllSkills();
		 ArrayList<Post> allPosts = server.getAllPosts();
		 ArrayList<Employer> allEmployers = server.getAllEmployers();
		 ArrayList<Person> allPersons = server.getAllPersons();
		 ArrayList<Job> allJobs = server.getAllJobs();
		 
		 //Skills --
		 assertTrue(allSkills.contains(mern));
		 assertTrue(allSkills.contains(cloudComputing));
		 assertTrue(allSkills.contains(springMVC));
		 
		 //Person
		 assertTrue(allPersons.contains(RWilliams));
		 assertTrue(allPersons.contains(KMiles));
		 assertTrue(allPersons.contains(Sundar));
		 
		 // Posts
		 assertTrue(allPosts.contains(SWE_Principles_Post));
		 
		 // Employer
		 assertTrue(allEmployers.contains(Netflix));
		 
		 //Job
		 assertTrue(allJobs.contains(NetflixJob1));
		 assertTrue(allJobs.contains(NetflixJob2));
		 assertTrue(allJobs.contains(NetflixJob3));
		 
		 
		 // Recommendation Test Start here

		 	recommendAll = new RecommendAll();
			recommendAll.sendRecommendation(SWEAssociate_Job);
			
			KMiles = server.getPerson(KMiles.getPageID()).data();
			RWilliams = server.getPerson(RWilliams.getPageID()).data();
			
			
			assertTrue(KMiles.getRecommendedJobs().contains(SWEAssociate_Job.getPageID()));
			assertTrue(RWilliams.getRecommendedJobs().contains(SWEAssociate_Job.getPageID()));
			
			//RecommendSkilled
			recommendSkilled = new RecommendSkilled();
			recommendSkilled.sendRecommendation(NetflixJob1);
			
			KMiles = server.getPerson(KMiles.getPageID()).data();
			RWilliams = server.getPerson(RWilliams.getPageID()).data();

			assertFalse(KMiles.getRecommendedJobs().contains(NetflixJob1.getPageID()));
			assertTrue(RWilliams.getRecommendedJobs().contains(NetflixJob1.getPageID()));

			//RecommendBest
			recommendBest = new RecommendBest();
			recommendBest.sendRecommendation(NetflixJob3);
			
			KMiles = server.getPerson(KMiles.getPageID()).data();
			RWilliams = server.getPerson(RWilliams.getPageID()).data();
			Sundar = server.getPerson(Sundar.getPageID()).data();
			
			assertFalse(KMiles.getRecommendedJobs().contains(NetflixJob3.getPageID()));
			assertFalse(RWilliams.getRecommendedJobs().contains(NetflixJob3.getPageID()));
			assertTrue(Sundar.getRecommendedJobs().contains(NetflixJob3.getPageID()));
			
			
			// Test apply and Reject: 
			Reject KMilesReject = new Reject(KMiles.getPageID());
			Apply RWilliamsAccept = new Apply(RWilliams.getPageID());
			
			KMilesReject.doAction(SWEAssociate_Job);
			RWilliamsAccept.doAction(NetflixJob1);
			
			
			KMiles = server.getPerson(KMiles.getPageID()).data();
			RWilliams = server.getPerson(RWilliams.getPageID()).data();
			NetflixJob1 = server.getJob(NetflixJob1.getPageID()).data();
			
			// Making sure KMiles rejected the job he was recommended
			assertFalse(SWEAssociate_Job.getApplicants().contains(KMiles.getPageID()));
			
			//Making sure RWilliams applied to the job he was recommended
			assertTrue(NetflixJob1.getApplicants().contains(RWilliams.getPageID()));
			
			 
			 // Remove someSkill and test it worked
			 server.removePage(someSkill.getPageID());
			 testPageRemoval(someSkill.getPageID(), server);
			 
			 allSkills = server.getAllSkills();
			 assertFalse(allSkills.contains(someSkill));
			 
			KMiles = server.getPerson(KMiles.getPageID()).data();
			RWilliams = server.getPerson(RWilliams.getPageID()).data();
			NetflixJob1 = server.getJob(NetflixJob1.getPageID()).data();
			
			System.out.println("Success");
					
	}	

}