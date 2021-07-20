package com.ishostak.tasks.lec12_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ProtectedArrayList<T> extends ArrayList<T> {

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation not allowed");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("This operation not allowed");
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("This operation not allowed");
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("This operation not allowed");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This operation not allowed");
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("This operation not allowed");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("This operation not allowed");
    }

    @Override
    public boolean removeIf(Predicate filter) {
        throw new UnsupportedOperationException("This operation not allowed");
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
         throw new UnsupportedOperationException("This operation not allowed");
    }
}
