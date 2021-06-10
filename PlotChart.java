import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import java.io.*;
import java.sql.*;
import java.util.*;

class PlotChart extends JFrame {
Container c;
JButton btnBack;

PlotChart() {

btnBack = new JButton("Back");

ActionListener a1 = (ae) -> {
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

DefaultCategoryDataset ds = new DefaultCategoryDataset();
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;

try{
s = sfact.openSession();
t = s.beginTransaction();
System.out.println("Connected");
List<Students> stu = new ArrayList<>();
stu = s.createQuery("from Students").list();
for(Students m : stu){
	String name = m.getName();
	int sub1 = m.getSub1();
	int sub2 = m.getSub2();
	int sub3 = m.getSub3();
	ds.addValue(sub1, "Subject 1", name);
	ds.addValue(sub2, "Subject 2", name);
	ds.addValue(sub3, "Subject 3", name);
}

JFreeChart ch = ChartFactory.createBarChart("Student Performance", "Subjects", "Marks", ds, PlotOrientation.VERTICAL, true, false, false);

c = getContentPane();
c.setLayout(new FlowLayout());

ChartPanel pa = new ChartPanel(ch);
c.add(pa);
c.add(btnBack);

File bb = new File("bb.png");
ChartUtilities.saveChartAsPNG(bb, ch, 500, 500);
} 
catch(Exception e) {
System.out.println("issue" + e);
}
finally{
s.close();
System.out.println("Disconnected");
}

setSize(700, 500);
setLocationRelativeTo(null);
setTitle("Performance Chart");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

