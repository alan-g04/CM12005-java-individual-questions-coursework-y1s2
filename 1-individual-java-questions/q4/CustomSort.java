import java.util.ArrayList;

public class CustomSort implements SortingInterface {
    private ArrayList<Double> values;
    private ArrayList<Integer> gaps;

    public CustomSort() {
        this.values = new ArrayList<>();
        this.gaps = new ArrayList<>();
    }

    public void setValues(ArrayList<Double> values) {
        this.values = values;
        sort();
    }

    public ArrayList<Integer> getGaps() {
        return this.gaps;
    }

    public void add(Double value) {
        values.add(value);
        sort();
    }

    public void remove(int index) {
        if (index >= 0 && index < values.size()) {
            values.remove(index);
            sort();
        }
    }

    public void sort() {
        int n = values.size();
        gaps = calculate_gaps(values);
        
        for (int gap : gaps) {
            for (int i = gap; i <= n - 1; i++) {
                Double temp = values.get(i);
                int j = 0;
                
                for (j = i; j >= gap; j -= gap) {
                    if (values.get(j - gap) <= temp) {
                        break;
                    }
                    values.set(j, values.get(j - gap));
                }
                values.set(j, temp);
            }
        }
    }
    
    private ArrayList<Integer> calculate_gaps(ArrayList<Double> vals) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> calculatedGaps = new ArrayList<>();
        int n = vals.size();
        int gap = 1;
        int i = 2;
        
        while (gap < n) {
            temp.add(gap);
            gap = (1 << i) - 1; 
            i++;
        }
        
        for (int k = temp.size() - 1; k >= 0; k--) {
            calculatedGaps.add(temp.get(k));
        }
        
        return calculatedGaps;
    }
}