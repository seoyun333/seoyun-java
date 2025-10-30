public class Homework5 {
    public static void main(String[] args) {
        // 1. 요구 사항에 맞는 Computer 객체 생성
        // Computer: Core i7(CPU), 32GB(메모리), 2TB(HDD), 흰색(컬러), 700W(파워)
        Computer computer = new Computer(
                "Core i7",
                "32GB",
                "2TB",
                "흰색",
                "700W"
        );

        // 2. 요구 사항에 맞는 Monitor 객체 생성
        // Monitor: 32인치(크기), 검은색(색상), 45W(전력소모)
        Monitor monitor = new Monitor(
                "32인치",
                "검은색",
                "45W"
        );

        // 3. PersonalComputer 객체 생성 (Composition 관계 설정)
        PersonalComputer pc = new PersonalComputer(computer, monitor);

        // 4. turnOn() 함수와 printInfo() 함수 호출
        pc.turnOn();
        pc.printInfo();
    }
}

// -------------------------------------------------------------
// Computer 클래스
// -------------------------------------------------------------
class Computer {
    // 멤버 변수는 private
    private String cpu;
    private String memory;
    private String hd;
    private String color;
    private String power;

    // 생성자
    public Computer(String cpu, String memory, String hd, String color, String power) {
        this.cpu = cpu;
        this.memory = memory;
        this.hd = hd;
        this.color = color;
        this.power = power;
    }

    // turnOn() 함수 (public)
    public void turnOn() {
        System.out.println("Turning on the computer.");
    }

    // printInfo() 함수 (public)
    public void printInfo() {
        System.out.println("The spec of the computer");
        System.out.println("CPU: " + this.cpu);
        System.out.println("Memory: " + this.memory);
        System.out.println("HDD: " + this.hd);
        System.out.println("Color: " + this.color);
        System.out.println("Power: " + this.power);
    }
}

// -------------------------------------------------------------
// Monitor 클래스
// -------------------------------------------------------------
class Monitor {
    // 멤버 변수는 private
    private String monitorSize;
    private String color;
    private String power;

    // 생성자
    public Monitor(String monitorSize, String color, String power) {
        this.monitorSize = monitorSize;
        this.color = color;
        this.power = power;
    }

    // turnOn() 함수 (public)
    public void turnOn() {
        System.out.println("Turning on the monitor.");
    }

    // printInfo() 함수 (public)
    public void printInfo() {
        System.out.println("The spec of the monitor");
        System.out.println("Size: " + this.monitorSize);
        System.out.println("Color: " + this.color);
        System.out.println("Power: " + this.power);
    }
}

// -------------------------------------------------------------
// PersonalComputer 클래스 (Composite/Composition)
// -------------------------------------------------------------
class PersonalComputer {
    // 멤버 변수는 private
    // Computer와 Monitor 객체를 멤버로 가짐 (요구사항 그림 반영)
    private Computer computer;
    private Monitor monitor;

    // 생성자
    public PersonalComputer(Computer computer, Monitor monitor) {
        this.computer = computer;
        this.monitor = monitor;
    }

    // turnOn() 함수 (public) - Computer와 Monitor의 turnOn()을 순차적으로 호출
    public void turnOn() {
        this.computer.turnOn();
        this.monitor.turnOn();
    }

    // printInfo() 함수 (public) - Computer와 Monitor의 printInfo()를 순차적으로 호출
    public void printInfo() {
        this.computer.printInfo();
        System.out.println("-------------------------"); // 시각적 구분을 위한 추가
        this.monitor.printInfo();
    }
}
