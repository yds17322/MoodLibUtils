# MoodLibUtils
自己用的一个module，逐步完善，表示是第一个做module，目前写了一个简单的OkHttp的代码简易封装

目前只是基于OkHttp做了一个简单的封装，只支持get/post的简单请求



欢迎讨论可给我发邮件～ 一起完善加入更多的内容。

yds17322@hotmail.com

## POST
```java
HttpUtils.post().url("http://192.168.1.111/login")
        .addParams("name", "1800000000")//
        .addParams("pwd", "123456")//
        .build()//
        .execute(new HttpUtilsCallback() {
            @Override
            public void success(String response) {
                Log.d("yds", "response ---> " + response);
                btn1.setText("post_success");
            }
            
            @Override
            public void error(String e) {
                Log.d("yds", "error ---> " + e);
                btn1.setText("post_error");
            }
        });
  ```
## GET
```java
HttpUtils.get().url("https://www.baidu.com/s?wd=a")
        .build()
        .execute(new HttpUtilsCallback() {
             @Override
            public void success(String response) {
                Log.d("yds", "response ---> " + response);
                btn2.setText("get_success");
            }
            
            @Override
            public void error(String e) {
                Log.d("yds", "error ---> " + e);
                btn2.setText("get_error");
            }
        });
```

### 目前就写了这两个，逐渐增加吧，望大家勇于批评。
 
  
