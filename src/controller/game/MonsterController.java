package controller.game;

import model.entity.monster.Monster;
import model.entity.player.Player;
import util.SoundEffects;
import view.panels.game.DisplayPanel;
import view.panels.game.MapPanel;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;

public class MonsterController {

    private static Monster monster;

    public static final double progressRateOfChange = 24.0 / MapPanel.FPS;

    public static void handleMonster() {
        monster = MonsterPanel.getMonster();
        Player player = PlayerPanel.getPlayer();
        if (MonsterPanel.isMonster()) {
            monster.takeAction();
            if (!SoundEffects.isBattleMusicPlaying()) {
                SoundEffects.playBattleMusic();
            }
            if (monster.getHP() <= 0) {
                SoundEffects.stopBattleMusic();
                SoundEffects.playThemeMusic();
                // DisplayPanel.appendConsoleModel("You killed " + monster + "!");
                monster.die();
                player.stopDefending();
                player.levelUp();
                MonsterPanel.clearMonster();
            }
        }
    }

    public static void progress() {
        monster = MonsterPanel.getMonster();
        if (PlayerPanel.getPlayer().getProgress() < 100) {
            monster.setProgress(monster.getProgress() + progressRateOfChange);
        }
    }

}
