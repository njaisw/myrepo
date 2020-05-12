package _com.ds.dynamic;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggDropping_IMP_3 {

    public int calculate(int eggs, int floors){
        
        int T[][] = new int[eggs+1][floors+1];
        int c =0;
        //TODO For egg-1 T[i] = i
        for(int i=0; i <= floors; i++){
            T[1][i] = i;
        }
        
        for(int e = 2; e <= eggs; e++){
            for(int f = 1; f <=floors; f++){
                T[e][f] = Integer.MAX_VALUE;
                for(int k = 1; k <=f ; k++){
                    c = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    //TODO 1+ min (max(T[e][k], T[e][f-k])).
                    if(c < T[e][f]){
                        T[e][f] = c;
                    }
                }
            }
        }
        return T[eggs][floors];
    }
    @Deprecated
    public int calculateRecursive(int eggs, int floors){
        if(eggs == 1){
            return floors;
        }
        if(floors == 0){
            return 0;
        }
        int min = 1000;
        for(int i=1; i <= floors; i++){
            int val = 1 + Math.max(calculateRecursive(eggs-1, i-1),calculateRecursive(eggs, floors-i));
            if(val < min){
                min = val;
            }
        }
        return min;
    }
    
    public static void main(String args[]){
        EggDropping_IMP_3 ed = new EggDropping_IMP_3();
        int r = ed.calculate(3,100);
        System.out.println(r);
    }
}
