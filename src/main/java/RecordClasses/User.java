package RecordClasses;

public class User {
    String url;
    UserVotes votes;
    Integer review_count;
    String type;
    String user_id;
    String name;
    Double average_stars;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserVotes getVotes() {
        return votes;
    }

    public void setVotes(UserVotes votes) {
        this.votes = votes;
    }

    public Integer getReview_count() {
        return review_count;
    }

    public void setReview_count(Integer review_count) {
        this.review_count = review_count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAverage_stars() {
        return average_stars;
    }

    public void setAverage_stars(Double average_stars) {
        this.average_stars = average_stars;
    }

    public class UserVotes {
        Integer funny;
        Integer useful;
        Integer cool;

        public Integer getFunny() {
            return funny;
        }

        public void setFunny(Integer funny) {
            this.funny = funny;
        }

        public Integer getUseful() {
            return useful;
        }

        public void setUseful(Integer useful) {
            this.useful = useful;
        }

        public Integer getCool() {
            return cool;
        }

        public void setCool(Integer cool) {
            this.cool = cool;
        }
    }
}