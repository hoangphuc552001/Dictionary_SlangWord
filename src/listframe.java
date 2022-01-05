import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by Le Hoang Phuc-19127059
 * List frame function
 */
public class listframe extends JFrame implements ActionListener{
	JButton btnBack;
	/**
	 * default constructor
	 * @throws Exception
	 */
    public listframe() throws Exception {
		Container container = this.getContentPane();
		SlangWord slangWord=SlangWord.getInstance();
        //Top Pannel
		JPanel topPanel=new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
		JLabel titleLabel = new JLabel();
		titleLabel.setText("SLANGWORDS  LIST");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("Monaco", Font.PLAIN, 35));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		topPanel.add(titleLabel);
		JLabel jlb=new JLabel();
		jlb.setAlignmentX(CENTER_ALIGNMENT);
		jlb.setText("Total: "+slangWord.getSize()+" words");
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
		topPanel.add(jlb);
		//Mid Pannel
		JPanel jMid=new JPanel();
		jMid.setLayout(new BoxLayout(jMid, BoxLayout.Y_AXIS));
		String[] columnNames = { "STT", "Slang Word", "Meaning" };
		JTable j=new JTable(slangWord.getSW_Data(), columnNames);
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
	 * Event dispatch thread
	 */
	public static void GUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    listframe frame = new listframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	 /**
     * set action listener
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnBack) {
			this.dispose();
			menuframe.GUI();
		}
	}

}