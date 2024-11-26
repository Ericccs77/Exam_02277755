import members.*;
import java.awt.*;

public class Drawing extends Canvas {
    private Lion lion;
    private Keeper keeper;
    private Drone drone;

    public Drawing(Lion lion, Keeper keeper, Drone drone) {
        super();
        this.lion = lion;
        this.keeper = keeper;
        this.drone = drone;
    }
    public void paint(Graphics g) {
        lion.draw(g);
        keeper.draw(g);
        drone.draw(g);
    }

}
