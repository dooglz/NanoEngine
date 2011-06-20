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
		while(i < 10000) //only loop 10'000 times, just incase... (obviously this will needed to be taken out sometime)
		{
			logic.update();
			woopata.render();
			i++;
		}
		gamerunning = false;
	}
}