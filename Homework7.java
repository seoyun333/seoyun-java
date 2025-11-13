public class Homework7 {
    public static void main(String[] args) {
        // 요구 사항에 따른 Homework7.Printer 객체 생성
        InkjetPrinter inkjet = new InkjetPrinter("Brother DCP-T730DW", 7500);
        LaserPrinter laser = new LaserPrinter("Canon MFC643Cdw", 1500);

        // InkjetPrinter의 print()를 availableCount가 0이 될 때까지 (7501번째 실패 시까지) 반복
        while (inkjet.print()) {
            // print()가 true를 반환하는 동안 (성공하는 동안) 계속 반복
        }

        // LaserPrinter의 print()를 availableCount가 0이 될 때까지 (1501번째 실패 시까지) 반복
        while (laser.print()) {
            // print()가 true를 반환하는 동안 (성공하는 동안) 계속 반복
        }

        // 최종 printedCount 확인 (선택적)
        // System.out.println("Inkjet 최종 출력 매수: " + inkjet.getPrintedCount());
        // System.out.println("Laser 최종 출력 매수: " + laser.getPrintedCount());
    }

    public abstract static class Printer {
        // 멤버 변수: model (모델명), printedCount (현재까지의 출력 매수), availableCount (출력 가능 매수)
        protected String model;
        protected int printedCount;
        protected int availableCount;

        // 생성자 (자식 클래스에서 호출)
        public Printer(String model, int availableCount) {
            this.model = model;
            this.availableCount = availableCount;
            this.printedCount = 0; // 초기 출력 매수는 0
        }

        // 추상 메서드: boolean print()
        // 출력 성공 시 true, 출력 실패 시 false 반환
        public abstract boolean print();

        // Getter 메서드 (선택적, 테스트 및 출력 결과 확인을 위해 추가)
        public int getPrintedCount() {
            return printedCount;
        }
    }

    public static class LaserPrinter extends Printer {

        // 생성자
        public LaserPrinter(String model, int availableCount) {
            super(model, availableCount);
        }

        // print() 함수 구현
        @Override
        public boolean print() {
            if (availableCount == 0) {
                // availableCount 값이 0일 경우:
                // "모델명: xx매매 인쇄 실패 - 토너 부족." 출력 후 false 리턴
                System.out.println(model + ": " + (printedCount + 1) + "매매 인쇄 실패 - 토너 부족.");
                return false;
            } else {
                // availableCount 값이 1 이상이면:
                // printedCount를 하나 증가, availableCount를 하나 감소시키고 true 리턴
                printedCount++;
                availableCount--;
                // (참고: 문제에서 성공 시 별도 출력 요구 사항은 없으므로 내부 상태만 변경)
                return true;
            }
        }
    }

    public static class InkjetPrinter extends Printer {

        // 생성자
        public InkjetPrinter(String model, int availableCount) {
            super(model, availableCount);
        }

        // print() 함수 구현
        @Override
        public boolean print() {
            if (availableCount == 0) {
                // availableCount 값이 0일 경우:
                // "모델명: xx매매 인쇄 실패 - 잉크 부족." 출력 후 false 리턴
                System.out.println(model + ": " + (printedCount + 1) + "매매 인쇄 실패 - 잉크 부족.");
                return false;
            } else {
                // availableCount 값이 1 이상이면:
                // printedCount를 하나 증가, availableCount를 하나 감소시키고 true 리턴
                printedCount++;
                availableCount--;
                // (참고: 문제에서 성공 시 별도 출력 요구 사항은 없으므로 내부 상태만 변경)
                return true;
            }
        }
    }
}