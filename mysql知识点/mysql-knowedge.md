# 一.mysql的执行顺序

```sql
select     5
	...
from       1
	...
where      2
	...
group by   3
	...
having     4
	...
order by   6
	..
```

# 二.sql基本语法

## 1.创建数据库

```sql
create database '库名';
use '库名'
```

## 2. 创建表

```sql
create table t_table(
    id int not null primary key auto_increment,
    name varchar(10) not null,
    sex boolean,
    age int
);
```

## 3. 修改表

1. 添加列

   ```sql
   alter table 't_table' add col char(20);
   ```

2. 删除列

   ```sql
   alter table 't_table' drop col;
   ```

3. 删除表

   ```sql
   drop table if exists 't_talbe';
   ```

## 5. 插入数据

1. 普通插入

   ```sql
   insert into 't_table' (col1, col2) values(v1,v2);
   ```

2. 插入搜索出来的数据

   ```sql
   insert into 't_table' (col1, col2) select col1, col2 from 'other_table'
   ```

3. 将一个表的内容插入到另一个表

   ```sql
   create table 'new_table' as select * from 'old_table'
   ```

## 6. 修改数据

```sql
update 't_table' set col = v1, col2 = v2 where id = 1;
```

## 7. 删除数据

### delete

```sql
delete from t_table where id = 2;
```

### truncate 清空整个表，但保留表结构

```sql
truncate table t_table
```

## 8. 查询

### distinct 去重关键字

```sql
select distinct col1, col2 from t_table;
```

### limit m, n 分页查询

```sql
# limit m, n 表示从m开始(起始为0),返回n行记录
#返回前五行
select * from t_table limit 5;
# 返回3-5行
select * from t_table limit 2, 3
```

## 9.排序

* asc ：升序（default)
* desc: 降序

```sql
select * from t_table order by col1 asc, col2 desc;
```

## 10.过滤

1. is null 判断一个字段的值是否为空

   ```sql
   select * from t_table where col1 is null;
   select * from t_table where col1 is not null;
   ```

## 11. 计算字段 

1. concat()函数的使用

   ```sql
   select concat('拼接', '  (  ', '  )', col1) from t_table;
   ```

## 12.函数

### 1.汇总函数

|  函数   |            解释            |
| :-----: | :------------------------: |
|  avg()  | 返回某列的平均值(忽略Null) |
| count() |       返回某列的行数       |
|  max()  |      返回某列的最大值      |
|  min()  |      返回某列的最小值      |
|  sum()  |       返回某列值之和       |

### 2. 文本处理函数

|     函数      |      解释      |
| :-----------: | :------------: |
| left(col, 2)  |   左边的字符   |
| right(col, 2) |   右边的字符   |
|  lower(col)   |  转为小写字符  |
|  upper(col)   |  转换大写字符  |
|  ltrim(col)   | 去除左边的空格 |
|  rtrim(col)   | 去除右边的空格 |
|  length(col)  | 返回字段的长度 |
| soundex(col)  |   转为语音值   |

### 3. 日期时间处理函数 

|        adddate()        |    增加一个日期    |
| :---------------------: | :----------------: |
|        addtime()        |    增加一个时间    |
|        curdate()        |    返回当前日期    |
|        curtime()        |    返回当前时间    |
|         date()          | 返回日期的时间部分 |
|       datediff()        |  计算两个日期之差  |
| date_add()  同adddate() |      操作日期      |
|      data_format()      |     日期格式化     |

### 4. 流程函数

1. if(value, t, f)   如果 value为true ，则返回 t , 否则返回 f
2. ifnull(v1, v2)  如果 v1不为空,则返回v1,否则返回v2

## 13.分组

```sql
select * from t_table group by col1, col2...... having ...;
```



# 三.数据库系统原理

## 1. 事务

所谓事务：就是满足**ACID**特性的一组操作，可以通过 **commit命令**提交一个事务，也可通过**rollback命令**回滚一个事务。

### 事务的 4 个特性

#### 1. 原子性(Atomicity)

事务是一组命令的执行，这些命令要么全部成功，要么全部失败。在对事务回滚时，可以使用回滚日志(Undo Log)，回滚日志记录了事务所执行的所有修改操作，输入回滚命令时会反向执行这些命令。

#### 2. 一致性(Consistency)

数据库在事务执行前后都保持一致性状态。在一致性状态下，所有事务对同一个数据的读取结果老师相同的。

#### 3. 隔离性(Isolation)

一个事务所做的修改在最终提交以前，对其他事务是不可见的。

#### 4. 持久性(Durability)

一旦事务提交，则其所做的修改将会永远保存到数据库中。即使系统发生崩溃，事务执行的结果也不能丢失。系统发生崩溃可以用重做日志(Redo Log) 进行恢复，从而实现持久性。

## 2.并发一致性问题



# 四.mysql条件、循环等结构

## if结构 

```sql
if 条件  then
	...
elseif 条件  then

else
	...
end if;
```

## 存储过程

```sql
create procedure 存储过程名字([in/out/inout 参数名 参数类型])
begin
	...
end;


SELECT * FROM INFORMATION_SCHEMA.ROUTINES WHERE ROUTINE_SCHEMA = 'xxx'; -- 查询指
定数据库的存储过程及状态信息
SHOW CREATE PROCEDURE 存储过程名称 ; -- 查询某个存储过程的定义
```

## 变量

变量分为：**系统变量、用户变量、局部变量**

### 系统变量

```sql
# 查看系统变量
show [session|global] variables;  # 查看所有系统变量
show [session|global] variables like '..'  # 模糊匹配查询
select @@[session|global].系统变量名;    # 查看指定的变量的值

# 设置系统变量(如果没有指定session, global 则默认是 session)
set [session | global] 系统变量名 = 值;
set @@[session | global]系统变量名 = 值;
```

### 用户变量

1. 赋值

   ```sql
   set @var_name = 值
   set @var_name := 值
   
   select @var_name := expr;
   select 字段名 into @var_name from 表名;
   ```

2. 查看

   ```sql
   select @var_name;
   ```

### 局部变量

1. 声明

   ```sql
   declare 变量名 变量类型 [default  ...];
   ```

2. 赋值

   ```sql
   set 变量名 = 值;
   set 变量名 := 值;
   select 字段名 into 变量名 from 表名;
   ```

## case when

```sql
# 语法1:  当val 和 when 后面的值相同时 执行 后面的语句
case val
	when v1 then statement
	when v2 then statement
	[else statement]
end case;

# 语法2: 当when后面的条件为true时，执行后面的语句
case 
	when condition1 then statement
	...
	[else statement]
end case;
```



## while循环

```sql
while 条件 do
	sql。。。
end while;
```

## repeat循环

```sql
repeat 
	sql...
	until 条件
end repeat;
```



## loop循环

```sql
[label名称:] loop
	sql...
end loop [lable名称]

leave label名称 #退出循环
iterate label名称 #进入下次循环
```



## 存储函数

```sql
create function 函数名(参数...)
returns type [characteristic...]
begin
	sql语句
	return ...;
end;


/*
characteristic 取值:
	deterministic: 相同的输入参数总是产生相同的结果
	no sql:			不包含sql 语句
	reads sql data:  包含读取数据的语句，但不包含写入数据的语句
*/

```

## 游标

游标是用来存储查询结果集的数据类型，在存储过程和函数中可以使用游标对结果集进行循环的处理。

使用方法如下 ：

1. 声明游标

   ```sql
   declare 游标名称 cursor for 查询语句;
   ```

2. 打开游标

   ```sql
   open 游标名称;
   ```

3. 获取游标记录

   ```sql
   fetch 游标名称 into 变量[...变量];
   ```

4. 关闭游标

   ```sql
   close 游标名称;
   ```

## 条件处理程序

条件处理程序(Handler)可以用来定义在流程控制结构执行过程中遇到问题时相应的处理步骤。

使用语法如下：

```sql
declare handler_action handler for condition_value [...condition_value] statement

handler_action的取值:
	continue:   继续执行当前程序
	exit:        退出程序
condition_value的取值:
	sqlstate sqlstate_value: 状态码
	
	sqlwarning:  所有以01开头的sqlstate代码的简写
	not found:   所有以02开头的sqlstate代码的简写
	sqlexception:除了sqlwarning和not found 之外的
```

## 触发器

```sql
create trigger 触发器名字 before/after insert/update/delete  on 表名 for each row --等级触发器
begin
	sql...
end;

show triggers;
drop trigger trigger_name;
```

| 关键字 |               描述               |
| :----: | :------------------------------: |
|  old   | 表示update、delete之前的记录对象 |
|  new   |     表示 insert后的记录对象      |





