package com.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/bridge-in-a-graph/
 * https://www.youtube.com/watch?v=thLQYBlz2DM
 *
 * <p>
 * An edge in an undirected connected graph is a bridge iff removing it disconnects the graph. For a disconnected undirected graph, definition is similar,
 * a bridge is an edge removing which increases number of disconnected components.
 * Like Articulation Points, bridges represent vulnerabilities in a connected network and are useful for designing reliable networks.
 * For example, in a wired computer network, an articulation point indicates the critical computers and a bridge indicates the critical wires or connections.
 */
public class _9_Bridge<T> {

    private int time;

    public Set<Edge<T>> getBridge(_1_Graph<T> graph) {

        Set<Edge<T>> result = new HashSet<Edge<T>>();
        Map<Vertex<T>, Integer> discovery = new HashMap<Vertex<T>, Integer>();
        Map<Vertex<T>, Integer> low = new HashMap<Vertex<T>, Integer>();
        Map<Vertex<T>, Vertex<T>> parent = new HashMap<Vertex<T>, Vertex<T>>();
        Map<Vertex<T>, Boolean> visited = new HashMap<Vertex<T>, Boolean>();

        for (Vertex<T> vertex : graph.getAllVertex()) {
            if (!visited.containsKey(vertex)) {
                BridgeUtil(vertex, result, discovery, low, parent, visited);
            }
        }
        return result;
    }

    private void BridgeUtil(Vertex<T> vertex, Set<Edge<T>> result, Map<Vertex<T>, Integer> discovery,
                            Map<Vertex<T>, Integer> low, Map<Vertex<T>, Vertex<T>> parent, Map<Vertex<T>, Boolean> visited) {
        // p->c
        // if child is not  visited then check if d(p)<l(c) then there is an edge
        // if vertex is not visited and child is not parent of vertex then l(p)= min (d(p),l(c) )
        /*

          a-->b
          |  /
          c----D
               |
               E

          output -> DE,CD
         */

        visited.put(vertex, true);
        discovery.put(vertex, time);
        low.put(vertex, time);
        time++;
        for (Vertex<T> child : vertex.getAdjacentVertexes()) {
            if (!visited.containsKey(child)) {
                parent.put(child, vertex);
                BridgeUtil(child, result, discovery, low, parent, visited);

                if (discovery.get(vertex) < low.get(child)) {
                    result.add(new Edge<T>(vertex, child));
                }
                low.put(vertex, Math.min(discovery.get(vertex), low.get(child)));
            } else {
                if (!child.equals(parent.get(vertex))) {
                    low.put(vertex, Math.min(discovery.get(vertex), low.get(child)));
                }
            }
        }
    }

    public static void main(String args[]) {

        _1_Graph<Integer> graph = new _1_Graph<Integer>(false);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        _9_Bridge<Integer> ap = new _9_Bridge<Integer>();
        Set<Edge<Integer>> result = ap.getBridge(graph);
        System.out.print(result);
    }

}
