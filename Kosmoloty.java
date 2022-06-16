import java.security.spec.KeySpec;
import java.util.*;
import java.io.*;

public class Kosmoloty {
    String name;
    int speedX;
    int speedY;
    int posX;
    int posY;
    int distance;
    public Kosmoloty(String N, int SX, int SY, int PX, int PY) {
        this.name = N;
        this.speedX = SX;
        this.speedY = SY;
        this.posX = PX;
        this.posY = PY;
    }

    public void Move() {
        posX += speedX;
        posY += speedY;
    }

    public static void main(String[] args) {
        ArrayList<Kosmoloty> Participants = new ArrayList<Kosmoloty>();
        int sizeX = 0;
        int sizeY = 0;
        Scanner in = new Scanner(System.in);
        String line = new String();
        boolean isProperData = true;
        if(args.length != 2) {
            isProperData = false;
        }
        else {
            sizeX = Integer.parseInt(args[0]);
            sizeY = Integer.parseInt(args[1]);
        }

        if(sizeX < 1 || sizeX > 100000 || sizeY < 1 || sizeY > 100000) {
            isProperData = false;
        }

        while(in.hasNext()) {
            line = in.nextLine();

            int OldPos = line.indexOf(',');

            String name = line.substring(0,OldPos);

            OldPos++;

            int NewPos = line.indexOf(',', OldPos);
            int speedX = Integer.parseInt(line.substring(OldPos, NewPos));

            OldPos = NewPos + 1;
            NewPos = line.indexOf(',', OldPos);

            int speedY = Integer.parseInt(line.substring(OldPos, NewPos));

            OldPos = NewPos + 1;
            NewPos = line.indexOf(',', OldPos);

            int posX = Integer.parseInt(line.substring(OldPos, NewPos));

            OldPos = NewPos + 1;
            NewPos = line.length();

            int posY = Integer.parseInt(line.substring(OldPos, NewPos));

            if(!name.matches("[a-zA-Z0-9]{1,10}")) {
                isProperData = false;
                break;
            }
            else {
                for (Kosmoloty k : Participants) {
                    if(name.equals(k.name)) {
                        isProperData = false;
                        break;
                    }
                }
            }

            if(speedX < -10000 || speedX > 10000 || speedY < -10000 || speedY > 10000) {
                isProperData = false;
                break;
            }

            if(posX > sizeX - 1 || posX < 0 || posY > sizeY - 1 || posY < 0) {
                isProperData = false;
                break;
            }

            if(isProperData) {
                Kosmoloty obj = new Kosmoloty(name, speedX, speedY, posX, posY);
                Participants.add(obj);
            }
            //System.out.println(name + "," + speedX + "," + speedY + "," + posX + "," + posY);
        }
        if(!isProperData) {
            System.out.println("klops");
        }
        else {

        }
        System.exit(0);
        //System.out.println("");
    }
}
