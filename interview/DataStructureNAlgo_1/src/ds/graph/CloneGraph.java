package ds.graph;

// https://leetcode.com/problems/clone-graph/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    List<Node> neighbors;

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class CloneGraph {

    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGph(Node node) {
        Node newNode = visited.get(node);

        if (newNode == null) {
            newNode = new Node(node.val, new ArrayList<>());
            visited.put(node, newNode);

            for (Node neighbor: node.neighbors) {
                Node newNeighbor = cloneGph(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return newNode;
    }
}