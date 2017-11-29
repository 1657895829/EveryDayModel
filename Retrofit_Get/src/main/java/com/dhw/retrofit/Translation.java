package com.dhw.retrofit;

/**
 * 步骤2：创建 接收服务器返回数据 的实体类
 */

public class Translation {
/*    *//**
     * content : {"from":"en-EU","to":"zh-CN","out":"示例","vendor":"ciba","err_no":0}
     *//*

    @SerializedName("content")
    private ContentBean contentX;

    public ContentBean getContentX() {
        return contentX;
    }

    public void setContentX(ContentBean contentX) {
        this.contentX = contentX;
    }

    public static class ContentBean {
        *//**
         * from : en-EU
         * to : zh-CN
         * out : 示例
         * vendor : ciba
         * err_no : 0
         *//*

        private String from;
        private String to;
        private String out;
        private String vendor;
        private int err_no;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getOut() {
            return out;
        }

        public void setOut(String out) {
            this.out = out;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public int getErr_no() {
            return err_no;
        }

        public void setErr_no(int err_no) {
            this.err_no = err_no;
        }
    }*/

    /**
     * 金山词霸API 的数据格式说明如下：
         // URL模板
         http://fy.iciba.com/ajax.php

         // URL实例
         http://fy.iciba.com/ajax.php?a=fy&f=auto&t=auto&w=hello%20world

         // 参数说明：
         // a：固定值 fy
         // f：原文内容类型，日语取 ja，中文取 zh，英语取 en，韩语取 ko，德语取 de，西班牙语取 es，法语取 fr，自动则取 auto
         // t：译文内容类型，日语取 ja，中文取 zh，英语取 en，韩语取 ko，德语取 de，西班牙语取 es，法语取 fr，自动则取 auto
         // w：查询内容

        status:请求成功时为 1
        content：内容信息
            from：原文内容类型
            to：译文内容类型
            vendor：来源平台
            out：译文内容
            err_no：请求成功时 为 0
     */

    //根据 金山词霸API 的数据格式，创建 接收服务器返回数据 的类：
    private int status;
    private content content;

    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println("请求成功时状态为 "+status);

        System.out.println("原文内容类型："+content.from);
        System.out.println("译文内容类型："+content.to);
        System.out.println("来源平台："+content.vendor);
        System.out.println("译文内容："+content.out);
        System.out.println("内容请求成功时 为："+content.errNo);
    }
}
