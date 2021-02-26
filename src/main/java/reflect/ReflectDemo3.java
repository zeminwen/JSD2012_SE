package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用有参构造器实例化对象
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception{
        Person p=new Person("张三",22);
        System.out.println(p);

        //反射
        Class cls=Class.forName("reflect.Person");
        //通过类对象获取对应的构造器
//        Constructor c=cls.getConstructor();//不传参数就是获取无参的构造器
        Constructor c=cls.getConstructor(String.class,int.class);//Person(String,int)

        Object o=c.newInstance("范传奇",25);
        System.out.println(o);
    }
}
