package conexion;

public abstract class HighlightMethod {
	
	public String attachments;
	
	public abstract void sendInterest(Job job);
	
    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }
}
