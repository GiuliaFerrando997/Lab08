package it.polito.tdp.dizionariograph.model;

import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.createGraph(4);
		System.out.println(String.format("**Grafo creato**\n"));
		
		Set<DefaultEdge> vicini = model.displayNeighbours("casa");
		System.out.println("Neighbours di casa: " + vicini + "\n");
		
		System.out.println("Cerco il vertice con grado massimo...");
		System.out.println(model.findMaxDegree()+model.displayNeighbours("care"));
	}

}
