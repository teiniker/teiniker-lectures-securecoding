Java methods used for byte-array processing
-------------------------------------------------------------------------------

java.util.Arrays
public static String toString(byte[] a)
-------------------------------------------------------------------------------
Returns a string representation of the contents of the specified array.
The string representation consists of a list of the array's elements, enclosed
in square brackets ("[]").
Adjacent elements are separated by the characters ", " (a comma followed by a space).
Elements are converted to strings as by String.valueOf(byte).
Returns "null" if a is null.


java.util.Arrays
public static boolean equals(byte[] a, byte[] a2)
-------------------------------------------------------------------------------
Returns true if the two specified arrays of bytes are equal to one another.
Two arrays are considered equal if both arrays contain the same number of
elements, and all corresponding pairs of elements in the two arrays are equal.

In other words, two arrays are equal if they contain the same elements in the
same order. Also, two array references are considered equal if both are null.


java.util.Arrays
public static void fill(byte[] a, byte val)
-------------------------------------------------------------------------------
Assigns the specified byte value to each element of the specified array of bytes.


java.util.Arrays
public static void fill(boolean[] a, int fromIndex, int toIndex, boolean val)
-------------------------------------------------------------------------------
Assigns the specified boolean value to each element of the specified range of
the specified array of booleans. The range to be filled extends from index
fromIndex, inclusive, to index toIndex, exclusive. (If fromIndex==toIndex,
the range to be filled is empty.)


java.util.Arrays
public static byte[] copyOf(byte[] original, int newLength)
-------------------------------------------------------------------------------
Copies the specified array, truncating or padding with zeros (if necessary) so
the copy has the specified length. For all indices that are valid in both the
original array and the copy, the two arrays will contain identical values.
For any indices that are valid in the copy but not the original, the copy will
contain (byte)0.
Such indices will exist if and only if the specified length is greater than that
of the original array.


java.util.Arrays
public static byte[] copyOfRange(byte[] original, int from, int to)
-------------------------------------------------------------------------------
Copies the specified range of the specified array into a new array.
The initial index of the range (from) must lie between zero and original.length,
inclusive.
The value at original[from] is placed into the initial element of the copy
(unless from == original.length or from == to).
Values from subsequent elements in the original array are placed into subsequent
elements in the copy.
The final index of the range (to), which must be greater than or equal to from,
may be greater than original.length, in which case (byte)0 is placed in all elements
of the copy whose index is greater than or equal to original.length - from.
The length of the returned array will be to - from.


java.lang.System
public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
-------------------------------------------------------------------------------
Copies an array from the specified source array, beginning at the specified
position, to the  specified position of the destination array.
A subsequence of array components are copied from the source array referenced
by src to the destination array referenced by dest.
The number of components copied is equal to the length argument.
The components at positions srcPos through srcPos+length-1 in the source array
are copied  into positions destPos through destPos+length-1, respectively, of
the destination array.


References:
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html
