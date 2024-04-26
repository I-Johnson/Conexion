package conexion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

class testRest {

	RestMain server;
	public IDGenerator idGenerator;
	
	public Skill cloudComputing;
	public Skill springMVC;
	public Skill mern;
	 
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
	
	public RecommendAll recommendAll;
	public RecommendBest recommendBest;
	public RecommendSkilled recommendSkilled;

	
	@BeforeEach
	void setUp() throws Exception{
		server = new RestMain(); 
		idGenerator = new IDGenerator();
		

	}
	
	public void testPageRemoval1(String id, RestMain server) {
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
	    server.makeClass("Person"); // /person
	    server.makeClass("Employer"); // /employer
	    server.makeClass("Job"); // /job
	    server.makeClass("pageCounter");

	    RestClient client = RestClient.create();

	    // Set up objects
	    setUpObjects();

	    // Test adding and retrieving pages
	    testPageOperations();

	    // Test recommendations
	    testRecommendations();

	    // Test actions like apply and reject
	    testActions();
	}

	private void setUpObjects() {
	    idGenerator = new IDGenerator();
	    cloudComputing = new Skill(idGenerator, "Cloud Computing");
	    springMVC = new Skill(idGenerator, "Spring MVC");
	    mern = new Skill(idGenerator, "MERN");
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

	    SWESenior_Job_Article = new Post(idGenerator, "SWE Job Article", "March 31", "BODY", KMiles.getPageID());

	    Netflix = new Employer(idGenerator, "Netflix", "No Sharing", "careers@netflix.com", "Finest Software Engineering", "Headquarters");

	    SWEAssociate_Job = new Job(idGenerator, "Software Engineering Associate", "April 1", "JobDesc", Netflix.getPageID(), 2, "Bachelors", "Computer Science");

	    NetflixJob1 = Netflix.postJob(3, "Masters", "Computer Science", "SWE Senior", "April1", "job Description");
	    NetflixJob1.addSkill(cloudComputing);
	    NetflixJob1.addSkill(mern);
	    NetflixJob1.addSkill(springMVC);

	    NetflixJob2 = Netflix.postJob(1, "Bachelors", "Computer Science", "SWE Associate", "May 20", "job Description");
	    NetflixJob2.addSkill(springMVC);

	    Netflix.addPost(SWEAssociate_Job);
	    Netflix.addPost(SWESenior_Job_Article);
	    cloudComputing.addPost(SWESenior_Job_Article);
	}

	private void testPageOperations() {
	    server.addPage(mern);
	    server.addPage(Sundar);
	    server.addPage(Netflix);
	    server.addPage(SWEAssociate_Job);
	    server.addPage(SWE_Principles_Post);
	    server.addPage(KMiles);
	    server.addPage(RWilliams);
	    server.addPage(NetflixJob1);
	    server.addPage(NetflixJob2);
	    server.addPage(cloudComputing);
	    server.updatePage(RWilliams);

	    // Test all the GET methods for all the classes
	    assertEquals(mern.getPageID(), server.getSkill(mern.getPageID()).data().getPageID());
	    assertEquals(Sundar.getPageID(), server.getPerson(Sundar.getPageID()).data().getPageID());
	    assertEquals(Netflix.getPageID(), server.getEmployer(Netflix.getPageID()).data().getPageID());
	    assertEquals(SWEAssociate_Job.getPageID(), server.getJob(SWEAssociate_Job.getPageID()).data().getPageID());
	    assertEquals(SWE_Principles_Post.getPageID(), server.getPost(SWE_Principles_Post.getPageID()).data().getPageID());

	    // Remove mern and test it worked
	    server.removePage(mern.getPageID());
	    testPageRemoval1(mern.getPageID(), server);

	    // Test PUT method
	    Sundar.setUserName("Sundar222");
	    server.updatePage(Sundar);
	    assertEquals(Sundar.getUserName(), server.getPerson(Sundar.getPageID()).data().getUserName());
	}

	private void testRecommendations() {
	    recommendAll = new RecommendAll();
	    recommendAll.sendRecommendation(SWEAssociate_Job);

	    KMiles = server.getPerson(KMiles.getPageID()).data();
	    RWilliams = server.getPerson(RWilliams.getPageID()).data();

	    assertTrue(KMiles.getRecommendedJobs().contains(SWEAssociate_Job.getPageID()));
	    assertTrue(RWilliams.getRecommendedJobs().contains(SWEAssociate_Job.getPageID()));

	    recommendSkilled = new RecommendSkilled();
	    recommendSkilled.sendRecommendation(NetflixJob1);
	    assertFalse(KMiles.getRecommendedJobs().contains(NetflixJob1.getPageID()));
	    assertTrue(RWilliams.getRecommendedJobs().contains(NetflixJob1.getPageID()));

	    recommendBest = new RecommendBest();
	    recommendBest.sendRecommendation(NetflixJob1);
	}

	private void testActions() {
	    Reject KMilesReject = new Reject(KMiles.getPageID());
	    Apply RWilliamsAccept = new Apply(RWilliams.getPageID());

	    KMilesReject.doAction(NetflixJob1);
	    RWilliamsAccept.doAction(NetflixJob1);

	    KMiles = server.getPerson(KMiles.getPageID()).data();
	    RWilliams = server.getPerson(RWilliams.getPageID()).data();
	    NetflixJob1 = server.getJob(NetflixJob1.getPageID()).data();

	    assertFalse(KMiles.getRecommendedJobs().contains(NetflixJob1.getPageID()));
	    assertFalse(RWilliams.getRecommendedJobs().contains(NetflixJob1.getPageID()));
	    assertFalse(NetflixJob1.getApplicants().contains(KMiles.getPageID()));
	    assertTrue(NetflixJob1.getApplicants().contains(RWilliams.getPageID()));
	}

	private void testPageRemoval(String id, RestMain server) {
	    boolean pageRemoved = false;
	    try {
	        server.getSkill(id);
	        pageRemoved = false;
	    } catch (RestClientException e) {
	        pageRemoved = true;
	    }
	    // Similar checks for other types of pages...
	    assertEquals(true, pageRemoved);
	}

}
