package chapter4;

import java.util.ArrayList;

class Graph {
    public ArrayList<Node> nodes = new ArrayList<>();
    public Node createNode(String name) {
        Node node = new Node();
        node.name = name;
        this.nodes.add(node);
        return node;
    }
}

class Node {
    public String name;
    public ArrayList<Node> children = new ArrayList<>();
    public Boolean visited = false;
}

class Scratch {
    private static Boolean search(Node root, Node end) {
        if (root.visited) {
            return false;
        } else if (root.name.equals(end.name)) {
            return true;
        }
        root.visited = true;
        for (int i = 0; i < root.children.size(); i++) {
            Boolean search = search(root.children.get(i), end);
            if (search) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node node0 = graph.createNode("0");
        Node node1 = graph.createNode("1");
        Node node2 = graph.createNode("2");
        Node node3 = graph.createNode("3");
        Node node4 = graph.createNode("4");
        Node node5 = graph.createNode("5");

        node0.children.add(node5);
        node0.children.add(node4);
        node0.children.add(node1);
        node1.children.add(node4);
        node1.children.add(node3);
        node2.children.add(node1);
        node3.children.add(node4);
        node3.children.add(node2);

        System.out.println(search(node0, node3));
    }
}
