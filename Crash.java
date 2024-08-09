import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("generate:" + i);
            downcall(i);
        }
    }

    public static MethodHandle downcall(int count) {
        MemoryLayout[] memoryLayouts = new MemoryLayout[count];
        Arrays.fill(memoryLayouts, ValueLayout.JAVA_INT);
        return Linker.nativeLinker().downcallHandle(
                FunctionDescriptor.ofVoid(memoryLayouts)
        );
    }

}
