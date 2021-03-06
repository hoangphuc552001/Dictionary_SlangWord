import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by Le Hoang Phuc-19127059
 * Multiple choice function frame
 */
public class MultipleChoice extends JFrame implements ActionListener {
    JButton findbaseddef_, findbasedsw_,btnBack;
    MultipleChoice(){
        Container con = this.getContentPane();
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.LINE_AXIS));
        findbaseddef_=new JButton("Random based definition");
        findbaseddef_.setAlignmentX(CENTER_ALIGNMENT);
        findbaseddef_.addActionListener(this);
        findbaseddef_.setFocusable(false);
        findbaseddef_.setBackground(new Color(243, 159, 63));
        findbaseddef_.setForeground(Color.white);
        findbaseddef_.setUI(new stylebutton());
        findbasedsw_=new JButton("Random based slang word");
        findbasedsw_.setAlignmentX(CENTER_ALIGNMENT);
        findbasedsw_.addActionListener(this);
        findbasedsw_.setFocusable(false);
        findbasedsw_.setBackground(new Color(243, 159, 63));
        findbasedsw_.setForeground(Color.white);
        findbasedsw_.setUI(new stylebutton());

        btnBack=new JButton("Back");
        btnBack.setAlignmentX(CENTER_ALIGNMENT);
        btnBack.addActionListener(this);
        btnBack.setFocusable(false);
        btnBack.setBackground(new Color(232, 55, 35));
        btnBack.setForeground(Color.white);
        btnBack.setUI(new stylebutton());
        jPanel.add(findbaseddef_);
        jPanel.add(Box.createRigidArea(new Dimension(10,0)));
        jPanel.add(findbasedsw_);
        JPanel jPanel1=new JPanel();
        jPanel1.setLayout(new BoxLayout(jPanel1,BoxLayout.PAGE_AXIS));
        jPanel1.add(jPanel);
        jPanel1.add(Box.createRigidArea(new Dimension(0,15)));
        jPanel1.add(btnBack);
        jPanel1.add(Box.createRigidArea(new Dimension(0,30)));
        // Setting con
        con.setLayout(new BorderLayout());
        con.add(Box.createRigidArea(new Dimension(0,15)),BorderLayout.PAGE_START);
        con.add(jPanel1,BorderLayout.CENTER);
        // Setting JFrame
        this.setTitle("Choose your choice");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(new Dimension(400,130));
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
                    MultipleChoice frame = new MultipleChoice();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)){
            this.dispose();
            menuframe.GUI();
        }
        else if (e.getSource().equals(findbasedsw_)){
            this.dispose();
            RandomBySW.GUI();
        }
        else if (e.getSource().equals(findbaseddef_)){
            this.dispose();
            RandomByDef.GUI();
        }
    }

}
