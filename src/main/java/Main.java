import models.Grid;
import models.Orientation;
import models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter Grid dimension (e.g. 5 3):");
            String dimension = br.readLine();

            String[] dimensions = dimension.split(" ");
            Grid grid = new Grid(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));

            while (true) {
                System.out.println("Enter robot intial status (e.g. 1 1 E representing, x, y and orientation):");
                String initStatusInput = br.readLine();

                System.out.println("Enter commands (e.g. RFRFRFRF, R-right, L-left, F-forward):");
                String commands = br.readLine();

                String[] initStatus = initStatusInput.split(" ");
                int x = Integer.parseInt(initStatus[0]);
                int y = Integer.parseInt(initStatus[1]);
                Orientation orientation = Orientation.valueOf(initStatus[2]);
                Robot robot = new Robot(grid, x, y, orientation);
                robot.takeCommands(commands);

                System.out.println("--------------");
                System.out.println(robot.getCurrentStatus());

                System.out.println("Continue?(y/n):");
                String shouldContinue = br.readLine();

                if (!shouldContinue.equals("y")) {
                    System.out.println("See you!");
                    System.exit(0);
                }
            }

        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
