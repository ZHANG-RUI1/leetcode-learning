package javacourse.jvm.homework.first.error;

import java.io.*;
import java.nio.file.Files;

/**
 * 这种方式需要对象实现序列化接口
 * @author zhangrui
 * @version 1.0
 * @date 2021/1/9 12:00
 */

public class MyClassLoader extends ClassLoader{
    public static void main(String[] args) {
        try {
            new MyClassLoader().findClass("Hello.xlass").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //1.寻找需要加载文件的路径
        File file = new File("E:\\JavaCourse\\2021_01_06\\Hello\\"+name);
        byte[] bytes = null;
        ByteArrayInputStream in = null;
        ObjectInputStream ois = null;
        Class clazz = null;

        //2.读取所提供的字节码，将其转换为对象并获取class对象
        try {
            bytes = Files.readAllBytes(file.toPath());
            for (byte b: bytes) {
                b = (byte) (255 - b);
            }

            in = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(in);
            clazz = ois.readObject().getClass();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return clazz;
    }
}
