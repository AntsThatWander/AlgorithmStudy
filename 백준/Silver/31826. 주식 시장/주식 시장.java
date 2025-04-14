import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    private static final int DEFAULT_COST = 10000;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int lines = Integer.parseInt(br.readLine());
            int cost = DEFAULT_COST;
            Map<Integer, Integer> stocks = new HashMap<>();

            for (int i=0; i<lines; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int purchaseCost = Integer.parseInt(st.nextToken());
                int purchaseAmount = Integer.parseInt(st.nextToken());
                int purchaseType = Integer.parseInt(st.nextToken());
                int finalPurchaseAmount = getTotalCostByType(purchaseAmount, purchaseType);

                if (!stocks.containsKey(purchaseCost) || stocks.get(purchaseCost)==0) {
                    stocks.put(purchaseCost, finalPurchaseAmount);
                    continue;
                }

                int currentPurchaseAmount = stocks.get(purchaseCost);
                if (!isPurchasable(currentPurchaseAmount, purchaseType)) {
                    stocks.put(purchaseCost, stocks.get(purchaseCost) + finalPurchaseAmount);
                    continue;
                }

                int totalPurchaseAmount = currentPurchaseAmount + finalPurchaseAmount;

                stocks.put(purchaseCost, totalPurchaseAmount);
                cost = purchaseCost;
            }

            System.out.println(cost);
            br.close();
        } catch (IOException ioe) {

        }

        
    }

    private static int getTotalCostByType(int purchaseAmount, int purchaseType) {
        return purchaseType * purchaseAmount;
    }

    private static boolean isPurchasable(int currentPurchaseAmount, int purchaseType) {
        if (purchaseType > 0) {
            return currentPurchaseAmount < 0 ? true : false;
        }

        return currentPurchaseAmount > 0 ? true : false;
    }
}
