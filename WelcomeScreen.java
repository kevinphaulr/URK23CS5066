package TRAVELAROUND;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeScreen extends JFrame {
    private JLabel marquee;

    public WelcomeScreen() {
        setTitle("Explore the World Travels");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(25, 25, 112)); // Midnight Blue background

        // Marquee-like scrolling label
        marquee = new JLabel("✈ Explore. Dream. Discover. Travel the World with Us! 🌍");
        marquee.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 26));
        marquee.setForeground(Color.YELLOW);
        marquee.setBounds(1000, 30, 1000, 30);
        add(marquee);

        Timer timer = new Timer(20, e -> {
            Point p = marquee.getLocation();
            if (p.x < -marquee.getWidth()) {
                marquee.setLocation(getWidth(), p.y);
            } else {
                marquee.setLocation(p.x - 2, p.y);
            }
        });
        timer.start();

        // Title Label
        JLabel titleLabel = new JLabel("🌐 Welcome to Explore the World Travels 🌴", JLabel.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 38));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(300, 200, 1300, 60);
        add(titleLabel);

        // Fancy Button
        JButton viewButton = new JButton("✨ View Places ✨");
        viewButton.setFont(new Font("Verdana", Font.BOLD, 20));
        viewButton.setBackground(new Color(0, 153, 204));
        viewButton.setForeground(Color.WHITE);
        viewButton.setFocusPainted(false);
        viewButton.setBounds(650, 400, 250, 50);
        add(viewButton);

        // Button action
        viewButton.addActionListener(e -> {
            new PlacesScreen();
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new WelcomeScreen();
    }
}
