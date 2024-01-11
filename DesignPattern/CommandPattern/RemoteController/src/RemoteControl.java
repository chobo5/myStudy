import java.util.ArrayList;
import java.util.List;

public class RemoteControl {
    List<Command> onCommands;
    List<Command> offCommands;
    Command undoCommand;

    public RemoteControl() {
        this.onCommands = new ArrayList<>();
        this.offCommands = new ArrayList<>();
    }

    public void setCommand(Command onCommand, Command offCommand) {
        this.onCommands.add(onCommand);
        this.offCommands.add(offCommand);
    }

    public void pressOnButton(int number) {
        onCommands.get(number).execute();
        undoCommand = onCommands.get(number);
    }

    public void pressOffButton(int number) {
        offCommands.get(number).execute();
        undoCommand = offCommands.get(number);
    }

    public void pressUndoButton() {
        try {
            undoCommand.undo();
        } catch (Exception e) {
            System.out.println("실행중인 동작이 없습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--------리모컨--------\n");
        for (int i = 0; i < onCommands.size(); i++) {
            sb.append("[slot] "+ i + "] " + onCommands.get(i).getClass().getName() + "    "
                    + offCommands.get(i).getClass().getName() + "\n");
        }
        sb.append("|| undo ||");
        return sb.toString();

    }
}
