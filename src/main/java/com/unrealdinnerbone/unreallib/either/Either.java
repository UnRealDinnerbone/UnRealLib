package com.unrealdinnerbone.unreallib.either;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@NotNull
public class Either<L,R> {

    public static <L, R> Either<L, R> left(L value) {
        return new Either<>(Optional.of(Optional.ofNullable(value)), Optional.empty());
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Either<>(Optional.empty(), Optional.of(Optional.ofNullable(value)));
    }

    private final Optional<Optional<L>> left;
    private final Optional<Optional<R>> right;

    private Either(Optional<Optional<L>> l, Optional<Optional<R>> r) {
        left = l;
        right = r;
    }

    public <T> T map(Function<? super L, ? extends T> lFunc, Function<? super R, ? extends T> rFunc) {
        return left.<T>map(l -> lFunc.apply(l.orElse(null))).orElseGet(() -> right.map(r -> rFunc.apply(r.orElse(null))).get());
    }

    public <T> Either<T, R> mapLeft(Function<? super L, ? extends T> lFunc) {
        return new Either<>(left.map(l -> l.map(lFunc)), right);
    }

    public <T> Either<L, T> mapRight(Function<? super R, ? extends T> rFunc) {
        return new Either<>(left, right.map(r -> r.map(rFunc)));
    }

    public void apply(Consumer<? super L> lFunc, Consumer<? super R> rFunc) {
        left.ifPresent(l -> lFunc.accept(l.orElse(null)));
        right.ifPresent(r -> rFunc.accept(r.orElse(null)));
    }

}