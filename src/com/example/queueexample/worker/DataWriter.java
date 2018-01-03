/**
 * 
 */
package com.example.queueexample.worker;

import java.util.concurrent.BlockingQueue;

import com.example.queueexample.model.ProcessedRecord;
import com.example.queueexample.model.Record;

/**
 * @author jokersingh
 *
 */
public class DataWriter implements Runnable{

private BlockingQueue<ProcessedRecord> queue;
    
    public DataWriter(BlockingQueue<ProcessedRecord> procressedRecordQueue){
        this.queue=procressedRecordQueue;
    }

    @Override
    public void run() {
        try{
        	ProcessedRecord record;
            //consuming messages until exit message is received
            while(!(record = queue.take()).isQueueEmpty()){
            Thread.sleep(10);
            System.out.println("Consumed "+record.getRecord());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

