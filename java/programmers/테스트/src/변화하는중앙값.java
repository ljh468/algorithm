import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 변화하는중앙값 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int length = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long[] A = new long[length];
            A[0] = 1983;
            long sum =A[0];
            for (int j = 1; j < length; j++) {
                A[j] = (A[j-1] * a + b) % 20090711;
                sum+=findMedian(A, j);
            }
            System.out.println(sum%20090711);
        }
    }

    public static long findMedian(long[] arr, int index) {
        if(index==1) {
            return arr[0];
        }
        long[] subArr = Arrays.copyOfRange(arr, 0, index+1);
        Arrays.sort(subArr);
        if(subArr.length%2 == 0) {
            return subArr[subArr.length/2-1];
        }
        return subArr[subArr.length/2];
    }
}
