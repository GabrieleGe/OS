import java.util.Comparator;

/**
 * Created by sattas on 5/20/14.
 */

public class ArrayIndexComparator implements Comparator<Integer>
{
    private final int[] array;
    private final int n;

    public ArrayIndexComparator(int[] array, int n)
    {
        this.array = array;
        this.n = n;
    }

    public Integer[] createIndexArray()
    {
        Integer[] indexes = new Integer[this.n];
        for (int i = 0; i < this.n; i++)
        {
            indexes[i] = i; // Autoboxing
        }
        return indexes;
    }

    @Override
    public int compare(Integer index1, Integer index2)
    {
        // Autounbox from Integer to int to use as array indexes
        return Integer.valueOf(array[index1]).compareTo(array[index2]);
    }
}
