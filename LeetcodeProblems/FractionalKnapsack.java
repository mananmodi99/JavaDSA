package LeetcodeProblems;

public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2){
                double v1 = (double) i1.value;
                double w1 = (double) i1.weight;
                double v2 = (double) i2.value;
                double w2 = (double) i2.weight;
                double c1 = v1/w1;
                double c2 = v2/w2;
                if(c1<c2) return 1;
                else if(c1>c2) return -1;
                else return 0;

            }
        });
        double totalValue = 0.0;
        for (Item i : arr) {

            int curWt = (int)i.weight;
            int curVal = (int)i.value;

            if (W - curWt >= 0) {
                W = W - curWt;
                totalValue += curVal;
            }
            else {

                double fraction = ((double)W / (double)curWt);
                totalValue += (curVal * fraction);
                W
                        = (int)(W - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }
}
