package com.yunseong.jhess.repository.domain.piece.event;

public interface Event<T> {

    T getTarget();
}
