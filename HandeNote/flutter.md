# Flutter

[官方文档](https://flutter.dev/docs/get-started/install)

## 安装flutter

有两种方式：

1.下载`.zip`包

[zip包下载地址](https://storage.googleapis.com/flutter_infra/releases/stable/macos/flutter_macos_v1.12.13+hotfix.5-stable.zip)

```bash
cd ~/development
unzip ~/Downloads/flutter_macos_v1.12.13+hotfix.5-stable.zip
```

2.从`Github`上克隆

```bash
cd ~/development
git clone https://github.com/flutter/flutter.git
```

3.请编辑`$HOME/.bash_profile`或`$HOME/.bashrc`。macOS Catalina默认情况下使用`Z shell`，因此请进行编辑`$HOME/.zshrc`。如果使用其他`Shell`，则计算机上的文件路径和文件名将不同。添加以下内容：

` export PATH="$PATH:$HOME/development/flutter/bin"`

4.运行`source $HOME/.<rc file>`，应用刚刚添加的配置


### Tips:

```
flutter现阶段的对于web端的支持仅在beta版中，尚未发布稳定版,因此web开发需要切换到beta版
```

```bash
flutter channel beta
flutter upgrade
flutter config --enable-web
```

## 创建一个简单的flutter应用

```bash
flutter create myapp
cd myapp
flutter run -d chrome
```

打包

```bash
flutter build web
```

自己写一个简单的登陆界面向后端发请求时，发现自带的`HttpClient`并不好用，发现有一个更好用的替代品 ---`dio`,这是Flutter中文网开源的一个强大的Dart Http请求库，支持**Restful API**、**FormData**、**拦截器**、**请求取消**、**Cookie管理**、**文件上传/下载**、**超时**等，[github仓库地址](https://github.com/flutterchina/dio/blob/master/README-ZH.md)


