package Main;

public class FrameWaiter {
    private int framesToWait;
    private int currentFrame;

    public FrameWaiter(int framesToWait) {
        this.framesToWait = framesToWait;
        this.currentFrame = 0;
    }

    public boolean waitFrames() {
        if (currentFrame < framesToWait) {
            currentFrame++;
            return false; // Frames still to wait
        } else {
            return true; // Frames waited
        }
    }
}