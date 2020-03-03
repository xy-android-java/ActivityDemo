# 说明
主要敲一下小demo
## 1. activity的生命周期，lifecycle
1. 四种状态
- 运行状态，可见可执行
- 暂停状态，可见不可执行
- 停止状态，不可见不可执行
- 销毁状态，APP已经finish了
2. 七个方法
- onCreate()
- onStart()
- onResume()
- onPause()，可见，但是不可执行，比如被对话框式activity覆盖
- onStop()，不可见，不可执行，被其他activity覆盖
- onDestroy()，调用finish()或者其他退出操作
- onRestart()，没进入销毁状态，activity A被activity B覆盖，B退出后，A就进入restart->start
## 2. activity传递数据
### 1. 传递数据
activity A <-> activity B
1. A->B，使用intent,putXXX,startActivity(intent)，B使用getIntent()取出intent
2. A<->B，A使用startActivityForResult(intent,resultCode)，B使用setResult(id,intent)，
A中复写方法onActivityResult，判断resultCode。
### 2. 恢复数据
activity A没有进入onDestroy，但是因为系统资源不够，回收了A，A中还有临时数据
1. A中重写onSaveInstanceState(Bundle outstate)，保存key - value
2. A中的onCreate方法判断Bundle是不是空，不是就取key - value出来

## 3. activity的启动模式
四种模式，目标是不是要创建新的activity
### standard
标准模式，默认的，都是一直创建新的activity实例，即使back stack中存在有实例
### singleTop
如果activity处于栈顶，就不创建，否则就创建
### singleTask
从栈顶开始查找，把在该activity上的activity出栈，到栈底了发现没有，就创建新的实例
### singleInstance
使用该模式创建的，会开辟一个新的back stack