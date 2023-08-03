package com.gurukul.day17;

import java.util.Arrays;

public class TopologicalProblem {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	int[][] mat = { { 0, 1, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 1, 1 },
		{ 1, 0, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0 } };
	System.out.println(topologicalSort(mat));
    }

    public static String topologicalSort(int mat[][]) {
	String ans = "";

	boolean[] visited = new boolean[mat.length];

	Arrays.fill(visited, false);
	int count = 0;

	while (count < mat.length) {
	    boolean isLoop = true;
	    for (int i = 0; i < mat.length; i++) {
		boolean flag = true;
		for (int j = 0; j < mat.length; j++) {
		    if (mat[j][i] == 1 && !visited[j]) {
			flag = false;
			break;
		    }
		}
		if (flag && !visited[i]) {
		    isLoop = false;
		    ans += (char) (i + 65);
		    visited[i] = true;
		    count++;
		    for (int k = 0; k < mat.length; k++) {
			mat[i][k] = 0;
		    }
		    break;
		}
	    }
	    if (isLoop)
		return "There is loop";
	}
	return ans;
    }

}
