package com.yunseong.jhess.repository.domain.game;

import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.Item;

public interface Board {

    Position getSize();

    Item getItem(Position position);

    void move(Position position, Position target);

    void process();

    void finish();

    boolean isExistItem(Position position);
}
