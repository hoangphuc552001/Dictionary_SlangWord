import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
/**
 * Created by Le Hoang Phuc-19127059
 * About me function frame
 */
public class AboutMe extends JFrame implements ActionListener{
    JTextPane txtMessage;
    JButton back;
    AboutMe(){
        Container con = this.getContentPane();
        // Setting con
        con.setLayout(new BorderLayout());
        JPanel panel_Chat = new JPanel();
        panel_Chat.setBorder(
                new TitledBorder(null, "About me", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        txtMessage = new JTextPane();
        txtMessage.setBackground(Color.BLACK);
        txtMessage.setForeground(new Color(0, 255, 119, 157));
        txtMessage.setFont(new Font("Monaco", Font.PLAIN, 18));
        txtMessage.setText("Name: Le Hoang Phuc\nID: 19127059\nHCMUS-K19-CLC");
        txtMessage.setFont(new Font("Arial",Font.BOLD,25));
        StyledDocument doc = txtMessage.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        panel_Chat.add(txtMessage);
        con.add(panel_Chat,BorderLayout.CENTER);
        JPanel n=new JPanel();
        n.setLayout(new FlowLayout(FlowLayout.CENTER));
        back = new JButton("Back");
        back.setAlignmentX(CENTER_ALIGNMENT);
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBackground(new Color(232, 55, 35));
        back.setForeground(Color.white);
        back.setUI(new stylebutton());
        back.setPreferredSize(new Dimension(60, 30));
        JFrame f=this;
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                menuframe.GUI();
            }
        });
        n.add(back);
        con.add(n,BorderLayout.PAGE_END);
        // Setting JFrame
        this.setTitle("About me");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
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
                    AboutMe frame = new AboutMe();
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

    }
}
