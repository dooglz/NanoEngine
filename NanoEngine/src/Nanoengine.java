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
import java.util.Collections;
import javax.swing.JFrame;

public class Nanoengine extends JFrame
{
	//Publics
	boolean calculatefps = true;
	int FrameLimit = 60;
	boolean Displayfps = false;
	static ArrayList<Sprite> spritelist = new ArrayList<Sprite>();
	//Privates
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
	//Constructor
	public Nanoengine(int width, int height)
	{
		resY = width; resY = height;
		System.out.println("Render engine starting");
		this.setIgnoreRepaint( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Canvas canvas = new Canvas();
		canvas.setIgnoreRepaint( true );
		canvas.setSize(resX,resY);                
		// Add canvas to game window...
		this.add( canvas );
		this.pack();
		this.setVisible( true );
		 // Create BackBuffer...
	    canvas.createBufferStrategy( 2 );
	    buffer = canvas.getBufferStrategy();
	    // Get graphics configuration...
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    GraphicsConfiguration gc = gd.getDefaultConfiguration();
	    // Create off-screen drawing surface
	    bi = gc.createCompatibleImage( resX, resY );
	    //HERE WE GO
	    System.out.println("NANOENGINE RENDER INITIATED (res: "+resX+"x"+resY+")");
	}
	public void render()
	{
		try {
	    	graphics = null;
	        // clear back buffer...
	        g2d = bi.createGraphics();
	        g2d.setColor( background );
	        g2d.fillRect( 0, 0, resX, resY);                  
	    	//-----------ACTUAL RENDER CRAP GOES IN HERE---------
	        
	        // Draw dem sprites
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
		   // Do the waiting 	
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
	    static void addsprite(Sprite spritetobeadded)
	    {
	  	  	spritelist.add(spritetobeadded);
	  	  System.out.println("Spritelist now contains: ");
	  	  System.out.println("Entry \tName \tZ-depth");	
	    	for(int i=0;i<spritelist.size();i++)
	    	{
	    	System.out.println(i+"\t"+spritelist.get(i).Name+"\t"+spritelist.get(i).z);	
	    	}
	    	// --------MOST IMPORTANT LINE IN THE JOINT ---
	    	Collections.sort(spritelist);
	    	// ------------MEET THE Z-BUFFER WIZARD!-------
	    }
	}
