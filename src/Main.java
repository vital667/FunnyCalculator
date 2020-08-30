import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    JTextField tf1, tf2, tf3;
    JButton b1, b2, b3, b4, exit;
    JLabel l, label, donation;
    JFrame f;

    Main() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);
        Border border2 = BorderFactory.createLineBorder(Color.MAGENTA, 2);
        Font ft = new Font("Verdana", Font.BOLD, 25);
        Font ft2 = new Font("Verdana", Font.BOLD, 20);

        f = new JFrame("Calculator vit667");

        Icon i = new ImageIcon("image.png");
        l = new JLabel(i);
        f.setContentPane(l);

        tf1 = new JTextField();
        tf1.setBounds(60, 35, 160, 30);
        tf1.setOpaque(true);
        tf1.setBackground(Color.LIGHT_GRAY);
        tf1.setBorder(border);

        tf2 = new JTextField();
        tf2.setBounds(60, 85, 160, 30);
        tf2.setOpaque(true);
        tf2.setBackground(Color.LIGHT_GRAY);
        tf2.setBorder(border);

        label = new JLabel("Result:");
        label.setBounds(60, 130, 80, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(ft2);

        donation = new JLabel("Please donate to vit667@gmail.com");
        donation.setBounds(5, 370, 270, 25);
        donation.setHorizontalAlignment(SwingConstants.CENTER);
        donation.setForeground(Color.white);
        donation.setBorder(border2);
        donation.setOpaque(true);
        donation.setBackground(Color.BLACK);

        tf3 = new JTextField();
        tf3.setBounds(60, 170, 160, 30);
        tf3.setOpaque(true);
        tf3.setBackground(Color.YELLOW);
        tf3.setBorder(border);

        b1 = new JButton("+");
        b1.setBounds(25, 230, 50, 50);
        b1.setBorder(border);
        b1.setOpaque(true);
        b1.setBackground(Color.GREEN);
        b1.setFont(ft);

        b2 = new JButton("-");
        b2.setBounds(85, 230, 50, 50);
        b2.setBorder(border);
        b2.setOpaque(true);
        b2.setBackground(Color.CYAN);
        b2.setFont(ft);

        b3 = new JButton("*");
        b3.setBounds(145, 230, 50, 50);
        b3.setBorder(border);
        b3.setOpaque(true);
        b3.setBackground(Color.MAGENTA);
        b3.setFont(ft);

        b4 = new JButton("/");
        b4.setBounds(205, 230, 50, 50);
        b4.setBorder(border);
        b4.setOpaque(true);
        b4.setBackground(Color.ORANGE);
        b4.setFont(ft);

        exit = new JButton("EXIT");
        exit.setBounds(25, 300, 230, 40);
        exit.setBorder(border);
        exit.setForeground(Color.black);
        exit.setOpaque(true);
        exit.setBackground(Color.pink);
        exit.setFont(ft);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        exit.addActionListener(this);

        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(exit);
        f.add(label);
        f.add(donation);

        f.setSize(280, 420);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);
        f.setResizable(false);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = "0";
        String s2 = "0";
        double d1;
        if (tf1.getText().equals("")) s1 = "0";
        else s1 = tf1.getText();
        if (tf2.getText().equals("")) s2 = "0";
        else s2 = tf2.getText();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = 0;
        double d = 0;

        if (e.getSource() == b1) {
            c = a + b;
            tf3.setText(String.valueOf(c));
        }
        if (e.getSource() == b2) {
            c = a - b;
            tf3.setText(String.valueOf(c));
        }
        if (e.getSource() == b3) {
            c = a * b;
            tf3.setText(String.valueOf(c));
        }
        if (e.getSource() == b4) {
            if (b == 0) tf3.setText("Dividing by zero!");
            else {
                d = (double) a / b;
                d1 = Math.round(d * 100) / 100.0;
                tf3.setText(String.valueOf(d1));
            }
        }
        if (e.getSource() == exit) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            f.dispose();
        }
    }
}
