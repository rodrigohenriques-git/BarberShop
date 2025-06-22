/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rodrigo.Utils;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author mysel
 */
public class BackgroundPanel extends JPanel {

    private ImageIcon backgroundImage;

    public BackgroundPanel(String imagePath) {
        // Carregar a imagem de fundo
        URL imgUrl = getClass().getClassLoader().getResource(imagePath);
        if (imgUrl != null) {
            backgroundImage = new ImageIcon(imgUrl);
        } else {
            backgroundImage = new ImageIcon("default.jpg"); // Caso a imagem não seja encontrada
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo ajustada ao tamanho do painel
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
