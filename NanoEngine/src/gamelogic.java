import java.util.ArrayList;

public class gamelogic
{
	//publics
	static ArrayList<Sprite> spriteLogiclist = new ArrayList<Sprite>();
	//Constructor
	public gamelogic()
	{
		System.out.println("gamelogic booting up...");
	    //alright first run, lets set this shit up
		frog bach = new frog("toad1",1,100,200);
		frog bach1 = new frog("toad2",3,300,200);
		frog bach2 = new frog("toad3",3,500,200);
		bach.vx = 0.1;
	}
	//addsprite to the array
    public static void addsprite(Sprite spritetobeadded)
    {
  	  	spriteLogiclist.add(spritetobeadded);
  	  	System.out.println("SpriteLogiclist now contains: ");	
    	for(int i=0;i<spriteLogiclist.size();i++)
    	{
    	System.out.println(i+"\t"+spriteLogiclist.get(i).Name);	
    	}
    }
    //send a poke out to all active sprites
    public void update(){
    	for(int i=0;i<spriteLogiclist.size();i++)
    	{
    		if (spriteLogiclist.get(i) != null)
    		{
    			spriteLogiclist.get(i).Process();
    		}
    	}
    }
	
}
