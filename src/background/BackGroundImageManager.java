package background;

import background.BackgroundImage;

import javax.swing.*;

public class BackGroundImageManager {

    BackgroundImage bgi;

    public BackGroundImageManager() {
        bgi = new BackgroundImage();
    }

    //Selects the appropriate bg Image. See bgImageTable.txt
    public ImageIcon getBackgroundImage(int tileType, char facing) {
        // facing = String.valueOf(facing).toUpperCase().charAt(0);
        if (facing == 'U' && (tileType == 0 || tileType == 3) || facing == 'D' && (tileType == 0 || tileType == 1) ||
                facing == 'L' && (tileType == 0 || tileType == 2) || facing == 'R' && (tileType == 0 || tileType == 4)) {
            return bgi.getBackgroundImage(0);
        }
        else if (facing == 'U' && (tileType == 1 || tileType == 9) || facing =='D'  && (tileType == 3 || tileType == 9)
                || facing == 'L' && (tileType == 4 || tileType == 10) || facing == 'R' && (tileType == 2 || tileType == 10)) {
            return bgi.getBackgroundImage(1);
        }
        else if (facing == 'U' && (tileType == 4 || tileType == 7) || facing =='D'  && (tileType == 2 || tileType == 5)
                || facing == 'L' && (tileType == 3 || tileType == 6) || facing == 'R' && (tileType == 1 || tileType == 8)) {
            return  bgi.getBackgroundImage(2);
        }
        else if (facing == 'U' && (tileType == 2 || tileType == 6) || facing =='D'  && (tileType == 4 || tileType == 8)
                || facing == 'L' && (tileType == 1 || tileType == 5) || facing == 'R' && (tileType == 3 || tileType == 7)) {
            return  bgi.getBackgroundImage(3);
        }
        else if (facing == 'U' && (tileType == 10 || tileType == 11) || facing =='D'  && (tileType == 10 || tileType == 13)
                || facing == 'L' && (tileType == 9 || tileType == 14) || facing == 'R' && (tileType == 9 || tileType == 12)) {
            return  bgi.getBackgroundImage(4);
        }
        else if (facing == 'U' && (tileType == 5 || tileType == 14) || facing =='D'  && (tileType == 7 || tileType == 12)
                || facing == 'L' && (tileType == 8 || tileType == 13) || facing == 'R' && (tileType == 6 || tileType == 11)) {
            return  bgi.getBackgroundImage(5);
        }
        else if (facing == 'U' && (tileType == 8 || tileType == 12) || facing =='D'  && (tileType == 6 || tileType == 14)
                || facing == 'L' && (tileType == 7 || tileType == 11) || facing == 'R' && (tileType == 5 || tileType == 13)) {
            return  bgi.getBackgroundImage(6);
        }
        else {
            return bgi.getBackgroundImage(7);
        }
    }
}
