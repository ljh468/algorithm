import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1. and or xor
// 2. 1~n 까지 넘어서는수
// 3. 팩토리얼 재귀
// 4. 큐
// 5. 이진트리
public class 오퍼스_코테 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);
        String[] intStr = new String[number];

        Boolean isStatus = false;
        String temp = "";

        int ppCount = 0; // count 값
        int inputCount= 0;
        while(!isStatus){
            input = br.readLine();
            // overflow
            if(inputCount > 10){
                System.out.print("overflow");
                break;
            }
            if(inputCount % 2 == 0){ // 입력,출력
                temp = input;
                if(input.equalsIgnoreCase("d")){
                    // underflow
                    if(ppCount == 0){
                        System.out.println("underflow");
                    }else{
                        intStr[0] = null;
                    }
                    inputCount++;
                }
            }else{
                if(temp.equalsIgnoreCase("e")){
                    intStr[ppCount] = input;
                    ppCount++;
                }else{
                    return; // 종료
                }
                temp = ""; // 초기화
            }
            inputCount++;
            if(inputCount == number * 2){
                isStatus = true;
            }
        }
        String str = "";
        str = Arrays.toString(intStr).replace(", "," ").replace("[","").replace("]","").replace(" null","");
        System.out.print(str);
    }
}
