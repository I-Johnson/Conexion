package conexion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testConexion {
	
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
	
	
	@BeforeEach 
	void setUp() throws Exception { 
		
		idGenerator = new IDGenerator();
		
		cloudComputing = new Skill(idGenerator, "Cloud Computing");
		springMVC = new Skill(idGenerator, "Spring MVC");
		mern = new Skill(idGenerator, "MERN");
		
		RWilliams = new Person(idGenerator, "Robin", "Williams", "robin@princeton.edu", "GreatestActor", 4, 
				"Masters", "PrincetonU", "Computer Science");
		
		RWilliams.getSkills().add(springMVC.getPageID());
		RWilliams.getSkills().add(cloudComputing.getPageID());
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
// 
//	
//	
	@Test
	
	// Checking if makeID from IDGenerator is creating new pages correctly
	public void test() {
		
		
		assertEquals("Robin", RWilliams.getUserName());
		assertEquals("Williams", RWilliams.getUserPassword());
		assertEquals("robin@princeton.edu", RWilliams.getUserEmail());
		assertEquals("GreatestActor", RWilliams.getUserBio());
		
		assertEquals("Computer Science", RWilliams.getPersonMajor());
		assertEquals("Masters", RWilliams.getPersonDegree());
		assertEquals("PrincetonU", RWilliams.getPersonInstitution());
		
		assertEquals("Headquarters", Netflix.getEmployerLocation());
		
		assertEquals(4, RWilliams.getYearsOfExperience());
		assertEquals(1, RWilliams.getPosts().size());
		assertEquals(3, RWilliams.getSkills().size());
		 
		//Checking the skill value is present after we add it
		assertEquals(cloudComputing.getPageID(), RWilliams.getSkills().get(1));
		assertEquals(springMVC.getPageID(), RWilliams.getSkills().get(0));
		
		//Checking the skill value is increased after we use addSkill
		assertEquals(mern.getPageID(), RWilliams.getSkills().get(2));
//		assertEquals(2, KMiles.getSkills().size());
		
		assertEquals(1, cloudComputing.getSkills().size());
		
		//Cloud computing was already added to netflix. 
		assertEquals(1, cloudComputing.getPosts().size());
		
		
		assertEquals(KMiles.getPageID(), SWESenior_Job_Article.getPostAuthor());
		
		
	 
		String success = "Your application has been submitted.";
		String fail = "Unable to submit! You don't meet the requirements";
//		
		assertEquals(RWilliamsPost1.getPageID(), RWilliams.getPosts().get(0));
		
//		assertEquals() 
		
		assertEquals(success, RWilliams.apply(NetflixJob1));
		assertEquals(fail, RWilliams.apply(NetflixJob2));
		
		assertEquals(success, KMiles.apply(NetflixJob2));
		assertEquals(fail, KMiles.apply(NetflixJob1));
		
		assertEquals("Computer Science", SWEAssociate_Job.getRequiredMajor());
		assertEquals("Bachelors", SWEAssociate_Job.getRequiredDegree());
		assertEquals(2, SWEAssociate_Job.getRequiredExperience());
		
//		assertEquals("Software Engineering Associate", Netflix.addPost(SWEAssociate_Job).size()); 
		
//		assertEquals(null, Netflix.getPosts().get(0).getPostAttachments());
 		
		//test permissions
		assertEquals(true, RWilliams.editAttempt(RWilliams));
		assertEquals(false, RWilliams.editAttempt(KMiles));
		
		assertEquals(true, RWilliams.editAttempt(RWilliamsPost1));
		assertEquals(false, KMiles.editAttempt(RWilliamsPost1));
		
		assertEquals(true, RWilliams.viewAttempt(KMiles));
		assertEquals(false, Netflix.editAttempt(KMiles));
		assertEquals(true, Netflix.editAttempt(SWEAssociate_Job));
		assertEquals(true, KMiles.viewAttempt(Netflix));
		assertEquals(true, KMiles.viewAttempt(KMiles)); 
		
	}
	
	public void RecommendationTest(){
		
	}

	

}
