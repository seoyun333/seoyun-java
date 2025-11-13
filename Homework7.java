public class Homework7 {
    public static void main(String[] args) {
        // 요구 사항에 따른 Printer 객체 생성
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
}