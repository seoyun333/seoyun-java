import java.util.Scanner;

public class Homework4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 사용자로부터 두 수 입력 받기
        System.out.print("두 수를 입력하세요: ");

        // 입력 예시 (4 12)와 같이 공백으로 구분된 두 정수를 받습니다.
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // 2. 재귀 호출을 이용한 최대공약수 계산
        int gcd_recursive = gcd_recursive(num1, num2);

        // 3. 반복문을 이용한 최대공약수 계산 (선택 사항이지만 요구사항에 따라 구현)
        // int gcd_iterative = gcd_iterative(num1, num2);

        // 4. 결과 출력 (재귀 호출 결과 사용)
        System.out.println("두 수의 최대공약수는 " + gcd_recursive + "입니다.");

        scanner.close();
    }

    // ==========================================================
    // 1. 재귀 호출(Recursive)을 이용한 gcd 함수 구현 (유클리드 호제법)
    // 함수 이름과 형태: int gcd(int m, int n)
    // (함수 오버로딩을 위해 이름에 _recursive를 붙였습니다.)
    // ==========================================================
    /**
     * 유클리드 호제법을 사용하여 두 수의 최대공약수를 재귀적으로 계산합니다.
     * @param m 첫 번째 정수
     * @param n 두 번째 정수
     * @return 최대공약수
     */
    public static int gcd_recursive(int m, int n) {
        // Step 2: n이 0이라면 m을 반환하고 함수 종료
        if (n == 0) {
            return m;
        }

        // Step 3: 첫 번째 인자로 n (m과 n 중 작은 수), 
        //         두 번째 인자로 m % n (큰 수를 작은 수로 나눈 나머지)를
        //         gcd 함수에 넣고 호출
        return gcd_recursive(n, m % n);
    }

    // ==========================================================
    // 2. 반복문(Iterative)을 이용한 gcd 함수 구현 (유클리드 호제법)
    // (요구사항에 '다시 반복문으로도 바꿔 보세요'가 있어 함께 구현했습니다.)
    // ==========================================================
    /**
     * 유클리드 호제법을 사용하여 두 수의 최대공약수를 반복적으로 계산합니다.
     * @param m 첫 번째 정수
     * @param n 두 번째 정수
     * @return 최대공약수
     */
    public static int gcd_iterative(int m, int n) {
        int temp;
        // n이 0이 아닐 때까지 반복
        while (n != 0) {
            // temp = m % n (나머지)
            temp = m % n;
            // m을 이전의 n으로 교체
            m = n;
            // n을 나머지(temp)로 교체
            n = temp;
        }
        // n이 0이 되었을 때 m이 최대공약수
        return m;
    }
}