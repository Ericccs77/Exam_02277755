package members;

import java.awt.*;
import java.io.IOException;

public class Drone extends Staff{
    private int radio_freq;

    public Drone(String name, int freq, int tagID) {
        super(name, tagID);
        this.radio_freq = freq;
        try{
            this.location = LocationSystem.getCoords(this.tagID);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(location.x, location.y, 3, 3);

    }

    public int getRadio_freq() {
        return radio_freq;
    }
    public void setRadio_freq(int radio_freq) {
        this.radio_freq = radio_freq;
    }

}
