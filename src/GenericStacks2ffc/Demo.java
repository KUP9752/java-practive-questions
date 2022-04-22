package GenericStacks2ffc;

import StrignStack1486.StringStack;
import StrignStack1486.StringStackArray;
import StrignStack1486.StringStackLinkedList;
import StrignStack1486.StringStackList;

public class Demo {
    public static <T> void transferStacks(GenericStack<T> dst, GenericStack<T> src)
            throws EmptyStackException, StackFullException {

        while(!src.isEmpty()) {
            dst.push(src.pop());
        }
    }

    public static void main(String[] args) throws EmptyStackException, StackFullException {
        GenericStack<String> aStack = new GenericStackArray<>();
        GenericStack<String> lStack = new GenericStackList<>();
        StringStack linkedStack = new StringStackLinkedList();

        aStack.push("1");
        aStack.push("2");
        aStack.push("3");
        aStack.push("4");

        System.out.println("Array Stack:" + aStack);
//        System.out.println("Array Stack:" + aStack.stack);
        transferStacks(lStack, aStack);

        System.out.println(lStack);
        lStack.pop();
        System.out.println(lStack);
    }
}
