package it.polito.tdp.dizionariograph;

import it.polito.tdp.dizionariograph.model.Model;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;

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
	    	int max = Integer.parseInt(model.findMaxDegree().split(" ")[0]);
	    	String parola = model.findMaxDegree().split(" ")[1];
	    	Set<DefaultEdge> vicini = model.displayNeighbours(parola);
	    	this.txtResult.setText("Il grado massimo e': "+max+"\n"
	    			+ "la parola e': "+parola+ "\n"
	    					+ "le parole vicine sono: "+vicini);
	    }

	    @FXML
	    void doCercaVicini(ActionEvent event) {
	    	String parolaInserita = this.txtParola.getText();
	    	System.out.println(parolaInserita+"!!!");
	    	if(parolaInserita!=null && parolaInserita.length()!=0) {
	    		try {
			    	Set<DefaultEdge> vicini = model.displayNeighbours(parolaInserita);
			    	this.txtResult.setText("Neighbours di "+parolaInserita+": " + vicini + "\n");
		    		} catch(NumberFormatException e) {
			    		txtResult.setText("Inserire una numero di lettere valido");
			    	} catch(RuntimeException e ) {
			    		txtResult.setText("Errore di connessione al database!");
			    	}
	    	}
	    	else txtResult.setText("Inserire una parola");
	    	
	    }

	    @FXML
	    void doGrafo(ActionEvent event) {
	    	try {
		    	int lunghezza = Integer.parseInt(this.txtLettere.getText());
		    	model.createGraph(lunghezza);
		    	this.btnVicini.setDisable(false);
		    	this.btnGrado.setDisable(false);
		    	} catch(NumberFormatException e) {
		    		txtResult.setText("Inserire una numero di lettere valido");
		    	} catch(RuntimeException e ) {
		    		txtResult.setText("Errore di connessione al database!");
		    	}
	    }

	    @FXML
	    void doReset(ActionEvent event) {
	    	this.txtLettere.clear();
	    	this.txtParola.clear();
	    	this.txtResult.clear();
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
