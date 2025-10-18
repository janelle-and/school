public class boundGeneric <T extends Number> {
    T num;

    public boundGeneric(T num) {
        this.num = num;
    }

    public double squareNum(T num){
        return num.doubleValue()*num.doubleValue();
    }

    public static void main(String[] args) {
        boundGeneric<Integer> intNums = new boundGeneric<>(10);
        Double value1 = intNums.squareNum(10);
        System.out.println(value1);

        boundGeneric<Double> doubleNums = new boundGeneric<>(11.1);
        Double value2 = doubleNums.squareNum(11.1);
        System.out.println(value2);
    }
}
