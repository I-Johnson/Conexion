package conexion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class skillRestTest {

	@Test
	void test() {
		IDGenerator idGenerator = new IDGenerator();
		Skill mern = new Skill(idGenerator, "mern");
		ObjectMapper objectMapper = new ObjectMapper(); 
//		jsonTry test = new jsonTry(0, "String", false);
		String mySKill_string;
		try {
			mySKill_string = objectMapper.writeValueAsString(mern);
			Skill mernBack = objectMapper.readValue(mySKill_string, Skill.class);	
			System.out.println(mySKill_string);
			System.out.println("back: " +  mernBack);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}