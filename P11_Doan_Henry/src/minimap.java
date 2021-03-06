import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Shows the minimap and the given RGB value of the given point.
 * 
 * @author Henry Doan
 */
public class minimap extends JPanel {
	
	private static final long serialVersionUID = 1L; 
	private ArrayList<BufferedImage> images; 
	private int frameNumber;
	
	// have materials here
	private BufferedImage Minimap;
	private BufferedImage Plains;
	
	/** 
	 * Construct a panel with a starter images  
	 * @param img  
	 * @throws IOException 
	 */ 
	
	public minimap() {
		
		//try catch of the material 
		try {
			Minimap = ImageIO.read(new File("./imgs/minimap.png"));
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
		JPanel minimapPanel = new JPanel();
		
		minimapPanel.setLayout(new GridLayout(Minimap.getWidth(), Minimap.getHeight()));	
		
		for(int i = 0; i < Minimap.getWidth(); i++ ) {
			for (int x = 0; x < Minimap.getHeight(); x++){
				int col = Minimap.getRGB(x , i);
				
				if  (col == -8466898) {
					// set to tiles for buffer images
					ImagePanel imgPanel = 
				} else if(col ==)
			}
		}
		
	}
	
	
		

	
	/**
	 * Add image to the ArrayList of images  
	 * @param img  
	 */ 
	
	public void add(BufferedImage img) {
		images.add(img);
	}
	
	/**
	 * Cycle through the frames using the % mod operation  
	 */ 
	public void nextFrame() { 
		frameNumber = (frameNumber + 1)%images.size(); 
	}
	
	/** 
	 * Implement the paint method to draw the images  
	 */ 
	@Override   
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		g.drawImage(images.get(frameNumber),  0,  0, null);
	}
	
	public static void main(String[] args) throws IOException {
		// panel Name
		JFrame frame = new JFrame("Mini Map");
		
		//Getting the image for the grid
		BufferedImage image = ImageIO.read(
		         new File("./imgs/minimap.png"));
		
		//refactor
		//getting the image for the  scroll bar
		ImageIcon ii = new ImageIcon("./imgs/minimap.png");
	    JScrollPane jsp = new JScrollPane(new JLabel(ii));
	    frame.getContentPane().add(jsp);

	    //see the set RGB value of the given point
	    int w = image.getWidth();
	    int h = image.getHeight();
	    int[] dataBuffInt = image.getRGB(0, 0, w, h, null, 0, w); 

	    Color c = new Color(dataBuffInt[100]);
	    
	    // RGB value 126, 206, 46 of plains and prints it out in the console.
	    System.out.println(c.getRed());
	    System.out.println(c.getGreen());
	    System.out.println(c.getBlue());;
	    
	    
	    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(300, 300));
	    frame.pack();
	    frame.setVisible(true);
	}

}
