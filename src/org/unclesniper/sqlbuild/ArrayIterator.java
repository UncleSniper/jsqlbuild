package org.unclesniper.sqlbuild;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.NoSuchElementException;

public class ArrayIterator<ElementT> implements Iterator<ElementT> {

    private final ElementT[] elements;

    private int index;

    public ArrayIterator(ElementT[] elements) {
        this.elements = elements;
    }

    public boolean hasNext() {
        return index < elements.length;
    }

    public ElementT next() {
        if (index < elements.length) {
            return elements[index++];
        } else {
            throw new NoSuchElementException();
        }
    }

    public void forEachRemaining(Consumer<? super ElementT> action) {
        for (; index < elements.length; ++index) {
            action.accept(elements[index]);
        }
    }

}
