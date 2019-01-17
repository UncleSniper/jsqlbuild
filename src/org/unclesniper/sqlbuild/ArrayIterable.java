package org.unclesniper.sqlbuild;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayIterable<ElementT> implements Iterable<ElementT> {

    private final ElementT[] elements;

    public ArrayIterable(ElementT[] elements) {
        this(elements, true);
    }

    public ArrayIterable(ElementT[] elements, boolean copyArray) {
        this.elements = copyArray ? Arrays.copyOf(elements, elements.length) : elements;
    }

    public ElementT[] getElements() {
        return elements;
    }

    public Iterator<ElementT> iterator() {
        return new ArrayIterator<ElementT>(elements);
    }

}
