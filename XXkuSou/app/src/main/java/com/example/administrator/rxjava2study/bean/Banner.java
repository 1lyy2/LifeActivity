package com.example.administrator.rxjava2study.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */

public class Banner {

    /**
     * date : 20180307
     * stories : [{"images":["https://pic3.zhimg.com/v2-4bc38ac4fe79d7a8c4fcd5b7d80144ca.jpg"],"type":0,"id":9672452,"ga_prefix":"030709","title":"蜘蛛结一张网，至少要逮到多少昆虫才不算亏？"},{"images":["https://pic1.zhimg.com/v2-0877cf4185c455dcbde18cbb74eb3a2c.jpg"],"type":0,"id":9672489,"ga_prefix":"030708","title":"堵截千亿拼多多，阿里与腾讯的电商新战役"},{"images":["https://pic3.zhimg.com/v2-92aaf2a6db2e5468e5f87a3498765a8a.jpg"],"type":0,"id":9672468,"ga_prefix":"030707","title":"人只有在抑郁的时候，才愿意思考"},{"images":["https://pic3.zhimg.com/v2-4456e05d12101a2e0ed64875ad4d9c42.jpg"],"type":0,"id":9672584,"ga_prefix":"030707","title":"爱奇艺的 IPO，与视频网站的囚徒困境"},{"images":["https://pic3.zhimg.com/v2-66c1ea5864658fd85d5baa9c9a636602.jpg"],"type":0,"id":9672415,"ga_prefix":"030707","title":"看完《唐人街探案 2》，说说什么是「压抑」情绪的本质"},{"images":["https://pic4.zhimg.com/v2-7d6bfbd725a86f84384442293d82d9db.jpg"],"type":0,"id":9672425,"ga_prefix":"030706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-f87e5e003d49f8ea18c52c5abe24b578.jpg","type":0,"id":9672452,"ga_prefix":"030709","title":"蜘蛛结一张网，至少要逮到多少昆虫才不算亏？"},{"image":"https://pic1.zhimg.com/v2-65d195df93ff7a094b6052c40621d348.jpg","type":0,"id":9672468,"ga_prefix":"030707","title":"人只有在抑郁的时候，才愿意思考"},{"image":"https://pic3.zhimg.com/v2-f3ffd1b65bca8e79dfbb5c0fa67d6956.jpg","type":0,"id":9672415,"ga_prefix":"030707","title":"看完《唐人街探案 2》，说说什么是「压抑」情绪的本质"},{"image":"https://pic3.zhimg.com/v2-ea13c5c41fba8d6e90b4d51df15c9696.jpg","type":0,"id":9672398,"ga_prefix":"030619","title":"总清醒着做梦，我这是《盗梦空间》看多了？"},{"image":"https://pic3.zhimg.com/v2-a2f69319aafd1bb4fa1c15fba2a03366.jpg","type":0,"id":9672584,"ga_prefix":"030707","title":"爱奇艺的 IPO，与视频网站的囚徒困境"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic3.zhimg.com/v2-4bc38ac4fe79d7a8c4fcd5b7d80144ca.jpg"]
         * type : 0
         * id : 9672452
         * ga_prefix : 030709
         * title : 蜘蛛结一张网，至少要逮到多少昆虫才不算亏？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-f87e5e003d49f8ea18c52c5abe24b578.jpg
         * type : 0
         * id : 9672452
         * ga_prefix : 030709
         * title : 蜘蛛结一张网，至少要逮到多少昆虫才不算亏？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
