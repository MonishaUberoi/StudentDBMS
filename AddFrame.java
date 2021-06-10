import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class AddFrame extends JFrame{
Container c;
JLabel lblRno, lblName, lblSub1, lblSub2, lblSub3;
JTextField txtRno, txtName, txtSub1, txtSub2, txtSub3;
JButton btnSave, btnBack;

AddFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblRno = new JLabel("Enter Roll Number:");
txtRno = new JTextField(25);

lblName = new JLabel("Enter Name:           ");
txtName = new JTextField(25);

lblSub1 = new JLabel("Enter Sub1 marks:");
txtSub1 = new JTextField(25);

lblSub2 = new JLabel("Enter Sub2 marks:");
txtSub2 = new JTextField(25);

lblSub3 = new JLabel("Enter Sub3 marks:");
txtSub3 = new JTextField(25);

btnSave = new JButton("Save");
btnBack = new JButton("Back");

ActionListener a1 = (ae) -> {
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {

int rno = 0 , sub1 = 0 , sub2 = 0, sub3 = 0;
String name = "";
int a = 0;

//ROLL NUMBER

while(true){
try{
rno = Integer.parseInt(txtRno.getText());	
if(Integer.toString(rno).equals("") || Integer.toString(rno) == null){
JOptionPane.showMessageDialog(c, "Enter the roll number!", "Message", JOptionPane.ERROR_MESSAGE);
txtRno.setText("");//clear input
txtRno.requestFocus();
break;
}
else if(rno < 0){
JOptionPane.showMessageDialog(c, "Roll number cant be negative!", "Message", JOptionPane.ERROR_MESSAGE);
txtRno.setText("");//clear input
txtRno.requestFocus();
break;
}
}
catch(NumberFormatException e){
JOptionPane.showMessageDialog(c, "Enter the roll number in integer!", "Message", JOptionPane.ERROR_MESSAGE);
txtRno.setText("");//clear input
txtRno.requestFocus();
break;
}

//NAME

try{
name = txtName.getText();
if (name == null || name.equals("")){
JOptionPane.showMessageDialog(c, "Enter the name!", "Message", JOptionPane.ERROR_MESSAGE);
txtName.setText("");//clear input
txtName.requestFocus();
break;
}
else if(!(validateString(name))){
JOptionPane.showMessageDialog(c, "Name can have only letters", "Message", JOptionPane.ERROR_MESSAGE);
txtName.setText("");//clear input
txtName.requestFocus();
break;
}
else if(name.length() < 2){
JOptionPane.showMessageDialog(c, "Name can be lesser than 2 letters", "Message", JOptionPane.ERROR_MESSAGE);
txtName.setText("");//clear input
txtName.requestFocus();
break;
}
}
catch(Exception e){
JOptionPane.showMessageDialog(c, e, "Message", JOptionPane.ERROR_MESSAGE);
txtName.setText("");//clear input
txtName.requestFocus();
break;
}

//SUBJECT1 

try{
sub1 = Integer.parseInt(txtSub1.getText());
if(Integer.toString(sub1).equals("") || Integer.toString(sub1) == null){
JOptionPane.showMessageDialog(c, "Enter the marks of subject 1 !", "Message", JOptionPane.ERROR_MESSAGE);
txtSub1.setText("");//clear input
txtSub1.requestFocus();
break;
}
else if(sub1 > 100 || sub1 < 0){
JOptionPane.showMessageDialog(c, "Subject 1 marks can be between 0 and 100 ", "Message", JOptionPane.ERROR_MESSAGE);
txtSub1.setText("");//clear input
txtSub1.requestFocus();
break;
}
}
catch(NumberFormatException e){
JOptionPane.showMessageDialog(c, "Enter the subject 1 marks in integer!", "Message", JOptionPane.ERROR_MESSAGE);
txtSub1.setText("");//clear input
txtSub1.requestFocus();
break;
}

//SUBJECT2

try{
sub2 = Integer.parseInt(txtSub2.getText());
if(Integer.toString(sub2).equals("") || Integer.toString(sub2) == null){
JOptionPane.showMessageDialog(c, "Enter the marks of subject 2 !", "Message", JOptionPane.ERROR_MESSAGE);
txtSub2.setText("");//clear input
txtSub2.requestFocus();
break;
}
else if(sub2 > 100 || sub2 < 0){
JOptionPane.showMessageDialog(c, "Subject 2 marks can be between 0 and 100 ", "Message", JOptionPane.ERROR_MESSAGE);
txtSub2.setText("");//clear input
txtSub2.requestFocus();
break;
}
}
catch(NumberFormatException e){
JOptionPane.showMessageDialog(c, "Enter the subject 2 marks in integer!", "Message", JOptionPane.ERROR_MESSAGE);
txtSub2.setText("");//clear input
txtSub2.requestFocus();
break;
}

//SUBJECT3

try{
sub3 = Integer.parseInt(txtSub3.getText());
if(Integer.toString(sub3).equals("") || Integer.toString(sub3) == null){
JOptionPane.showMessageDialog(c, "Enter the marks of subject 3 !", "Message", JOptionPane.ERROR_MESSAGE);
txtSub3.setText("");//clear input
txtSub3.requestFocus();
break;
}
else if(sub3 > 100 || sub3 < 0){
JOptionPane.showMessageDialog(c, "Subject 3 marks can be between 0 and 100 ", "Message", JOptionPane.ERROR_MESSAGE);
txtSub3.setText("");//clear input
txtSub3.requestFocus();
break;
}
}
catch(NumberFormatException e){
JOptionPane.showMessageDialog(c, "Enter the subject 3 marks in integer!", "Message", JOptionPane.ERROR_MESSAGE);
txtSub3.setText("");//clear input
txtSub3.requestFocus();
break;
}
a++;
break;
}
//FINAL ADDITION

if(a == 1){
StudentManagementOperations.addStudent(rno, name, sub1, sub2, sub3);
}
};
btnSave.addActionListener(a2);

c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);
c.add(lblSub1);
c.add(txtSub1);
c.add(lblSub2);
c.add(txtSub2);
c.add(lblSub3);
c.add(txtSub3);
c.add(btnSave);
c.add(btnBack);

setTitle("Add St.");
setSize(400,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public boolean validateString(String str) {
      str = str.toLowerCase();
      char[] charArray = str.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
         char ch = charArray[i];
         if (!(ch >= 'a' && ch <= 'z')) {
            return false;
         }
      }
      return true;
}
}