package members;

import java.awt.*;
import java.io.IOException;

public class Lion extends Staff{
    private int age;

    public Lion(String name, int age, int tagID) {
        super(name, tagID);
        this.age = age;
        try{
            this.location = LocationSystem.getCoords(this.tagID);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(location.x, location.y, 3, 3);
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
