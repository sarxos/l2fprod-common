package com.github.sarxos.l2fprod.sheet;

public interface Converter<T> {

	T toObject(String string);

	String toString(T object);
}
