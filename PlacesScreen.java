package TRAVELAROUND;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlacesScreen extends JFrame {
    private static final long serialVersionUID = 1L;

    public PlacesScreen() {
        setTitle("Explore the World - Destinations");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(245, 255, 250)); // Soft mint background
        setLayout(new BorderLayout());

        // Header label with style
        JLabel titleLabel = new JLabel("✈️ Choose Your Destination", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 38));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Center panel with border and shadow effect
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(20, 40, 20, 40),
            BorderFactory.createLineBorder(new Color(0, 102, 204), 2)
        ));

        // Table setup
        String[][] places = PlacesData.getPlaces();
        String[] columnNames = { "🌍 Place", "💰 Price (USD)" };

        JTable table = new JTable(places, columnNames);
        table.setFont(new Font("SansSerif", Font.PLAIN, 18));
        table.setRowHeight(40);
        table.setFillsViewportHeight(true);
        table.setGridColor(new Color(200, 200, 200));
        table.setShowGrid(true);
        table.setSelectionBackground(new Color(173, 216, 230));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(224, 255, 255));
        table.setEnabled(false);  // Optional: prevent editing

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel with "Next" button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(245, 255, 250));
        JButton nextButton = new JButton("🚀 Choose Your Trip");
        nextButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        nextButton.setBackground(new Color(34, 139, 34));
        nextButton.setForeground(Color.WHITE);
        nextButton.setPreferredSize(new Dimension(240, 50));
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Next button action
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BookingScreen();
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new PlacesScreen();
    }
}
