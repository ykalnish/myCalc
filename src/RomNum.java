public enum RomNum {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10);

    private final int val;
    RomNum(int val) {
        this.val = val;
    }

    /*
    public int getVal(){
        return val;
    }
*/
    public static boolean isRoman(String test) {
        for (RomNum c : RomNum.values())
            if (c.name().equals(test)) return true;
        return false;
    }
    public static String getRome(int num) { // ОК
        String ret = "";
        for (RomNum c : RomNum.values())
            if (c.val == num) ret = c.name();
        return ret;
   }

   public static int romToInt (String s) {
       return RomNum.valueOf(s).val;
   }

   public static String intToRom (int i) {
       //String output = "";
       StringBuilder output = new StringBuilder();
       if (i < 0) {
           //output = "-I";
           output.append("-I");
       }
       else if (i == 0) {
           output.append("0");
       }
       else if (i <= 10) {
           output.append(getRome(i));
       }
       else if ( i < 50) {
           output.append("X".repeat(i / 10));
           output.append(getRome(i % 10));
       }
       else if (i < 100) {
           output.append("L");
           i -= 50;
           output.append("X".repeat(i / 10));
           output.append(getRome(i % 10));
       }
       else if (i == 100) {
           output.append("C");
       }
        return output.toString();
   }
}
