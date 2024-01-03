package bitcamp.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStream extends FileInputStream {
    public DataInputStream(String name) throws FileNotFoundException {
        super(name);
    }

    public short readShort() throws IOException {
        return (short) (read() << 8 | read());
    }

    public int readInt() throws IOException {
        return read() << 24 | read() << 16 | read() << 8 | read();

    }

    public long readLong() throws IOException {
        return read() << 56 | read() << 48 | read() << 40 | read() << 32 | read() << 24 | read() << 16 | read() << 8 | read()
    }

    public boolean readBoolean() throws IOException {
        int value = read();
        if (value == 1) {
            return true;
        }else {
            return false
        }
    }
}
