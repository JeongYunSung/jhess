package com.yunseong.jhess.domain.item;

import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.common.TeamColor;

import java.util.function.Consumer;

public interface Item<T> {

    Position getPosition();

    TeamColor getTeam();

    void addEventListener(EventType eventType, Consumer<Event<T>> event);
}
