package com.gurukul.day17;

import java.util.Arrays;

public class ShortestPath {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	int mat[][] = {
		{ Integer.MAX_VALUE, 4, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
			Integer.MAX_VALUE }, // A
		{ 4, Integer.MAX_VALUE, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
			Integer.MAX_VALUE }, // B
		{ Integer.MAX_VALUE, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2,
			1 }, // C
		{ 8, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 4, 5, Integer.MAX_VALUE }, // D
		{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, Integer.MAX_VALUE, 9, Integer.MAX_VALUE,
			Integer.MAX_VALUE }, // E
		{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 9, Integer.MAX_VALUE, 6, 2 }, // F
		{ Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 5, Integer.MAX_VALUE, 6, Integer.MAX_VALUE, 7 }, // G
		{ Integer.MAX_VALUE, Integer.MAX_VALUE, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 7,
			Integer.MAX_VALUE } // H
	};

	System.out.println("minimum cost: " + prims(mat));

    }

    public static int prims(int mat[][]) {
	int ans = 0;
	int distanceArr[] = new int[mat.length];
	int parent[] = new int[mat.length];
	Arrays.fill(parent, -1);

	Arrays.fill(distanceArr, Integer.MAX_VALUE);
	distanceArr[0] = 0;
	boolean[] visited = new boolean[mat.length];
	int s = 0, mincost = 0;
	visited[s] = true;
//   		ans += (char) (s + 65) + " ";
	int count = 0;
	int min = Integer.MAX_VALUE;
	int minIndex = 0;
	while (count < mat.length) {
	    for (int i = 0; i < mat.length; i++) {
		if (!visited[i]) {
		    if (mat[s][i] < distanceArr[i]) {
			distanceArr[i] = mat[s][i];
			parent[i] = s;

//   				ans += (char) (i + 65) + " ";
		    }
		}
	    }
	    for (int i = 0; i < mat.length; i++) {
		if (!visited[i] && (distanceArr[i] < min)) {
		    min = distanceArr[i];
		    minIndex = i;
		    mincost += min;
		}
	    }

	    // min = Integer.MAX_VALUE;
	    visited[minIndex] = true;
	    s = minIndex;
	    count++;
	}
	for (int i = 1; i < parent.length; i++) {
	    System.out.println(((char) (parent[i] + 65)) + " " + (char) (i + 65));
	    //mincost += distanceArr[i];
	}
	return mincost;
    }

}
