package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String moveError = "[ERROR] 어디에도 포함되지 않는 값입니다.";
    BridgeNumberGenerator bridgeNumberGenerator;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private List<String> moveMapList = new ArrayList<>();
    private static int gameCount = 0;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String randomBridge, String input) {
        if(randomBridge == input) moveMapList.add("O");
        if(randomBridge != input) {
            moveMapList.add("X");
            outputView.printResult();
            retry();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if(inputView.readGameCommand().equals("R")){
            gameCount += 1;
            moveMapList.remove(moveMapList.size() - 1);
            inputView.readMoving();
        }
        if(inputView.readGameCommand().equals("Q")){
            gameCount += 1;
            outputView.printResult();
        }
    }
}
