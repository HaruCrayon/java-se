public class Test02 {
    public static void main(String[] args) {
        // String[] strs = {"jack", "harry", "smith"};
        // String[] strs = null;
        String[] strs = {};
        
        String findStr ="link";
        A02 a02 = new A02();
        Integer index = a02.find(findStr, strs);
        if(index != null) {
            System.out.println("查找的字符串的index是 " + index);
        } else {
            System.out.println("strs不能为null或{}");
        }
    }
}


//编写类A02，定义方法find，实现查找某字符串是否在字符串数组中，
//并返回索引，如果找不到，返回-1

class A02 {

    public Integer find(String findStr, String[] strs) {
        if(strs != null && strs.length > 0) {
            int index = -1;
            for(int i = 0; i < strs.length; i++) {
                if(findStr.equals(strs[i])) {
                    index =  i;
                }
            }
            return index;
        } else {
            return null;
        }    
    }
}