import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int num = 0, min=0, max=0;

        System.out.print("몇 개의 수를 입력할 예정인가요? ");
        num = scan.nextInt();
        scan.nextLine();

        System.out.print("수를 입력하세요: ");
        String inputLine = scan.nextLine().trim();
        String[] numStrings = inputLine.split("\\s+");

        min = Integer.parseInt(numStrings[0]);
        max = Integer.parseInt(numStrings[0]);

        for (int i=1; i<numStrings.length; i++){
            int currentNum = Integer.parseInt(numStrings[i]);

            if(currentNum < min){
                min = currentNum;
            }
            else if (currentNum > max){
                max = currentNum;
            }
        }

        System.out.printf("최대값: %d\n", max);
        System.out.printf("최소값: %d", min);
    }
}
