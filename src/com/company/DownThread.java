package com.company;

public class DownThread implements Runnable {
    MyGraph myGraph;

    public DownThread(MyGraph myGraph) {
        this.myGraph = myGraph;
        Thread thread=new Thread(this,"Move Down");
        thread.start();
    }
    @Override
    public void run() {
        while (true){
            try {
                myGraph.moveDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
