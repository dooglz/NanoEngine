import java.awt.Image;

import javax.swing.ImageIcon;


public class Sprite 
{
	String Name = "";
	double x = 0;
	double y = 0;
	double vx = 0;
	double vy = 0;
	Image picture1;
	private  long curTime = 0;
	private  long lastTime = 0;
	double timeCRYSIS = 0;
	public Sprite(String name,String pic,double X,double Y)
	{
		Name = name;
		picture1 = new ImageIcon("src//images/"+pic).getImage();
		x = X;
		y = Y;
		System.out.println("hello, I'm a sprite and My name is "+Name);	
		gamelogic.addsprite(this);
		Nanoengine.addsprite(this);
	}
	public void Process()
	{
		//this get's overwritten by individual AI classes; hopefully
	}
	public long Timediff()
	{
		lastTime = curTime;
	    curTime = System.currentTimeMillis();
	    if((curTime - lastTime)<1000){return (curTime - lastTime);}else{
	    return (1);}
	}
}
