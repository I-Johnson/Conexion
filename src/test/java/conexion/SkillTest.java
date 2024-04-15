package conexion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class SkillTest {

	@Test
	void test() {
		IDGenerator idGenerator = new IDGenerator();
		Skill mern = new Skill(idGenerator, "mern");
		ObjectMapper objectMapper = new ObjectMapper(); 
//		jsonTry test = new jsonTry(0, "String", false);
		String carAsString;
		try {
			carAsString = objectMapper.writeValueAsString(mern);
			Skill mernBack = objectMapper.readValue(carAsString, Skill.class);	
			System.out.println(carAsString);
			System.out.println(mernBack);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
