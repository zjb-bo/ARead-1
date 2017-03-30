package com.aread.cn.bean;

/**
 * Created by Administrator on 2017/3/30.
 */
public class JoinTeamBean {

    /**
     * server_status : 200
     * server_error : 成功
     * data : {"groupId":"0144","state":"1"}
     */

    private int server_status;
    private String server_error;
    private DataBean data;

    public int getServer_status() {
        return server_status;
    }

    public void setServer_status(int server_status) {
        this.server_status = server_status;
    }

    public String getServer_error() {
        return server_error;
    }

    public void setServer_error(String server_error) {
        this.server_error = server_error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * groupId : 0144
         * state : 1
         */

        private String groupId;
        private String state;

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "groupId='" + groupId + '\'' +
                    ", state='" + state + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "JoinTeamBean{" +
                "server_status=" + server_status +
                ", server_error='" + server_error + '\'' +
                ", data=" + data +
                '}';
    }
}
