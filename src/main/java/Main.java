import members.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Lion> lionList = new ArrayList<>();
        List<Drone> droneList = new ArrayList<>();
        List<Keeper> keeperList = new ArrayList<>();

        Lion lion1 = new Lion("Simba", 7, 30);
        lionList.add(lion1);
        Keeper keeper1 = new Keeper("Geoff","4392",80);
        keeperList.add(keeper1);
        Drone drone1 = new Drone("Monitor 1", 128, 124);
        droneList.add(drone1);

        JFrame frame = new JFrame();
        frame.setSize(600,600);

        frame.setTitle("zoo Map");

        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.revalidate();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        for(int i = 0;i<lionList.size();i++){

            Lion lion = lionList.get(i);

            for(int j = 0;j<droneList.size();j++){
                Drone drone = droneList.get(j);

                for(int k = 0;k<keeperList.size();k++){

                    Keeper keeper = keeperList.get(k);
                    Drawing draw = new Drawing(lion, keeper, drone);
                    panel.add(draw);

                    Point locationLion = lion.getLocation();
                    Point locationDrone = drone.getLocation();
                    Point locationKeeper = keeper.getLocation();


                    if (Math.hypot(Math.abs(locationLion.x- locationKeeper.x), Math.abs(locationLion.y- locationKeeper.y)) <60 ){
                        AlertSystem.alertADrone(drone.getRadio_freq());
                        AlertSystem.alertAKeeper(keeper.getPhoneNumber());
                    }
                }
            }

        }

        panel.repaint();

        frame.add(panel);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        while(true){
            try{Thread.sleep(1000);}catch(Exception e){}
            frame.repaint();
        }


    }
}
