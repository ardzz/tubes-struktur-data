package Manager;

import Utilities.Queue;
import java.util.Scanner;

public abstract class AbstractManager {
    protected String object_name;
    Scanner input = new Scanner(System.in);

    public AbstractManager(String object_name) {
        this.object_name = object_name;
    }

    public String getObjectName() {
        return object_name;
    }
}
