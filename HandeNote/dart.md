# Dart

[官方网址](https://dart.dev/samples)

[开启Dart的之旅](https://dart.dev/guides/language/language-tour)

按照惯例，让我们通过一个简单的`Hello world`例子进入`Dart`的学习

```dart
void main() {
    print("Hello dart !");
}
```

`Dart`语法要求每个application都应该有main()方法,通过print()方法可以将信息输出到控制台.

## tips

在使用vscode调试dart程序时需要配置`launch.json`才可以得心应手的使用。

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "name": "Dart",
            "program": "${file}",
            "request": "launch",
            "type": "dart"
        }
    ]
}
```

## 变量

由于类型推断，所以在类型安全的`Dart`代码中不需要声明变量类型，同`javascript`一样使用`var`声明变量，也可使用final和const

[final&const](https://dart.dev/guides/language/language-tour#final-and-const)

实例变量使用final
静态变量使用const

```dart
var name = 'dart';
var year = 2020;
var PI = 3.1415926;
var list = ['China', 'Hunan', 'Hengyang'];
var myMap = {'name': ['hande'], 'age': '21'};
```

## 流程控制语句

`Dart`的流程控制语句与其他语言没有什么差异

```dart
var i = 20;
if (i < 10) {
    print("i is less than 10");
} else if (i > 10) {
    print("i is more than 10");
} else {
    print("i is equal to 10");
}

for (var index in list) {
    print(index);
}

for (var i = 0; i < 10; i++) {
    print(i);
}

while (i < 20) {
    i += 1;
}
```

## 函数

```dart
int fibo(int n) {
    if (n == 0 || n == 1) return n;
    return fibo(n - 1) + fibo(n -2);
}

var res = fibo(20);
```

## Dart备忘录

[Dart cheatsheet codelab](https://dart.dev/codelabs/dart-cheatsheet)提供了一些常用代码的示例

`$` 用于取值

```dart
var a = 11;
var b = 22;

print('$a + $b' + ' = ${a + b}' + '${'ture'.toUpperCase()}'); // 11 + 22 = 33 TRUE
```

`??=` 判断为空就赋值

```dart
int a;
a ??= 66
```

等同于

```dart
int a;
if (a == null) {
    a = 66;
}
```

`??`除非它左侧的表达式为null，否则一直返回左侧的值

```dart
print(123 ?? 987);  //123
print(null ?? 'right'); //right
```

`?`防止可能为空的对象对属性方法的访问

```dart
object?.someProperty // ==>  (myObject != null) ? myObject.someProperty : null
object?.someProperty?.someMethod();
```

condition ? expr1 : expr2
如果条件为true，则求值expr1（并返回其值）；否则为false 。否则，求值并返回expr2的值。

```dart
print(1==0 ? 11111 : 00000)
```

## 异常

Dart提供Exception和Error 类型，以及许多预定义的子类型。当然，您可以定义自己的异常。但是，Dart程序可以将任何非null对象（不仅仅是Exception和Error对象）作为异常抛出。

```dart
throw FormatException('------>  this is a exception');

throw 'this is heiheihei';


try {
  breedMoreLlamas();
} on OutOfLlamasException {
  // A specific exception
  buyMoreLlamas();
} on Exception catch (e) {
  // Anything else that is an exception
  print('Unknown exception: $e');
} catch (e) {
  // No specified type, handles all
  print('Something really unknown: $e');
}

```

## 关键字

|1|2|3|4|
:--:|:--:|:--:| :--:
abstract|dynamic|implements|show|
as   | else |import | static
assert|enum|in|super
async|export |interface |switch
await|extends|is|sync
break|external|library|this
case|factory |mixin|throw
catch|false|new|true
class|final|null|try
const|finally|on |typedef
continue|for|operator |var
covariant |Function |part|void
default|get |rethrow|while
deferred |hide |return |with
do|if|set |yield

大部分的关键字的用法与`java`、`ts`、没有什么很大的差异，其中:
`dynamic`对应`ts`中的`any`，表示变量可以是任意类型，

`show`在你只想导一部分库的时候使用，如：`import 'package:xxx/xx1.dart' show xx;`，同时`hide`与其相反，不导入那一部分。

`as is !is` 在类型检查时使用，同时as还可用于指定库的别名`import 'package:xlib/x.dart' as xx;`，如：`(obj is Person) ? obj.name = 'sixGod';`等同于`(obj as Person).name = 'Iori'`

tips：
闭包里引用的变量不建议修改，只读

## 异步

[文档](https://dart.dev/guides/language/language-tour#asynchrony-support)
