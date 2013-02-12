package spleefmanager.misc;

//pure storage class
public class Area {
	int x1,z1,
		x2,z2,y;
	int BlockID;
	String sAreaName;
	//World world;
	
	
	public Area() {
		// TODO Auto-generated constructor stub
		x1=z1=x2=z2=y=0;
		BlockID=0;
		sAreaName="None";
	}
	public Area(int x1_1,int z1_1,int x2_1,int z2_1,int y_1,int bID,String par){
		x1=x1_1;
		x2=x2_1;
		z1=z1_1;
		z2=z2_1;
		y=y_1;
		BlockID=bID;
	}

}
