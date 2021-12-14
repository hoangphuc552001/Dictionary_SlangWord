import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class randomslangword extends JFrame implements ActionListener {

    //
    JLabel slanglabel, meanininglabel;
    JTextField slang_text,meaning_text;
    JButton back,refresh;
    SlangWord slangWord = SlangWord.getInstance();
    /**
     * default constructor
     *
     * @throws Exception
     */
    public randomslangword() throws Exception {
        Container container = this.getContentPane();
        JPanel topPanel=new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("RANDOM SLANGWORD");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Monaco", Font.PLAIN, 35));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        topPanel.add(titleLabel);
        JPanel jPaneltitle=new JPanel();
        jPaneltitle.setSize((new Dimension(50, 50)));
        jPaneltitle.setLayout(new BoxLayout(jPaneltitle, BoxLayout.LINE_AXIS));
        jPaneltitle.setBackground(new Color(222, 52, 49));
        jPaneltitle.add(titleLabel);
        JPanel jpEnd=new JPanel();
        jpEnd.setLayout(new BoxLayout(jpEnd, BoxLayout.PAGE_AXIS));
        jpEnd.add(Box.createRigidArea(new Dimension(0, 30)));
        jpEnd.add(jPaneltitle);
        jpEnd.add(Box.createRigidArea(new Dimension(0, 5)));
        topPanel.add(jpEnd);
        slanglabel = new JLabel();
        slanglabel.setText("Slang Word :");
        slanglabel.setFont(new Font("Monaco", Font.BOLD, 16));
        slang_text = new JTextField();
        slang_text.setPreferredSize(new Dimension(30,30));
        slang_text.setEditable(false);
        JPanel toppanel=new JPanel();
        toppanel.setLayout(new BoxLayout(toppanel,BoxLayout.LINE_AXIS));
        toppanel.add(Box.createRigidArea(new Dimension(30,0)));
        toppanel.add(slanglabel);
        toppanel.add(Box.createRigidArea(new Dimension(15,0)));
        toppanel.add(slang_text);
        toppanel.add(Box.createRigidArea(new Dimension(30,0)));
        JPanel pp=new JPanel();
        pp.setLayout(new BoxLayout(pp,BoxLayout.PAGE_AXIS));
        pp.add(Box.createRigidArea(new Dimension(0,30)));
        pp.add(toppanel);
        meanininglabel = new JLabel();
        meanininglabel.setText("Meaning :");
        meanininglabel.setFont(new Font("Monaco", Font.BOLD, 16));
        meaning_text = new JTextField();
        meaning_text.setPreferredSize(new Dimension(30,30));
        meaning_text.setEditable(false);
        JPanel toppanel1=new JPanel();
        toppanel1.setLayout(new BoxLayout(toppanel1,BoxLayout.LINE_AXIS));
        toppanel1.add(Box.createRigidArea(new Dimension(30,0)));
        toppanel1.add(meanininglabel);
        toppanel1.add(Box.createRigidArea(new Dimension(39,0)));
        toppanel1.add(meaning_text);
        toppanel1.add(Box.createRigidArea(new Dimension(30,0)));
        JPanel pp1=new JPanel();
        pp1.setLayout(new BoxLayout(pp1,BoxLayout.PAGE_AXIS));
        pp1.add(Box.createRigidArea(new Dimension(0,30)));
        pp1.add(toppanel1);
        //
        String[] randWord=slangWord.RandomSlangWord();
        slang_text.setFont(slang_text.getFont().deriveFont(Font.PLAIN, 14f));
        slang_text.setText(randWord[0]);
        meaning_text.setFont(meaning_text.getFont().deriveFont(Font.PLAIN, 14f));
        meaning_text.setText(randWord[1]);
        back = new JButton("Back");
        back.setAlignmentX(CENTER_ALIGNMENT);
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBackground(new Color(232, 55, 35));
        back.setForeground(Color.white);
        back.setUI(new stylebutton());
        back.setPreferredSize(new Dimension(70,30));
        //
        refresh = new JButton("Refresh");
        refresh.setAlignmentX(CENTER_ALIGNMENT);
        refresh.addActionListener(this);
        refresh.setFocusable(false);
        refresh.setBackground(new Color(18, 0, 147));
        refresh.setForeground(Color.white);
        refresh.setUI(new stylebutton());
        refresh.setPreferredSize(new Dimension(75,30));
        //
        JPanel jPanel=new JPanel();
        jPanel.add(Box.createRigidArea(new Dimension(0,40)));
        jPanel.add(refresh);
        jPanel.add(back);
        jPanel.setAlignmentX(CENTER_ALIGNMENT);
        pp1.add(jPanel);
        container.setLayout(new BorderLayout());
        //add to container
        JPanel ppp=new JPanel();
        ppp.setLayout(new BoxLayout(ppp,BoxLayout.PAGE_AXIS));
        ppp.add(pp);
        ppp.add(pp1);
        container.add(topPanel,BorderLayout.PAGE_START);
        container.add(ppp,BorderLayout.CENTER);

        // Setting JFrame
        this.setTitle("Random Slang Word");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(460, 300);
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
                    randomslangword frame = new randomslangword();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(back)){
            this.dispose();
            menuframe.GUI();
        }
        else if (e.getSource().equals(refresh)){
            String[] randWord=slangWord.RandomSlangWord();
            slang_text.setFont(slang_text.getFont().deriveFont(Font.PLAIN, 14f));
            slang_text.setText(randWord[0]);
            meaning_text.setFont(meaning_text.getFont().deriveFont(Font.PLAIN, 14f));
            meaning_text.setText(randWord[1]);
        }
    }
}

