import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {


    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {

        }
        System.out.println(new PascalsTriangle2().getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> output = new ArrayList<>();

        output.add(1);

        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int j = 1; j < i; j++) {
                current.add(output.get(j - 1) + output.get(j));
            }
            current.add(1);
            output = current;
        }

        return output;
    }

}
