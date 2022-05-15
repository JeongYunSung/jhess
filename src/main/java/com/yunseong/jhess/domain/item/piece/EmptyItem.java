package com.yunseong.jhess.domain.item.piece;

import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.item.Item;
import lombok.Getter;

@Getter
public class EmptyItem implements Item {

    public static final Item getInstance = new EmptyItem();

    private EmptyItem() {}

    @Override
    public Position getPosition() {
        return new Position(0, 0);
    }

    @Override
    public TeamColor getTeam() {
        return TeamColor.BLACK;
    }
}
