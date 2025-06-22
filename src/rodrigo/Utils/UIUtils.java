/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rodrigo.Utils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author myself
 */
public class UIUtils {

    public static void styleButton(JButton btn) {
        btn.setBackground(new Color(211, 211, 211)); // cinza claro
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Poppins", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169))); // cinza médio
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void styleHover(JButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(Color.WHITE); // hover: branco
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(211, 211, 211)); // volta ao cinza claro
            }
        });

    }
}
