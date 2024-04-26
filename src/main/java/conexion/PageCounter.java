package conexion;

public class PageCounter {
	
	Integer pageCount;

	public PageCounter() {
		super();
		this.pageCount = 0;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public void increment() {
		pageCount += 1;
	}
	public void decrement() {
		pageCount -= 1;
	}
	
}
