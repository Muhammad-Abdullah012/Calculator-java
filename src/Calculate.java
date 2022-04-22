
import java.util.ArrayList;

class Calculate {
    private ArrayList<String> values, operators;
    private final String INVALID_SYNTAX = "Invalid Syntax";

    Calculate(String input) {
        values = new ArrayList<String>();
        operators = new ArrayList<String>();
        input.trim();
        if(!input.isEmpty()) {
            if(input.startsWith("+") || input.startsWith("-")) {
                input = "0".concat(input);
            }
            input = replaceAns(input);
            //Do all scientific calculations and put result into input string
            input = doScientificCalculations(input);
            //seperate operators i.e +, -, *, / and values in input string
            
            seperateValuesAndOperators(input);

            if(operators.size() > 0) {
                //Perform Division, multiplication, addition and subtraction in order
                
                factorialProcess();
                divisionProcess();
                multiplicationProcess();
                additionProcess();
                subtractionProcess();
                if(Result.getResult() == null || !Result.getResult().equals(INVALID_SYNTAX))
                    Result.setResult(values.get(0));
            }
            else {
                Result.setResult(input);;
            }
        }
    }
    public String getResult() {
        return Result.getResult();
    }
    
    private static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
    

    private String replaceAns(String input) {
        StringBuilder sb = new StringBuilder(input);
        int count = count(input, "Ans");
        ArrayList<Integer> Indexes = new ArrayList<Integer>();
        for(int i = 0; i < count; i++) {
            if(input.indexOf("Ans", i) >= 0 && Result.getResult() != null && !Result.getResult().equals(INVALID_SYNTAX)) {
                Integer idx = input.indexOf("Ans", i);
                Indexes.add(idx);
            }
            else 
                break;
        }

        if(input.indexOf("Ans") >= 0 && Result.getResult() != null && !Result.getResult().equals(INVALID_SYNTAX))
            for(int i = Indexes.size() - 1; i >= 0; i--) {
                // Integer idx = input.indexOf("Ans");
                sb.replace(Indexes.get(i), Indexes.get(i) + "Ans".length(), Result.getResult());
            }
        return sb.toString();
    }
    private String doScientificCalculations(String input) {
        /*
            Calculate sin, cos, tan etc one by one, then store result in answers array.
            Then put answers one by one from array (backwards) into string, while keeping all other input operations in the string
            Then return that string.
        */
        ArrayList<String> Answers = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("sin(")) {
                String x = input.substring(begin + "sin(".length(), end);
                String ans = String.valueOf(SciFunctions.Sine(Double.valueOf(x)));
                Answers.add(ans);
            }
        }
        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("cos(")) {
                String x = input.substring(begin + "cos(".length(), end);
                String ans = String.valueOf(SciFunctions.Cosine(Double.valueOf(x)));
                Answers.add(ans);
            }
        }
        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("tan(")) {
                String x = input.substring(begin + "tan(".length(), end);
                String ans = String.valueOf(SciFunctions.Tangent(Double.valueOf(x)));
                Answers.add(ans);
            }
        }
        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("asin(")) {
                String x = input.substring(begin + "asin(".length(), end);
                String ans = String.valueOf(SciFunctions.SineInverse(Double.valueOf(x)));
                Answers.add(ans);
            }
        }
        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("acos(")) {
                String x = input.substring(begin + "acos(".length(), end);
                String ans = String.valueOf(SciFunctions.CosineInverse(Double.valueOf(x)));
                Answers.add(ans);
            }
        }
        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("atan(")) {
                String x = input.substring(begin + "atan(".length(), end);
                String ans = String.valueOf(SciFunctions.TangentInverse(Double.valueOf(x)));
                Answers.add(ans);
            }
        }

        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("abs(")) {
                String x = input.substring(begin + "abs(".length(), end);
                String ans = String.valueOf(SciFunctions.AbsoluteValue(Double.valueOf(x)));
                Answers.add(ans);
            }
        }

        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("sinh(")) {
                String x = input.substring(begin + "sinh(".length(), end);
                String ans = String.valueOf(SciFunctions.SineHyperbolic(Double.valueOf(x)));
                Answers.add(ans);
            }
        }

        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("cosh(")) {
                String x = input.substring(begin + "cosh(".length(), end);
                String ans = String.valueOf(SciFunctions.CosineHyperbolic(Double.valueOf(x)));
                Answers.add(ans);
            }
        }

        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("tanh(")) {
                String x = input.substring(begin + "tanh(".length(), end);
                String ans = String.valueOf(SciFunctions.TangentHyperbolic(Double.valueOf(x)));
                Answers.add(ans);
            }
        }

        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("sqrt(")) {
                String x = input.substring(begin + "sqrt(".length(), end);
                String ans = String.valueOf(SciFunctions.SquareRoot(Double.valueOf(x)));
                Answers.add(ans);
            }
        }

        for(int i = 0; i < ScientificButtons.op.size(); i++ ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            if(ScientificButtons.op.get(i).startsWith("cbrt(")) {
                String x = input.substring(begin + "cbrt(".length(), end);
                String ans = String.valueOf(SciFunctions.CubeRoot(Double.valueOf(x)));
                Answers.add(ans);
            }
        }
        for(int i = Answers.size() - 1; i >= 0; i-- ) {
            Integer begin = ScientificButtons.beginIndex.get(i), end = ScientificButtons.endIndex.get(i);
            sb.delete(begin, end + 1);
            sb.insert(begin, Answers.get(i));
        }
        ScientificButtons.beginIndex.clear();
        ScientificButtons.endIndex.clear();
        ScientificButtons.op.clear();
        return sb.toString();
    }
    
    private void seperateValuesAndOperators(String input) {
        Integer opIndex = -1;
            for(int i = 0; i < input.length(); i++) {
                char temp = input.charAt(i);
                if( temp == '+' || temp == '-' || temp == 'X' || temp == '/' || temp == '!' || temp == '^') {
                    values.add(input.substring(opIndex + 1, i));
                    operators.add(Character.toString(input.charAt(i)));
                    opIndex = i; 
                }
                if(i + 1 == input.length()) {
                    values.add(input.substring(opIndex + 1, input.length()));
                }
            }
    }
    
    private void factorialProcess() {
        for(int i = 0; i < operators.size(); i++) {
            if(operators.get(i).equals("!")) {
                Double result = Calculations.factorial(values.get(i));
                values.set(i, String.valueOf(result));
                operators.remove(i);
                if(values.get(i+1).equals("")) {
                    values.remove(i + 1);
                }
            }
        }
    }


    private void divisionProcess() {
        for(int i = 0; i < operators.size(); i++) {
            if(operators.get(i).equals("/")) {
                Double result = Calculations.divide(values.get(i), values.get(i + 1));
                values.remove(i);
                values.remove(i);
                operators.remove(i);
                values.add(i, result.toString());
            }
        }
    }
    private void multiplicationProcess() {
        for(int i = 0; i < operators.size(); i++) {
            if(operators.get(i).equals("X")) {
                Double result = Calculations.multiply(values.get(i), values.get(i + 1));
                values.remove(i);
                values.remove(i);
                operators.remove(i);
                values.add(i, result.toString());
            }
        }
    }
    private void additionProcess() {
        for(int i = 0; i < operators.size(); i++) {
            if(operators.get(i).equals("+")) {
                Double result = Calculations.addition(values.get(i), values.get(i + 1));
                values.remove(i);
                values.remove(i);
                operators.remove(i);
                values.add(i, result.toString());
            }
        }
    }
    private void subtractionProcess() {
        for(int i = 0; i < operators.size(); i++) {
            if(operators.get(i).equals("-")) {
                Double result = Calculations.subtraction(values.get(i), values.get(i + 1));
                values.remove(i);
                values.remove(i);
                operators.remove(i);
                values.add(i, result.toString());
            }
        }
    }
    

}