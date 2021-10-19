# hmcxy-user-tags

项目名称：企业级360度用户画像项目

来源：B站黑马程序员-大数据实战

视频地址: https://www.bilibili.com/video/BV1Mp4y1x7y7?from=search&amp;seid=8776407805922729018&amp;spm_id_from=333.337.0.0

# 部分导入指令

## MySQL数据库中表的数据导入到Hive表(使用SQOOP)

1. Hive中创建数据库Database;

```
CREATE DATABASE tags_dat;
```

2. 创建数据表

用户信息表： tbl_users
```
/export/servers/sqoop/bin/sqoop create-hive-table \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--table tbl_users \
--username root \
--password 123456 \
--hive-table tags_dat.tbl_users \
--fields-terminated-by '\t' \
--lines-terminated-by '\n'
```

订单数据表： tbl_orders
```
/export/servers/sqoop/bin/sqoop create-hive-table \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--table tbl_orders \
--username root \
--password 123456 \
--hive-table tags_dat.tbl_orders \
--fields-terminated-by '\t' \
--lines-terminated-by '\n'
```

商品表： tbl_goods
```
/export/servers/sqoop/bin/sqoop create-hive-table \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--table tbl_goods \
--username root \
--password 123456 \
--hive-table tags_dat.tbl_goods \
--fields-terminated-by '\t' \
--lines-terminated-by '\n'
```

行为日志表： tbl_logs
```
/export/servers/sqoop/bin/sqoop create-hive-table \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--table tbl_logs \
--username root \
--password 123456 \
--hive-table tags_dat.tbl_logs \
--fields-terminated-by '\t' \
--lines-terminated-by '\n'
```

3. 导入数据至Hive表

用户信息表： tbl_users
```
/export/servers/sqoop/bin/sqoop import \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--username root \
--password 123456 \
--table tbl_users \
--direct \
--hive-overwrite \
--delete-target-dir \
--fields-terminated-by '\t' \
--lines-terminated-by '\n' \
--hive-table tags_dat.tbl_users \
--hive-import \
--num-mappers 1
```

订单数据表： tbl_orders
```
/export/servers/sqoop/bin/sqoop import \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--username root \
--password 123456 \
--table tbl_orders \
--direct \
--hive-overwrite \
--delete-target-dir \
--fields-terminated-by '\t' \
--lines-terminated-by '\n' \
--hive-table tags_dat.tbl_orders \
--hive-import \
--num-mappers 10
```

商品表： tbl_goods
```
/export/servers/sqoop/bin/sqoop import \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--username root \
--password 123456 \
--table tbl_goods \
--direct \
--hive-overwrite \
--delete-target-dir \
--fields-terminated-by '\t' \
--lines-terminated-by '\n' \
--hive-table tags_dat.tbl_goods \
--hive-import \
--num-mappers 5
```

行为日志表： tbl_logs
```
/export/servers/sqoop/bin/sqoop import \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--username root \
--password 123456 \
--table tbl_logs \
--direct \
--hive-overwrite \
--delete-target-dir \
--fields-terminated-by '\t' \
--lines-terminated-by '\n' \
--hive-table tags_dat.tbl_logs \
--hive-import \
--num-mappers 20
```

## MySQL数据库中数据导入HBase数据库(使用SQOOP)

用户信息表： tbl_users
```
/export/servers/sqoop/bin/sqoop import \
-D sqoop.hbase.add.row.key=true \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--username root \
--password 123456 \
--table tbl_users \
--hbase-create-table \
--hbase-table tbl_users \
--column-family detail \
--hbase-row-key id \
--num-mappers 2
```

订单数据表： tbl_orders
```
/export/servers/sqoop/bin/sqoop import \
-D sqoop.hbase.add.row.key=true \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--username root \
--password 123456 \
--table tbl_orders \
--hbase-create-table \
--hbase-table tbl_orders \
--column-family detail \
--hbase-row-key id \
--num-mappers 10
```

商品表： tbl_goods
```
/export/servers/sqoop/bin/sqoop import \
-D sqoop.hbase.add.row.key=true \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--username root \
--password 123456 \
--table tbl_goods \
--hbase-create-table \
--hbase-table tbl_goods \
--column-family detail \
--hbase-row-key id \
--num-mappers 5
```

行为日志表： tbl_logs
```
/export/servers/sqoop/bin/sqoop import \
-D sqoop.hbase.add.row.key=true \
--connect jdbc:mysql://bigdata-cdh01.itcast.cn:3306/tags_dat \
--username root \
--password 123456 \
--table tbl_logs \
--hbase-create-table \
--hbase-table tbl_logs \
--column-family detail \
--hbase-row-key id \
--num-mappers 20
```


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

2. Hbase出现ERROR: Can't get master address from ZooKeeper; znode data == null

由于采用的是虚拟机经常有状态挂起，导致zookeeper或者hbase不稳定，因此，重启下Hbase就能解决。
```
/export/servers/hadoop/sbin/stop-hbase.sh
/export/servers/hadoop/sbin/start-hbase.sh
```
