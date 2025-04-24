package TRAVELAROUND;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookingScreen extends JFrame {
    private static final long serialVersionUID = 1L;

    public BookingScreen() {
        setTitle("✈️ Trip Booking");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 255, 250));  // Mint cream background
        setLayout(new GridBagLayout());  // Center content

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(500, 500));
        card.setBackground(Color.WHITE);
        card.setLayout(null);
        card.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 3));
        add(card);

        JLabel header = new JLabel("<html><div style='text-align:center;'><span style='font-size:24px; color:#004080;'>🌍<b>Book Your Dream Trip</b></span></div></html>");
        header.setBounds(50, 20, 400, 60);
        card.add(header);

        JLabel lblPlace = new JLabel("📍 Destination:");
        lblPlace.setBounds(50, 80, 150, 25);
        lblPlace.setFont(new Font("SansSerif", Font.PLAIN, 16));
        card.add(lblPlace);

        JTextField txtPlace = new JTextField();
        txtPlace.setBounds(200, 80, 200, 25);
        card.add(txtPlace);

        JLabel lblName = new JLabel("👤 Passenger Name:");
        lblName.setBounds(50, 120, 150, 25);
        lblName.setFont(new Font("SansSerif", Font.PLAIN, 16));
        card.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(200, 120, 200, 25);
        card.add(txtName);

        JLabel lblMembers = new JLabel("👥 No. of Travelers:");
        lblMembers.setBounds(50, 160, 150, 25);
        lblMembers.setFont(new Font("SansSerif", Font.PLAIN, 16));
        card.add(lblMembers);

        JTextField txtMembers = new JTextField();
        txtMembers.setBounds(200, 160, 200, 25);
        card.add(txtMembers);

        JLabel lblTotal = new JLabel("💰 Total Cost:");
        lblTotal.setBounds(50, 200, 150, 25);
        lblTotal.setFont(new Font("SansSerif", Font.PLAIN, 16));
        card.add(lblTotal);

        JTextField txtTotal = new JTextField();
        txtTotal.setBounds(200, 200, 200, 25);
        txtTotal.setEditable(false);
        card.add(txtTotal);

        JButton calcButton = new JButton("🧮 Calculate");
        calcButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        calcButton.setBackground(new Color(0, 153, 255));
        calcButton.setForeground(Color.WHITE);
        calcButton.setBounds(90, 260, 140, 35);
        card.add(calcButton);

        JButton proceedButton = new JButton("💳 Proceed to Payment");
        proceedButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        proceedButton.setBackground(new Color(0, 153, 76));
        proceedButton.setForeground(Color.WHITE);
        proceedButton.setBounds(90, 310, 250, 40);
        card.add(proceedButton);

        // Event handler for calculate
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String place = txtPlace.getText().trim();
                    int members = Integer.parseInt(txtMembers.getText().trim());
                    String[][] places = PlacesData.getPlaces();
                    double price = 0;
                    for (String[] row : places) {
                        if (row[0].equalsIgnoreCase(place)) {
                            price = Double.parseDouble(row[1]);
                            break;
                        }
                    }
                    if (price == 0) {
                        JOptionPane.showMessageDialog(null, "Destination not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    txtTotal.setText(String.valueOf(price * members));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid data.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Event handler for proceed
        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = txtName.getText();
                    String place = txtPlace.getText();
                    int members = Integer.parseInt(txtMembers.getText());
                    double cost = Double.parseDouble(txtTotal.getText());
                    new PaymentScreen(name, place, members, cost);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Complete all fields before proceeding.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookingScreen();
    }
}
