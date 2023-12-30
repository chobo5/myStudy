public class Main {
    public static void main(String[] args) {

        RemoteControl remote = new RemoteControl();
        Light light = new Light("거실");
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        remote.setCommand(lightOnCommand, lightOffCommand);


        GarageDoor garageDoor = new GarageDoor();
        Command garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        Command garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);
        remote.setCommand(garageDoorOpenCommand, garageDoorCloseCommand);

        System.out.println(remote);

        remote.pressOnButton(0);
        remote.pressOffButton(0);
        remote.pressOnButton(1);
        remote.pressOffButton(1);
    }
}