public class Test01 {
    public static void main(String[] args) {

        // double[] arr = {2.3, 4.0, 1.56, 7, 4.9};
        // double[] arr = null;
        double[] arr = {};

        A01 a01 = new A01();
        Double maxNum = a01.max(arr);
        if(maxNum != null) {
            System.out.println("数组的最大值是:" + maxNum);
        } else {
            System.out.println("arr不能为null或{}");
        }
    }
}


//编写类A01,定义方法max,实现求某个double数组的最大值,并返回

class A01 {

    public Double max(double[] arr) {
        if(arr != null && arr.length > 0) {
            double max = arr[0];
            for(int i = 1; i < arr.length; i++) {
                if(max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        } else {
            return null;
        }      
    }
}