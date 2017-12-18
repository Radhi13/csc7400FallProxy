/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 10
 * Students: Ragadeepthi, Manaswitha, Radhika
 * Date: 2017-10-12
 */

package edu.fitchburgstate.csc7400.f2017fall.proxy;
import java.io.PrintWriter;
/**
 * 
 * prints the file names and their content
 *
 */
public class StringifierProxy implements FileStringifier 
{
	/**
     * Create a file StringifierProxy with a file name
     * @param filename file name of file
     */
	public StringifierProxy(String filename) {
		this.fileName = filename;
		slowfilestringifier = new SlowFileStringifier(fileName);
    }
	/**
     * Prints the file names and calls display method in slowfilestringifier class
     * @param out the output print writer
     */
	public void display(PrintWriter out) 
	{
		System.out.println("Reading "+this.fileName);
		if(slowfilestringifier == null)
		{
			new Thread(
					new Runnable() {
		  				public void run() {		  				
		  					out.println(stringify());
		  					out.flush();	
		  				}		  			
		  			}).start();;			  		
		  		}
	      }  
				
	@Override
	public String stringify() {
		return slowfilestringifier.stringify();
		
	}
	
	private String fileName;
	private SlowFileStringifier slowfilestringifier;
}

