import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave, btnBack;

DeleteFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblRno = new JLabel("Enter Roll Number:");
txtRno = new JTextField(25);

btnSave = new JButton("Delete");
btnBack = new JButton("Back");

c.add(lblRno);
c.add(txtRno);
c.add(btnSave);
c.add(btnBack);

ActionListener a1 = (ae) -> {
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
int rno = 0;

//ROLL NUMBER

try{
rno = Integer.parseInt(txtRno.getText());
}
catch(NumberFormatException e){
JOptionPane.showMessageDialog(c, "Enter the roll number in integer!", "Message", JOptionPane.ERROR_MESSAGE);
txtRno.setText("");//clear input
txtRno.requestFocus();
}
finally{
if(Integer.toString(rno).equals("") || Integer.toString(rno) == null){
JOptionPane.showMessageDialog(c, "Enter the roll number!", "Message", JOptionPane.ERROR_MESSAGE);
txtRno.setText("");//clear input
txtRno.requestFocus();
}
else if(rno < 0){
JOptionPane.showMessageDialog(c, "Roll number cant be negative!", "Message", JOptionPane.ERROR_MESSAGE);
txtRno.setText("");//clear input
txtRno.requestFocus();
}
}
//FINAL ADDITION

StudentManagementOperations.deleteStudent(rno);
};
btnSave.addActionListener(a2);


setTitle("Delete St.");
setSize(300, 130);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}