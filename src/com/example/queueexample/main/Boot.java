/**
 * 
 */
package com.example.queueexample.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.example.queueexample.model.ProcessedRecord;
import com.example.queueexample.model.Record;
import com.example.queueexample.model.Task;
import com.example.queueexample.worker.DataProcessor;
import com.example.queueexample.worker.DataReader;
import com.example.queueexample.worker.DataWriter;

/**
 * @author jokersingh
 *
 */
public class Boot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Creating BlockingQueue of size 10
		
        BlockingQueue<Record> queue = new ArrayBlockingQueue<>(10);
        BlockingQueue<ProcessedRecord> procressedRecordQueue = new ArrayBlockingQueue<>(10);
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("task 1"));
		DataReader producer = new DataReader(queue,tasks);
		DataProcessor processor = new DataProcessor(queue, procressedRecordQueue);
        DataWriter consumer = new DataWriter(procressedRecordQueue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        
        new Thread(processor).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");

	}

}
