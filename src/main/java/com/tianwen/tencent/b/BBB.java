package com.tianwen.tencent.b;

/**
 * wangjq
 * 2021年05月20日  20:10
 */
public class BBB {
/*
    1.	一张座位表，包括两列，一列座位编号（自增ID键），一列学生姓名，表数据如下：
    ID	Seat
    1	桃子
    2	苹果
    3	梨子
    4	番茄
    5	李子

            写条SQL查询结果为相邻编号的座位的同学互换
    ID	Seat
    1	苹果
    2	桃子
    3	番茄
    4	梨子
    5	李子

    select
    t1.id, if(t1.id % 2 = 0,t2.seat,t1.seat)
    from
    table t1 join table t2 on t1.id = t2.id - 1
    join table t3 on t1.id + 1 = t2.id;
    ;

    select
    t1.id, if(t1.id % 2 = 0,(select t2.seat from table t2 where t2.id - 1),(select t3.seat from table t3 where t3.id + 1))
    from
    table t1

    */
}
