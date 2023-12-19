import javax.swing.*;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();

        JButton button = new JButton("버튼");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button); // 버튼을 프레임에 추가
        frame.setSize(300, 300); // 프레임의 크기 설정

        // 프레임 표시
        frame.setVisible(true);
    }
}
