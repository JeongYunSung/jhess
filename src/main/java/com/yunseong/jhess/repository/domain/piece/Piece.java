package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.module.Color;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.event.*;
import com.yunseong.jhess.repository.domain.piece.exception.AlreadyDestroyedPieceException;
import com.yunseong.jhess.repository.domain.piece.strategy.MoveStrategy;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class Piece implements Item {

    @Getter
    private final String name;
    @Getter
    private final Board board;
    @Getter
    private final Color color;
    @Getter
    private Position position;
    @Getter
    private PieceSate state;
    private final Map<EventType, Consumer<PieceEvent>> events;
    public Piece(String name, Board board, Color color, Position position) {
        this.name = name;
        this.board = board;
        this.color = color;
        this.position = position;
        this.state = PieceSate.INITIALIZED;
        this.events = new HashMap<>();
    }

    public void create() {
        this.state = PieceSate.CREATED;

        notifyEvent(EventType.CREATED, new PieceCreatedEvent(new PieceResponse(this)));
    }

    @Override
    public boolean move(Position position) {
        if(this.state != PieceSate.CREATED) throw new AlreadyDestroyedPieceException(this);

        if (!moveStrategies(position).canMove()) return false;

        this.position = position;

        notifyEvent(EventType.MOVED, new PieceMovedEvent(new PieceResponse(this)));

        return true;
    }

    public void addEventListener(EventType eventType, Consumer<PieceEvent> event) {
        this.events.put(eventType, event);
    }

    public void destroy() {
        if(this.state != PieceSate.CREATED) throw new AlreadyDestroyedPieceException(this);

        this.state = PieceSate.DESTROYED;

        notifyEvent(EventType.DESTROYED, new PieceDestroyedEvent(new PieceResponse(this)));
    }
    private void notifyEvent(EventType eventType, PieceEvent event) {
        if(this.events.containsKey(eventType)) {
            this.events.get(eventType).accept(event);
        }
    }

    protected abstract MoveStrategy moveStrategies(Position position);
}
