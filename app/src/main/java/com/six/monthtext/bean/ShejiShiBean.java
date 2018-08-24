package com.six.monthtext.bean;

import java.util.List;

public class ShejiShiBean {

    /**
     * code : 1
     * data : {"display":[{"uid":"100180","ordered":"0","space":"售楼处/家居别墅/样板间","bill":"0","evaluate":"0","nick_name":"刘卫军","avatar":"https://app.tuozhe8.com/uploads/avatar/091286e480d0ace52f3e965c462f0061100180.jpeg","address":"广东","charge":"价格面议","Stringro":"主张以情感美学创造艺术空间，其美学取向分为人本取向与文本取向两种"},{"uid":"100179","ordered":"1","space":"售楼处/样板间/家居别墅","bill":"0","evaluate":"0","nick_name":"韩松","avatar":"https://app.tuozhe8.com/uploads/avatar/cd0056fe4616508551f2cd38ca2294b3100179.jpeg","address":"广东","charge":"收费面议","Stringro":"致力于在传统美学智慧中挖掘现代性的可持续价值，冀望以物质空间为载体的全新生活体验的实现，来改变以往生活的习惯和认知，以寻求体悟生命真实的喜悦和智慧。"},{"uid":"100103","ordered":"11","space":"商业空间/酒店/办公空间","bill":"5","evaluate":"0","nick_name":"黄全","avatar":"https://app.tuozhe8.com/uploads/avatar/04e7ded9788efaaa5936f5eb994bb7b5100103.jpeg","address":"上海","charge":"收费面议","Stringro":"直面市场，设计不止是自我表达"},{"uid":"100181","ordered":"2","space":"售楼处/家居别墅/样板间","bill":"0","evaluate":"0","nick_name":"鬼手帕","avatar":"https://app.tuozhe8.com/uploads/avatar/8350263b013a428ad83118e16c68fb92100181.jpeg","address":"福建","charge":"收费面议","Stringro":"走个性化设计需要更耐心地与业主磨合"},{"uid":"101012","ordered":"0","space":"","bill":"0","evaluate":"0","nick_name":"得间老李","avatar":"https://app.tuozhe8.com/uploads/avatar/e521e0ac87aa0eac02f108fdb9993c13101012.jpeg","address":"湖北","charge":"收费面议","Stringro":"武汉得间设计创始人"},{"uid":"100193","ordered":"0","space":"售楼处/家居别墅/样板间","bill":"0","evaluate":"0","nick_name":"周晓安","avatar":"https://app.tuozhe8.com/uploads/avatar/1873cc4e37d2bde47df1ac93f87629cf100193.jpeg","address":"江苏","charge":"收费面议","Stringro":""},{"uid":"100196","ordered":"0","space":"售楼处/家居别墅/样板间","bill":"0","evaluate":"0","nick_name":"叶永志","avatar":"https://app.tuozhe8.com/uploads/avatar/c55301f590ac438267dd81c726d6d3a8100196.jpeg","address":"浙江","charge":"100 ~ 500元","Stringro":"今天的荣誉就是明天的起跑线，会一直坚持做好设计。"},{"uid":"101008","ordered":"0","space":"售楼处/家居别墅/样板间","bill":"0","evaluate":"0","nick_name":"之境内建筑廖志强","avatar":"https://app.tuozhe8.com/uploads/avatar/61135da0aa8df4e71d71b139b667a345101008.jpeg","address":"四川","charge":"100 ~ 500元","Stringro":""},{"uid":"101009","ordered":"0","space":"","bill":"3","evaluate":"0","nick_name":"周传龙","avatar":"https://app.tuozhe8.com/uploads/avatar/cddcbf6117bfe4a3ad57db4c3e8856e9101009.jpeg","address":"山东","charge":"100 ~ 500元","Stringro":"让设计赞美生活"},{"uid":"101267","ordered":"0","space":"","bill":"0","evaluate":"0","nick_name":"陈熠","avatar":"https://app.tuozhe8.com/uploads/avatar/b780ad70687dabe09f200d21b754d23f101267.jpeg","address":"江苏","charge":"收费面议","Stringro":""}]}
     * message : success
     */

    private String code;
    private DataBean data;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private List<DisplayBean> display;

        public List<DisplayBean> getDisplay() {
            return display;
        }

        public void setDisplay(List<DisplayBean> display) {
            this.display = display;
        }

        public static class DisplayBean {
            /**
             * uid : 100180
             * ordered : 0
             * space : 售楼处/家居别墅/样板间
             * bill : 0
             * evaluate : 0
             * nick_name : 刘卫军
             * avatar : https://app.tuozhe8.com/uploads/avatar/091286e480d0ace52f3e965c462f0061100180.jpeg
             * address : 广东
             * charge : 价格面议
             * Stringro : 主张以情感美学创造艺术空间，其美学取向分为人本取向与文本取向两种
             */

            private String uid;
            private String ordered;
            private String space;
            private String bill;
            private String evaluate;
            private String nick_name;
            private String avatar;
            private String address;
            private String charge;
            private String Stringro;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getOrdered() {
                return ordered;
            }

            public void setOrdered(String ordered) {
                this.ordered = ordered;
            }

            public String getSpace() {
                return space;
            }

            public void setSpace(String space) {
                this.space = space;
            }

            public String getBill() {
                return bill;
            }

            public void setBill(String bill) {
                this.bill = bill;
            }

            public String getEvaluate() {
                return evaluate;
            }

            public void setEvaluate(String evaluate) {
                this.evaluate = evaluate;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCharge() {
                return charge;
            }

            public void setCharge(String charge) {
                this.charge = charge;
            }

            public String getStringro() {
                return Stringro;
            }

            public void setStringro(String Stringro) {
                this.Stringro = Stringro;
            }
        }
    }
}
