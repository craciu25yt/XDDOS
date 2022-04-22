package XD.XDDOS.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class Panel extends JPanel {
    BrowserOpener browser = new BrowserOpener();

    private JPanel mainPanel, infoPanel;

    private JLabel discordLabel, githubLabel;

    private AdvancedTextField ipTextField, portTextField;

    private DropdownBox methodBox;

    public Panel(int width, int height) {
        setPreferredSize(new Dimension(width, height + 35));
        setLayout(null); // in swing there are things called layout managers and you can learn more about them here https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

        // jpanels are swing components that essentially represent a section of a window

        mainPanel = new JPanel();
        infoPanel = new JPanel();
        
        discordLabel = new JLabel();
        githubLabel = new JLabel();

        methodBox = new DropdownBox();

        methodBox.setBorder(new RoundedBorder(12));
        methodBox.setBackground(Color.WHITE);
        methodBox.setFocusable(false);
        methodBox.addMethods();

        methodBox.setToolTipText("Choose the attack method");

        
        infoPanel.setPreferredSize(new Dimension(width, 35));
        infoPanel.setBounds(0, 0, width, 35);
        infoPanel.setLayout(new FlowLayout(FlowLayout.TRAILING)); // flow layout makes sure components fit horizontally and trailing means it starts on the right
        infoPanel.setBackground(new Color(0xFFFFFF));

        discordLabel.setPreferredSize(new Dimension(25, 25));
        discordLabel.setIcon(new ImageIcon(getClass().getResource("images/discord.png")));
        discordLabel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    browser.openUrl("http://discord.io/XDDOS");
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        githubLabel.setPreferredSize(new Dimension(25, 25));
        githubLabel.setIcon(new ImageIcon(getClass().getResource("images/github.png")));
        githubLabel.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    browser.openUrl("https://github.com/XDMEOW");
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });

        
        JButton button = new JButton("Submit");

        button.setBackground(Color.WHITE);
        
        button.setPreferredSize(new Dimension(70, 40));

        button.setFocusPainted(false);

        button.setBorder(new RoundedBorder(12));
        button.setVisible(true);

        ipTextField = new AdvancedTextField();
        ipTextField.setGuideText("Enter the server IP");

        portTextField = new AdvancedTextField();
        portTextField.setGuideText("Enter the port");

        ipTextField.setBorder(new RoundedBorder(12));
        ipTextField.setPreferredSize(new Dimension(150, 40));
        
        portTextField.setBorder(new RoundedBorder(12));
        portTextField.setPreferredSize(new Dimension(150, 40));
        
        mainPanel.setBounds(0, 35, width, height);
        
        infoPanel.add(discordLabel);
        infoPanel.add(githubLabel);

        mainPanel.add(infoPanel);
        mainPanel.add(ipTextField);
        mainPanel.add(portTextField);
        mainPanel.add(methodBox);
        mainPanel.add(button);

        add(infoPanel);
        add(mainPanel);
    }
}
