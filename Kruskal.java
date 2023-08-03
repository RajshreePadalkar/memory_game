package com.gurukul.day17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kruskal {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

	    @Override
	    public int compare(Edge o1, Edge o2) {
		// TODO Auto-generated method stub
		return o1.getCost() - o2.getCost();
	    }
	});

	pq.add(new Edge(0, 1, 3));
	pq.add(new Edge(0, 3, 8));
	pq.add(new Edge(1, 2, 3));
	pq.add(new Edge(2, 6, 2));

	pq.add(new Edge(2, 7, 1));
	pq.add(new Edge(7, 6, 7));
	pq.add(new Edge(5, 6, 6));
	pq.add(new Edge(4, 5, 7));

	pq.add(new Edge(3, 4, 3));
	pq.add(new Edge(3, 5, 4));
	pq.add(new Edge(3, 6, 5));
	pq.add(new Edge(7, 5, 2));

	int nodes = 8;
	// Edge edge = new Edge();

	int parent[] = new int[nodes];
	Arrays.fill(parent, -1);

	for (int i = 0; i < nodes - 1;) {

	    Edge edge = pq.poll();
	    int p = edge.getParent();
	    int c = edge.getChild();

	    while (parent[p] != -1) {
		p = parent[p];
	    }
	    while (parent[c] != -1) {
		c = parent[c];
	    }
	    if (p != c) {
		i++;
		parent[c] = p;
		System.out.println(edge);
	    }
	}
    }
}
