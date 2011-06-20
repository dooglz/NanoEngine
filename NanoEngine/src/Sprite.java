import java.awt.Image;
import javax.swing.ImageIcon;
public class Sprite implements Comparable<Sprite>
{
	//Publics
	String Name = "";
	double x = 0;
	double y = 0;
	int z = 0;
	double vx = 0;
	double vy = 0;
	Image picture1;
	//Privates
	private  long curTime = 0;
	private  long lastTime = 0;
	double timeCRYSIS = 0;
	//Constructor
	public Sprite(String name,String pic,int depth,double X,double Y)
	{
		Name = name;
		picture1 = new ImageIcon("src//images/"+pic).getImage();
		x = X;
		y = Y;
		z = depth;
		System.out.println("hello, I'm a sprite and My name is "+Name);	
		gamelogic.addsprite(this);
		Nanoengine.addsprite(this);
	}
	//this get's overwritten by individual AI classes; hopefully
	public void Process()
	{
	}
	//Time code used for Ai calcs
	public long Timediff()
	{
		lastTime = curTime;
	    curTime = System.currentTimeMillis();
	    if((curTime - lastTime)<1000){return (curTime - lastTime);}else{
	    return (1);}
	}
	//This is complex Z-buffer stuff, do not mess!
	public int compareTo(Sprite ComparingSprite) {
		  final int BEFORE = -1;
		  final int EQUAL = 0;
		  final int AFTER = 1;
		  if (this.z == ComparingSprite.z ) {return EQUAL;}
		  if (this.z < ComparingSprite.z) {return BEFORE;}
		  if (this.z > ComparingSprite.z) {return AFTER;}
		  return EQUAL;
	}
}
