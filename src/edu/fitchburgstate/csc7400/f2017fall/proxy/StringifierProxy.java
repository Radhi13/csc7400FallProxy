/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 10
 * Students: Ragadeepthi, Manaswitha, Radhika
 * Date: 2017-10-12
 */

package edu.fitchburgstate.csc7400.f2017fall.proxy;
import java.io.*;
/**
 * 
 * prints the file names and their content
 *
 */
public class StringifierProxy extends Thread
{
	private String filename;
	private SlowFileStringifier slowfilestringifier;
	
	/**
     * Create a file stringifier with a file name
     * @param filename file name of file
     */
	
	public StringifierProxy(String filename) {
        this.filename = filename;
    }
    
    /**
     * Prints the file names and calls display method in slowfilestringifier class
     * @param out the output print writer
     */
     
	public void display(PrintWriter out) {
    	System.out.println("Reading "+this.filename);
		slowfilestringifier = new SlowFileStringifier(filename); 
	 }
	/**
	 *Thread for SlowStringifier display method
 	 */
	
	PrintWriter outWriter = new PrintWriter(System.out);
	public void run() {
		slowfilestringifier.display(outWriter);
		}
}
