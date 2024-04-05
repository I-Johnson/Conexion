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
	
	@BeforeEach
	void setUp() throws Exception {
		
		idGenerator = new IDGenerator();
		
		cloudComputing = new Skill(idGenerator, "Cloud Computing");
		springMVC = new Skill(idGenerator, "Spring MVC");
		mern = new Skill(idGenerator, "MERN");
		
		RWilliams = new Person(idGenerator, "Robin", "Williams", "robin@princeton.edu", "GreatestActor", 4, 
				"Masters", "PrincetonU", "Computer Science");
		
		RWilliams.getSkills().add(springMVC);
		RWilliams.getSkills().add(cloudComputing);
		RWilliams.addSkill(mern);
		
//		RW
		Post SWESenior_Job_Article = new Post(idGenerator, "SWE Job Article", "March 31", "BODY", KMiles);
		
		RWilliams.post("Centre College Good", "March 31st", "no_body_available");
//		KMiles.posts.addPost(SWESenior_Job_Article);
		
		KMiles = new Person(idGenerator, "Ken Miles", "FordIsBest", "Miles@ford.com", "Best Driver", 1, 
		"Bachelors", "Centre University", "Computer Science");

		KMiles.getSkills().add(springMVC);
		KMiles.addSkill(cloudComputing);
		
		SWEAssociate_Job = new Job(idGenerator, "Software Engineering Associate", "April 1", "JobDesc", Netflix, 2, "Bachelors", "Computer Science");
		
		Netflix = new Employer(idGenerator, "Netflix", "No Sharing", "careers@netflix.com", "Finest Software Engineering", "Headquarters");
		
		Netflix.postJob(3, "Masters", "Computer Science", "SWE Senior", "April1", "job Description");
		Netflix.getPosts().get(0).addSkill(cloudComputing);
		Netflix.getPosts().get(0).addSkill(mern);
		Netflix.getPosts().get(0).addSkill(springMVC);
		
		Netflix.postJob(1, "Bachelors", "Computer Science", "SWE Associate", "May 20", "job Description");
		Netflix.getPosts().get(1).addSkill(springMVC);
		
		Netflix.addPost(SWEAssociate_Job);
		Netflix.getPosts().get(0).addPost(SWESenior_Job_Article); 
		
		cloudComputing.addSkill(cloudComputing);
		
		cloudComputing.addPost(SWESenior_Job_Article);
	
	}
// 
//	
//	
	@Test
	
	// Checking if makeID from IDGenerator is creating new pages correctly
	public void test() {
		
		assertEquals(3, mern.getPageID());
		
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
		 
		//Checking the skill value is present after we added it
		assertEquals("Cloud Computing", RWilliams.getSkills().get(1).getSkill());
		assertEquals("Spring MVC", RWilliams.getSkills().get(0).getSkill());
		//Checking the skill value is increased after we use addSkill
		assertEquals("MERN", RWilliams.getSkills().get(2).getSkill());
//		assertEquals(2, KMiles.getSkills().size());
		
		assertEquals(1, cloudComputing.getSkills().size());
		
		//Cloud computing was already added to netflix. 
		assertEquals(2, cloudComputing.getPosts().size());
		
		
		assertEquals("Netflix", Netflix.getPosts().get(0).getPostAuthor().getUserName());
		
		
	 
		String success = "Your application has been submitted.";
		String fail = "Unable to submit! You don't meet the requirements";
		assertEquals("Centre College Good", RWilliams.getPosts().get(0).getPostTitle());
		assertEquals("March 31st", RWilliams.getPosts().get(0).getPostDate());
		assertEquals("no_body_available", RWilliams.getPosts().get(0).getPostBody());
		assertEquals("Robin", RWilliams.getPosts().get(0).getPostAuthor().getUserName());
		
//		assertEquals() 
		
		assertEquals(success, RWilliams.apply((Job) Netflix.getPosts().get(0)));
		assertEquals(fail, RWilliams.apply((Job) Netflix.getPosts().get(1)));
		
		assertEquals(success, KMiles.apply((Job) Netflix.getPosts().get(1)));
		assertEquals(fail, KMiles.apply((Job) Netflix.getPosts().get(0)));
		
		assertEquals("Computer Science", SWEAssociate_Job.getRequiredMajor());
		assertEquals("Bachelors", SWEAssociate_Job.getRequiredDegree());
		assertEquals(2, SWEAssociate_Job.getRequiredExperience());
		
//		assertEquals("Software Engineering Associate", Netflix.addPost(SWEAssociate_Job).size()); 
		
//		assertEquals(null, Netflix.getPosts().get(0).getPostAttachments());
 		
		//test permissions
		assertEquals(true, RWilliams.editAttempt(RWilliams));
		assertEquals(false, RWilliams.editAttempt(KMiles));
		
		assertEquals(true, RWilliams.editAttempt(RWilliams.getPosts().get(0)));
		assertEquals(false, KMiles.editAttempt(RWilliams.getPosts().get(0)));
		
		assertEquals(true, RWilliams.viewAttempt(KMiles));
		assertEquals(false, Netflix.editAttempt(KMiles));
		assertEquals(true, Netflix.editAttempt(Netflix.getPosts().get(0)));
		assertEquals(true, KMiles.viewAttempt(Netflix));
		assertEquals(true, KMiles.viewAttempt(KMiles)); 
		
	}

	

}
