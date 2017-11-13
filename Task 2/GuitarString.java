import java.util.*;
/**
 * 
 */
public class GuitarString {
  
  public double frequency;
  public int n;
  public BoundedQueue<Double> vibration;
  public final double SAMPLING_RATE = 44100;
  public final double ENERGY_DECAY = 0.994;
    
  /**
   * 
   */
  public GuitarString( double frequency ) {
    this.frequency = frequency;
    n = (int)(Math.ceil( SAMPLING_RATE / frequency ));
    vibration = new BoundedQueue<Double>(n); //add all zeroes
    for( int i = 0; i < vibration.getCapacity(); i++ ) {
      vibration.enqueue( 0.0 );
    }
  }
  
  /**
   * 
   */
  public void pluck() {
    Random rand = new Random();
    
    while( !vibration.isEmpty() ){
      vibration.dequeue();
    }
    
    for( int i = 0; i < vibration.getCapacity(); i++ ){
      vibration.enqueue( rand.nextDouble() - 0.5 );
    }
    
  }
  
  /**
   * 
   */
  public double sample() {
    return vibration.first();
  }
  
  /**
   * applies the Karplus-Strong algorithm, i.e., it deletes the sample at the 
   * front of the bounded queue and adds to the end of the bounded queue the average 
   * of the deleted sample and the sample at the front of the bounded queue, multiplied 
   * by the energy decay factor of 0.994.
   */
  public void tic() {
    vibration.enqueue((vibration.dequeue() + sample() ) * ENERGY_DECAY);
    System.out.println( "ticed" );
  }
  
  public static void main( String[] args ){
    GuitarString g = new GuitarString(440);
    g.pluck();
    System.out.println(g.vibration);
    g.tic();
    System.out.println(g.vibration);
  }
}