package util;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffects {

    // Sound effect stuff
    private Clip clip;
    private URL[] soundEffectUrls = new URL[1];
    public static final int MONSTER_DIE = 0;
    private final String monsterDiePath = "";

    // Static theme song stuff
    private static Clip themeMusicClip;
    private static final String gameThemePath = "/sounds/Lilium.wav";
    private static URL gameThemeUrl = SoundEffects.class.getResource(gameThemePath);

    public SoundEffects() {

        soundEffectUrls[0] = getClass().getResource(monsterDiePath);

    }

    // -------------------------------------- Sound effects ---------------------------------------
    private void setClip(int i) {
        try {
            this.clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundEffectUrls[i]);
            this.clip.open(ais);
        } catch (IOException | UnsupportedAudioFileException | NullPointerException | LineUnavailableException e) {
            System.out.println(SoundEffects.class + "setSoundFile threw an exception. Probably a problem with file path.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: Make dialogue box show up instead
            throw new ArrayIndexOutOfBoundsException("Index out of bounds for " + SoundEffects.class + " on soundUrls array.");
        }
    }

    private void play() {
        this.clip.start();
    }

    public void playSE(int i) {
        this.setClip(i);
        this.play();
    }

    /* Might not use
    private void stop() {
        this.clip.stop();
    }
    */

    // -------------------------------- Theme Music ------------------------------------------------------------
    private static void setMusicClip () {
        try {
            themeMusicClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(gameThemeUrl);
            themeMusicClip.open(ais);
        } catch (IOException | UnsupportedAudioFileException | NullPointerException | LineUnavailableException e) {
            System.out.println(SoundEffects.class + "setMusicClip threw an exception. Probably a problem with file path.");
        }
    }

    public static void playMusic() {
        setMusicClip();
        themeMusicClip.start();
        themeMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
