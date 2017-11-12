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
