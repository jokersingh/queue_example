/**
 * 
 */
package com.example.queueexample.worker;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.example.queueexample.model.Record;
import com.example.queueexample.model.Task;

/**
 * @author jokersingh
 *
 */
public class DataReader implements Runnable {

    private BlockingQueue<Record> queue;
    private List<Task> tasks;
    public DataReader(BlockingQueue<Record> q, List<Task> tasks){
        this.queue=q;
        this.tasks = tasks;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<100; i++){
        	Record record = new Record(""+i);
            try {
                Thread.sleep(i);
                queue.put(record);
                System.out.println("Produced "+record.getRecord());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Record record = new Record("exit");
        record.setQueueEmpty(true);
        try {
            queue.put(record);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}