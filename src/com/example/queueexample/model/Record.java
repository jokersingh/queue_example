/**
 * 
 */
package com.example.queueexample.model;

/**
 * @author jokersingh
 *
 */
public class Record {

	private String record;
	private boolean isQueueEmpty;

	public Record(String record) {
		this.record = record;
	}

	/**
	 * 
	 * @return
	 */
	public String getRecord() {
		return record;
	}

	/**
	 * @return the isQueueEmpty
	 */
	public boolean isQueueEmpty() {
		return isQueueEmpty;
	}

	/**
	 * @param isQueueEmpty the isQueueEmpty to set
	 */
	public void setQueueEmpty(boolean isQueueEmpty) {
		this.isQueueEmpty = isQueueEmpty;
	}
	
	

}
