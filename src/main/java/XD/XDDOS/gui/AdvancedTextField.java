package XD.XDDOS.gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class AdvancedTextField extends JTextField {
    public AdvancedTextField() {}

    public void setGuideText(String text) {
        setForeground(Color.GRAY);
        setText(text);
        addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                    if(getText().equals(text)) {
                    setForeground(Color.BLACK);
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                    if(getText().trim().equals("")) {
                    setForeground(Color.GRAY);
                    setText(text);
                }
            }

        });
    }
}
