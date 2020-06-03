# JavaScript

```
javascript 动态类型
typescript 静态类型
```

Js国内的包管理工具—->cnpm

```
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

[国内npm镜像](https://segmentfault.com/a/1190000002576600)

# JSON-server & faker

# JSON-Server

简单来说，JSON-Server是一个Node模块，运行Express服务器，你可以指定一个json文件作为api的数据源。
```
npm install -g son-server
```

# faker.js
如果要自己瞎编API数据的话也是比较烦恼，用faker.js就可以轻松解决这个问题啦!他可以帮助你自动生成大量fake的json数据，作为后端数据~
```
npm install faker
```
# JS+HTML
Angular, React, Vue, Bootstrap, jQuery (最基本、最常用的几个前端框架)

## jQuery

```js
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>

// $(function() {
        //     $("#a").on("change", function() {
        //         var a = $("#a").val()
        //         var b = $('#b').val()
        //         var s = parseInt(a) + parseInt(b)
        //         $('#s').val(s)

        //     })

        //     $("#b").on("change", function() {
        //         var a = $("#a").val()
        //         var b = $('#b').val()
        //         var s = parseInt(a) + parseInt(b)
        //         $('#s').val(s)

        //     })
        // });
```
实现a+b
```html
<html>
<head>
    <title>a + b</title>
    <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script>
        function add() {
            var a = $("#a").val()
            var b = $('#b').val()
            var s = parseInt(a) + parseInt(b)
            $('#s').val(s)
        }
    </script>
</head>
<body>
    <input type="text" value="123" id="a" onchange="add()" /> +
    <input type="text" value="321" id="b" onchange="add()" /> =
    <input type="text" value="?" id="s" />
    <button onclick="add()">result</button>
</body>
</html>
```

# axios
[axios source code](https://github.com/axios/axios)

axios框架：get和post请求
https://blog.csdn.net/muyi_amen/article/details/84108401

Aixos网络请求框架
https://segmentfault.com/a/1190000020601672?utm_source=tag-newest

# babel

[官方文档](https://babeljs.io/setup#installation)

babel: ES6 -> ES5

“Babel is a hugely flexible compiler that converts ES2015 and beyond into ES5 and ES3.”

ES5-, CommonJS

ES6, ECMAScript2015

ECMAScript（ES）是JavaScript语言的规范

ES5 -> ES6: 新增（正式的）OOP

ES6 -> TypeScript: 增加type类型检查
区别：
ES6用标准的import/export

CommonJS/ES5-是require()/exports.xx

`npm i --save-dev babel-preset-es2015`

tip:--save-dev代表安装在本地开发依赖中

cnpm install -g babel-cli

```js
  1 exports.foo=foo;
  2 function foo(){
  3     console.log(a);
  4 }
```
```js
  1 var _aa = require('./aa');
  2 (_aa.foo)()
```

babel aa.js -o out/aa.js
￼


# gulp

https://github.com/babel/gulp-babel

1. build project

   ```bash
    mkdir XX
    cd XX
    npm init -y
   ```

2. install gulp

   ```bash
   npm install gulp --save-dev
   ```

3. 编辑gulpfile.js

   ```js
    var gulp = require('gulp');

    gulp.task('hello', function() {
      console.log("Hello World!");
    });
   ```

4. 运行：

   ```bash
   gulp hello
   ```

# webpack

webpack的文档，可以参考一下    https://webpack.js.org/guides/getting-started/#modules

`cnpm install webpack webpack-cli -g`


# Vue

## [document](https://cli.vuejs.org/)

## Install

```bash
npm install -g @vue/cli
npm install -g vue
```

## 引入方式

1.script

`<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>`

2.本地文件

## 使用
```bash
vue init webpack demo
Vue create modem
```
es5 < es6 < ts
 
## typescript

使用vscode Debug .ts 文件
写一个测试文件

```ts
var a = 11, b= 22
console.log(`${a} + ${b} = ${a + b}`)
```

点击debug，报错无法直接运行ts，需要编译成es5，
在terminal中输入`tsc --init`，生成tsconfig文件，取消`”sourceMap": true`和`"outDir": "./out"`
的注释，再次在terminal中输入tsc,再次运行再报错，在launch.json中add configuration，具体可见`~/javaScript/handechou`

更为简单的做法:在terminal中输入`tsc --init`，生成tsconfig文件，取消`”sourceMap": true`和`"outDir": "./out"`
的注释，`alt+shift+b` 点击`task build`，就可以正常运行了

### 基础语法

[官方文档](https://www.typescriptlang.org/docs/handbook/basic-types.html)

常用基本数据类型的使用

```ts
let isTrue: boolean = true;

let num: number = 666;
let num1: number = 0xf00d;
let num2: number = 0b1010;
let num: number = 0o744;

let ss: string = "hello hande";

let list: number[] = [11, 22, 33];
let list:Array<number> = [1, 2, 3];
list[3] = 'add'
let tuple: [string, number];
tuple = ["age", 20];
console.log(x[0].substring(1));
console.log(x[1].substring(1)); //Erro

enum Color {Red, Green, Blue} //the default value of Red is 0
let c: Color = Color.Green
console.log(c) // 1
enum Color1 {Red, Green, Blue} //we can set the default value
let c1: Color1 = Color1.Green
console.log(c1) // 2
let colorName: string = Color1[3]
console.log(colorName) // 'Blue'

let notSure: any = 666
notSure = "it can be a string"
notSure = true
notSure = [1, 2, 3]
let list: any[] = [11, true, "useful"]

let a = [11, 22, 33]; //ES6

typeof a
'object'

for (let x in a) console.log(x)

let b = {aa: 11, bb: 22}  //ES6
b.aa // 11
b['aa'] //11  

let b: object = {aa: 11, bb: 22}

```

三元运算符

判断语句 ? 为真执行 : 为假执行; 

```ts
var num:number = -2;
var result = num > 0 ? "大于 0" : "小于 0，或等于 0";
console.log(result)
```

## 类型断言

类型断言是一种告诉编译器“相信我，我知道我在做什么”的方法。类型断言就像其他语言中的类型转换一样，但是不执行任何特殊的数据检查或重组。它对运行时间没有影响，仅由编译器使用。TypeScript假定您（程序员）已经执行了所需的任何特殊检查。

类型断言有两种形式。一种是“尖括号”语法：

```ts
let ss: any = "China No.1"
let sslen: number = (<string>ss).length
```

另一个是as TYPE：

```ts
let ss: any = "China No.1"
let ssl: number = (ss as string).length
```

#### var let const

```ts
这三种声明关键字，其主要区别是作用域不同，
var定义，作用域最广，安全性最低，变量可重复定义
let 和 const 作用域相同，变量不可重复定义，但是const声明的变量值不可变，但是其引用的值可变,只读
```

```ts
const num = 9;
console.log(num)
//num = 10; //Error
const list: any = [11, "22", true]
console.log(list); //[11, "22", true]
//list = [1, 2, 3] //Error
list[0] = 99;
list[1] = 88;
console.log(list); //[99, 88, true]
```

### 数组解构

```ts
let val = [11, 22, 33];
let [num1, num2, num3] = val;
let [num4] = val;

let [, second, , fourth] = [1, 2, 3, 4];
console.log(second); // outputs 2
console.log(fourth); // outputs 4

let [a, ...bc] = val; // bc: [string, boolean]

```

```ts
// Swap variable
[num1 , num2] = [num2, num1];
```

```ts
function f([first, second]: [number, number]) {
    console.log(first);
    console.log(second);
}
f([1, 2]);
```

### 元组解构

```ts
let tuple: [number, string, boolean] = [88, "hi" , true];
let [a, b, c] = tuple;
```

```ts
let [a, ...bc] = tuple; // bc: [string, boolean]
```

### 对象解构

```ts
let obj = {
    len: 3,
    type: "Object",
    deri?: string
  };
  let { type, len, deri = "xx"} = obj;
  console.log( "type -> " + `${type}\n` + "len -> " + `${len}`);
```

### Spread

```ts
let list1 = [1, 2, 3];
let list2 = [6, 4, 8];
let list3 = [999, 0, ...list1, 456, list2];
console.log(list3);
```

## vuetify

#### 一个简单的demo

1.建一个vue项目
```bash
vue create vuetifydemo
```
自定义选项全选

2.添加插件

```bash
cd vuetifydemo
vue add vuetify
```

`vi tsconfig.json`在compilerOptions下的type中添加vuetify

3.运行

`npm run serve`


### 在vscode中调试vue

[参考文档](https://cn.vuejs.org/v2/cookbook/debugging-in-vscode.html)

1.创建vue项目

```bash
vue create debugvue
```
configure choice
```
choose
Babel
TypeScript
Router
Vuex
Linter
Unit
```

```bash
cd vuetifydemo
vue add vuetify
```

2.`vi tsconfig.json`在compilerOptions下的type中添加vuetify,下载VScode插件`Debugger for Chrome`,编辑`vue.config.js`

```js
module.exports = {
  configureWebpack: {
    devtool: 'source-map'
  }
}
```
3.在terminal中运行`npm run serve`命令启动项目，再在vscode中设置断点，开始调试
