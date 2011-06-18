import java.util.ArrayList;


public class gamelogic {
	
	static ArrayList<Sprite> spriteLogiclist = new ArrayList<Sprite>();
	public gamelogic()
	{
		System.out.println("gamelogic booting up...");
	    //alright first run, lets set this shit up
		frog bach = new frog("toad1",200,200);
		bach.vx = 0.1;
	}
    public static void addsprite(Sprite spritetobeadded)
    {
  	  	spriteLogiclist.add(spritetobeadded);
  	  	System.out.println("SpriteLogiclist now contains: ");	
    	for(int i=0;i<spriteLogiclist.size();i++){
    	System.out.println(i+"\t"+spriteLogiclist.get(i).Name);	
    	}
    }
    public void update(){
    	for(int i=0;i<spriteLogiclist.size();i++)
    	{
    		if (spriteLogiclist.get(i) != null){
    			spriteLogiclist.get(i).Process();
    		}
    	}
    }
	
}
