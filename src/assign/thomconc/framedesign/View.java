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

package assign.thomconc.framedesign;

import assign.thomconc.logic.Logic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

final public class View extends JFrame
{
    
	private static final long serialVersionUID = 1L;
	
	private String re;
	private JTextField regexp, inpexp;
	private JLabel l1, l2;
	private JButton chkStr, gen_nfa, disp_nfa;
	protected View ()
	{
		
		super ( "Thomson's Construction" );		
		setSize ( 500, 500 );
		setLocation ( 450, 175 );
		//setVisible(true);
		setResizable ( false );
		setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		Container c = getContentPane ();
		c.setLayout ( new GridLayout ( 7, 2 ) );
		c.setBackground ( Color.BLUE );
		l1 = new JLabel ();
		Font f1 = new Font ( "Aerial", Font.BOLD, 20 );
		l1 = new JLabel ( "Enter The Regular Expression (R.E) -" );
		l1.setFont ( f1 );
		l1.setForeground ( Color.WHITE );
		l2 = new JLabel ( "Enter The Input String -" );
		l2.setFont ( f1 );
		l2.setForeground ( Color.WHITE );
		regexp = new JTextField ( 20 );
		inpexp = new JTextField ( 20 );
		chkStr = new JButton ( "Match String With R.E." );
		chkStr.addActionListener ( ( e ) ->
		                           {
			                      if ( Logic.stringCheck ( regexp.getText ().trim (), inpexp.getText ().trim () ) == true )
			                      {
				                   setVisible ( true );
				                   JOptionPane.showMessageDialog ( this, "Input Sting Matches R.E. !!!" );
			                      }
			                      else
			                      {
				                   setVisible ( true );
				                   JOptionPane.showMessageDialog ( this, "Input Sting Doesnot Match R.E !!!" );
			                      }
		                            }
		                          );
		gen_nfa = new JButton ( "Generate NFA" );
		gen_nfa.addActionListener ( ( e ) -> 
		                            {
			                          re = regexp.getText ().trim ();
			                          new Logic ( re );
		                                  setVisible ( true );
			                          JOptionPane.showMessageDialog ( this, "NFA successfully generated!!" );
	                                          regexp.setText ( "" );
	                                          inpexp.setText ( "" );
		                            }
		                          );
		disp_nfa = new JButton ( "Display NFA" );
		disp_nfa.addActionListener ( ( e ) ->
		                              {
		                                   Logic.display1 ();
		                              }	
	                                   );
		
		c.add ( new JLabel ( " " ) ); c.add ( new JLabel ( " " ) );
		c.add ( l1 ); c.add ( regexp );
		c.add ( l2 ); c.add ( inpexp );
		c.add ( new JLabel ( " " ) ); c.add ( chkStr );
		c.add ( new JLabel ( " " ) ); c.add ( gen_nfa );
		c.add ( new JLabel ( " " ) ); c.add ( disp_nfa );
		c.add ( new JLabel ( " " ) ); c.add ( new JLabel ( " " ) );
	        pack ();
		setVisible ( true );
	
	}
	
	public static void main ( String args [] )
	{
		 new View ();
        }
 }
