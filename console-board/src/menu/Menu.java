package menu;

import java.io.BufferedReader;
import java.io.IOException;

public interface Menu {
    void execute(BufferedReader in);
    String getName();
}
