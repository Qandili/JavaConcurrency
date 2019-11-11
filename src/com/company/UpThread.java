package com.company;

public class UpThread implements Runnable {
    MyGraph myGraph;

    public UpThread(MyGraph myGraph) {
        this.myGraph = myGraph;
        Thread thread=new Thread(this,"Move UP");
        thread.start();
    }
    @Override
    public void run() {
        while (true){
            try {
                myGraph.moveUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
