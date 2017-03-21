package thingy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Thingy {
	private static BigInteger k;
	private static boolean[][] graph;
	
	public static void setGraph() {
		graph = new boolean[17][106];
		for (int y = 0;y<graph.length;y++) {
			for (int x = 0;x<graph[0].length;x++) {
				graph[y][x] = func(graph[0].length-1-x, y);
			}
		}
	}
	
	public static boolean func(int xVal, int yVal) {
//		1/2<floor(mod(floor(y/17)*2^(-17*floor(x)-mod(floor(y), 17)),2))
		BigInteger x = BigInteger.valueOf(xVal);
		BigInteger y = BigInteger.valueOf(yVal).add(k);
		return 0.5<y.divideAndRemainder(BigInteger.valueOf(17))[0].divideAndRemainder(BigInteger.valueOf(2).pow(BigInteger.valueOf(17).multiply(x).add(y.mod(BigInteger.valueOf(17))).intValue()))[0].mod(BigInteger.valueOf(2)).doubleValue();
	}
	
	public static boolean[][] getGraph() {
		return graph;
	}

	public static void main(String[] args) {
		Window.init();
		k = new BigInteger("960939379918958884971672962127852754715004339660129306651505519271702802395266424689642842174350718121267153782770623355993237280874144307891325963941337723487857735749823926629715517173716995165232890538221612403238855866184013235585136048828693337902491454229288667081096184496091705183454067827731551705405381627380967602565625016981482083418783163849115590225610003652351370343874461848378737238198224849863465033159410054974700593138339226497249461751545728366702369745461014655997933798537483143786841806593422227898388722980000748404719");
		setGraph();
	}
}

@SuppressWarnings("serial")
class Renderer extends JPanel {
	private static Graphics2D g;
	private static final int SIZE = 12, MARGIN = 100;
	
	@Override
	public void paintComponent(Graphics g0) {
		g = (Graphics2D) g0;
		setBackground(Color.WHITE);
		super.paintComponent(g);
		try {
			drawDebug();
			
			for (int y = 0;y<Thingy.getGraph().length;y++) {
				for (int x = 0;x<Thingy.getGraph()[0].length;x++) {
					if (Thingy.getGraph()[y][x]) {
						g.fillRect(MARGIN+x*SIZE, MARGIN+y*SIZE, SIZE, SIZE);
					}
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private final static int textX = 25, textY = 30, textSize = 15;
	private void drawDebug() {
		StringBuilder text = new StringBuilder();

		text.append("Window = "+Window.width()+"x"+Window.height());

		String[] textLines = text.toString().split("\\$");
		g.setColor(Color.GREEN);
		g.setFont(new Font("Helvetica", Font.BOLD, textSize));
		for (int i = 0;i<textLines.length;i++) {
			g.drawString(textLines[i], textX, textY+textSize*i);
		}
	}


	public static Graphics2D getG() {
		return g;
	}
}

@SuppressWarnings("serial")
class Window extends JFrame {
	private static JFrame frame;
//	private static Input input;
	private static Renderer rendererer;

	private static float WINDOW_SCREEN_RATIO = 0.8f;
	
	public static void init() {
		rendererer = new Renderer();
		rendererer.setDoubleBuffered(true);
//		input = new Input();
		frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("BG");
		GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		frame.setPreferredSize(new Dimension((int)(screen.getDisplayMode().getWidth()*WINDOW_SCREEN_RATIO), (int)(screen.getDisplayMode().getHeight()*WINDOW_SCREEN_RATIO)));
		frame.pack();
		frame.setLocationRelativeTo(null);
//		frame.addKeyListener(input);
//		frame.addMouseMotionListener(input);
//		frame.addMouseListener(input);
//		frame.addMouseWheelListener(input);
//		frame.addWindowListener(input);
//		frame.addComponentListener(input);
		frame.add(rendererer);
		System.out.println("Window size: "+width()+","+height());
		frame.setVisible(true);
	}

	public static Renderer getRendererer() {
		return rendererer;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static int height() {
		return frame.getHeight();
	}

	public static int width() {
		return frame.getWidth();
	}

	public static int centerX() {
		return frame.getWidth()/2;
	}

	public static int centerY() {
		return frame.getHeight()/2;
	}
}
