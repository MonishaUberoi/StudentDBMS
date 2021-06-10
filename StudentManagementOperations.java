import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

class StudentManagementOperations{

public static void addStudent(int rno, String name, int sub1, int sub2, int sub3){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;

try{
s = sfact.openSession();
t = s.beginTransaction();
System.out.println("Connected");
Students b = (Students)s.get(Students.class, rno);
if(b == null){
Students stud = new Students(rno, name, sub1, sub2, sub3);
s.save(stud);
t.commit();
JOptionPane.showMessageDialog(null, "Record Added!", "Message", JOptionPane.INFORMATION_MESSAGE);
}else{
JOptionPane.showMessageDialog(null, "Roll number already exists in the records!", "Message", JOptionPane.INFORMATION_MESSAGE);
}
}
catch(Exception e){
t.rollback();
System.out.println("Issue" + e);
}
finally{
s.close();
System.out.println("Disconnected");
}
}


public static String viewStudent(){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session s = null;
String str = "Rno" + "\t" + "Name" + "\t\t" + "Subject 1" + "\t" + "Subject 2" + "\t" + "Subject 3\n";
try{
s = sfact.openSession();
System.out.println("Connected");
List<Students> stu = new ArrayList<>();
stu = s.createQuery("from Students").list();
Collections.sort(stu);
for(Students m : stu)
	str = str + (m.getRno() + "\t" + m.getName() + "\t\t" + m.getSub1() + "\t\t" + m.getSub2() + "\t\t" + m.getSub3() ) + "\n";
}
catch(Exception e){
System.out.println("Issue " + e);
}
finally{
s.close();
System.out.println("Disconnected");
}
return str;
}


public static void updateStudent(int rno, String name, int sub1, int sub2, int sub3){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;

try{
s = sfact.openSession();
t = s.beginTransaction();
System.out.println("Connected");
Students b = (Students)s.get(Students.class, rno);
if(b != null){
b.setName(name);
b.setSub1(sub1);
b.setSub2(sub2);
b.setSub3(sub3);
t.commit();
JOptionPane.showMessageDialog(null, "Record Updated!", "Message", JOptionPane.INFORMATION_MESSAGE);
}else{
JOptionPane.showMessageDialog(null, "Roll number does not exist in the records!", "Message", JOptionPane.INFORMATION_MESSAGE);
}
}
catch(Exception e){
t.rollback();
System.out.println("Issue" + e);
}
finally{
s.close();
System.out.println("Disconnected");
}
}


public static void deleteStudent(int rno){
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;
try{
s = sfact.openSession();
t = s.beginTransaction();
System.out.println("Connected");
Students b = (Students)s.get(Students.class, rno);
if(b != null){
s.delete(b);
t.commit();
JOptionPane.showMessageDialog(null, "Record Deleted!", "Message", JOptionPane.INFORMATION_MESSAGE);
}else{
JOptionPane.showMessageDialog(null, "Roll number does not exist in the records!", "Message", JOptionPane.INFORMATION_MESSAGE);
}
}
catch(Exception e){
t.rollback();
System.out.println("Issue " + e);
}
finally{
s.close();
System.out.println("Disconnected");
}
}

}
