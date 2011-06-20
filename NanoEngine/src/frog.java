public class frog extends Sprite
{
	//Constructor
	public frog(String name,int depth,double X,double Y)
	{
		super(name, "frog.jpg",depth, X, Y);
	}
	//AI
	public void Process()
	{
		this.timeCRYSIS = (Timediff()/10);
		this.x += this.vx *(timeCRYSIS);
		this.y += 0.5 *(timeCRYSIS);
	}
}
