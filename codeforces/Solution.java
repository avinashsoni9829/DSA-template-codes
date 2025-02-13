package com.example.test.graph.codeforces;


import java.util.*;

public class Solution {
    static Scanner scanner = new Scanner(System.in);


    public static class DSU {
        int [] parent , rank;

        public DSU(int n){
            parent = new int[n];
            rank = new  int[n];
            for(int i = 0 ; i < n ; ++i){
                parent[i] = i;
                rank[i] = 0;
            }

        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x , int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX!=rootY){
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                }
                else  if (rank[rootX]  < rank[rootY]){
                    parent[rootX] = rootY;
                }
                else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }

            }
        }

        public int findCC(){
            int count = 0;
            for(int i = 0 ; i < parent.length ; ++i){
                if(parent[i] == i){
                    count = count + 1;
                }
            }
            return count;
        }



    }

    private static int heightOfGraph(int node, Map<Integer, List<Integer>>graph){
        if (!graph.containsKey(node)) return 1;
        int maxDepth = 0;
        for (int subordinate : graph.get(node)) {
            maxDepth = Math.max(maxDepth, heightOfGraph(subordinate, graph));
        }

        return maxDepth + 1;
    }

    public static void main(String[] args) {

    }




}
