package conexion;

import org.springframework.web.client.RestClientException;

public class SendInterest extends HighlightMethod {

    @Override
    public void sendInterest(Job job) {
//        System.out.println("Interest sent to " + job.getPostTitle() + " without attachments.");
        Page page;
		RestMain client = RestMain.getInstance(); 
		IDGenerator idGenerator = IDGenerator.getInstance();
		
		int numberOfPages = idGenerator.getNumberOfPages();
		
		Job interestedJob = null;
		for(int i = 1; i<=numberOfPages; i++) {
			try {
				page = client.getJob("Job/" + ((Integer)i).toString()).data();
				interestedJob = (Job)page;
			} catch (RestClientException e){
			System.out.print("");
		}
		}
		interestedJob.addInterest(job.getPageID());
		client.updatePage(interestedJob);
    }

}
