public class demo {
    private static void implementSolution() {
        String str1 = new String("hello");
        String str2 = new String("hello");
        String str3 = str1;

        System.out.println("使用 == 运算符比较对象的引用：");
        System.out.println(str1 == str2);  // false
        System.out.println(str1 == str3);  // true

        System.out.println("使用 equals() 方法比较对象的内容：");
        System.out.println(str1.equals(str2));  // true
        System.out.println(str1.equals(str3));  // true
        System.out.println();
    }
}