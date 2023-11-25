public enum NumberRim {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10),
    XX(20),XXX(30),XL(40),L(50),LX(60),
    LXX(70),LXXX(80),XC(90), C(100);
    private final int arabNumber;

    NumberRim(int arabNumber) {
        this.arabNumber = arabNumber;
    }

    public int ConvertRimToArab() {
        return arabNumber;
    }
    public static String ConvertArabToRim(int arabNumberConvert) {

        for (NumberRim i : NumberRim.values()) {
            if (i.arabNumber == arabNumberConvert){
                return i.toString();
            }
        }
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("throws Exception");
            System.exit(0);
        }
        return "";
    }
}

