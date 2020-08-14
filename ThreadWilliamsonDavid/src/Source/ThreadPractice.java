package Source;

import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FileChooserUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class ThreadPractice extends JFrame implements ActionListener {

	public static JFrame frame = new JFrame("Word Counter");
	public static JPanel panel = new JPanel(new BorderLayout());
	public static JButton countWordsButton = new JButton("Count Words");
	public static JButton addFileButton = new JButton("Add File");
	public static JLabel spacer1 = new JLabel();
	public static JLabel spacer2 = new JLabel();
	public static JOptionPane fileNumberWarning = new JOptionPane();
	public static JLabel filesReadyForCount = new JLabel("Your Files Are Ready For Word Count");
	public static File[] files = new File[2];
	public static String[] words = null;
	public static int wordCount = 0;
	public static int wordCount1 = 0;
 	public static int getWordCount1() {
		return wordCount1;
	}

	public static void setWordCount1(int wordCount1) {
		ThreadPractice.wordCount1 = wordCount1;
	}

	public static int getWordCount2() {
		return wordCount2;
	}

	public static void setWordCount2(int wordCount2) {
		ThreadPractice.wordCount2 = wordCount2;
	}

	public static int getWordCount3() {
		return wordCount3;
	}

	public static void setWordCount3(int wordCount3) {
		ThreadPractice.wordCount3 = wordCount3;
	}






	public static int wordCount2 = 0;
 	public static int wordCount3 = 0;
	public static String file1Name = new String();
	public static String file2Name = new String();
	public static String file3Name = new String();
	public static File file1 = new File("");
	public static File file2 = new File("");
	public static File file3 = new File("");
	
	ThreadPractice() {
		
	}
	
	public static synchronized int countWords(File file) throws IOException {
	int wordCount = 0;

	FileReader fr = new FileReader(file);    //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr);    //Creation of BufferedReader object
    
    String s;
    while((s=br.readLine())!=null)    //Reading Content from the file
    {
       words=s.split(" ");   //Split the word using space
       wordCount = wordCount + words.length;   //increase the word count for each word
       
    }
    
    fr.close();
    
    wordCount -=8;
    return wordCount;
	}
	
	
     
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,20,0,0);
        layout.setConstraints(addFileButton, constraints);
        
        
        addFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (e.getSource() == addFileButton) {
            	   JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView()); 
            	   fileChooser.setDialogTitle("Please Select Three Files CTRL-Click:");
            	   fileChooser.setMultiSelectionEnabled(true);
           		   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
           		   int returnValue = fileChooser.showSaveDialog(panel);
            	   
            	   if (returnValue == JFileChooser.APPROVE_OPTION) {
            		   File[] files = fileChooser.getSelectedFiles();
            		   if (files.length != 3) {
            			   JOptionPane.showMessageDialog(panel,"Please Select Three Files" );
                	   } else {
                		   file1 = files[0];
                		   file2 = files[1];
                		   file3 = files[2];
                		   file1Name = file1.getName();
                		   file2Name = file2.getName();
                	       file3Name = file3.getName();
                	       
                		   JOptionPane.showMessageDialog(panel,"Please Press Count Words Button To Continue" );
                	   }
            	   }
            	   
               }
            }
         });
        	  
        countWordsButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource() == countWordsButton) {
        			
        			
 		            
             		   ExecutorService executorService1 = Executors.newSingleThreadExecutor();
             		   ExecutorService executorService2 = Executors.newSingleThreadExecutor();
             		   ExecutorService executorService3 = Executors.newSingleThreadExecutor();
             		   
             		   executorService1.execute(new Runnable() {
             			                        
             		       

						public void run() {
             		    	  
             		           try {
             		        	
 						     setWordCount1(countWords(file1));
             		         
 							} catch (IOException e) {
 								// TODO Auto-generated catch block
 								e.printStackTrace();
 							}
             		       }
             		       
             		       
             		   });
             		   
             		   executorService2.execute(new Runnable() {
             		       public void run() {
             		           
             		           try {
             		        	  
             		        	  setWordCount2(countWords(file2));
 								
 							} catch (IOException e) {
 								// TODO Auto-generated catch block
 								e.printStackTrace();
 							}
             		       }
             		       
             		       
             		   });
             		   
             		   executorService3.execute(new Runnable() {
             		       public void run() {
             		           
             		           try {
             		        	  setWordCount3(countWords(file3));
 								
 							} catch (IOException e) {
 								// TODO Auto-generated catch block
 								e.printStackTrace();
 							}
             		       }
             		       
             		       
             		       
             		   });
             		   executorService1.shutdown();
             		   executorService2.shutdown();
             		   executorService3.shutdown();
             		   try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
             		   JOptionPane.showMessageDialog(panel,"Word Count For " + file1Name + " is " + getWordCount1() + "." + System.lineSeparator() +
             				                               "Word Count For " + file2Name + " is " + getWordCount2() + "." + System.lineSeparator() +
             		                                       "Word Count For " + file3Name + " is " + getWordCount3() + ".");
             	   }
                }
        		
        		
        });
        
        
        panel.setLayout(layout);
        panel.add(spacer1);
        panel.add(countWordsButton);
        panel.add(addFileButton);
        panel.add(spacer2);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
