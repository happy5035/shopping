import java.util.*;

/**
 * Created by LeeYuan on 2016/9/12.
 */
public class test {

    public static void main(String[] args) {
        Integer a = 0;
        Integer b = 40;
        List<Integer> t = new ArrayList<Integer>();
        t.add(2);
        t.add(5);

        t.add(8);
        t.add(20);
        t.add(50);

        a = t.get(0);
        b = t.get(t.size() - 1);

        List countArray = countofnum(a, b);


        Map<Integer, Integer> map = new TreeMap<>();  // new HashMap < Integer, Integer>();
        int index = 0;
        int _t = t.get(index);
        for (Object c: countArray) {
            Integer i = (Integer) c;
            if (i < _t) {
                Integer count = map.get(_t);
                if (count == null) {
                    count = new Integer(0);
                }
                count = count + 1;
                map.put(_t, count);
            } if (i>_t){
                index++;
                _t = t.get(index);
                Integer count = map.get(_t);
                if (count == null) {
                    count = new Integer(0);
                }
                count = count + 1;
                map.put(_t, count);
            }
        }
        System.out.println(map);
        List<Integer> values = new ArrayList<Integer>();
        for (int i = 1 ; i<t.size();i++) {
            values.add(map.get(t.get(i)));
        }
        int sum = 0;
        for (int i = 0 ;i<values.size();i++) {
            for (int j =i; j<values.size(); j++) {
                int counts = 0;
                for (int k = i;k<=j;k++) {
                    counts += values.get(k);
                }
                sum += counts;
            }
        }
        System.out.println(sum);

    }

    private static List countofnum(int a,int b) {

        List countArray = new ArrayList<Integer>();
        for (int i =a+1; i<b ;i++) {
            if (i == 0 ) continue;
            boolean issus = false;
            for (int j =2;j<i; j++) {
                if (i % j == 0) {
                    issus = true;
                    break;
                }
            }
            if (!issus) {
                countArray.add(i);
            }
        }
        return countArray;
    }
}
