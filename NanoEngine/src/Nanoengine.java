import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Nanoengine extends JFrame
{
	//
	boolean calculatefps = true;
	int FrameLimit = 60;
	boolean Displayfps = false;
	//static Sprite spritelist[] = new Sprite[51];
	static ArrayList<Sprite> spritelist = new ArrayList<Sprite>();
	private int resX = 800;
	private int resY = 800;
	private  int fps = 0;
	private int frames = 0;
	private  double fromes = 0;
	private  long waittime = 0;
	private  long totalTime = 0;
	private  long curTime = 0;
	private  long lastTime = 0;
	private  Graphics graphics = null;
	private  Graphics2D g2d = null;
	private   Color background = Color.BLACK;
	private  BufferStrategy buffer = null;;
	private  BufferedImage bi = null;;
    
	public Nanoengine(int width, int height)
	{
		resY = width; resY = height;
		System.out.println("Generators Generating");
		this.setIgnoreRepaint( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Canvas canvas = new Canvas();
		canvas.setIgnoreRepaint( true );
		canvas.setSize(resX,resY);
		                
		// Add canvas to game window...
		this.add( canvas );
		this.pack();
		this.setVisible( true );
		System.out.println("Actuators Actuating");
		 // Create BackBuffer...
	    canvas.createBufferStrategy( 2 );
	    buffer = canvas.getBufferStrategy();

	    // Get graphics configuration...
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    GraphicsConfiguration gc = gd.getDefaultConfiguration();

	    // Create off-screen drawing surface
	    bi = gc.createCompatibleImage( resX, resY );
	    System.out.println("bufferers buffering");
	    // Objects needed for rendering...
	    Random rand = new Random();
	    System.out.println("Random machines randomizing");            
	    //HERE WE FUCKING GO
	    System.out.println("NANOENGINE RENDER INITIATED (res: "+resX+"x"+resY+")");
	}
	public void render()
	{
		try {
	        // FPS worker
	    	graphics = null;

	    	//-----------ACTUAL RENDER CRAP GOES IN HERE---------
	    	
	      //  fromes+=0.01;
	     //   if (fromes==360){fromes = 0;}
	        // clear back buffer...
	        g2d = bi.createGraphics();
	        g2d.setColor( background );
	        g2d.fillRect( 0, 0, 800, 800);                  
	        // draw some rectangles...
	      //  g2d.setColor( new Color(124,0,thattrig(fromes,121)));
	      //  g2d.fillRect( 0, 0,thattrig(fromes,400),thattrig(fromes,400));
	      //  g2d.setColor(new Color(thattrig(fromes,121),thattrig(fromes,121),250,250));
	     //   g2d.fillOval(400, 400, 200, 200);
	        //--
	    	for(int i=0;i<spritelist.size();i++)
	    	{
	    		if (spritelist.get(i) != null){
		    	g2d.drawImage(spritelist.get(i).picture1, (int)spritelist.get(i).x, (int)spritelist.get(i).y,null);
	    		}
	
	    	}
	        
	        //------------------------------------------------------
	    	if(Displayfps){
	        // display frames per second...
	        g2d.setFont( new Font( "Courier New", Font.PLAIN, 12 ) );
	        g2d.setColor( Color.GREEN );
	        g2d.drawString( String.format( "FPS: %s", fps ), 20, 20 );
	        }
	        // Blit image and flip...
	        graphics = buffer.getDrawGraphics();
	        graphics.drawImage( bi, 0, 0, null );
	        if(!buffer.contentsLost()){
	        	//halp
	        }
	          buffer.show();
		    	if(calculatefps)
		    	{
		    		lastTime = curTime;
			        curTime = System.currentTimeMillis();
			        totalTime += curTime - lastTime;
			        if( totalTime > 100 )
			        {
			          totalTime = 0;
			          fps = frames*10;
			          frames = 0;
			        }// - if calc frames is on, it also is capping frames by default.
			        if (fps > FrameLimit){
			        	waittime++;
			        }
			        if (fps < FrameLimit){
			        	waittime--;
			        }
			        if(waittime<0)
			        {
			        	waittime = 5;
			        }    
			        ++frames;
		    	}else{
		    		waittime = 10;
		    	}                 
	       try {
				Thread.sleep(waittime);
			} catch (InterruptedException e) {
				Thread.yield();
			}
	      } finally {
	        // release resources
	        if( graphics != null ) 
	          graphics.dispose();
	        if( g2d != null ) 
	          g2d.dispose();
	      }
	    }
	
	
	    static int thattrig(double frome,int x)
	    {
	    	return (((int) (Math.sin(frome)*(x/2)))+(x/2));
	    }
	    static void addsprite(Sprite spritetobeadded)
	    {
	  	  	spritelist.add(spritetobeadded);
	  	  System.out.println("Spritelist now contains: ");	
	    	for(int i=0;i<spritelist.size();i++){
	    	System.out.println(i+"\t"+spritelist.get(i).Name);	
	    	}
	    }
	}
