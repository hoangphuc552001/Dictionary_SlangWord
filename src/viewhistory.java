import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.FileWriter;
/**
 * Created by Le Hoang Phuc-19127059
 * View History function frame
 */
public class viewhistory extends JFrame implements ActionListener{
	JButton btnBack;
	JLabel jlbClearHistory;
	/**
	 * default constructor
	 * @throws Exception
	 */
    public viewhistory() throws Exception {
		JFrame temp=this;
		Container container = this.getContentPane();
		SlangWord slangWord=SlangWord.getInstance();
        //Top Pannel
		JPanel topPanel=new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
		JLabel titleLabel = new JLabel();
		titleLabel.setText("HISTORY SEARCH LIST");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("Monaco", Font.PLAIN, 35));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		topPanel.add(titleLabel);
		//
		JPanel jPaneltitle=new JPanel();
		jPaneltitle.setSize((new Dimension(50, 50)));
		jPaneltitle.setLayout(new BoxLayout(jPaneltitle, BoxLayout.LINE_AXIS));
		jPaneltitle.setBackground(new Color(222, 52, 49));
		jPaneltitle.add(titleLabel);
		//
		JPanel jpEnd=new JPanel();
		jpEnd.setLayout(new BoxLayout(jpEnd, BoxLayout.PAGE_AXIS));
		jpEnd.add(Box.createRigidArea(new Dimension(0, 30)));
        jpEnd.add(jPaneltitle);
        jpEnd.add(Box.createRigidArea(new Dimension(0, 5)));
		topPanel.add(jpEnd);
		//Mid Pannel
		JPanel jMid=new JPanel();
		jMid.setLayout(new BoxLayout(jMid, BoxLayout.Y_AXIS));
		String[] columnNames = { "Slang Word", "Meaning", "Data Time" };
		String[][] historyTable=slangWord.readFileHistory(SlangWord.FILE_SLANGWORD_HISTORY);
		JTable j=new JTable(historyTable, columnNames);
		j.setAlignmentX(CENTER_ALIGNMENT);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		j.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		j.setBounds(30, 40, 200, 300);
		j.setRowSelectionAllowed(false);
		j.setEnabled(false);
		JScrollPane sp = new JScrollPane(j);
		jMid.add(sp);
		JLabel jlb=new JLabel();
		jlb.setAlignmentX(CENTER_ALIGNMENT);
		jlb.setText("You searched "+ slangWord.HistorySize+" words");
		jlb.setAlignmentX(CENTER_ALIGNMENT);
		jMid.add(Box.createRigidArea(new Dimension(0, 5)));
		jMid.add(jlb);
		jMid.add(Box.createRigidArea(new Dimension(0, 20)));
		jlbClearHistory=new JLabel();
		jlbClearHistory.setText("Click here to clear history");
		jlbClearHistory.setAlignmentX(CENTER_ALIGNMENT);
		jlbClearHistory.setFont(new Font("Monaco", Font.PLAIN, 20));
		jlbClearHistory.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					temp.dispose();
					new FileWriter(SlangWord.FILE_SLANGWORD_HISTORY, false).close();
					new viewhistory();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		jMid.add(jlbClearHistory);
		//Bottom Pannel
		JPanel bottomPanel = new JPanel();
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setFocusable(false);
		btnBack.setAlignmentX(CENTER_ALIGNMENT);
		btnBack.setBackground(Color.white);
		btnBack.setForeground(new Color(222, 52, 49));
		bottomPanel.add(btnBack);
		bottomPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        // Add to container
        container.setLayout(new BorderLayout());
		container.add(topPanel,BorderLayout.PAGE_START);
		container.add(jMid, BorderLayout.CENTER);
		container.add(bottomPanel,BorderLayout.PAGE_END);
		// Setting JFrame
		this.setTitle("List Slang Words");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(670, 680);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	 /**
     * set action listener
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnBack) {
			this.dispose();
			new menuframe();
		}
	}

	/**
	 * event dispatch thread
	 */
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewhistory frame = new viewhistory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}