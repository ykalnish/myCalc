public enum MathOps {
    ADD("+"), SUB("-"), MUL("*"), DIV("/");

    private final String val;
    MathOps(String val) {
        this.val = val;
    }

    public static boolean isMath(String test) {
        for (MathOps c : MathOps.values()) {
            if (c.val.equals(test)) return true;
        }
        return false;
    }

}
