package conexion;
import java.util.Hashtable;

public class IDGenerator {
	private static IDGenerator instance = null;
	private Hashtable<Page, Integer> pageIDs; //attributes
	
	//constructor
	public IDGenerator() {
		pageIDs = new Hashtable<> ();
	}
	
	public static synchronized IDGenerator getInstance() {
		if (instance == null) {
			instance = new IDGenerator();
		}
		return instance;
	}
	
	public int makeID()
	{
		return pageIDs.size() + 1;
	}
	
	public int giveID(Page page) {
		if (pageIDs.containsKey(page) == false) {
			int id = makeID();
			pageIDs.put(page,  id);
			page.setPageID(id);
			return id;
		}
		return pageIDs.get(page);
	}
	
	public static void main (String[] args) {
		
	}

	/**
	 * @return the pageIDs
	 */
	public Hashtable<Page, Integer> getPageIDs() {
		return pageIDs;
	}

	/**
	 * @param pageIDs the pageIDs to set
	 */
	public void setPageIDs(Hashtable<Page, Integer> pageIDs) {
		this.pageIDs = pageIDs;
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(IDGenerator instance) {
		IDGenerator.instance = instance;
	}

}


