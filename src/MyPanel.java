import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener{
	Graphics graphics;
	
//	このバッファに描画内容を保持する
	BufferedImage bufferedImage;
	
	public MyPanel() {
		// TODO 自動生成されたコンストラクター・スタブ
		bufferedImage = new BufferedImage(KPaint.winX, KPaint.winY, BufferedImage.TYPE_INT_ARGB);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自動生成されたメソッド・スタブ
		super.paintComponent(g);
//		画面幅が変わった時のための再描画 ==========
		BufferedImage tmpBufferedImage = bufferedImage;
		bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
//		背景色の設定
		Graphics2D graphics2d = bufferedImage.createGraphics();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics2d.drawImage(tmpBufferedImage, 0, 0, this);
		g.drawImage(bufferedImage, 0, 0, this);
//		再描画処理終了 ==========
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Graphics2D graphics2d = bufferedImage.createGraphics();

		graphics2d.setColor(Color.black);
		graphics2d.fillOval(e.getX()-2, e.getY()-2, 5, 5);
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Graphics2D graphics2d = bufferedImage.createGraphics();
		graphics2d.setColor(Color.black);
		graphics2d.fillOval(e.getX()-2, e.getY()-2, 5, 5);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}
}
