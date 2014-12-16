package com.util;
import java.awt.BasicStroke;
import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;



import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class PieChart_AWT extends ApplicationFrame 
{
   public PieChart_AWT( String title ) 
   {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   private static PieDataset createDataset( ) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "IPhone 5s" , new Double( 20.01 ) );  
      dataset.setValue( "SamSung Grand" , new Double( 20.11 ) );   
      dataset.setValue( "MotoG" , new Double( 40 ) );    
      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Mobile Sales",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   public static void main( String[ ] args )
   {
      PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
   
   
   public JFreeChart getChart() {
	   
	   Service service = new Service();
	   ArrayList<Object[]> objts=service.makePieChart();
	   
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(Object[] obj:objts)
		{	
			
			
			
			dataset.setValue((String)obj[1],(Integer)obj[0]);
			
			
			
		}
		

		
		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("CLAIM STATISTICS", dataset, legend, tooltips, urls);

		PiePlot plot = (PiePlot) chart.getPlot();
		
		chart.setBorderPaint(Color.BLUE);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);
		chart.setTitle("CLAIM STATISTICS");
		
		return chart;
	}
 public JFreeChart getPolicyChart() {
	   
	   Service service = new Service();
	   ArrayList<Object[]> objts=service.makePolicyPieChart();
	   
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(Object[] obj:objts)
		{	
			
			
			
			dataset.setValue((String)obj[1],(Integer)obj[0]);
			
			
			
		}
		

		
		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createPieChart("POLICY STATISTICS", dataset, legend, tooltips, urls);

		PiePlot plot = (PiePlot) chart.getPlot();
		
		chart.setBorderPaint(Color.BLUE);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);
		chart.setTitle("POLICY STATISTICS");
		
		return chart;
	}
}