# Java基本语法

[参考网站1](https://www.tutorialspoint.com/java/index.htm)

[参考网站2](https://www.javatpoint.com/)

 java A.java

可以运行单文件

//指定运行版本

```bash
javac --release 7 Demo.java
javac --release 8 Demo.java
javac --release 12 Demo.java
```

```bash
// 查看运行时间
time javac Demo.java

javac A.java
javac B.java
java A
//可以模块化（多文件）运行（A调用B）
```

[Jackson](https://github.com/FasterXML/jackson)

json解析类库：Gson,FastJson,Jackson

导入maven的依赖包，可以在maven的[repostory网站](https://mvnrepository.com/)上搜索需要的dependency。

## Java动态数组

常用动态数组有两类：list和vector

### Vector

```
jshell> var v = new Vector<Integer>(3);
v ==> []
jshell> v.size()
$11 ==> 0
jshell> v
v ==> []
jshell> v.add(22)
$13 ==> true
jshell> v.add(11)
$14 ==> true
jshell> v.add(55)
$15 ==> true
jshell> v.add(88)
$16 ==> true
jshell> v
v ==> [22, 11, 55, 88]
jshell> v.size()
$18 ==> 4
jshell> v.set(0, 11)
$26 ==> 10
jshell> v
v ==> [11, 20, 30, 40, 50]
jshell> v.remove(4)
$28 ==> 50
jshell> v
v ==> [11, 20, 30, 40]
jshell> v.add(0, 1)
jshell> v
v ==> [1, 11, 20, 30, 40]
jshell> var a = v.get(3)
a ==> 30
jshell> v.contains(40)
$51 ==> true
jshell> v.indexOf(11)
$48 ==> 1
```

### List

```
jshell> List<String> l = new ArrayList<>(3)
l ==> []
jshell> l
l ==> []
jshell> l.add("hello")
$19 ==> true
jshell> l.add("world")
$20 ==> true
jshell> l
l ==> [hello, world]
jshell> l.add("Maxwit")
$22 ==> true
jshell> l.add("No.1")
$23 ==> true
jshell> l
l ==> [hello, world, Maxwit, No.1]
jshell> l.add(0,"hooooo")
jshell> l
l ==> [hooooo, hello, world, Maxwit, No.1]
jshell> l.set(1, "Hello")
$36 ==> "hello"
jshell> l
l ==> [hooooo, Hello, world, Maxwit, No.1]
jshell> l.remove(2)
$38 ==> "world"
jshell> l
l ==> [hooooo, Hello, Maxwit, No.1]
jshell> var m = l.get(2)
m ==> "Maxwit"
jshell> l.indexOf("No.1")
$45 ==> 3
jshell> l.contains("Maxwit")
$43 ==> true
``
## 栈和队列

### Stack

jshell> Stack<Integer> s = new Stack<>()
s ==> []
jshell> s.push(11)
$53 ==> 11
jshell> s
s ==> [11]
jshell> s.push(22)
$55 ==> 22
jshell> s.push(33)
$56 ==> 33
jshell> s.pop()
$57 ==> 33
jshell> s
s ==> [11, 22]
jshell>

### Queue

```jshell
jshell> Queue<Integer> q = new LinkedList<>()
q ==> []
jshell> q.offer(10)
$60 ==> true
jshell> q
q ==> [10]
jshell> q.offer(20)
$62 ==> true
jshell> q.offer(30)
$63 ==> true
jshell> q.poll()
$64 ==> 10
jshell> q
q ==> [20, 30]
jshell> q.remove()
$66 ==> 20
```

出队(删除)方式有两种：poll()和remove()
后者在队列为空时会抛异常
前者返回null
￼

## Map

```jshell
jshell> Map<String, Integer> m = new HashMap<>();
m ==> {}
jshell> m.put("aa", 11)
$2 ==> null
jshell> m
m ==> {aa=11}
jshell> m.put("aa", 11)
$4 ==> 11
jshell> m.put("aa", 22)
$5 ==> 11
jshell> m.put("bb", 11)
$6 ==> null
jshell> m
m ==> {aa=22, bb=11}
```

## 类与对象

### 接口

```java
package com.maxwit;

public class App {
    interface IA {
        int foo(int x, int y);
    }

    public static void main(String[] args) {
        IA ia = (int a, int b) -> a + b;
        System.out.println(ia.foo(11, 22));
    }
}
```

## 构造方法

实例化对象的时候会有如下操作：

1. 调用构造方法（构造方法和类名同名，是特殊的类方法，为什么特殊：第一，方法名和类名一致。第二，new 对象的时候被调用。）
2. 分配Class的内存存储空间，并且赋值给对象

```java
package main.java.mygradle;
class Mydemo1 {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    Mydemo1() {
        System.out.println("Constructor method called");
    }
    public static void main(String[] args) {
        Mydemo1 m1 = new Mydemo1();
        m1.setName("LiLei");
        System.out.println(m1.getName());
    }
}
```

## 如何给私有变量赋值

1.set方法

2.通过构造方法

```java
Student(String snum) {
        // System.out.println("I am a student");
        super();
        this.snum = snum;
        System.out.println(this.snum);
    }
Student s = new Student("s10001");
```

## 多态

多态的核心就是重写

## 泛型

```java
List<Integer> list  = new ArrayList<>();
```

```java
class B {
        int x = 22;

        public void func1() {
            System.out.println("A.func1():" + x);
        }
    }
```

## 抽象类

### abstract

1. abstract 关键字可以修饰类或方法。
2. abstract 类可以扩展（增加子类），但不能直接实例化。
3. abstract 方法不在声明它的类中实现，但必须在某个子类中重写。

```JAVA
abstract class AbstractClass {
    public void func() {
        System.out.println("from abstract class");
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        //AbstractClass a = new AbstractClass() //False 抽象类不能被实例化
        AbstractClass a = new AbstractClass(){}; //加一对{}这是用来创建匿名子类，一般是用来实例化接口或实例化抽象类
        a.func();
    }
}
```

## tips

* 采用 abstract 方法的类本来就是抽象类，并且必须声明为 abstract。
* abstract 类不能实例化。
* 仅当 abstract 类的子类实现其超类的所有 abstract 方法时，才能实例化 abstract 类的子类。这种类称为具体类，以区别于 abstract 类。
* 如果 abstract 类的子类没有实现其超类的所有 abstract 方法，该子类也是 abstract 类。
* abstract 关键字不能应用于 static、private 或 final 方法，因为这些方法不能被重写，因此，不能在子类中实现。
* final 类的方法都不能是 abstract，因为 final 类不能有子类。

## 抽象方法

有方法名的定义没有方法的实现
抽象方法的好处是允许定义和实现分开
抽象类和抽象方法的关系：含有抽象方法的类一定是抽象类，抽象类里不一定含有抽象方法
抽象类存在的意义是用来被继承的。一个类继承了一个抽象类，必须实现抽象类里面所有的抽象方法，否则，此类也是抽象类。

## 内部类

```java
class A {
    class B {
        public void foo() {
            System.out.println("A.foo()");
        }
    }

    public void foo() {
        B b = new B();
        b.foo();
        System.out.println("B.foo()");
    }
}

public class Demo {
    public static void main(String[] args) {
        A a = new A();
        // a.foo();
        A.B ab = a.new B(); // 类外实现内部类
        ab.foo();
    }
}
```

## 匿名内部类
￼

## static关键字

Java中的static关键字主要用于内存管理。我们可以将Java静态关键字与变量，方法，块和嵌套类一起使用。static关键字属于类，而不是类的实例

静态可以调静态，静态不能调非静态，非静态可以调静态

Static的四种使用情况：
1.变量（类变量）
2.方法（类方法）
3.块
4.嵌套类
￼
### 1.静态变量

* 静态变量是可以被引用所有对象引用的公共属性
* 静态变量在类的加载时仅在类区域中获得一次内存
* 优点：节约内存

### 2.静态方法

### 3.块

```java
class A {
    static {System.out.println(“static display”);}

    A() {
        System.out.println(“main display”);
    }
}
```

## final关键字

java中的final关键字用于限制用户。java final关键字可以在许多上下文中使用。最终可以是：

1. 变量
2. 方法
3. 类

声明变量是常量,只读值不可变同const

## volatile

声明变量为不稳定的，编译器将不会优化与此变量相关的代码
表象：当两个线程访问同一变量，加上valatile防止出错

## native

使用native声明的方法不需要实现只需要声明，方法由C/C++实现，跨语言调用

## 变量

## java转型

1.父类引用指向子类对象,子类s1引用不能指向父类对象。
2.把子类对象直接赋给父类引用叫upcasting向上转型，向上转型不用强制转换。
3.把指向子类对象的父类引用赋给子类引用叫向下转型(downcasting)，要强制转换。

```java
Father f1= new Son();  //向上转型

Son s1 = (Son)f1;  //向下转型
```

## java 命令行传参

```java
public class App {
    public static void main(String[] args) {
        System.out.println(System.getProperties().getProperty("foo"));
    //foo是java环境变量
    }
}
```

```sh
javac -D foo=“abcd” App.java
```

## 闭包

闭包能够将一个方法作为一个变量去存储、传递，这个方法有能力去访问所在类的自由变量。
[参考网址1](https://www.zhihu.com/question/51402215/answer/556617311)
[参考网址2](https://www.zhihu.com/question/21865351/answer/105489099)

```java
import java.util.Date;

public class DemoTime {
    public interface GetTime {
        void myPrint();
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        while (true) {
            final long count = System.currentTimeMillis() - start;
            GetTime ss = () -> {
                System.out.println(count);
            };
            ss.myPrint();
            if (count >= 2*1000)
                break;
        }
}
}
```

## Thread

### synchronized

`synchronized`其实是对`lock`的简化，方便我们使用锁，加上`synchronized`关键字后系统自动帮我们`lock`和`unlock`，属于无条件上锁无条件解锁，只能适用于一些简单的业务场景

操作缓冲区的代码就是临界区

在方法前加上synchronized
a b 两个线程，a在缓冲区时，b会等a执行完再执行

### Lock

```java
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexDemo {
    Lock mutex = new ReentrantLock();
    int i = 1;

    void foo() {
        mutex.lock();
        System.out.print(i + " -> ");
        i++;
        System.out.println(i);
        mutex.unlock();
    }

    public static void main(final String[] args) throws InterruptedException {
        MutexDemo demo = new MutexDemo();
        Vector<Thread> pool = new Vector<>(20);
        for (int i = 0; i < pool.capacity(); i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 5; j++)
                    demo.foo();
            });
            pool.add(thread);
            thread.start();
        }
        for (Thread thread : pool)
            thread.join();
        System.out.println("abc");
    }
}
```

## Socket

### Callable and Future

Java `Callable` 和 `Future` 在多线程中被大量使用。`Callable`接口类似于`Runnable`，但是`Runnable`不会返回结果，并且无法抛出返回结果的异常，而`Callable`功能更强大一些，被线程执行后，可以返回值，这个返回值可以被`Future`拿到，也就是说，`Future`可以拿到异步执行任务的返回值.

[参考网址1](https://www.journaldev.com/1090/java-callable-future-example)

[参考网址2](https://howtodoinjava.com/java/multi-threading/java-callable-future-example/)

```java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CallableFuture
 */
public class CallableFuture implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new CallableFuture();
        for (int i = 0; i < 100; i++) {
            Future<String> future = executorService.submit(callable);
            list.add(future);
        }
        for (Future<String> fut : list) {
            try {
                System.out.println(new Date() + " --> " + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            executorService.shutdown();
        }
    }
}

```

### Promise

### Function object

`Function<T, S> func = (T t) -> {return s};`

上面的语句表示传入一个定义一个Function对象，传入是的类型是T，返回的类型是S

### yield()

yield()，在代码调用yield方法，当前线程会主动放弃当前时间片；
