package learn_Lombok;

public class class2 {
    public static void main(String[] args) {
        class1_params class1Params=new class1_params();
        class1Params.setParam1("1");
        class1Params.setParam2("2");
        class1Params.setParam3("3");
        class1Params.setParam4("4");
        class1Params.setParam5("5");
        System.out.println(" param "+class1Params.getParam1());
        System.out.println(" param "+class1Params.getParam2());
        System.out.println(" param "+class1Params.getParam3());
        System.out.println(" param "+class1Params.getParam4());
        System.out.println(" param "+class1Params.getParam5());
    }
    public static void call2(){
        class1_params class1Params=new class1_params();
        System.out.println(" param "+class1Params.getParam1());
        System.out.println(" param "+class1Params.getParam2());
        System.out.println(" param "+class1Params.getParam3());
        System.out.println(" param "+class1Params.getParam4());
        System.out.println(" param "+class1Params.getParam5());
    }
}
