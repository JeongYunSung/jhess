package com.yunseong.jhess.domain.item.piece;

import com.yunseong.jhess.domain.item.Event;
import com.yunseong.jhess.domain.item.Item;
import com.yunseong.jhess.domain.item.EventType;

import java.util.function.Consumer;

public interface PieceItem extends Item<PieceResponse> {

    void addEventListener(EventType eventType, Consumer<Event<PieceResponse>> event);
}
