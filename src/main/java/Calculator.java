import java.util.Scanner;


public class Calculator {

    public static void main(String[] args)  {
        Scanner skan = new Scanner(System.in);
        String str = skan.nextLine();
        String [] mass = str.split(" "); //Разбиение строки на массив
        if (mass.length != 3){
            try {
                throw new Exception();
            }
            catch (Exception e) {
                System.out.println("throws Exception");
                System.exit(0);}
        }
        if (mass[0].indexOf(73)!=-1 || mass[0].indexOf(86)!=-1 ||mass[0].indexOf(88)!=-1){
            if (mass[2].indexOf(73)!=-1 || mass[2].indexOf(86)!=-1 ||mass[2].indexOf(88)!=-1){
                int firstNumer = ConvertRimToArab(mass[0]);
                int secondNumer = ConvertRimToArab(mass[2]);
                if ((secondNumer>=firstNumer && (mass[1].equals("-") || mass[1].equals("/"))) || firstNumer>10 || secondNumer>10){
                    try {
                        throw new Exception();
                    }
                    catch (Exception e) {
                        System.out.println("throws Exception");
                        System.exit(0);}
                }
                try{
                    int itog = Calc(firstNumer,mass[1],secondNumer);
                    System.out.println(ConvertArabToRim(itog));
                }
                catch (Exception e) {
                    System.out.println("throws Exception");
                    System.exit(0);}
            } else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("throws Exception");
                    System.exit(0);
                }
            }
        } else {
            try{
                if ((mass[2].indexOf(73) == -1) && (mass[2].indexOf(86) == -1) &&
                        (mass[2].indexOf(88) == -1)) {
                    if (Double.parseDouble(mass[0])%1!=0 || Double.parseDouble(mass[2])%1!=0){
                        try {
                            throw new Exception();
                        }
                        catch (Exception e) {
                            System.out.println("throws Exception");
                            System.exit(0);}
                    }
                    if (Integer.parseInt(mass[0]) > 10 || Integer.parseInt(mass[2])>10){
                        try {
                            throw new Exception();
                        }
                        catch (Exception e) {
                            System.out.println("throws Exception");
                            System.exit(0);}
                    }
                    try{
                        int itog = Calc(Integer.parseInt(mass[0]),mass[1],Integer.parseInt(mass[2]));
                        System.out.println(itog);
                    }
                    catch (Exception e){
                        System.out.println("throws Exception");
                        System.exit(0);
                    }

                }
                else {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("throws Exception");
                        System.exit(0);
                    }
                }
            }
            catch (Exception e) {
                System.out.println("throws Exception");
                System.exit(0);
            }
        }
    }
    public static int Calc(int firstNumber, String operation, int secondNumber) {
        switch (operation) {
            case "+" :
                return firstNumber + secondNumber;
            case "-" :
                return firstNumber - secondNumber;
            case "*" :
                return firstNumber * secondNumber;
            case "/" :
                return firstNumber / secondNumber;
            default :
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("throws Exception");
                    System.exit(0);
                }
        }
        return 0;
    }
    public static int ConvertRimToArab(String rimNumber){
        NumberRim NumberEnumRim = NumberRim.valueOf(rimNumber);
        return NumberEnumRim.ConvertRimToArab();
    }
    public static String ConvertArabToRim (int numerArab)  {
        int a = numerArab/10*10;
        int b = numerArab-a;
        try{
            if (a!=0 && b!=0) return NumberRim.ConvertArabToRim(a) + NumberRim.ConvertArabToRim(b);
            else if (a==0) return NumberRim.ConvertArabToRim(b);
            else if (b==0) return NumberRim.ConvertArabToRim(a);
        }
        catch (Exception e){
            System.out.println("throws Exception");
            System.exit(0);
        }
        return "0";
    }
}
