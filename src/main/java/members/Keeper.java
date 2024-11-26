package members;

import java.awt.*;
import java.io.IOException;

public class Keeper extends Staff{
    private String phoneNumber;

    public Keeper(String name, String phoneNumber, int tageID) {
        super(name, tageID);
        this.phoneNumber = phoneNumber;
        try{
            this.location = LocationSystem.getCoords(this.tagID);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(location.x, location.y, 2, 2);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
