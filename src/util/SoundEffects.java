package util;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffects {

    // Sound effect stuff
    private Clip clip;
    public static final int MONSTER_ATTACK = 0;
    public static final int MONSTER_DIE = 1;
    public static final int PLAYER_ATTACK = 2;
    public static final int ATTACK_ITEM = 3;
    public static final int HEAL_ITEM = 4;
    public static final int ATTACK_SPELL = 5;
    public static final int HEAL_SPELL = 6;
    public static final int STEAL_SPELL = 7;
    public static final int OPEN_CHEST = 8;
    public static final int STAIRS = 9;
    private final URL[] soundEffectUrls = new URL[10];

    // Static theme song stuff
    private static Clip themeMusicClip;
    private static final URL gameThemeUrl = SoundEffects.class.getResource("/sounds/Lilium.wav");

    // Static battle song stuff
    private static Clip battleMusicClip;
    private static final URL gameBattleUrl = SoundEffects.class.getResource("/sounds/Boogie.wav");
    private static boolean isBattleMusicPlaying;

    public SoundEffects() {

        soundEffectUrls[MONSTER_ATTACK] = getClass().getResource("/sounds/basic/Monster-attack.wav");
        soundEffectUrls[MONSTER_DIE] = getClass().getResource("/sounds/basic/Monster-die.wav");
        soundEffectUrls[PLAYER_ATTACK] = getClass().getResource("/sounds/basic/Player-attack.wav");
        soundEffectUrls[ATTACK_ITEM] = getClass().getResource("/sounds/item/Attack-item.wav");
        soundEffectUrls[HEAL_ITEM] = getClass().getResource("/sounds/item/Heal-item.wav");
        soundEffectUrls[ATTACK_SPELL] = getClass().getResource("/sounds/spell/Attack-spell.wav");
        soundEffectUrls[HEAL_SPELL] = getClass().getResource("/sounds/spell/Heal-spell.wav");
        soundEffectUrls[STEAL_SPELL] = getClass().getResource("/sounds/spell/Steal-spell.wav");
        soundEffectUrls[OPEN_CHEST] = getClass().getResource("/sounds/tile_object/Open-chest.wav");
        soundEffectUrls[STAIRS] = getClass().getResource("/sounds/tile_object/Stairs.wav");

    }

    // -------------------------------------- Sound effects ---------------------------------------
    private void setClip(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundEffectUrls[i]);
            this.clip = AudioSystem.getClip();
            this.clip.open(ais);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | NullPointerException e) {
            System.out.println(SoundEffects.class + "setSoundFile threw an exception. Probably a problem with file path.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: Make dialogue box show up instead
            throw new ArrayIndexOutOfBoundsException("Index out of bounds for " + SoundEffects.class + " on soundEffectUrls array.");
        }
    }

    private void play() {
        try {
            this.clip.start();
        } catch (NullPointerException e) {
            System.out.println("I can't play your stupid clip because " + e.getClass() + " in " + SoundEffects.class + ".play()");
        }

    }

    public void playSE(int i) {
        this.setClip(i);
        this.play();
    }

    // -------------------------------- Theme Music ------------------------------------------------------------
    private static void setThemeClip() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(gameThemeUrl);
            themeMusicClip = AudioSystem.getClip();
            themeMusicClip.open(ais);
        } catch (IOException | UnsupportedAudioFileException | NullPointerException | LineUnavailableException e) {
            System.out.println(SoundEffects.class + "setThemeClip threw an exception. Probably a problem with file path.");
        }
    }

    public static void playThemeMusic() {
        setThemeClip();
        themeMusicClip.start();
        themeMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // -------------------------------- Theme Music ------------------------------------------------------------
    private static void setBattleClip() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(gameBattleUrl);
            battleMusicClip = AudioSystem.getClip();
            battleMusicClip.open(ais);
        } catch (IOException | UnsupportedAudioFileException | NullPointerException | LineUnavailableException e) {
            System.out.println(SoundEffects.class + "setBattleClip threw an exception. Probably a problem with file path.");
        }
    }

    public static boolean isBattleMusicPlaying() {
        return isBattleMusicPlaying;
    }

    public static void playBattleMusic() {
        setBattleClip();
        themeMusicClip.stop();
        battleMusicClip.start();
        isBattleMusicPlaying = true;
        battleMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void endBattleMusic () {
        battleMusicClip.stop();
        isBattleMusicPlaying = false;
        playThemeMusic();
    }

}
