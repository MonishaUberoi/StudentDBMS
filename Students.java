import java.util.*;
class Students implements Comparable<Students>{
private int rno;
private String name;
private int sub1;
private int sub2;
private int sub3;
  
public Students(){
}

public Students(int rno, String name, int sub1, int sub2, int sub3){
this.rno = rno;
this.name = name;
this.sub1 = sub1;
this.sub2 = sub2;
this.sub3 = sub3;
}

public int compareTo(Students s){
	return rno - s.getRno();
}

public void setRno(int rno){
this.rno = rno;
}

public int getRno(){
return rno;
}

public void setName(String name){
this.name = name;
}

public String getName(){
return name;
}

public void setSub1(int sub1){
this.sub1 = sub1;
}

public int getSub1(){
return sub1;
}

public void setSub2(int sub2){
this.sub2 = sub2;
}

public int getSub2(){
return sub2;
}

public void setSub3(int sub3){
this.sub3 = sub3;
}

public int getSub3(){
return sub3;
}
}