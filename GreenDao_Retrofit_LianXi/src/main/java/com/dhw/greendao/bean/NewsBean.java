package com.dhw.greendao.bean;

import java.util.List;

/**
 * 接口返回的数据
 */
public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-11-30","title":"悦读｜鸿雁在云鱼在水","description":"万事如易","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-13002774.static/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043213&signature=-tV5Y52NMP4vYxJpmFjcYWXVXrWaMp5pmWFwcnPm73QOBr15RPiSCptMXeVsPSeMgKw5v*viQFmA5tVKwERV37DroVOzE0uuZymdYiIOVJg="},{"ctime":"2017-11-30","title":"善付嘱丨梦参老和尚：念念之间 都是修行","description":"腾讯佛学","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-28269253.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043213&signature=Y1*KwOmXnvH**8*VJn3eml2-QJmKEuYCmddFRQM7Pggse3JVzjfylgnfYALiLxQEum0RvekeL6ffaYm8mKXys7Z3ADKSPkKm3igANW36jyA="},{"ctime":"2017-11-30","title":"品读诗经 │ 胡洁：如何做到事业家庭两不误？\u2014\u2014《诗经·大雅·文王之什》里的幸福密码","description":"深圳图书馆","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60574741.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043212&signature=t-zqUM8r-zRpp3qO1XV*11aZN2hUS2tcAQ1pT5tDxyf0bPA48MGoNGbzd35HhZB*gN03oX397*fWuKs*F6uVxeseVcACPrCz0lIaq5aRlt8="},{"ctime":"2017-11-30","title":"一只猪、一只绵羊和一头乳牛，被关在一起，还有一位医生，这两个故事火了！","description":"企业管理","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60576195.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043212&signature=zg8nobsRWJUN2hw92IhXq1nhmSdQLVX3Crpis8EZoQHF6uLEigG5bvXnkeMaIeNk6ORD5TVoI2epQXub2t6dzDLbBii6qtojHLsxsBlj4nU="},{"ctime":"2017-11-30","title":"【岁月如歌】 舒生：《秋声小集》","description":"诗评万象","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60576711.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043212&signature=iGAD6VoYeZpvw*8170PuFQ7BNBmeQr7pTJy4gOEJNGhxdwlz4rlYw*cnwVZZh1y2pu8nCFbwi8Br9zrdRl75a7WHMwQLGgA8bd6thy*FAng="},{"ctime":"2017-11-30","title":"花、鸟、诗词间的碰撞，竟如此惊艳！","description":"云上文化","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60576338.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043211&signature=2ik9A1LvDHKMC5QWYZm6LejkwckGeMhvLdvZ6tAC81UkyYnMr0MQ0ky4NuvWJxKDK*l17qGXL9rQ8U1YS8dTGp7AuLEIe2lbsN4WMhCOmKw="},{"ctime":"2017-11-30","title":"妙笔写心\u2022陈少珊师生工笔花鸟作品展12月1日15:30在珠江美术馆开幕","description":"020艺术观察","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60550936.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043211&signature=oSftEf0KMLJubE6l6W1NNIQFCgtUyGS6Z*nmSZth7B33J8zbUOcFnL7qETTpmFXKGzTFXfDmAIoYfzsiSB0FN-wcEYPs3HX8S*EuHBeF570="},{"ctime":"2017-11-30","title":"瞧这一家子，出了这么多书法家，留下这么多书法珍宝","description":"云上文化","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60576728.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043211&signature=Dg1L53XgNxHhnIyfl89xO34qj3HX1oan1-FeF3rAzOWrcOv8E4CBZcpMDp3N71DH1BvkjNgdWsuhIgcvxlvDqLkPe6Nst6QAcKoxCly5bBE="},{"ctime":"2017-11-30","title":"【朗诵】与风景同醉","description":"遇见散文诗歌","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60551745.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043211&signature=lS2JYWC-6SPWs9gNisR7grBy0karUAxg25h-lYBHIX4qx7oDCpgOHM1i6FMl1xZjb8l1t5rUxfocWqX2cRy-mtZYJ9w7OE4kfT7jKXM0F2U="},{"ctime":"2017-11-30","title":"蜜蜡赌石开料，惊险刺激，背后的故事数不胜数，心惊肉跳的感觉，你要不要感受一下！！哈哈，来吧，亲们~","description":"金刚菩提子大课堂","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-60550331.jpg/640","url":"https://mp.weixin.qq.com/s?src=16&ver=520&timestamp=1512043210&signature=3xERtK9hD6NheT*QnIrEL65slmALfSNAWHtKAbF2dl1q5VeV6JPeamHhNjLsNxa4xSR-ceXq3FDSatY-ua7HC5oL9QeR*mR91iwtIYpw0Rg="}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

}
