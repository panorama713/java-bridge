package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String moveError = "[ERROR] 어디에도 포함되지 않는 값입니다.";
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public static List<String> moveMapList = new ArrayList<>();
    public static int gameCount = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String randomBridge, String input) {
        if(randomBridge.equals(input)) {
            moveMapList.add("O");
            return "O";
        }
        if(!randomBridge.equals(input)) {
            moveMapList.add("X");
            return "X";
        }
        return "";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge,List<String> moveMapList, int index) {
        String input = inputView.readGameCommand();
        if(input.equals("R")){
            moveMapList.remove("X");
            gameCount += 1;
            move(bridge.get(index), inputView.readMoving());
            return;
        }
        System.out.println("최종 게임 결과");
        outputView.printMap(bridge, moveMapList);
        outputView.printResult();
    }
}
