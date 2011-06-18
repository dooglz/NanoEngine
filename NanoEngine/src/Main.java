import javax.swing.JFrame;
public class Main extends JFrame
{
	static boolean gamerunning = false;
	public static void main(String[] args)
	{
		System.out.println("Program has begun");
		Nanoengine woopata = new Nanoengine(800,800);
		gamelogic logic = new gamelogic();
		//woopata.drawfps = true;
		woopata.calculatefps =true;
		woopata.Displayfps = false;
		int i= 0;
		gamerunning = true;
		while(i < 5000)
		{
		logic.update();
		woopata.render();
		i++;
		}
		gamerunning = false;
	}
}
