
## JVM

### 1. JVM 主要组成部分
JVM（Java Virtual Machine）主要由以下几个部分组成：

- **类加载器子系统（Class Loader Subsystem）**：负责加载.class文件到JVM中。
- **运行时数据区（Runtime Data Area）**：包括堆（Heap）、方法区（Method Area）、虚拟机栈（JVM Stack）、本地方法栈（Native Method Stack）、程序计数器（Program Counter Register）。
- **执行引擎（Execution Engine）**：包括解释器（Interpreter）、即时编译器（JIT Compiler）和垃圾回收器（Garbage Collector）。
- **本地接口（Native Interface）**：与本地代码交互。
- **垃圾回收器（Garbage Collector）**：管理内存，回收不再使用的对象。

### 2. JVM 内存结构
JVM 内存结构主要包括以下几部分：

- **堆（Heap）**：存储对象实例，是垃圾回收的主要区域。
- **方法区（Method Area）**：存储类结构、常量池、方法数据和方法代码。
- **虚拟机栈（JVM Stack）**：每个线程私有，存储局部变量、操作数栈、帧数据等。
- **本地方法栈（Native Method Stack）**：支持本地（Native）方法的调用。
- **程序计数器（Program Counter Register）**：每个线程私有，记录当前线程执行的字节码指令地址。

### 3. 分别介绍强引用，弱引用，软引用，虚引用
- **强引用（Strong Reference）**：最常见的引用，类似于 `Object obj = new Object();`，只要强引用存在，垃圾回收器永远不会回收被引用的对象。
- **软引用（Soft Reference）**：用 `SoftReference` 类表示，当内存不足时会被回收，适合实现内存敏感的缓存。
    ```java
    SoftReference<Object> softReference = new SoftReference<>(new Object());
    ```
- **弱引用（Weak Reference）**：用 `WeakReference` 类表示，垃圾回收器在下一次垃圾回收时会回收该引用对象。
    ```java
    WeakReference<Object> weakReference = new WeakReference<>(new Object());
    ```
- **虚引用（Phantom Reference）**：用 `PhantomReference` 类表示，无法通过虚引用访问对象，主要用于跟踪对象被垃圾回收的状态。
    ```java
    PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), new ReferenceQueue<>());
    ```

### 4. 怎么判断对象是否可以被回收
JVM 通过可达性分析算法（Reachability Analysis）判断对象是否可以被回收。以下对象被认为是"根"（GC Roots）：

- 虚拟机栈中引用的对象。
- 方法区中类静态属性引用的对象。
- 方法区中常量引用的对象。
- 本地方法栈中 JNI（即一般说的 Native 方法）引用的对象。

如果从 GC Roots 开始，没有任何引用链能到达某个对象，则该对象是不可达的，可以被垃圾回收。

### 5. 垃圾回收算法、垃圾回收机制
**垃圾回收算法**：

- **标记-清除（Mark-Sweep）**：首先标记所有需要回收的对象，然后清除它们。
- **复制算法（Copying）**：将对象从一块内存复制到另一块内存，适用于新生代。
- **标记-整理（Mark-Compact）**：标记所有需要回收的对象，然后将存活的对象移动到内存一端，适用于老年代。
- **分代收集（Generational Collection）**：将内存分为新生代和老年代，新生代使用复制算法，老年代使用标记-整理或标记-清除算法。

**垃圾回收机制**：

- **Minor GC**：回收新生代，频率高，速度快。
- **Major GC（Full GC）**：回收老年代和新生代，频率低，速度慢。

### 6. 垃圾回收器
常见的垃圾回收器有：

- **Serial GC**：单线程垃圾回收器，适用于单核 CPU 环境。
- **Parallel GC**：多线程垃圾回收器，适用于多核 CPU 环境。
- **CMS GC**：并发标记清除垃圾回收器，减少垃圾回收停顿时间。
- **G1 GC**：面向服务器应用的垃圾回收器，将内存分为多个区域（Region），优先回收垃圾最多的区域。

### 7. JVM 类加载机制
JVM 类加载机制包括以下几个步骤：

- **加载（Loading）**：将类的 .class 文件读入内存，并创建一个代表这个类的 `Class` 对象。
- **验证（Verification）**：确保 .class 文件的字节码符合 JVM 规范。
- **准备（Preparation）**：为类的静态变量分配内存，并将其初始化为默认值。
- **解析（Resolution）**：将常量池中的符号引用替换为直接引用。
- **初始化（Initialization）**：执行类的 `<clinit>` 方法，初始化静态变量。

### 8. 双亲委派机制
双亲委派机制是指类加载器在加载类时，将请求首先委派给父类加载器。具体步骤如下：

1. 当前类加载器先检查该类是否已被加载。
2. 如果没有加载，委派给父类加载器加载。
3. 父类加载器继续向上委派，直到达到启动类加载器。
4. 如果父类加载器无法加载该类，则由当前类加载器尝试加载。

这种机制保证了 Java 的核心类库不会被自定义类覆盖。

### 9. JVM 参数配置
常用的 JVM 参数配置包括：

- **内存设置**：
    - `-Xms`：初始堆大小。
    - `-Xmx`：最大堆大小。
    - `-Xmn`：新生代大小。
    - `-XX:MetaspaceSize`：初始元空间大小。
    - `-XX:MaxMetaspaceSize`：最大元空间大小。

- **垃圾回收器设置**：
    - `-XX:+UseSerialGC`：使用 Serial 垃圾回收器。
    - `-XX:+UseParallelGC`：使用 Parallel 垃圾回收器。
    - `-XX:+UseConcMarkSweepGC`：使用 CMS 垃圾回收器。
    - `-XX:+UseG1GC`：使用 G1 垃圾回收器。

- **调试和监控**：
    - `-XX:+PrintGCDetails`：打印垃圾回收详情。
    - `-XX:+PrintGCTimeStamps`：打印垃圾回收时间戳。
    - `-Xloggc:filename`：将垃圾回收日志输出到文件。

- **其他常用参数**：
    - `-server`：启用服务模式。
    - `-client`：启用客户端模式。
    - `-Dproperty=value`：设置系统属性。

这些参数可以根据应用的需求和环境进行调整和优化。

### 10. 堆和栈的区别
- 堆是运⾏时确定内存⼤⼩，⽽栈在编译时即可确定内存⼤⼩
- 堆内存由⽤户管理( Java中由JVM管理)，栈内存会被⾃动释放
- 栈实现⽅式采⽤数据结构中的栈实现，具有先进后出的顺序特点，堆为⼀块⼀块的内存
- 栈由于其实现⽅式，在分配速度上⽐堆快的多。分配⼀块栈内存不过是简单的移动⼀个指针
- 栈为线程私有, ⽽堆为线程共享

