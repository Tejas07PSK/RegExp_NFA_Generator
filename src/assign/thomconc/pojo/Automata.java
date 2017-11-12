/*  -> Simple Swing Automata Application.
 *  -> Future Updates -- Android Port (Expected).
 *  -> Project Type -- Self/Educational.
 *  -> Institute -- University Institute Of Technology, Burdwan University.
 *  -> Owner/Code file Designer :
 *             @ Name - Palash Sarkar.
 *             @ Department - Computer Science And Engineering.
 *             @ Roll.Number - 2014_1038.
 *             @ Email - palashsarkar0007@gmail.com.
 *  -> Copyright Norms - Every piece of code given below 
 *                       has been written by 'Palash Sarkar (Tj07)'©,
 *                       and he holds the rights to the file. Not meant to be
 *                       copied or tampered without prior permission
 *                       from the author.             
 */

package assign.thomconc.pojo;

import java.io.Serializable;

public class Automata implements Serializable
{
	 private static final long serialVersionUID = 1L;
	 
	 private String start;
     private String end;
     private String weight;
     
     public Automata()
     {
    	 start="";
    	 end="";
    	 weight="";
     }

	public String getStart() 
	{
		return (start);
	}

	public void setStart(String start) 
	{
		this.start = start;
	}

	public String getEnd() 
	{
		return (end);
	}

	public void setEnd(String end) 
	{
		this.end = end;
	}

	public String getWeight() 
	{
		return (weight);
	}

	public void setWeight(String weight) 
	{
		this.weight = weight;
	}
     
}
