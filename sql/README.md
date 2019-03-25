# 导入说明

数据库名：`ishop` ,可以自己在SQL文件中修改。

字符集：`utf8mb4`



常见问题：

导入数据超时,导致连接断开。

```mysql
Error occured at:2019-03-25 09:50:41
Line no.:7520
Error Code: 2006 - MySQL server has gone away
```

解决

把最大时间调大一点即可。

```mysql
SHOW GLOBAL VARIABLES LIKE 'max_allowed_packet';
SET GLOBAL max_allowed_packet=1024*1024*16;
```







