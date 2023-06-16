package controller;

import model.entity.monster.Monster;
import view.panels.game.DisplayPanel;
import view.panels.game.MonsterPanel;
import view.panels.game.PlayerPanel;

public class MonsterController {

    private static Monster monster;

    public static void handleMonster() {
        monster = MonsterPanel.getMonster();
        if (MonsterPanel.isMonster()) {
            monster.takeAction();
            if (monster.getHP() <= 0) {
                DisplayPanel.appendConsoleModel("You killed " + monster + "!");
                monster.dropGold();
                monster.giveExp();
                monster.dropItem();
                MonsterPanel.clearMonster();
            }
        }
    }

    public static void progress() {
        monster = MonsterPanel.getMonster();
        if (PlayerPanel.getPlayer().getProgress() < 100) {
            monster.setProgress(monster.getProgress() + (monster.getSpeed() / 10.0));
        }
    }

}
