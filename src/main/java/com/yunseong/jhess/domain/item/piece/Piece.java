package com.yunseong.jhess.domain.item.piece;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.item.Event;
import com.yunseong.jhess.domain.item.EventType;
import com.yunseong.jhess.domain.item.Item;
import com.yunseong.jhess.domain.item.MoveStrategy;
import com.yunseong.jhess.domain.item.piece.event.PieceDestroyedEvent;
import com.yunseong.jhess.domain.item.piece.event.PieceMovedEvent;
import com.yunseong.jhess.exception.AlreadyDestroyedPieceException;
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
    private final TeamColor team;
    @Getter
    private Position position;
    @Getter
    private PieceSate state;

    private final Map<EventType, Consumer<Event<PieceResponse>>> events;

    public Piece(String name, Board board, TeamColor color, Position position) {
        this.name = name;
        this.board = board;
        this.team = color;
        this.position = position;
        this.state = PieceSate.CREATED;
        this.events = new HashMap<>();
    }
    public boolean move(Position position) {
        if(this.state != PieceSate.CREATED) throw new AlreadyDestroyedPieceException(this);

        if (!moveStrategies(position).canMove()) return false;

        this.position = position;

        notifyEvent(EventType.MOVED, new PieceMovedEvent(new PieceResponse(this)));

        return true;
    }

    public void destroy() {
        if(this.state != PieceSate.CREATED) throw new AlreadyDestroyedPieceException(this);

        this.state = PieceSate.DESTROYED;

        notifyEvent(EventType.DESTROYED, new PieceDestroyedEvent(new PieceResponse(this)));
    }
    public void addEventListener(EventType eventType, Consumer<Event<PieceResponse>> event) {
        this.events.put(eventType, event);
    }
    private void notifyEvent(EventType eventType, Event<PieceResponse> event) {
        if(this.events.containsKey(eventType)) {
            this.events.get(eventType).accept(event);
        }
    }

    protected abstract MoveStrategy moveStrategies(Position position);
}
