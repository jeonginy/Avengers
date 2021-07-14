package Lottery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
class Confirm extends JFrame {
	int onOff;
	public Confirm(int select, int[][] selectedNum) {
		JPanel userBought = new JPanel();
		JLabel explain1 ;
		JLabel explain2 ;
		userBought.setLayout(new BoxLayout(userBought, BoxLayout.Y_AXIS));
		
		JPanel img1 = new JPanel();
		ImageIcon aa = new ImageIcon("Buttons/HOWMANY.gif");
		explain1= new JLabel(aa);
		ImageIcon aa2 = new ImageIcon("Buttons/" + select + ".gif");
		JLabel aa1 = new JLabel(aa2);
		img1.add(explain1);
		img1.add(aa1);
		userBought.add(img1);
		
		JPanel img2 = new JPanel();
		ImageIcon bb = new ImageIcon("Buttons/PRICEE.gif");
		explain2 = new JLabel(bb) ;
		img2.add(explain2);
		
		ImageIcon cc = new ImageIcon("Buttons/" + select + "000.gif");
		JLabel bb1 = new JLabel(cc);
		img2.add(bb1);
		userBought.add(img2);
		
		JPanel eury = new JPanel();
		ImageIcon prc = new ImageIcon("Buttons/purchase.gif");
		JLabel games = new JLabel(prc);
		
		games.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onOff = 1;
				System.out.println(onOff);
				new outcome(selectedNum, select);
				dispose();
			}
		});
		
		ImageIcon prc1 = new ImageIcon("Buttons/close.gif");
		JLabel games1 = new JLabel(prc1);
		games1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onOff = 0;
				dispose();
			}
		});
	

		
		eury.add(games);
		eury.add(games1);
		userBought.add(eury);
		

		add(userBought);
		
		
		

		showGUI();

	}
	
	private void showGUI() {
		pack();
		setLocation(500, 200);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}