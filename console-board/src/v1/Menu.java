package v1;

import java.io.IOException;

public interface Menu {
    void execute() throws IOException;
    String getName();
}
