package dynamicArray;

import org.junit.Test;

public class DynamicArrayTest {

    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.add(6, 2);

        dynamicArray.ForEach((Integer element) -> System.out.println(element));
        System.out.println("----------------");
        for (Integer num : dynamicArray){
            System.out.println(num);
        }
    }
}
