/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Admin;

import Business.Customer.Customer;
import Business.Customer.CustomerBillingDirectory;
import Business.Customer.CustomerDirectory;
import Business.RealEstate.Property;
import Business.RealEstate.PropertyDirectory;
import Business.Recreation.Room;
import Business.Recreation.RoomDirectory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author Shalom Daniel <your.name at your.org>
 */
public class Analytics {
    
    
    public void showPieChart(CustomerBillingDirectory cbd, JPanel jPanel){
        
        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();

        barDataset.setValue( "Total Rent Revenue " ,  cbd.getTotalRentRevenue());     
        barDataset.setValue( "Total Services Revenue " ,  cbd.getTotalServicesRevenue());   

 
      
      //create chart
        JFreeChart piechart = ChartFactory.createPieChart("\nTOTAL REVENUE DISTRIBUTION\n", barDataset, true,true,true);//explain
      
        PiePlot piePlot = (PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("Total Rent Revenue ", new Color(255,255,102));
        piePlot.setSectionPaint("Total Services Revenue ", new Color(102,255,102));
        
//        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.WHITE);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        jPanel.removeAll();
        jPanel.add(barChartPanel, BorderLayout.CENTER);
        jPanel.validate();

        
    }

    /*=============================================================================*/
    
    public void showLineChart(PropertyDirectory pd, JPanel jPanel){
        //create dataset for the graph
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Property p : pd.getProperties()){
            dataset.setValue(p.getPrice(), "Amount", p.getAddress());                      
        }
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("\nPROPERTIES PRICE DISTRIBUTION\n","Address ","Amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
//        lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        jPanel.removeAll();
        jPanel.add(lineChartPanel, BorderLayout.CENTER);
        jPanel.validate();
    }

    /*========================================================================================*/
    
    public void showHistogram(CustomerDirectory cd, JPanel jPanel){
        
        // create a map of customer ages
        Map<String, Integer> customerAges = new HashMap<>();
        
        for(Customer c : cd.getCustomerlist()){
            customerAges.put(c.getFullName(), c.getAge());
        }

        HistogramDataset dataset = new HistogramDataset();
        double[] ages = customerAges.values().stream().mapToDouble(Double::valueOf).toArray();
        dataset.addSeries("Age Distribution", ages, cd.getCustomerlist().size());
        
        JFreeChart chart = ChartFactory.createHistogram("\nAGE DISTRIBUTION\n", "Age Group", "Number of Customers", dataset, PlotOrientation.VERTICAL, true ,true,false);
            XYPlot plot= chart.getXYPlot();
        plot.getRenderer().setSeriesPaint(0, Color.BLUE);
        plot.setBackgroundPaint(Color.WHITE);
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
        jPanel.removeAll();
        jPanel.add(barpChartPanel2, BorderLayout.CENTER);
        jPanel.validate();
    }

    /*========================================================================================*/
    
    public void showBarChart(CustomerDirectory cd, JPanel jPanel){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Integer active_customers = cd.getNumberOfActiveCustomers();
        Integer nonactive_customers = (cd.getCustomerlist().size() - cd.getNumberOfActiveCustomers());

        
        dataset.setValue(active_customers, "", "\nActive Customers\n");
        dataset.setValue(nonactive_customers, "", "\nNon-Active Customers\n");
        
        JFreeChart chart = ChartFactory.createBarChart("\nLIST OF ACTIVE & NON-ACTIVE CUSTOMERS\n", "Count", "", 
                dataset, PlotOrientation.VERTICAL, true,true,true);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
//        categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        jPanel.removeAll();
        jPanel.add(barpChartPanel, BorderLayout.CENTER);
        jPanel.validate();
        
        
    }
    
        
    public void showRoomCountBarChart(RoomDirectory rd, JPanel jPanel){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(Room r : rd.getRooms()){
            dataset.addValue(r.getNo_of_requests(), "Requests", r.getRoomID());
        }
        
        JFreeChart chart = ChartFactory.createBarChart("\nLIST OF ROOMS WITH NUMBER OF BOOKINGS \n", "Count", "", 
                dataset, PlotOrientation.VERTICAL, true,true,true);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
//        categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        jPanel.removeAll();
        jPanel.add(barpChartPanel, BorderLayout.CENTER);
        jPanel.validate();
        
        
    }
        
   
    
}
