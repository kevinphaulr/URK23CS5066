package TRAVELAROUND;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class PaymentSuccessScreen extends JFrame {
    private static final long serialVersionUID = 1L;

    public PaymentSuccessScreen(String name, String place, int members, double cost, String method) {
        setTitle("Payment Successful");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(230, 255, 240));  // Light green background
        setLayout(new GridBagLayout());  // Center the content

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(600, 450));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(34, 139, 34), 3));
        card.setLayout(null);
        add(card);

        JLabel headerLabel = new JLabel("✅ Payment Successful!", JLabel.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setForeground(new Color(34, 139, 34));
        headerLabel.setBounds(100, 20, 400, 40);
        card.add(headerLabel);

        String paymentID = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        JLabel paymentIDLabel = new JLabel("🧾 Payment ID: <b>" + paymentID + "</b>");
        paymentIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        paymentIDLabel.setBounds(180, 80, 300, 30);
        card.add(paymentIDLabel);

        // HTML content block
        JLabel infoLabel = new JLabel("<html>" +
                "<div style='padding:10px;font-size:16px;'>" +
                "<b>Booking Details:</b><br><br>" +
                "👤 <b>Name:</b> " + name + "<br>" +
                "📍 <b>Place:</b> " + place + "<br>" +
                "👥 <b>Members:</b> " + members + "<br>" +
                "💵 <b>Total Cost:</b> $" + cost + "<br>" +
                "💳 <b>Payment Method:</b> " + method +
                "</div></html>");
        infoLabel.setBounds(100, 120, 400, 180);
        card.add(infoLabel);

        // Save booking to DB
        Booking.insert(name, place, members, cost, method, paymentID);

        JButton closeButton = new JButton("Finish ✨");
        closeButton.setFont(new Font("Arial", Font.BOLD, 18));
        closeButton.setBackground(new Color(34, 139, 34));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setBounds(220, 330, 150, 40);
        closeButton.addActionListener(e -> System.exit(0));
        card.add(closeButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PaymentSuccessScreen("John Doe", "Paris", 3, 1500, "Credit Card");
    }
}

