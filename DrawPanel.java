//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    void moveit(int x, int y) {
        this.volvoPoint.x = x;
        this.volvoPoint.y = y + 200;
        this.saabPoint.x = x;
        this.saabPoint.y = y;
        this.scaniaPoint.x = x;
        this.scaniaPoint.y = y + 400;
    }

    void moveVolvo(int x, int y) {
        this.volvoPoint.x = x;
        this.volvoPoint.y = y;
    }

    void moveSaab(int x, int y) {
        this.saabPoint.x = x;
        this.saabPoint.y = y;
    }

    void moveScania(int x, int y) {
        this.scaniaPoint.x = x;
        this.scaniaPoint.y = y;
    }

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        try {
            this.volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            this.saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            this.scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.volvoImage, this.volvoPoint.x, this.volvoPoint.y, (ImageObserver)null);
        g.drawImage(this.saabImage, this.saabPoint.x, this.saabPoint.y, (ImageObserver)null);
        g.drawImage(this.scaniaImage, this.scaniaPoint.x, this.scaniaPoint.y, (ImageObserver)null);
    }
}
