package conexion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class recommendationTest {
	RestMain server;
	public IDGenerator idGenerator;
	
	public Skill cloudComputing;
	public Skill springMVC;
	public Skill mern;
	 
	public Person KMiles;
	public Person RWilliams;
	
	public Employer Netflix;
	
	public Job SWEAssociate_Job;
	
	public Post SWESenior_Job_Article;
	
	public Post RWilliamsPost1;
	
	public Job NetflixJob1;
	public Job NetflixJob2;
	
	public RecommendAll recommendAll;
	public RecommendBest recommendBest;
	public RecommendSkilled recommendSkilled;
	


	@BeforeEach 
	void setUp() throws Exception { 
		server = new RestMain(); 
		idGenerator = new IDGenerator();
		
		cloudComputing = new Skill(idGenerator, "Cloud Computing");
		springMVC = new Skill(idGenerator, "Spring MVC");
		mern = new Skill(idGenerator, "MERN");
		
		RWilliams = new Person(idGenerator, "Robin", "Williams", "robin@princeton.edu", "GreatestActor", 4, 
				"Masters", "PrincetonU", "Computer Science");
		
		RWilliams.addSkill(springMVC);
		RWilliams.addSkill(cloudComputing);
		RWilliams.addSkill(mern);
		 
		RWilliamsPost1 = RWilliams.post("Centre College Good", "March 31st", "no_body_available");
		
		
//		KMiles.posts.addPost(SWESenior_Job_Article);
		
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
	
	@Test 
	void RecommendationTest() {
		server.addPage(KMiles);
		server.addPage(RWilliams);
		server.addPage(Netflix);
		server.addPage(SWEAssociate_Job);
//		server.addPage(SWESenior_Job);
//		server.addPage(SWE_Principles_Post);
		server.addPage(cloudComputing);
		
		
		// RecommendALL
		recommendAll = new RecommendAll();
		recommendAll.sendRecommendation(SWEAssociate_Job);
		
		KMiles = server.getPerson(KMiles.getPageID()).data();
		RWilliams = server.getPerson(RWilliams.getPageID()).data();
		
		
		assertTrue(KMiles.getRecommendedJobs().contains(SWEAssociate_Job.getPageID()));
		assertTrue(RWilliams.getRecommendedJobs().contains(SWEAssociate_Job.getPageID()));
		
		System.out.print(NetflixJob1.getSkills());
		System.out.print(RWilliams.getSkills());
		//RecommendSkilled
		recommendSkilled = new RecommendSkilled();
		recommendSkilled.sendRecommendation(NetflixJob1);
		assertFalse(KMiles.getRecommendedJobs().contains(NetflixJob1.getPageID()));
		assertTrue(RWilliams.getRecommendedJobs().contains(NetflixJob1.getPageID()));
//		
		//RecommendBest
//		recommendBest = new RecommendBest();
//		recommendBest.sendRecommendation(NetflixJob1);
//		assertFalse(KMiles.getRecommendedJobs().contains(NetflixJob1.getPageID()));
//		assertTrue(RWilliams.getRecommendedJobs().contains(NetflixJob1.getPageID()));
		
		
		
		// Test apply and Reject: 
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

}
