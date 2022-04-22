public class Calculations {
    private static final String INVALID_SYNTAX = "Invalid Syntax";
    private static Result result;
    Calculations() {
        result = new Result();
    }
    static Double factorial(String value) {
        System.out.println(value);
        Integer output = 1;
        Integer num = Integer.valueOf(value);
        for(Integer i = 1; i <= num; i++) {
            output *= i;
        }
        return Double.valueOf(output);
    } 
    static Double divide(String value1, String value2) {
        if(Double.valueOf(value2).equals(0.0)) {
            UI.showError("Cannot divide by zero");
            result.setResult(INVALID_SYNTAX); 
        }
        Double output = 0.0;
        try {
            output = Double.valueOf(value1) / Double.valueOf(value2);
        }
        catch(Exception e) {
            UI.showError(INVALID_SYNTAX);
            result.setResult(INVALID_SYNTAX);
        }
        return output;
    }
    static Double multiply(String value1, String value2) {
        Double output = 0.0;
        try {
            output = Double.valueOf(value1) * Double.valueOf(value2);
        }
        catch(Exception e) {
            UI.showError(INVALID_SYNTAX);
            result.setResult(INVALID_SYNTAX);
        }
        return output;
    }
    static Double addition(String value1, String value2) {
        Double output = 0.0;
        try {
            output = Double.valueOf(value1) + Double.valueOf(value2);
        }
        catch(Exception e) {
            UI.showError(INVALID_SYNTAX);
            result.setResult(INVALID_SYNTAX);
        }
        return output;
    }
    static Double subtraction(String value1, String value2) {
        Double output = 0.0;
        try {
            output = Double.valueOf(value1) - Double.valueOf(value2);
        }
        catch(Exception e) {
            UI.showError(INVALID_SYNTAX);
            result.setResult(INVALID_SYNTAX);
        }
        return output;
    }
}
