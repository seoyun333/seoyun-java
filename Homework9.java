import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Homework9 {
    public static void main(String[] args) {
        // ID와 비밀번호를 저장할 HashMap 생성
        HashMap<String, String> dbMap = new HashMap<>();

        // 1. db.txt 파일에서 데이터 읽어오기
        try {
            // 상대 경로 "db.txt"를 사용하여 파일 읽기
            Scanner fileScanner = new Scanner(new File("db.txt"));

            while (fileScanner.hasNext()) {
                // 파일 형식은 "ID 비밀번호" 순서라고 가정
                String id = fileScanner.next();
                String password = fileScanner.next();
                dbMap.put(id, password);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("db.txt 파일을 찾을 수 없습니다. 프로젝트 최상위 경로에 파일이 있는지 확인해주세요.");
            return; // 파일을 못 찾으면 프로그램 종료
        }

        // 2. 사용자 입력 및 로그인 로직 처리
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");

            // ID 입력
            System.out.print("id : ");
            String inputId = sc.nextLine().trim(); // 요구사항: trim() 함수 사용

            // ID 존재 여부 확인 (HashMap의 containsKey 사용)
            if (!dbMap.containsKey(inputId)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                System.out.println(); // 줄바꿈
                continue;
            }

            // 비밀번호 입력
            System.out.print("password : ");
            String inputPass = sc.nextLine().trim(); // 요구사항: trim() 함수 사용

            // 비밀번호 일치 여부 확인
            if (!dbMap.get(inputId).equals(inputPass)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                System.out.println(); // 줄바꿈
            } else {
                // 로그인 성공
                System.out.println("id와 비밀번호가 일치합니다.");
                break; // 반복문 종료
            }
        }

        sc.close();
    }
}