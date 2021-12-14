import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class findbasedsw extends JFrame implements ActionListener {
    JButton btnBack, ok, loadAll;
    JTextField jIDf;
    SlangWord slangWord = SlangWord.getInstance();
    JTable j;

    /**
     * default constructor
     *
     * @throws Exception
     */
    public findbasedsw() throws Exception {

        Container container = this.getContentPane();
        //top pannel
        //Top Pannel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("List Definition of Slang Words");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Monaco", Font.PLAIN, 30));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        topPanel.add(titleLabel);
        //
        JPanel jPaneltitle = new JPanel();
        jPaneltitle.setSize((new Dimension(50, 50)));
        jPaneltitle.setLayout(new BoxLayout(jPaneltitle, BoxLayout.LINE_AXIS));
        jPaneltitle.setBackground(new Color(222, 52, 49));
        jPaneltitle.add(titleLabel);
        //
        JPanel jpEnd = new JPanel();
        jpEnd.setLayout(new BoxLayout(jpEnd, BoxLayout.PAGE_AXIS));
        jpEnd.add(Box.createRigidArea(new Dimension(0, 30)));
        jpEnd.add(jPaneltitle);
        jpEnd.add(Box.createRigidArea(new Dimension(0, 5)));
        topPanel.add(jpEnd);
        //size
        JLabel jlb = new JLabel();
        jlb.setAlignmentX(CENTER_ALIGNMENT);
        jlb.setText("Total: " + slangWord.getSize() + " words");
        topPanel.add(jlb);
        //id
        JPanel jInfor = new JPanel();
        JLabel jId = new JLabel("Slang Word");
        jIDf = new JTextField(10);
        jIDf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String id = jIDf.getText().toString();
                    String[][] findDef = slangWord.findSlangWord(id);
                    if (findDef!=null){
                        for (int i=0;i<findDef.length;i++){
                            try {
                                slangWord.writeFileHisory(findDef[i][1], findDef[i][2]);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    String[] columnNames = {"STT", "Slang Word", "Meaning"};
                    DefaultTableModel model = new DefaultTableModel(findDef, columnNames);
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    j.setModel(model);
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                    j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                    j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                    j.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                }
            }
        });
        ok = new JButton("OK");
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        ok.addActionListener(this);
        jInfor.add(jId);
        jInfor.add(jIDf);
        jInfor.add(ok);
        topPanel.add(jInfor);
        //mid pannel
        JPanel jMid = new JPanel();
        jMid.setLayout(new BoxLayout(jMid, BoxLayout.PAGE_AXIS));
        String[] columnNames = {"STT", "Slang Word", "Meaning"};
        String[][] findSW = slangWord.getSW_Data();
        j = new JTable(findSW, columnNames);
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
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        btnBack.setFocusable(false);
        btnBack.setAlignmentX(CENTER_ALIGNMENT);
        btnBack.setBackground(Color.white);
        btnBack.setForeground(new Color(222, 52, 49));
        jMid.add(sp);
        JPanel jend = new JPanel();
        jend.add(btnBack);
        loadAll = new JButton("Load Again");
        loadAll.addActionListener(this);
        loadAll.setFocusable(false);
        loadAll.setAlignmentX(CENTER_ALIGNMENT);
        loadAll.setBackground(Color.white);
        loadAll.setForeground(new Color(48, 93, 150));
        jend.add(loadAll);
        //add to container
        container.setLayout(new BorderLayout());
        container.add(topPanel, BorderLayout.PAGE_START);
        container.add(jMid, BorderLayout.CENTER);
        container.add(Box.createRigidArea(new Dimension(30, 0)), BorderLayout.WEST);
        container.add(Box.createRigidArea(new Dimension(30, 0)), BorderLayout.EAST);
        container.add(jend, BorderLayout.PAGE_END);
        // Setting JFrame
        this.setTitle("Find based on Slang Word");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(700, 700);
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
            FindWord.GUI();
        } else if (e.getSource().equals(ok)) {
            String id = jIDf.getText().toString();
            String[][] findDef = slangWord.findSlangWord(id);
            if (findDef!=null){
                for (int i=0;i<findDef.length;i++){
                    try {
                        slangWord.writeFileHisory(findDef[i][1], findDef[i][2]);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            String[] columnNames = {"STT", "Slang Word", "Meaning"};
            DefaultTableModel model = new DefaultTableModel(findDef, columnNames);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            j.setModel(model);
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            j.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        } else if (e.getSource().equals(loadAll)) {
            String id = jIDf.getText().toString();
            String[][] findDef = slangWord.getSW_Data();
            String[] columnNames = {"STT", "Slang Word", "Meaning"};
            DefaultTableModel model = new DefaultTableModel(findDef, columnNames);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            j.setModel(model);
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            j.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        }
    }

    /**
     * Event dispatch thread
     */
    public static void GUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    findbasedsw frame = new findbasedsw();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
