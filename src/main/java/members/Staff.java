package members;

import java.awt.*;
import java.io.*;

public class Staff{
    protected String name;
    protected int tagID;
    protected Point location;

    public Staff(String name, int tagID) {
        this.name = name;
        this.tagID = tagID;
        try{
            this.location = LocationSystem.getCoords(this.tagID);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void draw(Graphics g, Point location) {
        g.fillOval(location.x, location.y, 10, 10);
    }

    public String getName() {
        return name;
    }
    public int getTagID() {
        return tagID;
    }
    public Point getLocation() {
        return location;
    }

}
