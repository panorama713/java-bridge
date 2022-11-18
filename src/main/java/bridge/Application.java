package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static OutputView outputView = new OutputView();
    static BridgeRandomNumberGenerator br = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(br);
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    private static List<String> bridge = new ArrayList<>();
    private static String retryInput = "";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        validateMove();
        outputView.printResult();
    }
    public static void validateMove() {
        for (int i = 0; i < bridge.size(); i++) {
            if (bridgeGame.move(bridge.get(i), inputView.readMoving()).equals("X")) {
                outputView.printMap(bridge, BridgeGame.moveMapList);
                retryInput = inputView.readGameCommand();
                bridgeGame.retry(retryInput, bridge, BridgeGame.moveMapList, i);
            }
            if (retryInput.equals("Q")) return;
            if(i == bridge.size() - 1) System.out.println("최종 게임 결과");
            outputView.printMap(bridge, BridgeGame.moveMapList);
        }
    }
}
