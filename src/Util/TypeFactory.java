package Util;

import tag.ClassType;
import tag.MethodType;
import tag.PackageType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhaoshiqiang on 2016/9/15.
 */
public class TypeFactory {

    private static ClassType CLASSTYPE = new ClassType();
    private static MethodType METHODTYPE = new MethodType();
    private static PackageType PACKAGETYPE = new PackageType();

    public static ClassType getCLASSTYPE() {
        return CLASSTYPE;
    }

    public static MethodType getMETHODTYPE() {
        return METHODTYPE;
    }

    public static PackageType getPACKAGETYPE() {
        return PACKAGETYPE;
    }

    public static ClassType getClassType() throws Exception {
        return (ClassType) deepCopy(CLASSTYPE);
    }

    public static MethodType getMethodType() throws Exception {
        return (MethodType) deepCopy(METHODTYPE);
    }

    public static PackageType getPackageType(){
        return new PackageType();
    }

    private static Object deepCopy(Object object) throws Exception{

        //将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(object);
        //将流序列化成对象
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return ois.readObject();
    }
}
