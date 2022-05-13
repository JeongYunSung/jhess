package com.yunseong.jhess.repository.domain.module;

public class GameUtil {

    public static Direction getDirection(Position position, Position target) {
        final int x = target.getX() - position.getX();
        final int y = target.getY() - position.getY();

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
