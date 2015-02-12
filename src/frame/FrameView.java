package frame; 


 import java.awt.BorderLayout; 
import java.awt.Button; 
import java.awt.CardLayout; 
import java.awt.FlowLayout; 
import java.awt.Frame; 
import java.awt.Label; 
import java.awt.Panel; 
import java.awt.TextField; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowEvent; 
import java.awt.event.WindowListener; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
 
 

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 
 
 

import last.MySQL; 
 
 
 public class FrameView extends Frame implements ActionListener,WindowListener{ 
    private Button button1 = new Button("データ表示"); 
      CardLayout cardlayout; 
      Panel panel1; 
      Panel panel2; 
 	  
 	 
 	public FrameView(FrameController controller) { 
 		// TODO Auto-generated constructor stub 
         panel1 =new Panel(); 
         panel2 = new Panel(); 
         
 		addWindowListener(this); 
 		setTitle("日本人男性の喫煙率"); 
 		
 		cardlayout= new CardLayout(); 
 		setLayout(cardlayout); 
 		panel2.add(button1,BorderLayout.CENTER); 
 		add(panel2); 
 		add(panel1); 
 		button1.addActionListener(this);  
 		
 	} 
 
 	@Override 
 	public void actionPerformed(ActionEvent e) { 
 		
 		if(e.getSource()==button1){ 
 			int id,year,parcentage; 
 			ResultSet rs; 
 			MySQL mysql = new MySQL(); 
 			rs = mysql.selectAll(); 
            DefaultCategoryDataset data = new DefaultCategoryDataset(); 
            
 			try{ 
 				     while(rs.next()){ 
 				    	   id=rs.getInt("id"); 
 				    	   year =rs.getInt("year"); 
 				    	   parcentage=rs.getInt("parcentage"); 
 				    	   data.addValue(parcentage,"parcentage",""+year); 
 				    	   panel1.add(new Label("ID:     "+id+"     年度     "+year+"年     喫煙率     "+parcentage+"%")); 
 				           } 
 			 
 			 }catch(SQLException a){ 
 	} 
 		    JFreeChart chart = ChartFactory.createLineChart("SmokingRates", 
 		                                   "year", 
 		                                   "parcentage", 
 		                                   data, 
 		                                   PlotOrientation.VERTICAL, 
 		                                   true, 
 		                                   false, 
 		                                   false); 
 		    ChartPanel chp = new ChartPanel(chart); 
 		    panel1.add(chp); 
 		    cardlayout.next(this); 
 			} 
 	}

@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

 System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
