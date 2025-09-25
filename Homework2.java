import java.util.Scanner;

class Student {
    private int studentId;
    private String name;
    private String major;
    private long phoneNumber;

    // 생성자
    public Student(int studentId, String name, String major, long phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.phoneNumber = phoneNumber;
    }

    // Getter & Setter
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // 전화번호 형식 변환 메서드
    public String getFormattedPhone() {
        String phoneStr = Long.toString(phoneNumber);

        // 맨 앞자리 0 복구
        if (!phoneStr.startsWith("0")) {
            phoneStr = "0" + phoneStr;
        }

        // 010-xxxx-xxxx 형태로 변환
        return phoneStr.substring(0, 3) + "-" +
                phoneStr.substring(3, 7) + "-" +
                phoneStr.substring(7);
    }

    // 학생 정보 출력용
    public String toString() {
        return studentId + " " + name + " " + major + " " + getFormattedPhone();
    }
}

public class Homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];

        // 학생 3명 입력받기
        for (int i = 0; i < students.length; i++) {
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");
            int studentId = scanner.nextInt();
            String name = scanner.next();
            String major = scanner.next();
            long phoneNumber = scanner.nextLong();

            students[i] = new Student(studentId, name, major, phoneNumber);
        }

        // 출력
        System.out.println("\n입력된 학생들의 정보는 다음과 같습니다.");
        for (int i = 0; i < students.length; i++) {
            System.out.println((i+1) + "번째 학생: " + students[i].toString());
        }

        scanner.close();
    }
}
