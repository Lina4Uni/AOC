import java.util.List;
import java.util.ArrayList;
class Day01 {

    public static void main(String[] args) {
        printData2();
    }

    public static void printData()
    {
        List<String[]> data = DataReader.readData("   ", "data01_01.txt");
        ArrayList<Integer> leftValues = new ArrayList<>();
        ArrayList<Integer> rightValues = new ArrayList<>();
        for (String[] values : data) {
            leftValues.add(Integer.parseInt(values[0]));
            rightValues.add(Integer.parseInt(values[1]));
        }
        leftValues.sort(Integer::compareTo);
        rightValues.sort(Integer::compareTo);
        int sum = 0;
        while (leftValues.size() > 0) {
            int left = leftValues.get(0);
            int right = rightValues.get(0);
            sum += Math.abs(left - right);
            leftValues.remove(0);
            rightValues.remove(0);
        }
        System.out.println(sum);
    }

    public static void printData2() {
        List<String[]> data = DataReader.readData("   ", "data01_02.txt");
        ArrayList<Integer> leftValues = new ArrayList<>();
        ArrayList<Integer> rightValues = new ArrayList<>();

        for (String[] values : data) {
            try {
                leftValues.add(Integer.parseInt(values[0]));
                rightValues.add(Integer.parseInt(values[1]));
            } catch (NumberFormatException e) {
                System.err.println("Ungültige Datenzeile: ");
            }
        }

        leftValues.sort(Integer::compareTo);
        rightValues.sort(Integer::compareTo);

        int sum = 0;

        for (int left : leftValues) {
            int count = 0;
            for (int i = 0; i < rightValues.size(); i++) {
                if (rightValues.get(i) == left) {
                    count++;
                }
            }

            sum += left * count;
        }

        System.out.println("Gesamtsumme: " + sum);
    }

}