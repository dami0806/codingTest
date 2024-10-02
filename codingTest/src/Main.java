import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        // 입력받기
        int[] input = getInputArray();

        // 가장 작은 수 제거
        int[] result = solution(input);

        // 출력
        System.out.println(Arrays.toString(result));
    }

    /**
     * 입력값 받기
     *Scanner vs BufferReader
     * @return int[]: 입력된 배열
     * @throws IOException
     */
    static int[] getInputArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(",");

        // input -> int[]
        int[] arr = new int[input.length];

        try {
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i].trim());
            }
        } catch (NumberFormatException e) {
            System.out.println("입력값은 유효한 숫자가 아닙니다: " + e.getMessage());

            return new int[]{-1};
        }

        br.close();

        return arr;
    }

    /**
     * 가장 작은수 찾은 후 제거
     * @param arr int[]: 입력된 배열
     * @return int[]: 최소 숫자 제거된 배열
     */
    static int[] solution(int[] arr) {

        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Integer.MAX_VALUE;

        // 가장 작은수 찾기
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        // 가장 작은수 제거
        int[] result = new int[arr.length - 1];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != min) {
                result[idx++] = arr[i];
            }
        }
        return result;
    }
}