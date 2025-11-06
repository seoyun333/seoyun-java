// Course 클래스
class Course {
    // 멤버 변수: code와 name
    private String code;
    private String name;

    // 생성자
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // code getter (필수 요구사항은 아니지만, 상속받는 클래스에서 접근 필요 시 사용)
    public String getCode() {
        return code;
    }

    // name getter (필수 요구사항은 아니지만, 상속받는 클래스에서 접근 필요 시 사용)
    public String getName() {
        return name;
    }

    // toString() 메서드는 자식 클래스에서 오버라이딩되므로, 기본 구현은 간단하게 둠
    @Override
    public String toString() {
        return "Course [code=" + code + ", name=" + name + "]";
    }
}

// Course를 상속받는 OnlineCourse 클래스
class OnlineCourse extends Course {
    // 생성자: 부모 클래스의 생성자를 호출
    public OnlineCourse(String code, String name) {
        super(code, name);
    }

    // toString() 오버라이딩
    @Override
    public String toString() {
        // 부모 클래스의 getter를 사용하거나, 부모 클래스에서 protected 접근자를 사용해야 함.
        // 여기서는 부모 클래스의 getter를 사용하거나,
        // super.toString()을 활용하여 원하는 형식으로 조합
        return "Code: " + super.getCode() + ", Name: " + super.getName() + ", Type: Online";
    }
}

// Course를 상속받는 OfflineCourse 클래스
class OfflineCourse extends Course {
    // 생성자: 부모 클래스의 생성자를 호출
    public OfflineCourse(String code, String name) {
        super(code, name);
    }

    // toString() 오버라이딩
    @Override
    public String toString() {
        // 부모 클래스의 getter를 사용하여 원하는 형식으로 조합
        return "Code: " + super.getCode() + ", Name: " + super.getName() + ", Type: Offline";
    }
}

// 요구사항에 따른 메인 클래스
public class Homework6 {
    public static void main(String[] args) {
        // Course 객체 생성
        OfflineCourse course1 = new OfflineCourse("HAEA9201", "Object Oriented Programming");
        OnlineCourse course2 = new OnlineCourse("HAFL0012", "C Programming 1");

        // 출력 결과 확인
        System.out.println(course1); // course1.toString() 호출
        System.out.println(course2); // course2.toString() 호출
    }
}