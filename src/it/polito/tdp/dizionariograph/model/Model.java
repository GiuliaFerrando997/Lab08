package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	
	private Graph<String, DefaultEdge> grafo;
	private List<String> parole;
	private int lunghezza;

	public void createGraph(int numeroLettere) {
		this.lunghezza=numeroLettere;
		this.grafo = new SimpleGraph<>(DefaultEdge.class);
		
		WordDAO dao = new WordDAO();
		this.parole=dao.getAllWordsFixedLength(numeroLettere);
		Graphs.addAllVertices(this.grafo, this.parole);
		
		for(String s : this.grafo.vertexSet()) {
			List<String> vicini = this.getAdiacenza(s, this.grafo.vertexSet());
			
		}
	}

	private List<String> getAdiacenza(String partenza, Set<String> vertex) {
		List<String> vicini = null;
		int count =0;
		for(String s : vertex) {
			for(int i=0; i<this.lunghezza; i++) {
				if(partenza.charAt(i)!=s.charAt(i))
					count ++;
			}
			if(count==1) {
				vicini.add(s);
			}
		}
		return vicini;
	}

	public List<String> displayNeighbours(String parolaInserita) {

		System.err.println("displayNeighbours -- TODO");
		return new ArrayList<String>();
	}

	public int findMaxDegree() {
		System.err.println("findMaxDegree -- TODO");
		return -1;
	}
}
