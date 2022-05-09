package com.yunseong.jhess.repository.domain.api;

public class GameUtil {

    public static Direction getDirection(Position position1, Position position2) {
        final int x = position2.getX() - position1.getX();
        final int y = position2.getY() - position1.getY();

        final int gcd = getGcd(x, y);

        if(gcd == 0) return Direction.getDirection(x, y);

        return Direction.getDirection(x/gcd, y/gcd);
    }

    public static boolean isTeam(Color color1, Color color2) {
        return color1 == color2;
    }

    public static int getGcd(int x, int y) {
        int temp;
        if(x < y) {
            temp = x;
            x = y;
            y = temp;
        }
        while(y>0) {
            temp = x%y;
            x = y;
            y = temp;
        }
        return x;
    }
}
