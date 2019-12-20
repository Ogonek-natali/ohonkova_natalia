package ua.khpi.oop.Ohonkova06;
import java.util.Comparator;

	 public class StringLenghtSort implements Comparator<String> {
    /**
     * @param o1 - first string.
     * @param o2 - second string.
     * @return - ggg.
     */
	@Override
    public int compare(final String o1, final String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
	 }

