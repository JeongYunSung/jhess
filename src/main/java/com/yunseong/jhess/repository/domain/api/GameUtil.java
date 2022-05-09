package com.yunseong.jhess.repository.domain.api;

public class GameUtil {

    public static Direction getDirection(Position position1, Position position2) {
        final int x = position2.getX() - position1.getX();
        final int y = position2.getY() - position1.getY();

        return null;
    }

    public static boolean isTeam(Color color1, Color color2) {
        return color1 == color2;
    }
}
