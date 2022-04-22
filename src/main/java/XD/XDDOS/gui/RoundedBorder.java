package XD.XDDOS.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;
import java.awt.geom.Area;

import javax.swing.JPopupMenu;
import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {
    protected int radius;

    public RoundedBorder(int radius) {
      this.radius = radius;
    }

    @Override public void paintBorder(
        Component c, Graphics g, int x, int y, int width, int height) {
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                          RenderingHints.VALUE_ANTIALIAS_ON);
      int r = radius;
      int w = width  - 1;
      int h = height - 1;
  
      Area round = new Area(new RoundRectangle2D.Float(x, y, w, h, r, r));
      if (c instanceof JPopupMenu) {
        g2.setPaint(c.getBackground());
        g2.fill(round);
      } else {
        Container parent = c.getParent();
        if (Objects.nonNull(parent)) {
          g2.setPaint(parent.getBackground());
          Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
          corner.subtract(round);
          g2.fill(corner);
        }
      }
      g2.setPaint(c.getForeground());
      g2.draw(round);
      g2.dispose();
    }
    @Override public Insets getBorderInsets(Component c) {
      return new Insets(4, 8, 4, 8);
    }
    @Override public Insets getBorderInsets(Component c, Insets insets) {
      insets.set(4, 8, 4, 8);
      return insets;
    }
  }

// public class RoundedBorder implements Border {

//     private int radius;


//     public RoundedBorder(int radius) {
//         this.radius = radius;
//     }


//     public Insets getBorderInsets(Component c) {
//         return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
//     }


//     public boolean isBorderOpaque() {
//         return true;
//     }


//     public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//         Graphics2D g2D = (Graphics2D) g;
//         g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//         g2D.drawRoundRect(x, y, width-1, height-1, radius, radius);
//     }
// }
