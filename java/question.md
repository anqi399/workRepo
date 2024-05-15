# Java基础

## == 和 equals() 的区别
   == 运算符：
   == 运算符用于比较两个对象的内存地址，即判断两个对象是否引用同一块内存空间。
   如果两个对象引用的是同一个对象（即内存地址相同），则 == 运算符返回 true，否则返回 false。
   对于基本数据类型，== 运算符用于比较它们的值是否相等。
   equals() 方法：
   equals() 方法是 Object 类中定义的方法，用于比较两个对象的内容是否相等。
   默认情况下，equals() 方法的行为与 == 运算符相同，即比较两个对象的内存地址。
   但是，equals() 方法可以被子类重写（override），用于根据对象的属性来判断对象是否相等。
   在重写 equals() 方法时，通常会根据对象的属性值来比较，如果两个对象的属性值相同，则认为这两个对象相等，否则不相等。 # 
## 重写和重载的区别
   重写是指子类重新定义（覆盖）了父类中的某个方法，使得子类在调用该方法时执行子类自己的实现逻辑。
   重写发生在子类和父类之间，方法签名必须一致，即方法名、参数列表和返回类型都相同。
   重写是多态性的一种表现，子类可以根据需要重写父类的方法，以实现特定的功能需求。
   重写时，子类方法的访问修饰符不能比父类方法的访问修饰符更严格，但可以更宽松。
   重写只适用于实例方法，不能重写静态方法。

   ```java
   class Animal {
       public void makeSound() {
           System.out.println("Animal makes a sound");
       }
   }

   class Dog extends Animal {
       @Override
       public void makeSound() {
           System.out.println("Dog barks");
       }
   }
   ```

   重载是指在同一个类中，可以定义多个同名的方法，但它们的参数列表必须不同（包括参数个数、类型或顺序）。
   重载发生在同一个类中，同名方法的参数列表不同，可以有不同的返回类型。
   重载是静态绑定（编译时多态）的一种表现，编译器根据参数列表的不同选择合适的方法。
   重载可以增强方法的灵活性和易用性，提供了一种便利的方式来处理不同类型或数量的参数。

   ```java
   class Calculator {
       public int add(int a, int b) {
           return a + b;
       }

       public double add(double a, double b) {
           return a + b;
       }

       public int add(int a, int b, int c) {
           return a + b + c;
       }
   }
   ```

## 实例方法和静态方法

    实例方法是对象的方法，必须通过对象来调用；而静态方法是类的方法，可以通过类名直接调用。实例方法操作对象的状态，而静态方法则不依赖于对象的状态。
## 面向过程和面向对象区别

### 面向过程
- **思维方式**：以过程（步骤）为中心。
- **代码组织**：通过函数和过程组织代码。
- **复用性**：复用性较低，修改影响大。
- **示例**：C 语言。

### 面向对象
- **思维方式**：以对象为中心。
- **代码组织**：通过类和对象组织代码。
- **复用性**：复用性高，通过继承和多态实现。
- **示例**：Java、C++。

## 面向对象三大特性

### 封装
- **定义**：将数据和方法封装在对象内部，隐藏实现细节。
- **优点**：提高代码安全性和维护性。

### 继承
- **定义**：子类继承父类的属性和方法，扩展或重写其功能。
- **优点**：提高代码复用性，形成类层次结构。

### 多态
- **定义**：同一方法可以有不同表现形式（方法重载和方法重写）。
- **优点**：提高代码灵活性和可扩展性。

```java
// 示例：多态
class Animal {
   public void sound() {
      System.out.println("Animal makes a sound");
   }
}

class Dog extends Animal {
   @Override
   public void sound() {
      System.out.println("Dog barks");
   }
}

public class TestPolymorphism {
   public static void main(String[] args) {
      Animal myDog = new Dog();
      myDog.sound(); // 输出：Dog barks
   }
}
``` 

## 1. String、StringBuilder、StringBuffer 的区别

### String
- **不可变类**：字符串一旦创建，不能改变。
- **线程安全**：由于不可变性，天然线程安全。
- **性能**：适合少量字符串操作，频繁操作性能较差。

### StringBuilder
- **可变类**：内容可变，提供修改方法。
- **线程不安全**：非同步设计，适用于单线程环境。
- **性能**：比 `String` 和 `StringBuffer` 性能更好，适合频繁字符串操作。

### StringBuffer
- **可变类**：内容可变，提供修改方法。
- **线程安全**：同步设计，适用于多线程环境。
- **性能**：比 `StringBuilder` 性能稍差，但线程安全。

## 2. 接口和抽象类的区别

### 接口
- **完全抽象**：只声明方法，不包含实现。
- **多继承**：一个类可以实现多个接口。
- **默认方法**：Java 8 引入，可以包含默认方法实现。
- **变量**：只能有常量（public static final）。

### 抽象类
- **部分抽象**：可以包含方法声明和具体实现。
- **单继承**：一个类只能继承一个抽象类。
- **构造函数**：可以有构造函数。
- **变量**：可以有普通成员变量。

## 3. 常见的异常类

- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `ClassCastException`
- `IllegalArgumentException`
- `IllegalStateException`
- `NumberFormatException`
- `IOException`
- `FileNotFoundException`
- `InterruptedException`

## 4. Exception 和 Error 有什么区别

### Exception
- **描述**：应用程序可以捕获和处理的异常。
- **子类**：`IOException`、`SQLException` 等。
- **恢复性**：可以通过编写代码进行恢复。

### Error
- **描述**：严重的错误，通常不可恢复。
- **子类**：`OutOfMemoryError`、`StackOverflowError` 等。
- **恢复性**：通常无法通过代码恢复。

## 5. checkedException 和 uncheckedException 区别

### checkedException
- **编译期检查**：必须捕获或声明抛出。
- **父类**：`Exception`，但不包括 `RuntimeException` 及其子类。
- **示例**：`IOException`、`SQLException`。

### uncheckedException
- **运行期检查**：不强制捕获或声明。
- **父类**：`RuntimeException` 及其子类。
- **示例**：`NullPointerException`、`ArrayIndexOutOfBoundsException`。

## 6. final 关键字

- **final 变量**：不可变，一旦赋值不能改变。
- **final 方法**：不可重写，子类不能修改此方法。
- **final 类**：不可继承，不能有子类。
- **final 参数**：方法参数不可修改。

## 7. 泛型的理解

- **定义**：允许在类、接口和方法中使用类型参数，提供类型安全的代码。
- **优点**：
   - **类型安全**：在编译时检查类型错误。
   - **重用性**：编写通用代码，适用于多种类型。
   - **性能**：避免类型转换，提升性能。

```java
// 示例：泛型类
public class Box<T> {
   private T item;
   public void setItem(T item) { this.item = item; }
   public T getItem() { return item; }
}

   // 示例：泛型方法
   public <T> void printArray(T[] array) {
      for (T element : array) {
         System.out.println(element);
      }
   }
   
   /*
    <T> T可以传入任何类型的list
    关于参数T的说明：
        第一个T表示<T>是一个泛型
        第二个T表示方法返回的是T类型的数据
        第三个T表示集合List传入的数据是T类型
*/

   private <T> T getStudent(List<T> list){
      return;
   }
// Result<T>
```

# 集合
## Java的集合类有那些？
- 主要由Collection和Map派生而出。其中Collection派生出Set、List、Queue。
- Collection接口：根接口
  - List接口：有序集合，允许重复；ArrayList、LinkedList
  - Set接口：不允许重复。HashSet、LikedHashSet、TreeSet
  - Queue接口：队列；LikedList、PriorityQueue
- Map接口：键值对；HashMap、TreeMap、LinkedHaseMap

## Array和ArrayList区别
- 数组大小固定。ArrayList动态数组，自动扩容
- 数组可以存在任何类型元素，但不支持泛型；ArrayList支持泛型
- 数组可存储基本类型数据，也可存储对象；Arraylist只能存对象（List<Env> envs = new ArrayList<>()），基本类型数据需要使用对于的包装类（如Integer、Double）
- 数组为简单的数据结构；ArrayList为集合框架一部分，提供CRUD等基本操作


## 1. ArrayList 和 LinkedList 区别？

### ArrayList
- **底层数据结构**：动态数组。
- **查询速度**：快，随机访问时间复杂度为 O(1)。
- **插入删除速度**：慢，插入或删除元素时可能需要移动大量元素。
- **内存使用**：占用连续内存空间。

### LinkedList
- **底层数据结构**：双向链表。
- **查询速度**：慢，随机访问时间复杂度为 O(n)。
- **插入删除速度**：快，只需改变指针指向。
- **内存使用**：占用分散的内存空间，存储额外的指针。

## 2. 集合类中那些是线程安全的，哪些是不安全的？

### 线程安全的
- `Vector`
- `Hashtable`
- `Collections.synchronizedList`
- `Collections.synchronizedMap`
- `ConcurrentHashMap`
- `CopyOnWriteArrayList`
- `CopyOnWriteArraySet`

### 线程不安全的
- `ArrayList`
- `LinkedList`
- `HashMap`
- `HashSet`
- `TreeMap`
- `TreeSet`

## 3. ArrayList 扩容机制？

- 默认初始容量为 10。
- 当需要的元素数量超过当前数组容量时，`ArrayList` 会扩容。
- 扩容策略为：新容量 = 旧容量的 1.5 倍 + 1。
- 新容量数组创建完成后，将旧数组元素复制到新数组。

## 4. Map 接口有那些实现类？

- `HashMap`
- `LinkedHashMap`
- `TreeMap`
- `Hashtable`
- `ConcurrentHashMap`
- `WeakHashMap`
- `IdentityHashMap`

## 5. HashMap 简述？底层原理实现？

- `HashMap` 是基于哈希表实现的 `Map` 接口的非同步类，允许存储 `null` 键和 `null` 值。
- 底层实现：
   - 使用数组和链表（JDK 1.8 之后还包括红黑树）来存储数据。
   - 通过 `hashCode` 方法计算键的哈希值，然后与数组长度取模决定元素的存储位置。

## 6. Hash 冲突如何解决，HashMap 如何解决 Hash 冲突？

### 解决方法
- **链地址法**：将哈希值相同的元素存储在同一个链表中。
- **开放地址法**：发现冲突时，尝试探测其它存储位置。

### HashMap 的解决方式
- 使用链地址法解决冲突。
- JDK 1.8 之后，当单个链表长度超过一定阈值（默认 8）时，链表转换为红黑树，提高查询效率。

## 7. HashMap 的 put 方法流程

1. 计算键的 `hashCode` 并确定数组索引位置。
2. 如果索引位置为空，直接插入新节点。
3. 如果索引位置不为空，遍历链表或红黑树：
   - 键相同时，替换旧值。
   - 键不同，插入链表或红黑树。
4. 插入新节点后，检查是否需要扩容。
5. 如果需要扩容，重新哈希并调整数组大小。

## 8. HashMap 为什么线程不安全，如何安全？

### 线程不安全原因
- 多线程环境下，`put` 操作可能会导致数据不一致或死循环（例如，扩容时）。

### 如何保证线程安全
- 使用 `Collections.synchronizedMap` 包装 `HashMap`。
- 使用线程安全的 `ConcurrentHashMap`。

## 9. HashSet、HashMap、HashTable 区别

- **HashSet**
   - 底层实现：基于 `HashMap`，仅存储键。
   - 线程不安全。

- **HashMap**
   - 存储键值对，允许 `null` 键和值。
   - 线程不安全。

- **Hashtable**
   - 存储键值对，不允许 `null` 键和值。
   - 线程安全（方法上使用 `synchronized`）。

## 10. HashMap 和 ConcurrentHashMap 区别

- **HashMap**
   - 线程不安全。
   - 整体数据结构：数组 + 链表/红黑树。

- **ConcurrentHashMap**
   - 线程安全，采用分段锁机制。
   - 支持高并发，读取操作无锁。
   - 更复杂的结构：分段数组 + 链表/红黑树。

# 
String、StringBuilder、StringBuffer的区别
接口和抽象类的区别
常见的异常类
Exception和Error有什么区别
checkedException和uncheckedException区别
final关键字
泛型的理解
面向过程和面向对象区别
面向对象三大特性