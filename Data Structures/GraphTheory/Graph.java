/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

    /**
    *
    * @author Akatsuki
    */
public class Graph {

    int MAX_VERTS = 20;
    Vertex vertexList[];
    int adjMatrix[][];
    int nVertices;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVertices = 0;
    }

    public void addVertex(int value){
        vertexList[nVertices]=new Vertex(nVertices,value);//gives ID on its own implicitly
        nVertices++;
    }
    
    public void addEdge(int startId , int endId){
        adjMatrix[startId][endId]=1;
        adjMatrix[endId][startId]=1; 
    }
    
    public int getAdjUnvisitedVertex(int vId){     
        for(int j=0;j<nVertices;j++)
            if(adjMatrix[vId][j]==1 && vertexList[j].wasVisited==false)return j;    
        //Univisited vertex must have an edge to given vertex and it should have not been visited
        return -1;
    }
    
    public void dfs(int id){//start dfs from Id 
        Stack<Integer> stack = new Stack<>();
        //stack will contain Id of each vertex, 
        vertexList[id].wasVisited=true;
        System.out.println(vertexList[id].value);
        stack.push(id);
        while(!stack.isEmpty()){
            int vId = getAdjUnvisitedVertex(stack.peek());
            if(vId==-1)stack.pop();
            else{
                vertexList[vId].wasVisited=true;
                 System.out.println(vertexList[vId].value);
                 stack.push(vId);            
            }      
    }
           
            for(int j=0;j<nVertices;j++)vertexList[j].wasVisited=false;         
       
    }
    
    public  void bfs(int id){
        Queue<Integer> queue =new LinkedList();
        vertexList[id].wasVisited=true;
        System.out.println(vertexList[id].value);
        queue.add(id);
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
              System.out.println(v1);
            while((v2=getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited=true;
                queue.add(v2);
                        }
        }
        for(int j=0;j<nVertices;j++)vertexList[j].wasVisited=false;         
    }
}