public class PowerofThree {

    public static void main(String[] args) {
        PowerofThree obj = new PowerofThree();
//        System.out.println(a % (int)(a));
        System.out.println(obj.isPowerOfThree(1));
    }

    public boolean isPowerOfThree(int n) {
        if(n == 1) {
            return true;
        }
        double a = Math.log10(n)/Math.log10(3);
        return a % (int)(a) == 0;
    }
}
