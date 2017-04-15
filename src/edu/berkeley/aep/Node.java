package edu.berkeley.aep;
import java.util.*;

public class Node {
    String name;
    int costFromParent;
    Collection<Node> connectedNodes = new ArrayList<>();

    public Node (String name){
        this.name = name;
        this.costFromParent = 0;
    }

    public void connect (Node destination, int cost){
        if (!this.name.equals(destination.name)) {
            destination.costFromParent = cost;
            this.connectedNodes.add(destination);
        }
    }
    public boolean isConnected(Node destination){
        return countHops(destination) >= 0;
    }

    public int countHops(Node destination){ //Initial Question
        return countHops(destination, new ArrayList<>());
    }

    private int countHops(Node destination, Collection<Node> visited){ //Recursive Question
        if (destination.equals(this)) return 0;
        if (visited.contains(this)) return -1;
        visited.add(this);
        int min = Integer.MAX_VALUE;
        for (Node eachNode:this.connectedNodes) {
            int hopCount = eachNode.countHops(destination, visited);
            if ( hopCount != -1 && hopCount < min) {
                min = hopCount + 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int getMinCostTo(Node destination) {
        if (destination.equals(this)) return 0;
        return getMinCostTo(destination, new ArrayList<>());
    }

    private int getMinCostTo(Node destination, Collection<Node> visited){ //Recursive Question
        if (destination.equals(this)) return this.costFromParent;
        if (visited.contains(this)) return -1;
        visited.add(this);
        int min = Integer.MAX_VALUE;
        for (Node eachNode:this.connectedNodes) {
            int cost = eachNode.getMinCostTo(destination, visited);
            if ( cost != -1 && cost < min) {
                min = cost + this.costFromParent;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}