package com.rashmi.queue;

public interface Queue<T> {
	
	    public Queue<T> enQueue(T t); // add element at the back of the queue and return the new queue

	    public Queue<T> deQueue() throws Exception; // remove element at the front of the queue and return the new queue

	    public T head() throws Exception; // get element at the front of the queue

	    public boolean isEmpty(); // check if queue is empty
	
}
