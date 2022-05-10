package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.event.*;
import com.yunseong.jhess.repository.domain.piece.exception.AlreadyDestroyedPieceException;
import com.yunseong.jhess.repository.domain.piece.strategy.MoveStrategy;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public abstract class Piece {

    private final String name;

    private int length;
    private Position position;
    private PieceSate pieceSate;
    private final Map<EventType, Consumer<Event>> events;
    public Piece(String name, int length, Position position) {
        this.name = name;
        this.length = length;
        this.position = position;
        this.pieceSate = PieceSate.INITIALIZED;
        this.events = new HashMap<>();
    }

    public void create() {
        this.pieceSate = PieceSate.CREATED;

        notifyEvent(EventType.CREATED, new PieceCreatedEvent(this));
    }

    public boolean move(Position position) {
        if(this.pieceSate != PieceSate.CREATED) throw new AlreadyDestroyedPieceException(this);

        if (!moveStrategies(position).canMove()) return false;

        this.position = position;

        notifyEvent(EventType.MOVED, new PieceMovedEvent(this));

        return true;
    }

    public void destroy() {
        if(this.pieceSate != PieceSate.CREATED) throw new AlreadyDestroyedPieceException(this);

        this.pieceSate = PieceSate.DESTROYED;

        notifyEvent(EventType.DESTROYED, new PieceDestroyedEvent(this));
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void addEventListener(EventType eventType, Consumer<Event> event) {
        this.events.put(eventType, event);
    }

    private void notifyEvent(EventType eventType, Event event) {
        if(this.events.containsKey(eventType)) {
            this.events.get(eventType).accept(event);
        }
    }

    public abstract MoveStrategy moveStrategies(Position position);
}
