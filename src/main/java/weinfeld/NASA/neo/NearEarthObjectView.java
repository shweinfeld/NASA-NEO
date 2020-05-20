package weinfeld.NASA.neo;

import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;

/**
 * Display the NearEarthObject
 */
@Singleton
public class NearEarthObjectView extends JComponent {

    public void setNearEarthObject(NeoFeed.NearEarthObject neo) {
        this.neo = neo;
        repaint();
    }

    private NeoFeed.NearEarthObject neo;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (neo == null) {
            return;
        }
        //Earth
        g.setColor(Color.blue);
        g.fillOval(-50, 200, 100, 100);

        //Asteroid
        g.setColor(Color.red);
        g.fillOval(getWidth()-10, 200, 10, 10);

        double lunars = neo.closestLunarDistance();
        double uiDistance = getWidth() - 10;
        double moonX = uiDistance / lunars;

        //Moon
        g.setColor(Color.gray);
        g.fillOval((int)moonX, 200, 25, 25);



    }
}
