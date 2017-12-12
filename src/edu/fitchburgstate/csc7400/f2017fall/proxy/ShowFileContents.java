/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 10
 * 
 * Date: 2017-11-28
 */
package edu.fitchburgstate.csc7400.f2017fall.proxy;

import java.io.File;
import java.io.PrintWriter;

/**
 * Show the contents of all the files in a specific directory
 */
public class ShowFileContents {

    /**
     * Accepts a file directory and then prints out the contents of
     * all the files in that directory
     * @param args single arg with directory path
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ShowFileContents <directory>");
        }
        String dirname = args[0];

        File dir = new File(dirname);
        if (!dir.exists()) {
            System.err.println(dirname + " does not exist");
            return;
        }
        if (!dir.isDirectory()) {
            System.err.println(dirname + " is not a directory");
            return;
        }

        PrintWriter outWriter = new PrintWriter(System.out);
        FileStringifier fd = new StringifierProxy(outWriter, dir);
        fd.display(outWriter);
    }

}
