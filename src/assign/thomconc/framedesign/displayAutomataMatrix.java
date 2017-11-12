package assign.thomconc.framedesign;

import assign.thomconc.pojo.Automata;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

public class displayAutomataMatrix extends JFrame
{
	private static final long serialVersionUID = 1L;

	public displayAutomataMatrix(ArrayList <Automata> aut,String cre)
	{
		super("NFA IN MATRIX FORM");
		String heading[]={"Start State","End State","Edge Weight"};
		String data[][];
	    data = new String[aut.size()][3];
	    int r=0;
		for(Automata obj : aut)
			{
			     data[r][0]=obj.getStart();
				 data[r][1]=obj.getEnd();
				 data[r][2]=obj.getWeight();
	             r++;
			}
			
	    Container con=getContentPane();
	    con.setLayout(new BorderLayout());
			
	    JTable datatable=new JTable(data, heading);
	    JScrollPane jsp=new JScrollPane(datatable);
			
	    con.add(new JLabel("N.F.A. Matrix For R.E.- "+cre),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);
			
		setSize(850, 300);
			
		setLocation(200, 200);
		pack();
		setVisible(true);
    }
}
