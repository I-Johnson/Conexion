package Views;

import java.util.ArrayList;

import conexion.Person;
import conexion.RestMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.ViewTransitionalModel;

public class AllPersonsViewController {
	ViewTransitionalModel vm;
	public void setModel(ViewTransitionalModel vm) {
		this.vm = vm;
		RestMain client = RestMain.getInstance();
		ObservableList<Person> observablePerson = FXCollections.observableList(client.getAllPersons());
		allPersonsList.setItems(observablePerson);
	}
    @FXML
    private ListView<Person> allPersonsList;
    
	@FXML 
	private Button myPersonsButton;
	

	@FXML
	void onClickShowOnlyMyPersons(ActionEvent event) {
		if(vm.getLoggedIn() != null) {
			ArrayList<Person> myPersons = new ArrayList<Person> ();
			for (Person person: allPersonsList.getItems()) {
				if (vm.getLoggedIn().getPersons().contains(person.getPageID())) {
					myPersons.add(person);
				}
			}
			ObservableList<Person> myObservablePerson = FXCollections.observableList(myPersons);
			allPersonsList.setItems(myObservablePerson);
		}
	}
}
