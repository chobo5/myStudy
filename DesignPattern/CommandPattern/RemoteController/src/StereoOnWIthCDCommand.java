public class StereoOnWIthCDCommand implements Command{
    Stereo stereo;

    public StereoOnWIthCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }
}
