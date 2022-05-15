package com.yunseong.jhess.util;

import com.yunseong.jhess.domain.common.Direction;
import com.yunseong.jhess.domain.common.Position;

public class GameUtil {

    public static Direction getDirection(Position position, Position target) {
        final int x = target.getX() - position.getX();
        final int y = target.getY() - position.getY();

        final int gcd = getGcd(x, y);

        if(gcd == 0) return Direction.getDirection(x, y);

        return Direction.getDirection(x/gcd, y/gcd);
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
