import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class menuframe  extends JFrame implements ActionListener {
    JButton btnView,btnFindWord,btnHistory,btnAdd,btnEdit,btnDelete,btnReset,
    btnRandom,btnChoice,btnAbout;
    SlangWord slangWord=SlangWord.getInstance();
    menuframe(){
        stylepanel spn=new stylepanel();
        Container container1 = this.getContentPane();
        Container container=new Container();
        Dimension size = new Dimension(160, 25);
        //Top Pannel
        JPanel topPanel=new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("MENU");
        titleLabel.setForeground(new Color(222, 52, 49));
        titleLabel.setFont(new Font("Monaco", Font.PLAIN, 30));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        topPanel.add(titleLabel);
        // JLabel jlb=new JLabel();
		// jlb.setAlignmentX(CENTER_ALIGNMENT);
		// jlb.setText("Le Hoang Phuc - 19127059 - HCMUS");
        //
		JPanel jPaneltitle=new JPanel();
		jPaneltitle.setSize((new Dimension(50, 50)));
		jPaneltitle.setLayout(new BoxLayout(jPaneltitle, BoxLayout.LINE_AXIS));
		jPaneltitle.add(titleLabel);
        jPaneltitle.setBackground(new Color(247, 245, 245));
        jPaneltitle.setAlignmentX(CENTER_ALIGNMENT);
		//
		JPanel jpEnd=new JPanel();
		jpEnd.setLayout(new BoxLayout(jpEnd, BoxLayout.PAGE_AXIS));
        jpEnd.add(jPaneltitle);
        jpEnd.add(Box.createRigidArea(new Dimension(0, 5)));
        jpEnd.setBackground(new Color(147, 176, 194));
        jpEnd.setAlignmentX(CENTER_ALIGNMENT);
		topPanel.add(jpEnd);
        topPanel.setAlignmentX(CENTER_ALIGNMENT);
		//topPanel.add(jlb);
        //mid pannel
        btnView=new JButton("View Words List");
        btnView.setAlignmentX(CENTER_ALIGNMENT);
        btnView.addActionListener(this);
        btnView.setFocusable(false);
        btnView.setBackground(new Color(245, 66, 87));
        btnView.setForeground(Color.white);
        btnView.setUI(new stylebutton());
        btnView.setMaximumSize(size);
        btnView.setPreferredSize(size);
        btnView.setMaximumSize(size);
        //
        btnFindWord=new JButton("Find Word");
        btnFindWord.setAlignmentX(CENTER_ALIGNMENT);
        btnFindWord.addActionListener(this);
        btnFindWord.setFocusable(false);
        btnFindWord.setBackground(new Color(245, 66, 87));
        btnFindWord.setForeground(Color.white);
        btnFindWord.setUI(new stylebutton());
        btnFindWord.setMaximumSize(size);
        btnFindWord.setPreferredSize(size);
        btnFindWord.setMaximumSize(size);
        //
        btnHistory=new JButton("Find Search History");
        btnHistory.setAlignmentX(CENTER_ALIGNMENT);
        btnHistory.addActionListener(this);
        btnHistory.setFocusable(false);
        btnHistory.setBackground(new Color(245, 66, 87));
        btnHistory.setForeground(Color.white);
        btnHistory.setUI(new stylebutton());
        btnHistory.setMaximumSize(size);
        btnHistory.setPreferredSize(size);
        btnHistory.setMaximumSize(size);
        //
        btnAdd=new JButton("Add Slang Word");
        btnAdd.setAlignmentX(CENTER_ALIGNMENT);
        btnAdd.addActionListener(this);
        btnAdd.setFocusable(false);
        btnAdd.setBackground(new Color(245, 66, 87));
        btnAdd.setForeground(Color.white);
        btnAdd.setUI(new stylebutton());
        btnAdd.setMaximumSize(size);
        btnAdd.setPreferredSize(size);
        btnAdd.setMaximumSize(size);
        //
        btnDelete=new JButton("Delete Slang Word");
        btnDelete.setAlignmentX(CENTER_ALIGNMENT);
        btnDelete.addActionListener(this);
        btnDelete.setFocusable(false);
        btnDelete.setBackground(new Color(245, 66, 87));
        btnDelete.setForeground(Color.white);
        btnDelete.setUI(new stylebutton());
        btnDelete.setMaximumSize(size);
        btnDelete.setPreferredSize(size);
        btnDelete.setMaximumSize(size);
        //
        btnEdit=new JButton("Edit Slang Word");
        btnEdit.setAlignmentX(CENTER_ALIGNMENT);
        btnEdit.addActionListener(this);
        btnEdit.setFocusable(false);
        btnEdit.setBackground(new Color(245, 66, 87));
        btnEdit.setForeground(Color.white);
        btnEdit.setUI(new stylebutton());
        btnEdit.setMaximumSize(size);
        btnEdit.setPreferredSize(size);
        btnEdit.setMaximumSize(size);
        //
        btnReset=new JButton("Reset Slang Word");
        btnReset.setAlignmentX(CENTER_ALIGNMENT);
        btnReset.addActionListener(this);
        btnReset.setFocusable(false);
        btnReset.setBackground(new Color(245, 66, 87));
        btnReset.setForeground(Color.white);
        btnReset.setUI(new stylebutton());
        btnReset.setMaximumSize(size);
        btnReset.setPreferredSize(size);
        btnReset.setMaximumSize(size);
        //
        btnRandom=new JButton("Random Slang Word");
        btnRandom.setAlignmentX(CENTER_ALIGNMENT);
        btnRandom.addActionListener(this);
        btnRandom.setFocusable(false);
        btnRandom.setBackground(new Color(245, 66, 87));
        btnRandom.setForeground(Color.white);
        btnRandom.setUI(new stylebutton());
        btnRandom.setMaximumSize(size);
        btnRandom.setPreferredSize(size);
        btnRandom.setMaximumSize(size);
        //
        btnChoice=new JButton("Multiple Choice");
        btnChoice.setAlignmentX(CENTER_ALIGNMENT);
        btnChoice.addActionListener(this);
        btnChoice.setFocusable(false);
        btnChoice.setBackground(new Color(245, 66, 87));
        btnChoice.setForeground(Color.white);
        btnChoice.setUI(new stylebutton());
        btnChoice.setMaximumSize(size);
        btnChoice.setPreferredSize(size);
        btnChoice.setMaximumSize(size);
        //
        btnAbout=new JButton("About me");
        btnAbout.setAlignmentX(CENTER_ALIGNMENT);
        btnAbout.addActionListener(this);
        btnAbout.setFocusable(false);
        btnAbout.setBackground(new Color(245, 66, 87));
        btnAbout.setForeground(Color.white);
        btnAbout.setUI(new stylebutton());
        btnAbout.setMaximumSize(size);
        btnAbout.setPreferredSize(size);
        btnAbout.setMaximumSize(size);
        // Add to container
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(topPanel);
        // container.add(Box.createRigidArea(new Dimension(0,10)));
        // container.add(titleLabel);
        container.add((Box.createRigidArea(new Dimension(0,20))));
        container.add(btnView);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnFindWord);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnHistory);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnAdd);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnDelete);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnEdit);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnReset);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnRandom);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnChoice);
        container.add((Box.createRigidArea(new Dimension(0,10))));
        container.add(btnAbout);
        //
        spn.setLayout(new BorderLayout());
        spn.add(container,BorderLayout.CENTER);
        container1.add(spn);
        // Setting Frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu");
		this.setVisible(true);
		this.setSize(450, 450);
        this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
    /**
     * set action listener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==btnView){
            this.dispose();
            try {
                listframe.GUI();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==btnFindWord){
            this.dispose();
            try {
                FindWord.GUI();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==btnHistory){
            this.dispose();
            try {
                viewhistory.GUI();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==btnAdd){
            this.dispose();
            try {
                new addslangword();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==btnDelete){
            this.dispose();
            try {
                new deleteslangword();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==btnReset){
            try {
                slangWord.resetSlangWord();
                JOptionPane.showMessageDialog(this,"Reset successfully");  
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (e.getSource().equals(btnRandom)){
            this.dispose();
            randomslangword.GUI();
        }else if (e.getSource().equals(btnEdit)){
            this.dispose();
            editslangword.GUI();
        }else if (e.getSource().equals(btnChoice)){
            this.dispose();
            MultipleChoice.GUI();
        }else if (e.getSource().equals(btnAbout)){
            this.dispose();
            AboutMe.GUI();
        }
    }
    /**
     * Event dispatch thread
     */
    public static void GUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menuframe frame = new menuframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * main function 
     * @param args from terminal
     */
    public static void main(String[] args){
        menuframe.GUI();
    }
    
}
