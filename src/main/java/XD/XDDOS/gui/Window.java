package XD.XDDOS.gui;

import javax.swing.JFrame;

public class Window extends JFrame {
    // the window class extends the jframe class which has all the GUI components for the window

    public Window(String title, int width, int height) {
        setTitle(title);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new Panel(width, height));

        pack();
        setLocationRelativeTo(null); // centers the window on the screen
        setVisible(true);
    }
}