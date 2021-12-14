import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class addslangword extends JFrame implements ActionListener {
    JButton Add, Cancel;
    JTextField jtx, jtx1;
    SlangWord slangWord = SlangWord.getInstance();

    public addslangword() {
        Container container = this.getContentPane();
        //
        JPanel title = new JPanel();
        title.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel title_ = new JLabel("Input slang word");
        title_.setForeground(new Color(235, 116, 52));
        title_.setFont(new Font("Monaco", Font.PLAIN, 15).deriveFont(Font.BOLD));
        title.add(title_);
        title.setAlignmentX(LEFT_ALIGNMENT);
        //
        JLabel jsl = new JLabel("Slang word");
        jtx = new JTextField(10);
        JLabel jmn = new JLabel("Meaning");
        jtx1 = new JTextField(10);
        title.add(Box.createRigidArea(new Dimension(100, 0)));
        title.add(jsl);
        title.add(Box.createRigidArea(new Dimension(1, 0)));
        title.add(jtx);
        title.add(Box.createRigidArea(new Dimension(80, 0)));
        title.add(jmn);
        title.add(Box.createRigidArea(new Dimension(17, 0)));
        title.add(jtx1);
        Add = new JButton("Add");
        Add.setAlignmentX(CENTER_ALIGNMENT);
        Add.addActionListener(this);
        Add.setFocusable(false);
        Add.setBackground(new Color(58, 235, 52));
        Add.setForeground(Color.white);
        Add.setUI(new stylebutton());
        Cancel = new JButton("Cancel");
        Cancel.setAlignmentX(CENTER_ALIGNMENT);
        Cancel.addActionListener(this);
        Cancel.setFocusable(false);
        Cancel.setBackground(new Color(232, 55, 35));
        Cancel.setForeground(Color.white);
        Cancel.setUI(new stylebutton());
        JPanel jpadd = new JPanel();
        jpadd.add(Add);
        jpadd.add(Cancel);
        jpadd.setAlignmentX(CENTER_ALIGNMENT);
        //title.add(Add);
        title.setAlignmentX(LEFT_ALIGNMENT);
        //add to container
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.add(title);
        container.add(jpadd);
        // Setting JFrame
        this.setTitle("Add Slang Words");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(340, 200);
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
                    addslangword frame = new addslangword();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String slang = jtx.getText(), meaning = jtx1.getText();
        if (e.getSource() == Add) {
            if (slang.length() == 0 || meaning.length() == 0) {
                this.dispose();
                JOptionPane.showMessageDialog(this, "Empty input!!!", "Alert", JOptionPane.WARNING_MESSAGE);
                 addslangword.GUI();
            } else {
                if (slangWord.checkSlang(slang) == false) {
                    try {
                        slangWord.addSlangWord(slang, meaning, 1, 0);
                        JOptionPane.showMessageDialog(this, "Added successfully");
                        this.dispose();
                        ///
                        JFrame ff=new JFrame();
                        Container container = ff.getContentPane();
                        //Top Pannel
                        JPanel topPanel=new JPanel();
                        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
                        JLabel titleLabel = new JLabel();
                        titleLabel.setText("SlangWord just added");
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
                        String[][] getSWdata=new String[1][3];
                        getSWdata[0][0]="1";
                        getSWdata[0][1]=slang;
                        getSWdata[0][2]=meaning;
                        JTable j=new JTable(getSWdata, columnNames);
                        j.setAlignmentX(CENTER_ALIGNMENT);
                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                        j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                        j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                        j.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                        j.setBounds(30, 40, 200, 300);
                        j.setEnabled(false);
                        JScrollPane sp = new JScrollPane(j);
                        jMid.add(sp);
                        //Bottom Pannel
                        JButton btnBack;
                        JPanel bottomPanel = new JPanel();
                        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                        btnBack = new JButton("Back");
                        btnBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ff.dispose();
                                addslangword.GUI();
                            }
                        });
                        btnBack.setFocusable(false);
                        btnBack.setAlignmentX(CENTER_ALIGNMENT);
                        btnBack.setBackground(Color.white);
                        btnBack.setForeground(new Color(222, 52, 49));
                        bottomPanel.add(btnBack);
                        bottomPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                        // Add to container
                        container.setLayout(new BorderLayout());
                        container.add(topPanel,BorderLayout.PAGE_START);
                        container.add(jMid, BorderLayout.CENTER);
                        container.add(bottomPanel,BorderLayout.PAGE_END);
                        // Setting JFrame
                        ff.setTitle("List Slang Words");
                        ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        ff.setVisible(true);
                        ff.setSize(670, 300);
                        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                        ff.setLocation(dim.width / 2 - ff.getSize().width / 2, dim.height / 2 - ff.getSize().height / 2);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    int a = JOptionPane.showConfirmDialog(this, "Do you want to overwrite slang word?");
                    if (a == JOptionPane.CANCEL_OPTION) {
                        jtx1.setText("");
                        jtx.setText("");
                    } else if (a == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(this, "Duplicated successfully");
                        try {
                            slangWord.addSlangWord(slang, meaning, 2, 0);
                            this.dispose();
                            ///
                            JFrame ff=new JFrame();
                            Container container = ff.getContentPane();
                            //Top Pannel
                            JPanel topPanel=new JPanel();
                            topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
                            JLabel titleLabel = new JLabel();
                            titleLabel.setText("SlangWord just added");
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
                            String[][] getSWdata=new String[1][3];
                            getSWdata[0][0]="1";
                            getSWdata[0][1]=slang;
                            getSWdata[0][2]=meaning;
                            JTable j=new JTable(getSWdata, columnNames);
                            j.setAlignmentX(CENTER_ALIGNMENT);
                            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                            j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                            j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                            j.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                            j.setBounds(30, 40, 200, 300);
                            j.setEnabled(false);
                            JScrollPane sp = new JScrollPane(j);
                            jMid.add(sp);
                            //Bottom Pannel
                            JButton btnBack;
                            JPanel bottomPanel = new JPanel();
                            bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                            btnBack = new JButton("Back");
                            btnBack.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ff.dispose();
                                    addslangword.GUI();
                                }
                            });
                            btnBack.setFocusable(false);
                            btnBack.setAlignmentX(CENTER_ALIGNMENT);
                            btnBack.setBackground(Color.white);
                            btnBack.setForeground(new Color(222, 52, 49));
                            bottomPanel.add(btnBack);
                            bottomPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                            // Add to container
                            container.setLayout(new BorderLayout());
                            container.add(topPanel,BorderLayout.PAGE_START);
                            container.add(jMid, BorderLayout.CENTER);
                            container.add(bottomPanel,BorderLayout.PAGE_END);
                            // Setting JFrame
                            ff.setTitle("List Slang Words");
                            ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            ff.setVisible(true);
                            ff.setSize(670, 300);
                            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                            ff.setLocation(dim.width / 2 - ff.getSize().width / 2, dim.height / 2 - ff.getSize().height / 2);
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    } else if (a == JOptionPane.YES_OPTION) {
                        this.dispose();
                        JFrame jf = new JFrame();
                        jf.setTitle("Choose word");
                        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        jf.setVisible(true);
                        jf.setSize(380, 380);
                        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                        jf.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
                        Container con = new Container();
                        con = jf.getContentPane();
                        con.setLayout(new BorderLayout());
                        JPanel jpn = new JPanel();
                        JLabel jb = new JLabel("Click to choose meaning to overwrite");
                        jb.setFont(new Font("Monaco", Font.PLAIN, 20));
                        jpn.add(jb);
                        jpn.setAlignmentX(CENTER_ALIGNMENT);
                        String[] columnNames = {"STT", "Words"};
                        JTable j = new JTable(slangWord.getMeaning(slang), columnNames);
                        j.setAlignmentX(CENTER_ALIGNMENT);
                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                        j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                        j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                        j.getColumnModel().getColumn(0).setPreferredWidth(10);
                        j.getColumnModel().getColumn(1).setPreferredWidth(370);
                        j.setBounds(30, 40, 200, 300);
                        j.setRowHeight(25);
                        JButton jBack=new JButton("Back");
                        jBack = new JButton("Cancel");
                        jBack.setAlignmentX(CENTER_ALIGNMENT);
                        jBack.addActionListener(this);
                        jBack.setFocusable(false);
                        jBack.setBackground(new Color(232, 55, 35));
                        jBack.setForeground(Color.white);
                        jBack.setUI(new stylebutton());
                        con.add(jpn, BorderLayout.PAGE_START);
                        con.add(j, BorderLayout.CENTER);
                        JPanel end=new JPanel();
                        end.setLayout(new FlowLayout(FlowLayout.CENTER));
                        end.add(jBack);
                        jBack.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        jf.dispose();
                                                        addslangword.GUI();
                                                    }
                                                });
                                con.add(end, BorderLayout.PAGE_END);
                        ListSelectionModel cellSelectionModel = j.getSelectionModel();
                        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
                            @Override
                            public void valueChanged(ListSelectionEvent e) {
                                // TODO Auto-generated method stub
                                int[] selectedRow = j.getSelectedRows();
                                String selectedData = null;
                                String selectedDataNameWord = null;
                                for (int i = 0; i < selectedRow.length; i++) {
                                    selectedData = (String) j.getValueAt(selectedRow[i], 0);
                                    selectedDataNameWord = (String) j.getValueAt(selectedRow[i], 1);
                                }
                                int a = JOptionPane.showConfirmDialog(null, "Did you want this meaning: " + selectedDataNameWord + "?");
                                if (a == JOptionPane.YES_OPTION) {
                                    int index = Integer.valueOf(selectedData).intValue();
                                    try {
                                        slangWord.addSlangWord(slang, meaning, 3, index);
                                        jf.dispose();
                                        JOptionPane.showMessageDialog(jf, "Overwrited successfully");
                                        ///
                                        JFrame ff=new JFrame();
                                        Container container = ff.getContentPane();
                                        //Top Pannel
                                        JPanel topPanel=new JPanel();
                                        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
                                        JLabel titleLabel = new JLabel();
                                        titleLabel.setText("SlangWord just added");
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
                                        String[][] getSWdata=new String[1][3];
                                        getSWdata[0][0]="1";
                                        getSWdata[0][1]=slang;
                                        getSWdata[0][2]=meaning;
                                        JTable j=new JTable(getSWdata, columnNames);
                                        j.setAlignmentX(CENTER_ALIGNMENT);
                                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                                        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                                        j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                                        j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                                        j.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                                        j.setBounds(30, 40, 200, 300);
                                        j.setEnabled(false);
                                        JScrollPane sp = new JScrollPane(j);
                                        jMid.add(sp);
                                        //Bottom Pannel
                                        JButton btnBack;
                                        JPanel bottomPanel = new JPanel();
                                        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                                        btnBack = new JButton("Back");
                                        btnBack.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                ff.dispose();
                                                addslangword.GUI();
                                            }
                                        });
                                        btnBack.setFocusable(false);
                                        btnBack.setAlignmentX(CENTER_ALIGNMENT);
                                        btnBack.setBackground(Color.white);
                                        btnBack.setForeground(new Color(222, 52, 49));
                                        bottomPanel.add(btnBack);
                                        bottomPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                                        // Add to container
                                        container.setLayout(new BorderLayout());
                                        container.add(topPanel,BorderLayout.PAGE_START);
                                        container.add(jMid, BorderLayout.CENTER);
                                        container.add(bottomPanel,BorderLayout.PAGE_END);
                                        // Setting JFrame
                                        ff.setTitle("List Slang Words");
                                        ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        ff.setVisible(true);
                                        ff.setSize(670, 300);
                                        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                                        ff.setLocation(dim.width / 2 - ff.getSize().width / 2, dim.height / 2 - ff.getSize().height / 2);
                                    } catch (IOException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }
            }
        } else if (e.getSource() == Cancel) {
            this.dispose();
            new menuframe();
        }
    }
}
