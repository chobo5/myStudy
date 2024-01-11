public class StereoOffWIthCDCommand implements Command{
    Stereo stereo;

    public StereoOffWIthCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
