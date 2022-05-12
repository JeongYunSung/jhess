package com.yunseong.jhess.repository.domain.game;

import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.EmptyItem;
import com.yunseong.jhess.repository.domain.piece.Item;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmptyBoard implements Board {

    private Position size;

    @Override
    public Position getSize() {
        return this.size;
    }

    @Override
    public Item getTarget(Position position) {
        return new EmptyItem(position);
    }

    @Override
    public boolean isExistItem(Position position) {
        return false;
    }
}
