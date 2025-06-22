/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.RoundedButton to edit this template
 */
package rodrigo.Utils;

import java.awt.*;
import javax.swing.JButton;

/**
 *
 * @author myself
 */
public class RoundedButton extends JButton {

    private Color backgroundColor = new Color(212, 175, 55);
    private Color hoverColor = new Color(255, 215, 0);
    private boolean hovered = false;

    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.BLACK);
        setFont(new Font("Poppins", Font.BOLD, 13));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hovered = true;
                repaint();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                hovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color fill = hovered ? hoverColor : backgroundColor;
        g2.setColor(fill);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    public void paintBorder(Graphics g) {
        // sem borda feia
    }

    @Override
    public boolean isContentAreaFilled() {
        return false;
    }
}
