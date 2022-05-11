package com.yunseong.jhess.repository.domain.game;

import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.Item;

public interface Board {

    Position getSize();

    Item getTarget(Position position);
}
