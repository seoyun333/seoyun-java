public abstract class Printer {
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