public class Light {
    String object;

    public Light(String object) {
        this.object = object;
    }

    public void on() {
        System.out.println(object + " 조명이 켜졌습니다.");
    }

    public void off() {
        System.out.println(object + " 조명이 꺼졌습니다.");
    }
}
