# `MVP`思想实现项目基础框架搭建

[TOC]

## 一、整体框架

本文采用`MVP`思想实现了项目基础框架搭建，并演示了登录流程，其整体思路如下图所示：

![image](https://github.com/tianyalu/NeMvpModelLogin/raw/master/show/login_mvp_structure.png)

## 二、登录实现

### 2.1 实现效果

实现效果如下图所示：

![image](https://github.com/tianyalu/NeMvpModelLogin/raw/master/show/show.gif)

### 2.2 整体思路

代码层面的结构如下图所示：

![image](https://github.com/tianyalu/NeMvpModelLogin/raw/master/show/show.png)

### 2.3 内存泄漏

`Presenter`层使用了`Activity`弱引用，当用户退出`Activity`之后即使后台有在做长时间的耗时操作，也只是在`Presenter`层，`Activity`在`gc`后会被销毁，避免了内存泄漏。



