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
public class DataProcessor implements Runnable{

	private BlockingQueue<Record> queue;
	private BlockingQueue<ProcessedRecord> procressedRecordQueue;
    public DataProcessor(BlockingQueue<Record> q, BlockingQueue<ProcessedRecord> procressedRecordQueue){
        this.queue=q;
        this.procressedRecordQueue = procressedRecordQueue;
    }

    @Override
    public void run() {
        try{
        	Record record;
        	int i = 0;
            //consuming messages until exit message is received
            while(!(record = queue.take()).isQueueEmpty()){
            Thread.sleep(10);
            System.out.println("processing "+record.getRecord());
            ProcessedRecord processedRecord = new ProcessedRecord();
            processedRecord.setRecord("Processed Record-" + i+1);
            procressedRecordQueue.put(processedRecord);
            }
            ProcessedRecord processedRecord = new ProcessedRecord();
            processedRecord.setQueueEmpty(true);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}