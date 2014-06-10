import java.io.IOException;

/**
 * Created by sattas on 3/28/14.
 */
public class Operation {
    public static void main (String[] args) {

        InputData r = new InputData();
        try {
            r.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

