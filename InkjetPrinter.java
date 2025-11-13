public class InkjetPrinter extends Printer {

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