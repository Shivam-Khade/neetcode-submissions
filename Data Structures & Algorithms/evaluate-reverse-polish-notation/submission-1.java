class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {

            if (Character.isDigit(token.charAt(token.length() - 1))) {
                st.push(Integer.parseInt(token));
            } else {
                int num1 = st.pop();
                int num2 = st.pop();

                switch (token) {
                    case "+":
                        st.push(num2 + num1);
                        break;
                    case "-":
                        st.push(num2 - num1);
                        break;
                    case "*":
                        st.push(num2 * num1);
                        break;
                    case "/":
                        st.push(num2 / num1);
                        break;
                }
            }
        }

        return st.peek();
    }
}