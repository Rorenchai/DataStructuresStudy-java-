# 数据结构（Java）练习代码 —— 按知识点分包整理

本目录是 IntelliJ IDEA 的 Java 工程，源码根目录为 `DataStructure/src`。
源码按知识点分到 5 个子目录，每个子目录就是一个 Java 包：**目录名 = 包名**。
每个文件开头都有一段说明注释（作用 / 所属知识点 / 实现要点），紧接着才是 `package` 语句。

```
数据结构/
├── DataStructure/
│   └── src/                     ← 源码根目录（IDEA 的 Sources Root）
│       ├── common/              package common      3 个文件：公共接口与实体类
│       ├── seqlist/             package seqlist     8 个文件：线性表 · 顺序存储
│       ├── linkedlist/          package linkedlist  8 个文件：线性表 · 链式存储
│       ├── stack/               package stack       9 个文件：栈
│       └── queue/               package queue       7 个文件：队列（含约瑟夫环）
├── out/                         ← IDEA 的编译输出（旧 class 可 Build → Rebuild Project 清理）
├── 数据结构.iml                  ← 工程模块配置（source root 指向 DataStructure/src）
└── README.md                    ← 本文件
```

一共 35 个 `.java` 文件，全部在各自的包目录里，`src` 根目录下没有散落文件。

## 一、知识点索引

| 知识点 | 包（目录） | 文件数 | 核心类 / 接口 | 可运行入口（全名） |
| --- | --- | --- | --- | --- |
| 公共基础类 | `common` | 3 | `LinearList`、`Student`、`LinkedNode` | —— |
| 线性表 · 顺序表 | `seqlist` | 8 | `SeqList` | `seqlist.Main`、`seqlist.TestSeqList`、`seqlist.TestStudentSeqList`、`seqlist.SeqListDemo_homework`、`seqlist.ReverseListTest`、`seqlist.MergeListTest` |
| 线性表 · 单链表 | `linkedlist` | 8 | `Node`、`SinglyLinkedList`、`LinknodeList` | `linkedlist.TestSinglyLinkedList`、`linkedlist.TestStudentSinglyLinkedList`、`linkedlist.TestLinknodeList`、`linkedlist.MergeLinkedListTest` |
| 栈 | `stack` | 9 | `Stark`、`SeqStark`、`LinkedStack`、`LinkedStack2` | `stack.TestSeqStark`、`stack.TestLinkedStack`、`stack.BracketMatch`、`stack.ReverseDemo`、`stack.DecToBinTest` |
| 队列 | `queue` | 7 | `Queue`、`SeqCirQueue`、`LinkedQueue` | `queue.TestSeqCirQueue`、`queue.TestLinkedQueue`、`queue.DecimalToBinary`、`queue.JosephusRing` |

推荐学习顺序：`common` → `seqlist` → `linkedlist` → `stack` → `queue`，后一个知识点会复用前一个的结点类 / 接口。

包与包之间的依赖关系：

```
common  ←──  seqlist      （SeqList 实现 LinearList；测试用 Student）
common  ←──  linkedlist   （SinglyLinkedList 实现 LinearList；LinknodeList 用 LinkedNode；测试用 Student）
common  ←──  stack        （LinkedStack 用 LinkedNode）
common  ←──  queue        （LinkedQueue 用 LinkedNode）
```

同包内互相引用不需要 `import`；跨包才需要，所以只有 7 个文件带 `import common.xxx`。

## 二、各包说明

### common（公共基础类，被多个知识点复用）

| 文件 | 作用 |
| --- | --- |
| `LinearList.java` | 线性表接口：`get` / `set` / `insert` / `remove` / `contains` / `indexOf` / `size` / `clear` / `isEmpty` / `printList`。顺序表和单链表都实现它，所以放在公共包 |
| `Student.java` | 测试用的学生实体类，重写 `toString` / `equals` / `hashCode`，作为顺序表、链表的元素类型演示泛型 |
| `LinkedNode.java` | 带 `getData()` / `setNext()` 的结点类，被 `LinknodeList`（单链表）、`LinkedStack`（链栈）、`LinkedQueue`（链队列）复用 |

### seqlist（线性表 · 顺序存储）

| 文件 | 作用 |
| --- | --- |
| `SeqList.java` | 顺序表实现：泛型数组存储、满时自动扩容一倍、插入后移、删除前移，另含 `reverse()` 逆置 |
| `Main.java` | 顺序表增删改查的综合演示 |
| `TestSeqList.java` | 以 `Integer` 为元素的顺序表测试 |
| `TestStudentSeqList.java` | 以 `Student` 为元素的顺序表测试（演示泛型与 `equals`） |
| `SeqListDemo_homework.java` | 作业版顺序表：`char` 字符表，完整演示创建、批量插入、指定位置插入、删除、查找、修改、遍历 |
| `ReverseListTest.java` | 顺序表逆置演示（调用传参版 `reverse(list)`） |
| `MergeList.java` / `MergeListTest.java` | 两个有序顺序表合并成一个有序表（归并思路） |

### linkedlist（线性表 · 链式存储）

| 文件 | 作用 |
| --- | --- |
| `Node.java` | 单链表结点：`data` 数据域 + `next` 地址域 |
| `SinglyLinkedList.java` | 带头结点的单链表实现：尾插法建表、按位取/改、插入、删除、判包含、求长度、清空、遍历 |
| `TestSinglyLinkedList.java` | 以 `Integer` 为元素的单链表测试 |
| `TestStudentSinglyLinkedList.java` | 以 `Student` 为元素的单链表测试 |
| `LinknodeList.java` / `TestLinknodeList.java` | 基于 `LinkedNode` 的另一版链表：头插法、尾插法、按索引取值、按值删除 |
| `MergeLinkedList.java` / `MergeLinkedListTest.java` | 两个有序单链表合并成一个有序链表 |

### stack（栈）

| 文件 | 作用 |
| --- | --- |
| `Stark.java` | 栈接口：`push` / `pop` / `peek` / `isEmpty`（类名沿用原来的 `Stark`，即 `Stack` 的笔误写法，为保证代码逻辑不变未重命名） |
| `SeqStark.java` / `TestSeqStark.java` | 顺序栈：数组 + `top` 指针实现，默认容量 16 |
| `LinkedStack.java` / `TestLinkedStack.java` | 链栈：复用 `LinkedNode`，头插法入栈、头删法出栈 |
| `LinkedStack2.java` | 链栈的另一种写法：私有静态内部类 `Node` + `size` 计数 |
| `BracketMatch.java` | 栈的应用：括号匹配 `()` `[]` `{}` |
| `ReverseDemo.java` | 栈的应用：字符串逆置 |
| `DecToBinTest.java` | 栈的应用：十进制整数转二进制 |

### queue（队列）

| 文件 | 作用 |
| --- | --- |
| `Queue.java` | 队列接口：`enqueue` / `dequeue` / `peek` / `isEmpty` |
| `SeqCirQueue.java` / `TestSeqCirQueue.java` | 循环顺序队列：数组 + 取模运算，`front`/`rear` 指针，判满时留空一个位置 |
| `LinkedQueue.java` / `TestLinkedQueue.java` | 链队列：带头结点，复用 `LinkedNode`，`front` / `rear` 指针 |
| `DecimalToBinary.java` | 队列的应用：十进制小数转二进制小数（使用 `java.util.Queue`） |
| `JosephusRing.java` | 队列的应用：约瑟夫环（n 个人按 m 报数出列，用 `Queue` + `LinkedQueue` 模拟） |

## 三、编译和运行

### 方式一：IntelliJ IDEA（推荐）

1. 用 IDEA 打开本目录 `数据结构`，`数据结构.iml` 已经把 `DataStructure/src` 标记为源码根目录；
2. 点开任意测试类，在 `main` 方法左侧点绿色三角运行；
3. 如果 IDEA 里还显示旧目录名或残留红叉，执行 **File → Reload All from Disk**（或右键项目 → Reload from Disk），必要时 **Build → Rebuild Project** 清掉 `out/` 里的旧 class。

### 方式二：命令行（JDK 17，在项目根目录执行）

```powershell
# 编译全部源码到 build 目录
$files = Get-ChildItem -Recurse -Filter *.java DataStructure\src | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -d build @files

# 运行时用“包名.类名”（冒号前的是包名）
java -cp build seqlist.TestSeqList
java -cp build queue.JosephusRing
```

也可以只编译某一个类（javac 会顺着 sourcepath 自动找依赖的源码）：

```powershell
javac -encoding UTF-8 -sourcepath DataStructure\src -d build DataStructure\src\queue\JosephusRing.java
java -cp build queue.JosephusRing
```

## 四、关于包结构的说明

Java 的规则是：**带包声明的源文件必须放在与包名同名的目录里**，而包名必须是合法的 Java 标识符，惯例用小写英文（例如 `queue`）。
所以之前把源码分到 `04_队列` 这类目录时，IDEA 2025.3 会报「缺少软件包语句，但与文件路径相对应的软件包名称 '04_队列' 无效」——因为 `04_队列` 以数字开头，不是合法包名，随后同目录的 `Queue`、`LinkedQueue` 也全部解析失败。

现在的处理方式：

- 目录改名为 `common` / `seqlist` / `linkedlist` / `stack` / `queue`，与包名一一对应；
- 每个文件开头都加了文件头说明注释，并加了 `package 包名;`，原有代码一行未改；
- 跨包引用的 7 个文件补 `import common.xxx;`；
- 类的全名变成 `包名.类名`（如 `queue.JosephusRing`），IDEA 里点 `main` 绿三角的运行方式不受影响。

## 五、可选的小改进（本次未做）

- `Stark` → `Stack`、`LinknodeList` → `LinkedNodeList` 这类命名笔误可以后续统一重命名（属于改代码，需要同步改引用）；
- 如果课程要求按功能再细分，可在包内继续加子包（子目录名同样要是合法包名）。
