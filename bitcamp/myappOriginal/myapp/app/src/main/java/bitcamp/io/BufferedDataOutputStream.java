package bitcamp.io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedDataOutputStream extends DataOutputStream{

    private byte[] buffer = new byte[8192];
    int size = 0;
    public BufferedDataOutputStream(String name) throws FileNotFoundException {
        super(name);
    }

    @Override
    public void write(int b) throws IOException {
        if(size == buffer.length) {
            super.write(buffer);
            size = 0;
            flush();
        }
        buffer[size++] = (byte) b;
    }

    @Override
    public void write(byte[] b) throws IOException {
        for (byte by : b) {
            if (size == buffer.length) {
                flush();
            }
            //버퍼가 모두 찼다면, 즉시 버퍼에 저장된 데이터를 파일로 출력한다.
//            super.write(buffer);
//            size = 0;
            buffer[size++] = by;
        }

    }

    // 버퍼에 저장된 데이터를 파일로 출력한다.
    @Override
    public void flush() throws IOException {
        super.write(buffer, 0 ,size);
        size = 0;
    }

    @Override
    public void close() throws IOException {
        // 출력 스트림을 닫기 전에 버퍼에 남아 있는 데이터를 파일로 출력한다.
        flush();
        super.close();
    }
}
