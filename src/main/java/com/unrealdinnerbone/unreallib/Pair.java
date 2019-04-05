package com.unrealdinnerbone.unreallib;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair<A, B> {
    private final A a;
    private final B b;
}
