package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
			List<String> vicini = new ArrayList<>();
			vicini=this.getAdiacenza(s, this.grafo.vertexSet());
				for(String v : vicini) {
					this.grafo.addEdge(s, v);
				}
		}
	}

	private List<String> getAdiacenza(String partenza, Set<String> vertex) {
		List<String> vicini = new ArrayList<>();
		for(String s : vertex) {
			int count =0;
			for(int i=0; i<this.lunghezza && count<2; i++) {
				if(partenza.charAt(i)!=s.charAt(i))
					count ++;
			}
			if(count==1) {
				vicini.add(s);
			}
		}
		return vicini;
	}

	public Set<DefaultEdge> displayNeighbours(String parolaInserita) {
		return this.grafo.edgesOf(parolaInserita);
	}

	public String findMaxDegree() {
		int max =0;
		String parola = null;
		for(String s : this.grafo.vertexSet()) {
			if(this.grafo.degreeOf(s)>max) {
				max=this.grafo.edgesOf(s).size();
				parola=s;
			}
		}
		return max+" "+parola;
	}
}
