import java.util.Arrays;
import java.util.Comparator;

public class Task03 {
    //  in one line
    public static void printArray(String[] arr) {
        for (String str : arr) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void sortReverse(String[] arr) {
        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER.reversed());
    }

    public static void sortByWordCount(String[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(s -> s.split("\\s+").length));
        // split into words if SPACE
    }

    public static void main(String[] args) {
        String[] texts = {
                "Bad guy",
                "Planning is a key to Success",
                "World big 6",
                "Chop chop chop..."
        };

        System.out.println("Initial array:");
        printArray(texts);

        String[] reverseSorted = Arrays.copyOf(texts, texts.length);
        sortReverse(reverseSorted);
        System.out.println("\nSorted in reverse (Z to A):");
        printArray(reverseSorted);

        // Sort by number of words
        String[] wordCountSorted = Arrays.copyOf(texts, texts.length);
        sortByWordCount(wordCountSorted);
        System.out.println("\nSorted by word number:");
        printArray(wordCountSorted);
    }
}
