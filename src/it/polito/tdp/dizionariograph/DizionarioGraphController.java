package it.polito.tdp.dizionariograph;

import it.polito.tdp.dizionariograph.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	
	private Model model;

	public void setModel(Model model) {
		this.model=model;
		
	}
	
	 @FXML
	    private TextField txtLettere;

	    @FXML
	    private TextField txtParola;

	    @FXML
	    private Button btnGeneraGrafo;

	    @FXML
	    private Button btnVicini;

	    @FXML
	    private Button btnGrado;

	    @FXML
	    private TextArea txtResult;

	    @FXML
	    private Button btnReset;

	    @FXML
	    void doCercaGradoMAX(ActionEvent event) {

	    }

	    @FXML
	    void doCercaVicini(ActionEvent event) {

	    }

	    @FXML
	    void doGrafo(ActionEvent event) {

	    }

	    @FXML
	    void doReset(ActionEvent event) {

	    }
	    
	    @FXML
	    void initialize() {
	        assert txtLettere != null : "fx:id=\"txtLettere\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert btnGeneraGrafo != null : "fx:id=\"btnGeneraGrafo\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert btnVicini != null : "fx:id=\"btnVicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert btnGrado != null : "fx:id=\"btnGrado\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

	    }

	
}
