package com.dhw.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

//把接口返回的数据bean中的实体数据类抽取另建1个类，构建为表结构
@Entity
public class NewslistBean {
        /**
         * ctime : 2017-11-30
         * title : 小鱼儿读错Jasper、max的名字，Jasper暖心可爱高情商
         * description : 娱乐八卦新鲜事
         * picUrl : https://zxpic.gtimg.com/infonew/0/wechat_pics_-16485301.static/640
         * url : https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512050417&signature=QTm5xfVEEuhJV664kh8Zjt7kXoc6jKYIKnALQ5csOoRwfxlxFKKcI4HU*uJNHuxBbS26L-BoXtW4FEn-0qQP7Csx-L2r1Nv8S-zZS9XAZYE=
         */

        @Id(autoincrement = true)
        private Long id;
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        @Generated(hash = 1402622097)
        public NewslistBean(Long id, String ctime, String title, String description, String picUrl, String url) {
            this.id = id;
            this.ctime = ctime;
            this.title = title;
            this.description = description;
            this.picUrl = picUrl;
            this.url = url;
        }

        @Generated(hash = 923354944)
        public NewslistBean() {
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Long getId() {
            return this.id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    @Override
    public String toString() {
        return "NewslistBean{" +
                "id=" + id +
                ", ctime='" + ctime + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
