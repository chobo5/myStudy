package v2.menu;

import java.io.BufferedReader;

public interface Menu {
    void execute(BufferedReader in);
    String getName();
}
