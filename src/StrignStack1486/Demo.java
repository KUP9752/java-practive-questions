package StrignStack1486;

public class Demo {
    public static void transferStacks(StringStack dst, StringStack src) {
        while (!src.isEmpty()) {
            dst.push(src.pop());
        }
    }

    public static void main(String[] args) {
        StringStack aStack = new StringStackArray();
        StringStack lStack = new StringStackList();
        StringStack linkedStack = new StringStackLinkedList();

        aStack.push("1");
        aStack.push("2");
        aStack.push("3");
        aStack.push("4");

        System.out.println(aStack);
        transferStacks(lStack, aStack);

        System.out.println(lStack);
        lStack.pop();
        System.out.println(lStack);




    }
}
