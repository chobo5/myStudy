package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP주소: " + local);

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
            for (InetAddress address : iaArr) {
                System.out.println("네이버 IP주소: " + address);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
