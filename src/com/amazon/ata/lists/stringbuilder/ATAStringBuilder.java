package com.amazon.ata.lists.stringbuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A mutable sequence of characters.
 */
public class ATAStringBuilder {

    // tracks the mutable sequence of characters
    private final List<Character> value;

    /**
     * COMPLETION 1
     * Constructs a string builder with no characters in it.
     */
    public ATAStringBuilder() {
        value = new ArrayList<>();
    }

    /**
     * COMPLETION 1
     * Constructs a string builder initialized to the contents of the specified string.
     *
     * @param initialString the initial contents of the string builder
     */
    public ATAStringBuilder(String initialString) {
        // PARTICIPANTS - initialize here
        value = new ArrayList<>();
        this.append(initialString);
    }

    /**
     * COMPLETION 2
     * Returns the length (character count).
     *
     * @return the length of the sequence of characters currently
     * represented by this object
     */
    public int length() {
        return value.size();
    }

    /**
     * COMPLETION 2
     *
     * Appends the specified string.
     * <p>
     * The characters of the {@code String} argument are appended, in order, increasing the length of this sequence by the length of the argument.
     * If {@code str} is {@code null}, then the four characters {@code "null"} are appended.
     *
     * @param str a string, to be appended.
     * @return a reference to this object.
     */
    public ATAStringBuilder append(String str) {
        if (str == null) {
            this.append("null");
        } else {
            for (int i = 0; i < str.length(); i++) {
                value.add(str.charAt(i));
            }
        }
        return this;
    }

    /**
     * COMPLETION 2
     *
     * Inserts the {@code char} argument into this sequence.
     * <p>
     * The {@code offset} argument must be greater than or equal to {@code 0},
     * and less than or equal to the {@linkplain #length() length} of this sequence.
     *
     * @param offset the offset.
     * @param c      a {@code char}.
     * @return a reference to this object.
     * @throws IndexOutOfBoundsException if the offset is invalid.
     */
    public ATAStringBuilder insert(int offset, char c) {
        if (offset > this.length()) {
            throw new IndexOutOfBoundsException("Out of Bounds_ - _ -");
        }
        value.add(offset, c);
        return this;
    }

    /**
     * COMPLETION 2
     *
     * Returns the {@code char} value in this sequence at the specified index.
     * The first {@code char} value is at index {@code 0}, the next at index
     * {@code 1}, and so on, as in array indexing.
     * <p>
     * The index argument must be greater than or equal to
     * {@code 0}, and less than the length of this sequence.
     *
     * @param index the index of the desired {@code char} value.
     * @return the {@code char} value at the specified index.
     * @throws IndexOutOfBoundsException if {@code index} is
     *                                   negative or greater than or equal to {@code length()}.
     */
    public char charAt(int index) {
        if (index >= value.size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return value.get(index);
    }

    /**
     * EXTENSION 1
     * <p>
     * The character at the specified index is set to {@code ch}. This
     * sequence is altered to represent a new character sequence that is
     * identical to the old character sequence, except that it contains the
     * character {@code ch} at position {@code index}.
     * <p>
     * The index argument must be greater than or equal to
     * {@code 0}, and less than the length of this sequence.
     *
     * @param index the index of the character to modify.
     * @param ch    the new character.
     * @return This object.
     * @throws IndexOutOfBoundsException if {@code index} is
     *                                   negative or greater than or equal to {@code length()}.
     */
    public ATAStringBuilder setCharAt(int index, char ch) {
        if (index >= value.size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        value.set(index, ch);
        return this;
    }

    /**
     * EXTENSION 1
     * <p>
     * Removes the {@code char} at the specified position in this sequence. This sequence is shortened by one.
     *
     * @param index Index of {@code char} to remove
     * @return This object.
     * @throws StringIndexOutOfBoundsException if the {@code index}
     *                                         is negative or greater than or equal to
     *                                         {@code length()}.
     */
    public ATAStringBuilder deleteCharAt(int index) {
        if (index >= value.size()) {
            throw new StringIndexOutOfBoundsException("Index is out of bounds");
        }
        value.remove(index);
        return this;
    }

    /**
     * EXTENSION 2
     * <p>
     * Returns a new {@code String} that contains a subsequence of characters currently contained in this sequence.
     * The substring begins at the specified {@code start} and extends to the character at index {@code end - 1}.
     *
     * @param start The beginning index, inclusive.
     * @param end   The ending index, exclusive.
     * @return The new string.
     * @throws StringIndexOutOfBoundsException if {@code start} or {@code end} are negative or greater than {@code length()},
     * or {@code start} is greater than {@code end}.
     */
    public String substring(int start, int end) {
        if (start < 0 || end < 0) {
            throw new IndexOutOfBoundsException("Index is below 0");
        }
        if (start > end) {
            throw new IndexOutOfBoundsException("Start index greater than end index.");
        }

        List<Character> charList = value.subList(start, end);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: charList) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * EXTENSION 2
     * <p>
     * Inserts the string into this builder.
     * <p>
     * The characters of the {@code String} argument are inserted, in
     * order, into this sequence at the indicated offset, moving up any
     * characters originally above that position and increasing the length
     * of this sequence by the length of the argument.
     * <p>
     * If {@code str} is {@code null}, then the four characters
     * {@code "null"} are inserted into this sequence.
     * <p>
     * The {@code offset} argument must be greater than or equal to
     * {@code 0}, and less than or equal to the {@linkplain #length() length}
     * of this sequence.
     *
     * @param offset the offset where the string should be inserted.
     * @param str    a string, to be inserted.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException if the offset is invalid.
     */
    //CHECKSTYLE:OFF:OverloadMethodsDeclarationOrder
    public ATAStringBuilder insert(int offset, String str) {
        if (offset < 0 || offset > value.size()) {
            throw new StringIndexOutOfBoundsException("Index is out of bounds");
        }
        ArrayList<Character> newList = new ArrayList<>();
        for (char c: str.toCharArray()) {
            newList.add(c);
        }
        value.addAll(offset, newList);
        return this;
    }
    //CHECKSTYLE:ON:OverloadMethodsDeclarationOrder

    /**
     * EXTENSION 2
     * <p>
     * Appends the string representation of the {@code Object} argument, using the method String.valueOf.
     * <p>
     * If {@code obj} is {@code null}, then the four characters {@code "null"} are appended.
     *
     * @param obj an {@code Object}, to be appended.
     * @return a reference to this object.
     */
    //CHECKSTYLE:OFF:OverloadMethodsDeclarationOrder
    public ATAStringBuilder append(Object obj) {
        this.append(Objects.requireNonNullElse(String.valueOf(obj), "null"));
        return this;
    }
    //CHECKSTYLE:ON:OverloadMethodsDeclarationOrder

    @Override
    public String toString() {
        char[] charArray = transformListToArray(value);
        return new String(charArray);
    }

    private char[] transformListToArray(List<Character> list) {
        char[] transformed = new char[list.size()];
        for (int index = 0; index < list.size(); index++) {
            transformed[index] = list.get(index);
        }

        return transformed;
    }
}
