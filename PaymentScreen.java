package TRAVELAROUND;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentScreen extends JFrame {
    private static final long serialVersionUID = 1L;

    public PaymentScreen(String name, String place, int members, double cost) {
        setTitle("💳 Select Payment Method");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 255, 250)); // Soft mint background
        setLayout(new GridBagLayout());  // Center the panel

        // Main card panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 300));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 3));
        add(panel);
        JLabel lblTitle = new JLabel("<html><div style='text-align:center;'><span style='font-size:24px;'>🧾 <b>Choose Your Payment Method</b></span></div></html>");
        lblTitle.setBounds(50, 30, 400, 60);  // Increased height to accommodate the text properly

        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(lblTitle);

        // GPAY Button
        JButton gpayBtn = new JButton("📱 Google Pay");
        gpayBtn.setBounds(80, 100, 150, 40);
        gpayBtn.setBackground(new Color(51, 153, 255));
        gpayBtn.setForeground(Color.WHITE);
        gpayBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(gpayBtn);

        // Card Button
        JButton cardBtn = new JButton("💳 Card");
        cardBtn.setBounds(260, 100, 150, 40);
        cardBtn.setBackground(new Color(0, 153, 76));
        cardBtn.setForeground(Color.WHITE);
        cardBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(cardBtn);

        JLabel note = new JLabel("<html><center>Note: Make sure your details are correct before proceeding.</center></html>", JLabel.CENTER);
        note.setFont(new Font("SansSerif", Font.ITALIC, 12));
        note.setBounds(50, 180, 400, 40);
        panel.add(note);

        // GPAY action
        gpayBtn.addActionListener(e -> {
            String gpayNumber = JOptionPane.showInputDialog(null, "📲 Enter GPay Number:");
            if (gpayNumber != null && !gpayNumber.trim().isEmpty()) {
                new PaymentSuccessScreen(name, place, members, cost, "GPay - " + gpayNumber);
                dispose();
            }
        });

        // Card action
        cardBtn.addActionListener(e -> {
            String[] options = { "Credit Card", "Debit Card" };
            String cardType = (String) JOptionPane.showInputDialog(
                    null,
                    "💳 Select Card Type:",
                    "Card Type",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (cardType != null) {
                String cardNumber = JOptionPane.showInputDialog(null, "🔢 Enter " + cardType + " Number:");
                if (cardNumber != null && !cardNumber.trim().isEmpty()) {
                    new PaymentSuccessScreen(name, place, members, cost, cardType + " - " + cardNumber);
                    dispose();
                }
            }
        });

        setVisible(true);
    }
}
