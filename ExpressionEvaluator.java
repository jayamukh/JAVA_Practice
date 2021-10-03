import java.util.Scanner;

class ExpressionEvaluator {

    public ExpressionEvaluator(String expr) {
        expr_ = expr;
        position_ = -1;
    }

    void next() {
        curr_char_ = ++position_ < expr_.length() ? expr_.charAt(position_) : -1;
    }

    void prev() {
        curr_char_ = --position_ < expr_.length() ? expr_.charAt(position_) : -1;
    }

    boolean should_apply(char c) {
        if (curr_char_ == c) {
            next();
            return true;
        }
        return false;
    }

    double eval() {
        next();
        return evalExpr();
    }

    double eval_term() {
        double result = eval_Power();
        while (true) {
            if (should_apply('*')) {
                result *= eval_Power();
            }
            else if (should_apply('/')) {
                double div = eval_Power();
                if (div == 0.0) {
                    invalidOp = true;
                    return 0.0;
                }
                result /= div;
            }
            else return result;
        }
    }

    double evalExpr() {
        double result = eval_term();
        while (true) {
            if (should_apply('+')) {
                result += eval_term();
            }
            else if (should_apply('-')) {
                result -= eval_term();
            }
            else return result;
        }
    }

    double eval_Power() {
        double result = eval_factor();
        double base = result;

        while (true) {
            if (should_apply('^')) {
                if (base < 0.0) {
                    invalidOp = true;
                    return 0.0;
                }
                result = 1.0;
                double exponent = eval_factor();
                while (exponent != 0) {
                    result *= base;
                    --exponent;
                }
            }
            else return result;
        }
    }

    double eval_square(double n) {
        double e = 0.01, low = 0.0, high = n;
        double ans = (high + low) / 2.0;

        while ((((ans * ans - n) > 0.0) ? (ans * ans - n) : -(ans * ans - n)) >= e) {

            if (ans * ans < n)
                low = ans;
            else
                high = ans;
            ans = (high + low) / 2.0;
        }
        return ans;
    }

    double eval_factor() {
        double result = 0.0;

        if (should_apply('-')) {
            if (should_apply('(')) {

                result = -evalExpr();
                if (!should_apply(')')) {
                    invalidOp = true;
                    return 0.0;
                }
            }

            else {
                result = -eval_Power();
            }
        }
        else if (should_apply('a')) {
            String val = expr_.substring(position_ - 1, position_ + 2);
            if (val.equals("abs")) {
                next();
                next();
                if (should_apply('(')) {
                    result = evalExpr();
                    if (!should_apply(')')) {
                        invalidOp = true;
                        return 0.0;
                    }
                }

                if (result < 0.0) {
                    result = -result;
                }
            }
        }
        else if (should_apply('s')) {
            String val = expr_.substring(position_ - 1, position_ + 3);
            if (val.equals("sqrt")) {
                next();
                next();
                next();
                if (should_apply('(')) {
                    result = evalExpr();
                    if (!should_apply(')')) {
                        invalidOp = true;
                        return 0.0;
                    }
                }
                if (result < 0.0) {
                    invalidOp = true;
                    return 0.0;
                }
                result = eval_square(result);
            }
        }
        else if (should_apply('(')) {
            result = evalExpr();
            if (!should_apply(')')) {
                invalidOp = true;
                return 0.0;
            }
        }
        else {
            if ((curr_char_ >= '0' && curr_char_ <= '9') || (curr_char_ == '.')) {
                int origPos = position_;
                boolean dotChk = false;
                do {
                    if (curr_char_ == '.') {
                        if (!dotChk) {
                            dotChk = true;
                        }
                        else {
                            invalidOp = true;
                            break;
                        }
                    }
                    next();
                } while ((curr_char_ >= '0' && curr_char_ <= '9') || (curr_char_ == '.'));

                // next();
                if (invalidOp) {
                    return 0.0;
                }
                result = Double.valueOf(expr_.substring(origPos, position_));
            }
            else {
                invalidOp = true;
                return 0.0;
            }
        }
        return result;
    }

    int position_;
    int curr_char_;
    String expr_;
    static boolean invalidOp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        expression = expression.replaceAll("\\s+", "");

        ExpressionEvaluator ex = new ExpressionEvaluator(expression);
        double res = ex.eval();
        if (invalidOp) {
            System.out.println("Invalid mathematical expression.");
        }
        else {
            System.out.println(String.format("%.2f", res));
        }
        scanner.close();
    }
}
