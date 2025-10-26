package Exercise3;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class FileWriterDynamicProxy implements InvocationHandler {
    private Object testImpl;
    FileWriter fw;

    public FileWriterDynamicProxy(Object impl, String fileName) {
        this.testImpl = impl;
        try {
            this.fw = new FileWriter(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } 

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("update")) {
            fw.write("[ " + new Date().toString() + " ] ");
            fw.write(args[0].toString());
            fw.write(" changed state to: ");
            fw.write(args[1].toString() + "\n");
            fw.flush();
            return null;
        }
        else {
            return method.invoke(testImpl, args);
        }
    }
}
