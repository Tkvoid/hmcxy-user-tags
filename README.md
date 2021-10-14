# hmcxy-user-tags

项目名称：企业级360度用户画像项目

来源：B站黑马程序员-大数据实战

视频地址: https://www.bilibili.com/video/BV1Mp4y1x7y7?from=search&amp;seid=8776407805922729018&amp;spm_id_from=333.337.0.0

# 可能报错

1. maven中出现Cannot resolve org.codehaus.groovy:groovy-all:2.4.4

首先确认repository中repository\org\codehaus\groovy\groovy-all下已经存在2.4.4版本，其次打开repository\org\apache\hive\hive-exec\hive-exec-1.1.0-cdh5.14.0.pom
修改groovy-all的依赖为
```
<dependency>
      <groupId>org.codehaus.groovy</groupId>
      <artifactId>groovy-all</artifactId>
      <version>2.4.4</version>
      <scope>compile</scope>
      <type>POM</type>
</dependency>
```
