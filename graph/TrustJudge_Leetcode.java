package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrustJudge_Leetcode {

	public static void main(String[] args) {

		System.out.println(findJudge(2, new int[][] { { 1, 2 }, { 2, 3 } }));

	}

	public static int findJudge(int n, int[][] trust) {

		int[][] res = new int[2][n + 1];

		for (int i = 0; i < trust.length; i++) {
			int t = trust[i][0];
			int j = trust[i][1];
			res[0][t]++;
			res[1][j]++;
		}

		for (int i = 1; i <= n; i++) {
			if (res[0][i] == 0 && res[1][i] == n - 1) {
				return i;
			}
		}

		return -1;

	}
}
