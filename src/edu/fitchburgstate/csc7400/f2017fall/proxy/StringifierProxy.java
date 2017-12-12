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
public class StringifierProxy implements FileStringifier
{
    /**
         * Initializes object with the passed values
         * @param out
         * @param dir
         */

	public StringifierProxy(PrintWriter out,File dir)
	{
        
        this.outWriter = out;
        this.dir = dir;
    }
    
    /**
     * Prints the file names and calls display method in slowfilestringifier class
     * @param out the output print writer
     */
     
	public void display(PrintWriter out) 
	{
		for (File file: dir.listFiles()) 
		{
            if (file.isDirectory()) 
            	continue;
            this.fileName = file.getPath();
    	System.out.println("Reading "+fileName);
		}
		for (File file: dir.listFiles()) 
		{
            if (file.isDirectory()) 
            	continue;
            this.fileName = file.getPath();
    	slowfilestringifier = new SlowFileStringifier(fileName);
    	slowfilestringifier.display(outWriter);
        }
	}
	public String stringify()
	{
		return "";
	}
	
	private String fileName;
	private final File dir;
    
	PrintWriter outWriter = new PrintWriter(System.out);
	SlowFileStringifier slowfilestringifier;
}
