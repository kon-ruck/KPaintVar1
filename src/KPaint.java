import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class KPaint extends JFrame implements ActionListener{
	MyPanel myPanel = new MyPanel();
	
	JMenuBar jMenuBar = new JMenuBar();
	JMenuItem jMenuItem = new JMenuItem("保存");
	
	JFileChooser jFileChooser = new JFileChooser();
	
	File dir = new File("C:\\Users\\owner\\Desktop");
	File file = new File("sumple.png");
	
	static int winX = 800;
	static int winY = 500;
	
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new KPaint();
	}

	public KPaint() {
		// TODO 自動生成されたコンストラクター・スタブ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jMenuItem.addActionListener(this);
		jMenuBar.add(jMenuItem);
		
		jFileChooser.setCurrentDirectory(dir);
		jFileChooser.setSelectedFile(file);
		
		setJMenuBar(jMenuBar);
		getContentPane().add(myPanel);
		setSize(winX, winY);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		// 保存ボタンが押されたときpng形式で保存する
		int f = jFileChooser.showSaveDialog(this);
		if(f == 0) {
			dir = new File(jFileChooser.getSelectedFile().getParent());
			file = new File(jFileChooser.getSelectedFile().getName());
			try {
				ImageIO.write(myPanel.bufferedImage, "png", new File(dir.getPath() + "\\" + file.getPath()));
				System.out.println(dir.getPath() + "\\" + file.getPath());
			} catch (IOException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}
	}
}
