import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BasicGUI extends JFrame implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    final JTextField t1 = new JTextField("Username");
    JPasswordField t2 = new JPasswordField("Password");
    JButton b1 = new JButton("Login");
    Font font1 = new Font("SansSerif", Font.BOLD, 13);

    public BasicGUI()
    {
        super("Chat Application");
        t1.setFont(font1);
        t2.setFont(font1);
        add(t1);
        add(t2);
        add(b1);
        setSize(300,300);
        setLayout(null);        
        t1.setBounds(70,30,150,20);
        t2.setBounds(70,65,150,20);
        b1.setBounds(110,100,80,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        b1.addActionListener(this);
        t1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(final MouseEvent e) {
                t1.setText("");
            }
        });

        t2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                t2.setText("");
            }
        });

        

    }

    public void actionPerformed(final ActionEvent e) {
        dispose();
        final Font font1 = new Font("SansSerif", Font.BOLD, 13);
        final JFrame frame = new JFrame("Chat Window");
        final JButton button = new JButton("Send");
        // button.setSize(15,15);
        final JTextArea text = new JTextArea();
        final JTextField tfield = new JTextField();
        final JPanel panel1 = new JPanel(new BorderLayout(10, 10));
        final JPanel panel2 = new JPanel(new BorderLayout(10, 10));
        final JPanel panel3 = new JPanel(new FlowLayout());
        final JScrollPane pane = new JScrollPane(text);
        text.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        tfield.setFont(font1);
        text.setFont(font1);
        panel1.add(panel2, BorderLayout.SOUTH);
        panel1.add(pane, BorderLayout.CENTER);
        panel2.add(tfield, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.SOUTH);
        panel3.add(button);
        text.setEditable(false);
        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(300, 300);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                text.append("Username : " + tfield.getText() + "\n");

            }
        });
        tfield.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                tfield.setText("");
            }
        });

        tfield.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
               if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                  button.doClick();
               }
            }
         });


    }

}

public class GUI {
    public static void main(final String[] args)
    {
        new BasicGUI();
    }
}