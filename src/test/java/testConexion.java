import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testConexion {
	
	public IDGenerator idGenerator;
//	private ArrayList<Skill> skills;
//	private ArrayList<Post> posts;
	
	public Skill cloudComputing;
	public Skill SpringMVC;
	public Skill Mern;
	public Person KMiles;
	public Person RWilliams;
	
//	private Page page;
//	
//	private ArrayList<Job> jobs;
//	private Job applyJob;
//	private ArrayList<String> postAttachments;
//	private User user;
//	
	@BeforeEach
	void setUp() throws Exception {
		idGenerator = new IDGenerator();
		Skill cloudComputing = new Skill(idGenerator, "Cloud Computing");
//		skills = new ArrayList<>();
//		posts = new ArrayList<> ();
//		jobs = new ArrayList<> ();
//		user = new User(idGenerator, skills, posts, null, null, null, null);
//		postAttachments = new ArrayList<> ();
//		
//		
//	}
//
//	
//	
//	@Test
//	
//	// Checking if makeID from IDGenerator is creating new pages correctly
//	public void test() {
//		
//		Skill Python = new Skill(idGenerator, new ArrayList<Skill>(), new ArrayList<Post>(), "Python");
//		Skill JavaTDD = new Skill(idGenerator, new ArrayList<Skill>(), new ArrayList<Post>(), "Java : TDD");
//		Skill CloudComputing = new Skill(idGenerator, new ArrayList<Skill>(), new ArrayList<Post>(), "Cloud Computing");
//		
//		Person RWilliams = new Person(idGenerator, new ArrayList<Skill>(), new ArrayList<Post>(), "Robin Williams", "DeadPoetSociety", "rob@hotmail.com", "BIO", 3,
//				"Bachelors", "Princeton University", "Computer Science");
//		RWilliams.getSkills().add(JavaTDD);
//		
//		Person KMiles = new Person(idGenerator, new ArrayList<Skill>(), new ArrayList<Post>(), "Ken Miles", "FordIsBest", "Miles@ford.com", "Best Driver", 8, 
//				"Masters", "Centre University", "Computer Science");
//		
//		KMiles.getSkills().add(CloudComputing);
//		KMiles.getSkills().add(JavaTDD);
//		KMiles.getSkills().add(Python);
//		
//		Employer Netflix = new Employer(idGenerator, new ArrayList<Skill>(), new ArrayList<Post>(), "Netflix", "No Sharing", "careers@netflix.com", "Finest Software Engineering", "Headquarters", jobs);
//		
//		//we can apply to existing job too but I'm testing the posted jobs below which covers both cases. 
////		Job SWEAssociate_Job = new Job(idGenerator, new ArrayList<Skill>(), new ArrayList<Post>(), "jobAllCanApply", "Jan 22", postAttachments, "Body", user, 3, "Bachelors", "Computer Science");
////		Job SWESenior_Job = new Job(idGenerator, new ArrayList<Skill>(), new ArrayList<Post>(), "Senior Level Job", "Mar 10", postAttachments, "Body", user, 5, "Masters", "Computer Science");
//		
////		SWEAssociate_Job.getSkills().add(JavaTDD);
//		
//		
//		
//		assertEquals(1, Python.getPageID()); // 2 for python because user is 1. 
//		assertEquals(2, JavaTDD.getPageID());
//		assertEquals(3, CloudComputing.getPageID());
//		
//		assertEquals(4, RWilliams.getPageID());
//		assertEquals(5, KMiles.getPageID());
//		assertEquals(6, Netflix.getPageID());
//		
//		
////		assertEquals(null, RWilliams.getIdGenerator());
//		
//		//Testing Post Method (User)
//		RWilliams.post("Movies", "Yesterday", postAttachments, "Body", new ArrayList<Skill>());
//		assertEquals(1, RWilliams.getPosts().size());
//		assertEquals(0, KMiles.getPosts().size());
//		
//		Netflix.post("SWE Best Practices", "March", postAttachments, "How to do video streaming w/o any problems", new ArrayList<Skill>());
//		
//		ArrayList<Skill> SWEAssociateSkills = new ArrayList<Skill>();
//		SWEAssociateSkills.add(JavaTDD);
//		
//		ArrayList<Skill> SWESeniorSkills = new ArrayList<Skill>();
//		SWESeniorSkills.add(CloudComputing);
//		SWESeniorSkills.add(JavaTDD);
//		SWESeniorSkills.add(Python);
//		
//		Netflix.postJob(3, "Bachelors", "Computer Science", SWEAssociateSkills, "SWE Associate", "March", postAttachments, "Consider Applying");
//		Netflix.postJob(5, "Masters", "Computer Science", SWESeniorSkills, "SWE Senior", "March", postAttachments, "Consider Applying");
//		
//		assertEquals(Python.getPageID(), 1);
//		
//		
//		
//		
//		String success = "Your application has been submitted.";
//		String fail = "Unable to submit! You don't meet the requirements";
////		Job job = Netflix.getJobs().get(1);
//		//Test
//		//Applicant w/ requirement
//		assertEquals(success, RWilliams.apply((Job) Netflix.getPosts().get(1)));
//		// Applicant w/o requirement for higher level job
//		assertEquals(fail, RWilliams.apply((Job) Netflix.getPosts().get(2)));
//		// Applicant w/ requirement for higher level job
//		assertEquals(success, KMiles.apply((Job) Netflix.getPosts().get(2)));
		
	}

	

}
