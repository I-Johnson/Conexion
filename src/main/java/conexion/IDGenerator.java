package conexion;
import java.util.Hashtable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class IDGenerator {
	private static IDGenerator instance = null;
	private Hashtable<Integer, Page> pageIDs; //attributes
	
	//constructor
	@JsonIgnore
	public IDGenerator() {
		pageIDs = new Hashtable<> ();
	}
	
	public static synchronized IDGenerator getInstance() {
		if (instance == null) {
			instance = new IDGenerator();
		}
		return instance;
	}
	
	public Integer makeID()
	{
		return pageIDs.size() + 1;
	}
	@JsonIgnore
	public Integer giveID(Page page) {
		Integer id = makeID();
//		pageIDs.put(id, page);
		page.setPageID(id);
		return id;
	}
	
	public static void main (String[] args) {
		
	}

	/**
	 * @return the pageIDs
	 */
	public Hashtable<Integer, Page> getPageIDs() {
		return pageIDs;
	}

	/**
	 * @param pageIDs the pageIDs to set
	 */
	public void setPageIDs(Hashtable<Integer, Page> pageIDs) {
		this.pageIDs = pageIDs;
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(IDGenerator instance) {
		IDGenerator.instance = instance;
	}
	
	public Page getPageById(Integer id) {
		return pageIDs.get(id);
	}

}


