package com.interview.graph;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
http://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
 For a general weighted graph,we can calculate single source shortest distances in O(VE) time using Bellman–Ford Algorithm.
 For a graph with no negative weights, we can do better and calculate single source shortest distances in O(E + VLogV) time using Dijkstra’s algorithm.

 Can we do even better for Directed Acyclic Graph (DAG)? We can calculate single source shortest distances in O(V+E) time for DAGs.
 The idea is to use Topological Sorting.
 */
public class _15_B_DAGShortestPathTopological<T> {

    public Map<Vertex<T>,Integer> shortestPath(_1_Graph<T> graph, Vertex<T> startVertex){
        
        Map<Vertex<T>,Integer> distance = new HashMap<Vertex<T>,Integer>();
        _15_A_TopologicalSort<T> sort = new _15_A_TopologicalSort<T>();
        Deque<Vertex<T>> deque = sort.topSort(graph);
        distance.put(startVertex, 0);
        while(!deque.isEmpty()){
            Vertex<T> vertex = deque.poll();
            for(Edge<T> edge : vertex.getEdges()){
                if(getDistance(edge.getVertex2(),distance) > getDistance(edge.getVertex1(),distance) + edge.getWeight()){
                    distance.put(edge.getVertex2(), getDistance(edge.getVertex1(),distance) + edge.getWeight());
                }
            }
        }
        
        return distance;
    }
    
    private int getDistance( Vertex<T> vertex,Map<Vertex<T>,Integer> distance){
        return distance.containsKey(vertex) ? distance.get(vertex) : 1000;
    }
    
    public static void main(String args[]){
        _1_Graph<Integer> graph = new _1_Graph<Integer>(true);
        graph.addEdge(1, 2,4);
        graph.addEdge(2, 3,3);
        graph.addEdge(2, 4,2);
        graph.addEdge(1, 3,2);
        graph.addEdge(3, 5,1);
        graph.addEdge(4, 5,5);
        graph.addEdge(5, 6,2);
        graph.addEdge(4, 7,3);

        _15_B_DAGShortestPathTopological<Integer> shortestPath = new _15_B_DAGShortestPathTopological<Integer>();
        Map<Vertex<Integer>,Integer> distance = shortestPath.shortestPath(graph, graph.getAllVertex().iterator().next());
        System.out.print(distance);
        
    }
}
