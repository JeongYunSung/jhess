package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmptyItem implements Item {

    private Position position;
}
