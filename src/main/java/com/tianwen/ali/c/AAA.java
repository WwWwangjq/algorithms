package com.tianwen.ali.c;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月24日  21:02
 */
public class AAA {
/*
    题目1
    为了保护客户信息，我们会对客户的登录号进行脱敏处理再进行展示，登录号有邮箱、手机号两
    种格式，未来有可能新增新的格式。邮箱的脱敏规则：@前面的字符显示3位，3位后显示3个*
            ，@后面完整显示，如：con***@163.com，如果少于三位，则全部显示，@前加**，例如tt@163
            .com则显示为tt**@163.com；手机号的脱敏规则：中国大陆号码显示前 3 位 + **** + 后 4
    位，如：137****9050；

    代码模板:*/

    /**
     * 登录号脱敏处理
     *  contianwen@163.com -> con***@163.com
     *  tt@163.com -> tt**@163.com
     *  137****9050
     */

    public static void main(String[] args) {
//        String loginId = " contianwen@163.com";
//        String loginId = " tt@163.com";
        String loginId = " 8613713519050 ";
        System.out.println(desensitize(loginId));
    }

    private final static String separator = "@";

    public static String desensitize(String loginId){
        if (Objects.isNull(loginId)){
            return "";
        }
        loginId = loginId.trim();
        // 识别输入格式
        boolean isEmail = loginId.contains(separator);
        // 进行脱敏处理
        return isEmail ? desensitizeEmail(loginId) : desensitizePhone(loginId);
    }

    private static String desensitizeEmail(String email) {
        int index = email.indexOf(separator);
        String prefix = email.substring(0, index);
        String suffix = email.substring(index);
        prefix = prefix.length() < 3 ? prefix + "**" : prefix.substring(0, 3) + "***";
        return prefix + suffix;
    }

    private static String desensitizePhone(String phone) {
        if (phone.startsWith("+86")) {
            phone = phone.substring(3, 14);
        } else if (phone.startsWith("86")) {
            phone = phone.substring(2, 13);
        }
        if (phone.length() < 11) {
            return "";
        }
        String prefix = phone.substring(0, 3);
        String suffix = phone.substring(7, 11);
        return prefix + "****" + suffix;
    }
}
