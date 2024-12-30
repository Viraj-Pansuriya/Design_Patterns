import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object obj) {
        return instrumentation.getObjectSize(obj);
    }
}
