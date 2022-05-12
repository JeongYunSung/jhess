package com.yunseong.jhess.repository.domain.game;

import com.yunseong.jhess.repository.domain.module.Position;

public interface Board {

    Position getSize();

    boolean isExistItem(Position position);
}
