package com.yunseong.jhess.domain.item.piece;

import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.item.Event;
import com.yunseong.jhess.domain.item.EventType;
import com.yunseong.jhess.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Consumer;

@Getter
@AllArgsConstructor
public class EmptyItem implements Item {
    @Override
    public Position getPosition() {
        return new Position(0, 0);
    }

    @Override
    public TeamColor getTeam() {
        return TeamColor.BLACK;
    }
}
