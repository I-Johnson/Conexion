package Views;

import java.util.ArrayList;

import conexion.Post;
import conexion.RestMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import models.ItemPostCell;
import models.Text;
import models.ViewTransitionalModel;

public class AllPostsViewController
{
	ViewTransitionalModel vm;
	ListPost listPost;
	Post post;
	Text info;
	
	public Text getInfo() {
		return info;
	}



	public void setInfo(Text info) {
		this.info = info;
	}
	
	public Post getPost() {
		return post;
	}



	public void setPost(Post post) {
		this.post = post;
	}
	
	public void setPostName() {
		postTitle.textProperty().bind(this.info.getPostName());
		this.info.getPostName().set(post.getPostTitle());
	}
	
	public void setPostDescriptionName() {
		postDescriptionLabel.textProperty().bind(this.info.getPostDescription());
		this.info.getPostDescription().set(post.getPostBody());
	}
	
	public void setEditInfo() {
		postNameTextField.textProperty().set(post.getPostTitle());
		postDescriptionTextField.textProperty().set(post.getPostBody());
	}
	
	public void setPostViewModel(ViewTransitionalModel vm) {
		this.vm = vm;

		
	}
    

	@FXML
    private ListView<Post> allPostsList;
	
	@FXML 
	private Button myPostsButton;
	
	@FXML
	void onClickShowOnlyMyPosts(ActionEvent event) {
		if(vm.getLoggedIn() != null) {
			ArrayList<Post> myPosts = new ArrayList<Post> ();
			for (Post post: allPostsList.getItems()) {
				if (vm.getLoggedIn().getPosts().contains(post.getPageID())) {
					myPosts.add(post);
				}
			}
			ObservableList<Post> myObservablePosts = FXCollections.observableList(myPosts);
			allPostsList.setItems(myObservablePosts);
		}
	}
	
    @FXML
    private Label postDescriptionLabel;

    @FXML
    private Button postEditButton;

    @FXML
    private Label postTitle;

    @FXML
    void onClickEditPostPage(ActionEvent event) {
//    	String user = loggedIn.getPageID();
//    	if (job.has_permission(loggedIn)) {
//    		vm.showEditJob(job.getPageID());
//    	}
//    	if (job.getEditors().contains(user)) {
//            vm.showEditJob(job.getPageID());
//        }
//    	System.out.print("print" + user);
    	vm.showEditPost(post.getPageID());
    	
    }
	
	public void showPostItem(Post item) {
		vm.showSinglePost(item.getPageID());
	}
	
	private final AllPostsViewController itemShower;
	
    public AllPostsViewController()
    {
    	itemShower=this;
//    	loggedIn = null;
    }
    
    public void setPostModel(ListPost model)
    {
    	this.listPost = model;
    	
    	allPostsList.setCellFactory(new Callback<ListView<Post>, ListCell<Post>>()
		  {

			@Override
			public ListCell<Post> call(ListView<Post> lv)
			{
				return new ItemPostCell(lv,itemShower);
			}
		  });
    	
    	allPostsList.setItems(model.getItems());
    	
    	
    }
    
    //EditPost
    @FXML
    private TextArea postDescriptionTextField;

    @FXML
    private Button postEditSave;

    @FXML
    private TextField postNameTextField;

    @FXML
    void onClickPostEditSave(ActionEvent event) {
//    	setEditInfo();
    	String postName = postNameTextField.textProperty().get();
    	String jobDescription = postDescriptionTextField.textProperty().get();
    	
    	post.setPostTitle(postName);
    	post.setPostBody(jobDescription);
    	RestMain client = RestMain.getInstance();
    	client.updatePage(post);
    	vm.showSinglePost(post.getPageID());
    	
    }
	
}