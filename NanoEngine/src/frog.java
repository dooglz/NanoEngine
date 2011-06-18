
public class frog extends Sprite
{
	public frog(String name,double X,double Y)
	{
		super(name, "frog.jpg", X, Y);
	}
	public void Process()
	{
		this.timeCRYSIS = (Timediff()/10);
		this.x += this.vx *(timeCRYSIS);
		this.y += 2.5 *(timeCRYSIS);
	}
	
}
