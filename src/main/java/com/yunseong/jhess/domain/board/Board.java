package com.yunseong.jhess.domain.board;

import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.Item;

public interface Board {

    Position getSize();

    Item getItem(Position position);

    boolean addItem(Item item);

    void move(Position position, Position target);

    boolean isExistItem(Position position);
}
