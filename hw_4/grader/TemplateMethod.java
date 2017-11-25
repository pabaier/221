public abstract class TemplateMethod {

    private final String testName;

    public TemplateMethod(String name) {
        testName = name;
    }

    public final String RESET = "\u001B[0m";
    public final String CORRECT = "\u001B[32m";
    public final String PARTCORRECT = "\u001B[34m";
    public final String INCORRECT = "\u001B[31m";
    public final String TESTHEAD = "\u001B[35m";
    public final String TESTEXPECT = "\u001B[36m";

    // public final String RESET = "";
    // public final String CORRECT = "";
    // public final String PARTCORRECT = "";
    // public final String INCORRECT = "";
    // public final String TESTHEAD = "";
    // public final String TESTEXPECT = "";

    public int runTest() {
        System.out.println(TESTHEAD + "\t" + testName + RESET);
        int points = 0;

        int[] result  = testMethod();
        
        if(result[0] == 404){
            System.out.println(INCORRECT + "\t\tError running test - " + 0 + "/" + result[1] + RESET);
            return 0;
        }
        else if(result[0] > 100) {
            result[0] -= 100;
            System.out.println(CORRECT + " - Correct - " + result[0] + "/" + result[1] + RESET);
        }
        else if(result[0] > 0) {
            System.out.println(PARTCORRECT + " - Partially Correct - " + result[0] + "/" + result[1] + RESET);
        }
        
        points += result[0];

        return points;
    }

    public abstract int[] testMethod();

}