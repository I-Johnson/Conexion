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
	public Job SWESenior_Job;
	
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
		RWilliams.getSkills().add(mern);
		
		RWilliams.post("Centre College Good", "March 31st", "no_body_available");

		KMiles = new Person(idGenerator, "Ken Miles", "FordIsBest", "Miles@ford.com", "Best Driver", 1, 
		"Bachelors", "Centre University", "Computer Science");

		KMiles.getSkills().add(springMVC);
		
		Netflix = new Employer(idGenerator, "Netflix", "No Sharing", "careers@netflix.com", "Finest Software Engineering", "Headquarters");
		
		Netflix.postJob(3, "Masters", "Computer Science", "SWE Senior", "April1", "job Description");
		Netflix.getPosts().get(0).addSkill(cloudComputing);
		Netflix.getPosts().get(0).addSkill(mern);
		Netflix.getPosts().get(0).addSkill(springMVC);
		
		Netflix.postJob(1, "Bachelors", "Computer Science", "SWE Associate", "May 20", "job Description");
		Netflix.getPosts().get(1).addSkill(springMVC);
	
	}
//
//	
//	
	@Test
	
	// Checking if makeID from IDGenerator is creating new pages correctly
	public void test() {
//		
		assertEquals(3, mern.getPageID());
		
		assertEquals("Computer Science", RWilliams.getPersonMajor());
		assertEquals("Masters", RWilliams.getPersonDegree());
		assertEquals("PrincetonU", RWilliams.getPersonInstitution());
		
		assertEquals(4, RWilliams.getYearsOfExperience());
		assertEquals(1, RWilliams.getPosts().size());
		assertEquals(3, RWilliams.getSkills().size());
		
		//Checking the skill value is present after we added it
		assertEquals("Cloud Computing", RWilliams.getSkills().get(1).getSkill());
		assertEquals("Spring MVC", RWilliams.getSkills().get(0).getSkill());
		assertEquals("MERN", RWilliams.getSkills().get(2).getSkill());
		
		
	
		String success = "Your application has been submitted.";
		String fail = "Unable to submit! You don't meet the requirements";
		
		assertEquals(success, RWilliams.apply((Job) Netflix.getPosts().get(0)));
		assertEquals(fail, RWilliams.apply((Job) Netflix.getPosts().get(1)));
		
		assertEquals(success, KMiles.apply((Job) Netflix.getPosts().get(1)));
		assertEquals(fail, KMiles.apply((Job) Netflix.getPosts().get(0)));
		
		
		
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
