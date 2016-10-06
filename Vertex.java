/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

/**
 *
 * @author Akatsuki
 */
public class Vertex {

     public int value;
     public int id;
     public boolean wasVisited;

    public Vertex(int id,int value) {
        this.id=id;
        this.value = value;
    }
       public Vertex(int value) {
        this.value = value;
    }

    public void setVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
     
     
}
