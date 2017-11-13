/* FILENAME: BoundedQueue.java
 * WHO: Julia McDonald, Xinhui Xu
 * WHAT: Assignment 7 Task 2
 * WHEN: Fall 2017 */
import javafoundations.*;

public class BoundedQueue<T> extends javafoundations.CircularArrayQueue<T>{
    private int capacity;
    
    public BoundedQueue(int cap){
	super(); //super DEF_CAP is 10, assumes cap >=10
	capacity = cap;
    }

    /*Returns true if the size of the queue is equal to capacity
      @return - if the size of the queue is equal to capacity*/
    public boolean isFull(){
	return size() == capacity;
    }

    /*Enques the new element if queue is not at capacity
      @param element - the new element*/
    public void enqueue(T element){
	if (!isFull()){
	    super.enqueue(element);
	} else {
	    System.out.println("Queue is full.");
 }
    }

    /*Return capacity + inherited toString
      @return - the string representation of BoundedQueue*/
    public String toString(){
	return "Capacity: " + capacity + "\n" + super.toString();
    }
    
    public int getCapacity(){
      return capacity;
    }
    
    public static void main(String[] args){
	BoundedQueue<Double> b = new BoundedQueue<Double>(10);
	b.enqueue(0.5);
	b.enqueue(0.1);
	b.enqueue(0.1);
	b.enqueue(0.1);
	b.enqueue(0.1);
	b.enqueue(0.1);
	b.enqueue(0.1);
	b.enqueue(0.1);
	b.enqueue(0.1);
	b.enqueue(0.1);
	b.enqueue(0.1); //should print queue is full once

	System.out.println(b);
    }
}
