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

package assign.thomconc.logic;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import assign.thomconc.pojo.Automata;
import assign.thomconc.framedesign.displayAutomataMatrix;

final public class Logic 
{
	private static class PrthStCntr
        {
    	       private int pexn;
    	       private int sci;
    	       private int isl;
    	       private int chkststate;
    	       private int fst;
    	       private int lst;
    	       private int slb;
          
    	       PrthStCntr ()
    	       {
    		      pexn = 0;
                      sci = 0;
    		      isl = 0;
    		      chkststate = 0;
    		      fst = 0;
    		      lst = 0;
    		      slb = 0;
    	       }
    	       PrthStCntr ( int pexn )
    	       {
    		     this ();
    		     this.pexn = pexn;
    	       }
    	  
    	       private void setIsl ( int isl )
    	       {
    		     this.isl = isl;
    	       }
    	  
    	       private void setSci ( int sci )
    	       {
    		     this.sci = sci;
    	       }
    	  
    	       private void setChkststate ( int chkststate )
    	       {
    		     this.chkststate = chkststate;
    	       }
    	  
    	       private void setFst ( int fst )
    	       {
    		     this.fst = fst;
    	       }
    	  
    	       private void setLst ( int lst )
    	       {
    		     this.lst = lst;
    	       }
    	  
    	       private void setSlb ( int slb )
    	       {
    		     this.slb = slb;
    	       }
    	  
    	       private int getIsl ()
    	       {
    		     return ( isl );
    	       }
    	  
    	       private int getPexn ()
    	       {
    		     return ( pexn );
    	       }
    	  
    	       private int getSciv ()
    	       {
    		     return ( sci );
    	       }
    	  
    	       private int getChkststate ()
    	       {
    		     return ( chkststate );
    	       }
    	  
    	       private int getFst ()
    	       {
    		     return ( fst );
    	       }
    	  
    	       private int getLst ()
    	       {
    		     return ( lst );
    	       }
    	  
    	       private int getSlb ()
    	       {
    		     return ( slb );
    	       }
    	  
        }
	  
      private String re;
      private static String cre;
      private static int sco; 
      private ArrayList < PrthStCntr > psc;
      private static ArrayList < Automata > auto;
      
      public Logic ()
      {
    	   super ();
    	   sco = 0;
    	   psc = new ArrayList < PrthStCntr > ();
    	   auto = new ArrayList < Automata > ();
      }
      public Logic ( String re )
      {
    	   this ();
    	   this.re = re;
    	   statenumbering ( this.re );
    	   parse ( this.re );
      }
      
      public static boolean stringCheck ( final String regexp, final String inpexp )
      {
    	       Pattern patt;
    	       Matcher match;
    	   
    	       patt = Pattern.compile ( regexp );
    	       match = patt.matcher ( inpexp );
    	       
	       if ( match.matches () == true )
    	       {
    	              return ( true );
    	       }
    	       else
    	       {
    		      return ( false );
    	       }
       }
       protected void statenumbering ( String re )
       {
    	    cre = re;
    	    int ln = re.length(), c = 0, osl = 0;
    	    int ppsmax = 0; 
    	    int prcl = 0;
    	    ArrayList < Character > brkts = new ArrayList < Character > ();
    	    while( c < ln )
    	    {
    		   if ( ( re.charAt ( c ) ) == '(' )
    		   {
    			  brkts.add ( '(' );
    			  psc.add ( new PrthStCntr ( brkts.size () + ppsmax ) );
    			  if ( ( c > 0 ) && ( re.charAt ( c - 1 ) == '|' ) )
    			  {
    				  psc.get ( ( brkts.size () + ppsmax ) - 1 ).setSlb ( 1 );
    				  c++;
    				  continue;
    			  }
    			  else
    			  {
    				  c++;
    			          continue;
    			  }
    		   }
    		   if ( ( re.charAt ( c ) ) == ')' )
    		   {
    			  prcl++;
    			  if ( ( psc.size () ) != prcl )
    			  {
    			       if( ( re.charAt ( c + 1 ) ) == '*' )
    			       {
    				       psc.get ( ( brkts.size () + ppsmax ) - 1 ).setSci ( ( psc.get ( ( brkts.size () + ppsmax ) - 1 ).getSci () ) + 1 );
    				       brkts.remove ( ( brkts.size () ) - 1 );
    				       c = c + 2;
    			               continue;
    			       }
    			       else
    			       {
    				       brkts.remove ( ( brkts.size () ) - 1 );
    			    	       c++;
    				       continue;
    			       }
    		          }
    			  else
    			  {
    				   if ( c + 1 == ln )
   			           {
   				           ppsmax = psc.size ();
   				           brkts.remove ( ( brkts.size () ) - 1 );
                                           c = c + 1;
                                           break;
   			           }
   			           if((re.charAt(c+1)=='*')&&((c+2)==ln))
                                   {
                                          psc.get((brkts.size()+ppsmax)-1).setSci((psc.get((brkts.size()+ppsmax)-1).getSci())+1);
  				                          brkts.remove((brkts.size())-1);
               	                          ppsmax=psc.size();
  				                          c=c+2;
  				                          break;
                                   }
   			           else
   			           {
   			        	   ppsmax=psc.size();
				           brkts.remove((brkts.size())-1);
				           c++;
				           continue;
   			           }
    			  }
    		  }
    			  
    		  if((re.charAt(c))=='|')
    		  {
    		        if((psc.size())==prcl)
                        {
                    	    if(osl==0)
                    	    {	
                    	        sco++;
                    	        osl++;
                    	        c++;
                    	        continue;
                    	    }
                    	    else
                    	    {
                    		    c++;
                    	        continue; 
                    	    }
                        }
    			        else
    			        {
                            if((psc.get(brkts.size()-1).getIsl())==0)
                            {
                                psc.get((brkts.size()+ppsmax)-1).setSci((psc.get((brkts.size()+ppsmax)-1).getSci())+1);
                                psc.get((brkts.size()+ppsmax)-1).setIsl((psc.get((brkts.size()+ppsmax)-1).getIsl())+1);
                                c++;
                                continue;
                            }
                            else
                            {
                                c++;
                                continue;
                            }
    			   
    		            }
              }
    		  else
    		  {
    			   if(psc.size()==prcl)
    			   {
    				     if(c+1==ln)
                                 {
                                     c=c+1;
                                     break;
                                 }
    			         if((re.charAt(c+1)=='*')&&((c+2)==ln))
                                 {
                 	                 c=c+2;
                 	                 break;
                                 }
     			         if((re.charAt(c+1))=='*')
     			         {
     				           c=c+2;
     				           continue;
     			         }
     			         else
     			         {
     				           c++;
     				           continue;
     			         }
    		       }
    	           else
    			   {
    			         if((re.charAt(c+1))=='*')
    	     			   {
    	     		             c=c+2;
    	     				     continue;
    	     			   }
    	     			   else
    	     			   {
    	     				  c++;
    	     				  continue;
    	     			   }
                   }
    	     }
          }
          brkts.clear();
      }

      protected void parse(String re)
      {
    	 abstract class AnonymousInner
    	 {
    		 protected abstract void recurConstruct(int sc);
    	 }
    	 
    	 final int ln = re.length();
         
         for(PrthStCntr obj : psc)
         {
        	 obj.setIsl(0);
         }
         System.out.println(sco);
         AnonymousInner in=new AnonymousInner() 
         {
             int c=0;
             int ppsmax=0;
             int prst=0;
             int prcl=0;
             int osl=0;
             ArrayList <Character> brkts=new ArrayList <Character> ();
             int fl[]=new int [2];
            
             protected void recurConstruct(int sc)
        	 {
        	    if(c<ln)
                {
        	       char ch=re.charAt(c);
            	   System.out.println(ch);
        	       System.out.println("Check");
        	       switch(ch)
                   {
                       case '(' : brkts.add('(');
                                  sc=sc+(psc.get((brkts.size()+ppsmax)-1).getSci());
                                  psc.get((brkts.size()+ppsmax)-1).setFst(sc);
                                  System.out.print(sc);
                                  if(c==0)
                                  {
                                	  fl[0]=sc;
                                	  psc.get((brkts.size()+ppsmax)-1).setChkststate(1);
                                  }
                                  c++;
                                  prst++;
                                  recurConstruct(sc);
                                  return;
                      
                       case ')' : if((psc.get((brkts.size()+ppsmax)-1).getIsl())==0)
                    	              psc.get((brkts.size()+ppsmax)-1).setLst(sc);
        			              if(((c+1)!=ln)&&(re.charAt(c+1))=='*')
        			              {
        				              construct(psc.get((brkts.size()+ppsmax)-1).getFst()-1,psc.get((brkts.size()+ppsmax)-1).getFst(),"E");
        				              construct(psc.get((brkts.size()+ppsmax)-1).getFst()-1,psc.get((brkts.size()+ppsmax)-1).getLst()+1,"E");
        				              construct(psc.get((brkts.size()+ppsmax)-1).getLst(),psc.get((brkts.size()+ppsmax)-1).getFst(),"E");
        				              construct(psc.get((brkts.size()+ppsmax)-1).getLst(),psc.get((brkts.size()+ppsmax)-1).getLst()+1,"E");
        				              psc.get((brkts.size()+ppsmax)-1).setFst((psc.get((brkts.size()+ppsmax)-1).getFst())-1);
        				              psc.get((brkts.size()+ppsmax)-1).setLst((psc.get((brkts.size()+ppsmax)-1).getLst())+1);
        				              sc=psc.get((brkts.size()+ppsmax)-1).getLst();
        				              if(psc.get((brkts.size()+ppsmax)-1).getChkststate()==1)
        				              {
        				            	  fl[0]=psc.get((brkts.size()+ppsmax)-1).getFst();
        				            	  fl[1]=psc.get((brkts.size()+ppsmax)-1).getLst();
        				              }
        				              prcl++;
        				              if((prst==prcl)&&(osl==0))
        				            	  fl[1]=sc;
        				              if((psc.get((brkts.size()+ppsmax)-1).getSlb())==1)
        				              {
        				                  if(prst!=prcl)
        				                  {
        				                	  construct(psc.get((brkts.size()+ppsmax)-2).getFst(),psc.get((brkts.size()+ppsmax)-1).getFst(),"E");
        				                  }
        				                  else
        				                  {
        				                      construct(fl[0],psc.get((brkts.size()+ppsmax)-1).getFst(),"E");
        				                	  ppsmax=prcl;
        				                  }
        				              }
        				              brkts.remove((brkts.size())-1);
        				              c=c+2;
        				              recurConstruct(sc);
        			                  return;
        			                }
        			                else
        			                {
        			                	  if(psc.get((brkts.size()+ppsmax)-1).getChkststate()==1)
          				                  {
          				            	          fl[0]=psc.get((brkts.size()+ppsmax)-1).getFst();
          				            	          fl[1]=psc.get((brkts.size()+ppsmax)-1).getLst();
          				                  }
        			                	  sc=psc.get((brkts.size()+ppsmax)-1).getLst();
       				                      prcl++;
       				                      if((prst==prcl)&&(osl==0))
         				            	      fl[1]=sc;
       				                      if((psc.get((brkts.size()+ppsmax)-1).getSlb())==1)
      				                      {
      				                	       if(prst!=prcl)
      				                	       {
      				                	           construct(psc.get((brkts.size()+ppsmax)-2).getFst(),psc.get((brkts.size()+ppsmax)-1).getFst(),"E");
      				                	       }
      				                	       else
      				                	       {
      				                		       construct(fl[0],psc.get((brkts.size()+ppsmax)-1).getFst(),"E");
      				                		       ppsmax=prcl;
      				                	       }
      				                      }
        			                	  brkts.remove((brkts.size())-1);
        			    	              c++;
        			    	              recurConstruct(sc);
        				                  return;
        			               }
        			               //return;
                       
                        case '|' : if(prst!=prcl)
                                   {
                        	            psc.get((brkts.size()+ppsmax)-1).setIsl((psc.get((brkts.size()+ppsmax)-1).getIsl())+1);
                        	            if((psc.get((brkts.size()+ppsmax)-1).getIsl())==1)
                        	            {
                        	            	 construct(psc.get((brkts.size()+ppsmax)-1).getFst()-1,psc.get((brkts.size()+ppsmax)-1).getFst(),"E");
                        	            	 construct(sc,sc+1,"E");
                        	            	 psc.get((brkts.size()+ppsmax)-1).setFst((psc.get((brkts.size()+ppsmax)-1).getFst())-1);
               				                 psc.get((brkts.size()+ppsmax)-1).setLst(sc+1);
               				                 sc=psc.get((brkts.size()+ppsmax)-1).getLst()+1;
                        	            	 c++;
                        	            	 recurConstruct(sc);
                        	            	 return;
                        	            }
                        	            if((psc.get((brkts.size()+ppsmax)-1).getIsl())>1)
                                        {
                        	            	 construct(sc,psc.get((brkts.size()+ppsmax)-1).getLst(),"E");
               				                 sc=sc+1;
               				                 c++;
               				                 recurConstruct(sc);
               				                 return;
                                        }
                                   }
                                   else
                                   {
                                	   osl++;
                                	   if(osl==1)
                                	   {
                                		    construct(fl[0]-1,fl[0],"E");
                                		    construct(fl[1],fl[1]+1,"E");
                                		    fl[0]=fl[0]-1;
                                		    fl[1]=fl[1]+1;
                                		    sc=fl[1]+1;
                                		    c++;
                                		    recurConstruct(sc);
                                		    return;
                                	   }
                                	   if(osl>1)
                                	   {
                                		   construct(sc,fl[1],"E");
                                		   sc=sc+1;
                                		   c++;
                                		   recurConstruct(sc);
                                		   return;
                                	   }
                                   }
        			               //return;
        				           
         			   default : if(c==0)
                    	           fl[0]=sc;
         			             System.out.println("ina");
                                  if(((c+1)!=ln)&&(re.charAt(c+1)=='*'))
                                  {
                                	  construct(sc,sc+1,"E");
                  	                  construct(sc+1,sc+2,Character.toString(re.charAt(c)));
                  	                  construct(sc+2,sc+1,"E");
                  	                  construct(sc+2,sc+3,"E");
                  	                  construct(sc,sc+3,"E");
                  	                  if((c>0)&&(re.charAt(c-1)=='|'))
                  	                  {
                  	                	  if(prcl!=prst)
                  	                	  {
                  	                		  construct(psc.get((brkts.size()+ppsmax)-1).getFst(),sc,"E");
                  	                	  }
                  	                	  else
                  	                	  {
                  	                		  construct(fl[0],sc,"E");
                  	                	  }
                  	                  }
                  	                  sc=sc+3;
                  	                  if((prst==prcl)&&(osl==0))
      				            	      fl[1]=sc;
                  	                  c=c+2;
                  	                  recurConstruct(sc);          
                  	                  return;
                                     
                                  }
     				              else
     				              {
     				            	  System.out.println("dawg");
     				            	  construct(sc,sc+1,Character.toString(re.charAt(c)));
     				            	  if((c>0)&&(re.charAt(c-1)=='|'))
     				            	  {
     				            		 if(prcl!=prst)
                 	                	  {
                 	                		  construct(psc.get((brkts.size()+ppsmax)-1).getFst(),sc,"E");
                 	                	  }
                 	                	  else
                 	                	  {
                 	                		  construct(fl[0],sc,"E");
                 	                	  }
     				            	  }
     				            	  sc=sc+1;
     				            	  if((prst==prcl)&&(osl==0))
       				            	      fl[1]=sc;
     				            	  c++;
     				            	  recurConstruct(sc);
     				            	  return;
     				              }
                                  //return;
                   }
                }
        	    else
        	    {
        	    	System.out.println("Margo");
        	    	if(osl>0)
        	    	{
        	    		construct(sc,fl[1],"E");
        	    		return;
        	    	}
        	    	else
        	    	{
        	    		fl[1]=sc;
        	    		return;
        	    	}
        	    	//return;
        	    }
        	 }
         };
         in.recurConstruct(sco);
      
      }
      
      protected void construct(int start,int end,String weight)
      {
    	  Automata obj=new Automata ();
    	  obj.setStart("q"+start);
    	  obj.setEnd("q"+end);
    	  obj.setWeight(weight);
    	  auto.add(obj);
      }
      
      public static void display1()
      {
    	  new displayAutomataMatrix(auto,cre);
      }
}
