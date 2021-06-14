package com.unrealdinnerbone.unreallib;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ActiveList<T> {
    private final List<T> list;
    private T activeValue;
    private int spot = 0;

    public ActiveList(List<T> list) throws IllegalArgumentException {
        this.list = list;
        if (list.size() > 0) {
            this.activeValue = list.get(spot);
        } else {
            throw new IllegalArgumentException("List must have at least one value");
        }
    }

    public List<T> getList() {
        return list;
    }

    @NotNull
    public T getActiveValue() {
        return activeValue;
    }

    public void setActiveValue(T t) throws IllegalArgumentException {
        if (list.contains(t)) {
            this.activeValue = t;
        }else {
            throw new IllegalArgumentException("List does not contain" + t.toString());
        }
    }

    public void setActiveNext() {
        if (list.size() > ++spot) {
            this.activeValue = list.get(spot);
        } else {
            this.activeValue = list.get(0);
            this.spot = 0;
        }
    }

    public int getSpot() {
        return spot;
    }
}