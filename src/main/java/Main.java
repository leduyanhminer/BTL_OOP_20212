import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String baseUrlID = Utility.chooseBaseUrl();
            String testSuiteId = Utility.chooseAPIEndPoint(baseUrlID);

            RunTestFromMain runner = new RunTestFromMain();
            runner.runTest(testSuiteId);
            runner.displayTestResult();
        }

    }
}

