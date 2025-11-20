import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework8 {
    public static void main(String[] args) {
        Map<String, String> userDatabase = new HashMap<>();

        userDatabase.put("myId", "myPass");
        userDatabase.put("myId2", "myPass2");
        userDatabase.put("myId3", "myPass3");

        Scanner scanner = new Scanner(System.in);

        boolean loginSuccess = false;

        while (!loginSuccess) {
            System.out.println("id와 password를 입력해주세요.");

            System.out.print("id : ");
            String inputId = scanner.nextLine().trim();

            if (!userDatabase.containsKey(inputId)) {

                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                continue;
            }


            System.out.print("password : ");
            String inputPassword = scanner.nextLine().trim();


            String storedPassword = userDatabase.get(inputId);

            if (storedPassword.equals(inputPassword)) {

                System.out.println("id와 비밀번호가 일치합니다.");
                loginSuccess = true;
            } else {

                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            }
        }

        scanner.close();
    }
}