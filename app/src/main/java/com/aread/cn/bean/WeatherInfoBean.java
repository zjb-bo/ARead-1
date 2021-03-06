package com.aread.cn.bean;

/**
 * Created by Administrator on 2017/5/18.
 */

public class WeatherInfoBean {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"time":"20160629113000","ret_code":0,"cityInfo":{"c6":"yunnan","c5":"丽江","c4":"lijiang","c3":"丽江","c9":"中国","c8":"china","c7":"云南","c17":"+8","c16":"AZ9888","c1":"101291401","c2":"lijiang","c11":"0888","longitude":100.222,"c10":"2","latitude":26.903,"c12":"674100","c15":"2394"},"f1":{"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不宜","desc":"降水可能会淋湿衣物，请选择在室内晾晒。"},"clothes":{"title":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"},"dy":{"title":"不宜","desc":"天气不好，不适宜垂钓。"},"beauty":{"title":"保湿","desc":"请选用中性保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"雨水可能会使心绪无端地挂上轻愁。"},"travel":{"title":"适宜","desc":"较弱降水和微风将伴您共赴旅程。"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"无","desc":"气温不高，中暑几率极低。"},"cold":{"title":"较易发","desc":"降温幅度较大，预防感冒。"},"gj":{"title":"较适宜","desc":"有降水，逛街需要带雨具。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"cl":{"title":"较不宜","desc":"室外锻炼请携带雨具。"},"glass":{"title":"不需要","desc":"白天能见度差不需要佩戴太阳镜"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"aqi":{"title":"中","desc":"无需特别防护"},"ac":{"title":"较少开启","desc":"体感舒适，不需要开启空调。"},"mf":{"title":"一般","desc":"建议选用防晒滋润型护发品或带遮阳帽。"},"ag":{"title":"极不易发","desc":"无需担心过敏，可放心外出，享受生活。"},"pj":{"title":"较适宜","desc":"适量的饮用啤酒，注意不要过量。"},"nl":{"title":"较不适宜","desc":"建议夜生活最好在室内进行。"},"pk":{"title":"不宜","desc":"天气不好，不适宜放风筝。"}},"air_press":"766 hPa","jiangshui":"75%","night_wind_power":"微风10m/h","day_wind_power":"微风10m/h","day_weather_code":"07","sun_begin_end":"06:28|20:17","ziwaixian":"最弱","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":3,"night_air_temperature":"15","day_air_temperature":"22","day_wind_direction":"无持续风向","day":"20160629","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"无持续风向"},"f3":{"day_weather":"小雨","night_weather":"中雨","night_weather_code":"08","index":{"cold":{"title":"较易发","desc":"天较凉，增加衣服，注意防护。"},"clothes":{"title":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"aqi":{"title":"良","desc":"气象条件有利于空气污染物扩散。"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"travel":{"title":"较不宜","desc":"有降水，推荐您在室内进行休闲运动。"}},"night_wind_power":"微风10m/h","day_wind_power":"微风10m/h","day_weather_code":"07","sun_begin_end":"06:28|20:17","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":5,"night_air_temperature":"13","day_air_temperature":"21","day_wind_direction":"无持续风向","day":"20160701","night_weather_pic":"http://app1.showapi.com/weather/icon/night/08.png","night_wind_direction":"无持续风向"},"f2":{"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","index":{"cold":{"title":"少发","desc":"无明显降温，感冒机率较低。"},"clothes":{"title":"舒适","desc":"建议穿长袖衬衫单裤等服装。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"aqi":{"title":"良","desc":"气象条件有利于空气污染物扩散。"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"travel":{"title":"较不宜","desc":"有降水，推荐您在室内进行休闲运动。"}},"night_wind_power":"微风10m/h","day_wind_power":"微风10m/h","day_weather_code":"07","sun_begin_end":"06:28|20:17","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":4,"night_air_temperature":"16","day_air_temperature":"24","day_wind_direction":"无持续风向","day":"20160630","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"无持续风向"},"now":{"aqiDetail":{"co":0.38,"so2":8,"area":"丽江","o3":42,"no2":9,"area_code":"lijiang","quality":"优","aqi":19,"pm10":18,"pm2_5":12,"o3_8h":37,"primary_pollutant":""},"weather_code":"03","wind_direction":"西北风","temperature_time":"16:01","wind_power":"1级","aqi":19,"sd":"70%","weather_pic":"http://appimg.showapi.com/images/weather/icon/day/03.png","weather":"阵雨","temperature":"21"}}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * time : 20160629113000
         * ret_code : 0
         * cityInfo : {"c6":"yunnan","c5":"丽江","c4":"lijiang","c3":"丽江","c9":"中国","c8":"china","c7":"云南","c17":"+8","c16":"AZ9888","c1":"101291401","c2":"lijiang","c11":"0888","longitude":100.222,"c10":"2","latitude":26.903,"c12":"674100","c15":"2394"}
         * f1 : {"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","index":{"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不宜","desc":"降水可能会淋湿衣物，请选择在室内晾晒。"},"clothes":{"title":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"},"dy":{"title":"不宜","desc":"天气不好，不适宜垂钓。"},"beauty":{"title":"保湿","desc":"请选用中性保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"雨水可能会使心绪无端地挂上轻愁。"},"travel":{"title":"适宜","desc":"较弱降水和微风将伴您共赴旅程。"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"无","desc":"气温不高，中暑几率极低。"},"cold":{"title":"较易发","desc":"降温幅度较大，预防感冒。"},"gj":{"title":"较适宜","desc":"有降水，逛街需要带雨具。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"cl":{"title":"较不宜","desc":"室外锻炼请携带雨具。"},"glass":{"title":"不需要","desc":"白天能见度差不需要佩戴太阳镜"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"aqi":{"title":"中","desc":"无需特别防护"},"ac":{"title":"较少开启","desc":"体感舒适，不需要开启空调。"},"mf":{"title":"一般","desc":"建议选用防晒滋润型护发品或带遮阳帽。"},"ag":{"title":"极不易发","desc":"无需担心过敏，可放心外出，享受生活。"},"pj":{"title":"较适宜","desc":"适量的饮用啤酒，注意不要过量。"},"nl":{"title":"较不适宜","desc":"建议夜生活最好在室内进行。"},"pk":{"title":"不宜","desc":"天气不好，不适宜放风筝。"}},"air_press":"766 hPa","jiangshui":"75%","night_wind_power":"微风10m/h","day_wind_power":"微风10m/h","day_weather_code":"07","sun_begin_end":"06:28|20:17","ziwaixian":"最弱","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":3,"night_air_temperature":"15","day_air_temperature":"22","day_wind_direction":"无持续风向","day":"20160629","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"无持续风向"}
         * f3 : {"day_weather":"小雨","night_weather":"中雨","night_weather_code":"08","index":{"cold":{"title":"较易发","desc":"天较凉，增加衣服，注意防护。"},"clothes":{"title":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"aqi":{"title":"良","desc":"气象条件有利于空气污染物扩散。"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"travel":{"title":"较不宜","desc":"有降水，推荐您在室内进行休闲运动。"}},"night_wind_power":"微风10m/h","day_wind_power":"微风10m/h","day_weather_code":"07","sun_begin_end":"06:28|20:17","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":5,"night_air_temperature":"13","day_air_temperature":"21","day_wind_direction":"无持续风向","day":"20160701","night_weather_pic":"http://app1.showapi.com/weather/icon/night/08.png","night_wind_direction":"无持续风向"}
         * f2 : {"day_weather":"小雨","night_weather":"小雨","night_weather_code":"07","index":{"cold":{"title":"少发","desc":"无明显降温，感冒机率较低。"},"clothes":{"title":"舒适","desc":"建议穿长袖衬衫单裤等服装。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"aqi":{"title":"良","desc":"气象条件有利于空气污染物扩散。"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"travel":{"title":"较不宜","desc":"有降水，推荐您在室内进行休闲运动。"}},"night_wind_power":"微风10m/h","day_wind_power":"微风10m/h","day_weather_code":"07","sun_begin_end":"06:28|20:17","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","weekday":4,"night_air_temperature":"16","day_air_temperature":"24","day_wind_direction":"无持续风向","day":"20160630","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"无持续风向"}
         * now : {"aqiDetail":{"co":0.38,"so2":8,"area":"丽江","o3":42,"no2":9,"area_code":"lijiang","quality":"优","aqi":19,"pm10":18,"pm2_5":12,"o3_8h":37,"primary_pollutant":""},"weather_code":"03","wind_direction":"西北风","temperature_time":"16:01","wind_power":"1级","aqi":19,"sd":"70%","weather_pic":"http://appimg.showapi.com/images/weather/icon/day/03.png","weather":"阵雨","temperature":"21"}
         */

        private String time;
        private int ret_code;
        private CityInfoBean cityInfo;
        private F1Bean f1;
        private F3Bean f3;
        private F2Bean f2;
        private NowBean now;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public CityInfoBean getCityInfo() {
            return cityInfo;
        }

        public void setCityInfo(CityInfoBean cityInfo) {
            this.cityInfo = cityInfo;
        }

        public F1Bean getF1() {
            return f1;
        }

        public void setF1(F1Bean f1) {
            this.f1 = f1;
        }

        public F3Bean getF3() {
            return f3;
        }

        public void setF3(F3Bean f3) {
            this.f3 = f3;
        }

        public F2Bean getF2() {
            return f2;
        }

        public void setF2(F2Bean f2) {
            this.f2 = f2;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public static class CityInfoBean {
            /**
             * c6 : yunnan
             * c5 : 丽江
             * c4 : lijiang
             * c3 : 丽江
             * c9 : 中国
             * c8 : china
             * c7 : 云南
             * c17 : +8
             * c16 : AZ9888
             * c1 : 101291401
             * c2 : lijiang
             * c11 : 0888
             * longitude : 100.222
             * c10 : 2
             * latitude : 26.903
             * c12 : 674100
             * c15 : 2394
             */

            private String c6;
            private String c5;
            private String c4;
            private String c3;
            private String c9;
            private String c8;
            private String c7;
            private String c17;
            private String c16;
            private String c1;
            private String c2;
            private String c11;
            private double longitude;
            private String c10;
            private double latitude;
            private String c12;
            private String c15;

            public String getC6() {
                return c6;
            }

            public void setC6(String c6) {
                this.c6 = c6;
            }

            public String getC5() {
                return c5;
            }

            public void setC5(String c5) {
                this.c5 = c5;
            }

            public String getC4() {
                return c4;
            }

            public void setC4(String c4) {
                this.c4 = c4;
            }

            public String getC3() {
                return c3;
            }

            public void setC3(String c3) {
                this.c3 = c3;
            }

            public String getC9() {
                return c9;
            }

            public void setC9(String c9) {
                this.c9 = c9;
            }

            public String getC8() {
                return c8;
            }

            public void setC8(String c8) {
                this.c8 = c8;
            }

            public String getC7() {
                return c7;
            }

            public void setC7(String c7) {
                this.c7 = c7;
            }

            public String getC17() {
                return c17;
            }

            public void setC17(String c17) {
                this.c17 = c17;
            }

            public String getC16() {
                return c16;
            }

            public void setC16(String c16) {
                this.c16 = c16;
            }

            public String getC1() {
                return c1;
            }

            public void setC1(String c1) {
                this.c1 = c1;
            }

            public String getC2() {
                return c2;
            }

            public void setC2(String c2) {
                this.c2 = c2;
            }

            public String getC11() {
                return c11;
            }

            public void setC11(String c11) {
                this.c11 = c11;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getC10() {
                return c10;
            }

            public void setC10(String c10) {
                this.c10 = c10;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getC12() {
                return c12;
            }

            public void setC12(String c12) {
                this.c12 = c12;
            }

            public String getC15() {
                return c15;
            }

            public void setC15(String c15) {
                this.c15 = c15;
            }
        }

        public static class F1Bean {
            /**
             * day_weather : 小雨
             * night_weather : 小雨
             * night_weather_code : 07
             * index : {"yh":{"title":"较不适宜","desc":"建议尽量不要去室外约会。"},"ls":{"title":"不宜","desc":"降水可能会淋湿衣物，请选择在室内晾晒。"},"clothes":{"title":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"},"dy":{"title":"不宜","desc":"天气不好，不适宜垂钓。"},"beauty":{"title":"保湿","desc":"请选用中性保湿型霜类化妆品。"},"xq":{"title":"较差","desc":"雨水可能会使心绪无端地挂上轻愁。"},"travel":{"title":"适宜","desc":"较弱降水和微风将伴您共赴旅程。"},"hc":{"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"},"zs":{"title":"无","desc":"气温不高，中暑几率极低。"},"cold":{"title":"较易发","desc":"降温幅度较大，预防感冒。"},"gj":{"title":"较适宜","desc":"有降水，逛街需要带雨具。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"cl":{"title":"较不宜","desc":"室外锻炼请携带雨具。"},"glass":{"title":"不需要","desc":"白天能见度差不需要佩戴太阳镜"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"aqi":{"title":"中","desc":"无需特别防护"},"ac":{"title":"较少开启","desc":"体感舒适，不需要开启空调。"},"mf":{"title":"一般","desc":"建议选用防晒滋润型护发品或带遮阳帽。"},"ag":{"title":"极不易发","desc":"无需担心过敏，可放心外出，享受生活。"},"pj":{"title":"较适宜","desc":"适量的饮用啤酒，注意不要过量。"},"nl":{"title":"较不适宜","desc":"建议夜生活最好在室内进行。"},"pk":{"title":"不宜","desc":"天气不好，不适宜放风筝。"}}
             * air_press : 766 hPa
             * jiangshui : 75%
             * night_wind_power : 微风10m/h
             * day_wind_power : 微风10m/h
             * day_weather_code : 07
             * sun_begin_end : 06:28|20:17
             * ziwaixian : 最弱
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/07.png
             * weekday : 3
             * night_air_temperature : 15
             * day_air_temperature : 22
             * day_wind_direction : 无持续风向
             * day : 20160629
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/07.png
             * night_wind_direction : 无持续风向
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBean index;
            private String air_press;
            private String jiangshui;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String ziwaixian;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBean getIndex() {
                return index;
            }

            public void setIndex(IndexBean index) {
                this.index = index;
            }

            public String getAir_press() {
                return air_press;
            }

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public static class IndexBean {
                /**
                 * yh : {"title":"较不适宜","desc":"建议尽量不要去室外约会。"}
                 * ls : {"title":"不宜","desc":"降水可能会淋湿衣物，请选择在室内晾晒。"}
                 * clothes : {"title":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"}
                 * dy : {"title":"不宜","desc":"天气不好，不适宜垂钓。"}
                 * beauty : {"title":"保湿","desc":"请选用中性保湿型霜类化妆品。"}
                 * xq : {"title":"较差","desc":"雨水可能会使心绪无端地挂上轻愁。"}
                 * travel : {"title":"适宜","desc":"较弱降水和微风将伴您共赴旅程。"}
                 * hc : {"title":"不适宜","desc":"天气不好，建议选择别的娱乐方式。"}
                 * zs : {"title":"无","desc":"气温不高，中暑几率极低。"}
                 * cold : {"title":"较易发","desc":"降温幅度较大，预防感冒。"}
                 * gj : {"title":"较适宜","desc":"有降水，逛街需要带雨具。"}
                 * uv : {"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"}
                 * cl : {"title":"较不宜","desc":"室外锻炼请携带雨具。"}
                 * glass : {"title":"不需要","desc":"白天能见度差不需要佩戴太阳镜"}
                 * wash_car : {"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"}
                 * aqi : {"title":"中","desc":"无需特别防护"}
                 * ac : {"title":"较少开启","desc":"体感舒适，不需要开启空调。"}
                 * mf : {"title":"一般","desc":"建议选用防晒滋润型护发品或带遮阳帽。"}
                 * ag : {"title":"极不易发","desc":"无需担心过敏，可放心外出，享受生活。"}
                 * pj : {"title":"较适宜","desc":"适量的饮用啤酒，注意不要过量。"}
                 * nl : {"title":"较不适宜","desc":"建议夜生活最好在室内进行。"}
                 * pk : {"title":"不宜","desc":"天气不好，不适宜放风筝。"}
                 */

                private YhBean yh;
                private LsBean ls;
                private ClothesBean clothes;
                private DyBean dy;
                private BeautyBean beauty;
                private XqBean xq;
                private TravelBean travel;
                private HcBean hc;
                private ZsBean zs;
                private ColdBean cold;
                private GjBean gj;
                private UvBean uv;
                private ClBean cl;
                private GlassBean glass;
                private WashCarBean wash_car;
                private AqiBean aqi;
                private AcBean ac;
                private MfBean mf;
                private AgBean ag;
                private PjBean pj;
                private NlBean nl;
                private PkBean pk;

                public YhBean getYh() {
                    return yh;
                }

                public void setYh(YhBean yh) {
                    this.yh = yh;
                }

                public LsBean getLs() {
                    return ls;
                }

                public void setLs(LsBean ls) {
                    this.ls = ls;
                }

                public ClothesBean getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBean clothes) {
                    this.clothes = clothes;
                }

                public DyBean getDy() {
                    return dy;
                }

                public void setDy(DyBean dy) {
                    this.dy = dy;
                }

                public BeautyBean getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyBean beauty) {
                    this.beauty = beauty;
                }

                public XqBean getXq() {
                    return xq;
                }

                public void setXq(XqBean xq) {
                    this.xq = xq;
                }

                public TravelBean getTravel() {
                    return travel;
                }

                public void setTravel(TravelBean travel) {
                    this.travel = travel;
                }

                public HcBean getHc() {
                    return hc;
                }

                public void setHc(HcBean hc) {
                    this.hc = hc;
                }

                public ZsBean getZs() {
                    return zs;
                }

                public void setZs(ZsBean zs) {
                    this.zs = zs;
                }

                public ColdBean getCold() {
                    return cold;
                }

                public void setCold(ColdBean cold) {
                    this.cold = cold;
                }

                public GjBean getGj() {
                    return gj;
                }

                public void setGj(GjBean gj) {
                    this.gj = gj;
                }

                public UvBean getUv() {
                    return uv;
                }

                public void setUv(UvBean uv) {
                    this.uv = uv;
                }

                public ClBean getCl() {
                    return cl;
                }

                public void setCl(ClBean cl) {
                    this.cl = cl;
                }

                public GlassBean getGlass() {
                    return glass;
                }

                public void setGlass(GlassBean glass) {
                    this.glass = glass;
                }

                public WashCarBean getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBean wash_car) {
                    this.wash_car = wash_car;
                }

                public AqiBean getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBean aqi) {
                    this.aqi = aqi;
                }

                public AcBean getAc() {
                    return ac;
                }

                public void setAc(AcBean ac) {
                    this.ac = ac;
                }

                public MfBean getMf() {
                    return mf;
                }

                public void setMf(MfBean mf) {
                    this.mf = mf;
                }

                public AgBean getAg() {
                    return ag;
                }

                public void setAg(AgBean ag) {
                    this.ag = ag;
                }

                public PjBean getPj() {
                    return pj;
                }

                public void setPj(PjBean pj) {
                    this.pj = pj;
                }

                public NlBean getNl() {
                    return nl;
                }

                public void setNl(NlBean nl) {
                    this.nl = nl;
                }

                public PkBean getPk() {
                    return pk;
                }

                public void setPk(PkBean pk) {
                    this.pk = pk;
                }

                public static class YhBean {
                    /**
                     * title : 较不适宜
                     * desc : 建议尽量不要去室外约会。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class LsBean {
                    /**
                     * title : 不宜
                     * desc : 降水可能会淋湿衣物，请选择在室内晾晒。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBean {
                    /**
                     * title : 较舒适
                     * desc : 建议穿薄外套或牛仔裤等服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class DyBean {
                    /**
                     * title : 不宜
                     * desc : 天气不好，不适宜垂钓。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class BeautyBean {
                    /**
                     * title : 保湿
                     * desc : 请选用中性保湿型霜类化妆品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class XqBean {
                    /**
                     * title : 较差
                     * desc : 雨水可能会使心绪无端地挂上轻愁。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBean {
                    /**
                     * title : 适宜
                     * desc : 较弱降水和微风将伴您共赴旅程。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class HcBean {
                    /**
                     * title : 不适宜
                     * desc : 天气不好，建议选择别的娱乐方式。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ZsBean {
                    /**
                     * title : 无
                     * desc : 气温不高，中暑几率极低。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ColdBean {
                    /**
                     * title : 较易发
                     * desc : 降温幅度较大，预防感冒。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GjBean {
                    /**
                     * title : 较适宜
                     * desc : 有降水，逛街需要带雨具。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBean {
                    /**
                     * title : 最弱
                     * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClBean {
                    /**
                     * title : 较不宜
                     * desc : 室外锻炼请携带雨具。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class GlassBean {
                    /**
                     * title : 不需要
                     * desc : 白天能见度差不需要佩戴太阳镜
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBean {
                    /**
                     * title : 不宜
                     * desc : 有雨，雨水和泥水会弄脏爱车。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBean {
                    /**
                     * title : 中
                     * desc : 无需特别防护
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AcBean {
                    /**
                     * title : 较少开启
                     * desc : 体感舒适，不需要开启空调。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class MfBean {
                    /**
                     * title : 一般
                     * desc : 建议选用防晒滋润型护发品或带遮阳帽。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AgBean {
                    /**
                     * title : 极不易发
                     * desc : 无需担心过敏，可放心外出，享受生活。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PjBean {
                    /**
                     * title : 较适宜
                     * desc : 适量的饮用啤酒，注意不要过量。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class NlBean {
                    /**
                     * title : 较不适宜
                     * desc : 建议夜生活最好在室内进行。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class PkBean {
                    /**
                     * title : 不宜
                     * desc : 天气不好，不适宜放风筝。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }
        }

        public static class F3Bean {
            /**
             * day_weather : 小雨
             * night_weather : 中雨
             * night_weather_code : 08
             * index : {"cold":{"title":"较易发","desc":"天较凉，增加衣服，注意防护。"},"clothes":{"title":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"aqi":{"title":"良","desc":"气象条件有利于空气污染物扩散。"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"travel":{"title":"较不宜","desc":"有降水，推荐您在室内进行休闲运动。"}}
             * night_wind_power : 微风10m/h
             * day_wind_power : 微风10m/h
             * day_weather_code : 07
             * sun_begin_end : 06:28|20:17
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/07.png
             * weekday : 5
             * night_air_temperature : 13
             * day_air_temperature : 21
             * day_wind_direction : 无持续风向
             * day : 20160701
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/08.png
             * night_wind_direction : 无持续风向
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBeanX index;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBeanX getIndex() {
                return index;
            }

            public void setIndex(IndexBeanX index) {
                this.index = index;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public static class IndexBeanX {
                /**
                 * cold : {"title":"较易发","desc":"天较凉，增加衣服，注意防护。"}
                 * clothes : {"title":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"}
                 * uv : {"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"}
                 * aqi : {"title":"良","desc":"气象条件有利于空气污染物扩散。"}
                 * wash_car : {"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"}
                 * travel : {"title":"较不宜","desc":"有降水，推荐您在室内进行休闲运动。"}
                 */

                private ColdBeanX cold;
                private ClothesBeanX clothes;
                private UvBeanX uv;
                private AqiBeanX aqi;
                private WashCarBeanX wash_car;
                private TravelBeanX travel;

                public ColdBeanX getCold() {
                    return cold;
                }

                public void setCold(ColdBeanX cold) {
                    this.cold = cold;
                }

                public ClothesBeanX getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBeanX clothes) {
                    this.clothes = clothes;
                }

                public UvBeanX getUv() {
                    return uv;
                }

                public void setUv(UvBeanX uv) {
                    this.uv = uv;
                }

                public AqiBeanX getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBeanX aqi) {
                    this.aqi = aqi;
                }

                public WashCarBeanX getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBeanX wash_car) {
                    this.wash_car = wash_car;
                }

                public TravelBeanX getTravel() {
                    return travel;
                }

                public void setTravel(TravelBeanX travel) {
                    this.travel = travel;
                }

                public static class ColdBeanX {
                    /**
                     * title : 较易发
                     * desc : 天较凉，增加衣服，注意防护。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBeanX {
                    /**
                     * title : 较舒适
                     * desc : 建议穿薄外套或牛仔裤等服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBeanX {
                    /**
                     * title : 最弱
                     * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBeanX {
                    /**
                     * title : 良
                     * desc : 气象条件有利于空气污染物扩散。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBeanX {
                    /**
                     * title : 不宜
                     * desc : 有雨，雨水和泥水会弄脏爱车。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBeanX {
                    /**
                     * title : 较不宜
                     * desc : 有降水，推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }
        }

        public static class F2Bean {
            /**
             * day_weather : 小雨
             * night_weather : 小雨
             * night_weather_code : 07
             * index : {"cold":{"title":"少发","desc":"无明显降温，感冒机率较低。"},"clothes":{"title":"舒适","desc":"建议穿长袖衬衫单裤等服装。"},"uv":{"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},"aqi":{"title":"良","desc":"气象条件有利于空气污染物扩散。"},"wash_car":{"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"},"travel":{"title":"较不宜","desc":"有降水，推荐您在室内进行休闲运动。"}}
             * night_wind_power : 微风10m/h
             * day_wind_power : 微风10m/h
             * day_weather_code : 07
             * sun_begin_end : 06:28|20:17
             * day_weather_pic : http://app1.showapi.com/weather/icon/day/07.png
             * weekday : 4
             * night_air_temperature : 16
             * day_air_temperature : 24
             * day_wind_direction : 无持续风向
             * day : 20160630
             * night_weather_pic : http://app1.showapi.com/weather/icon/night/07.png
             * night_wind_direction : 无持续风向
             */

            private String day_weather;
            private String night_weather;
            private String night_weather_code;
            private IndexBeanXX index;
            private String night_wind_power;
            private String day_wind_power;
            private String day_weather_code;
            private String sun_begin_end;
            private String day_weather_pic;
            private int weekday;
            private String night_air_temperature;
            private String day_air_temperature;
            private String day_wind_direction;
            private String day;
            private String night_weather_pic;
            private String night_wind_direction;

            public String getDay_weather() {
                return day_weather;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public String getNight_weather_code() {
                return night_weather_code;
            }

            public void setNight_weather_code(String night_weather_code) {
                this.night_weather_code = night_weather_code;
            }

            public IndexBeanXX getIndex() {
                return index;
            }

            public void setIndex(IndexBeanXX index) {
                this.index = index;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public String getDay_weather_code() {
                return day_weather_code;
            }

            public void setDay_weather_code(String day_weather_code) {
                this.day_weather_code = day_weather_code;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public int getWeekday() {
                return weekday;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public static class IndexBeanXX {
                /**
                 * cold : {"title":"少发","desc":"无明显降温，感冒机率较低。"}
                 * clothes : {"title":"舒适","desc":"建议穿长袖衬衫单裤等服装。"}
                 * uv : {"title":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"}
                 * aqi : {"title":"良","desc":"气象条件有利于空气污染物扩散。"}
                 * wash_car : {"title":"不宜","desc":"有雨，雨水和泥水会弄脏爱车。"}
                 * travel : {"title":"较不宜","desc":"有降水，推荐您在室内进行休闲运动。"}
                 */

                private ColdBeanXX cold;
                private ClothesBeanXX clothes;
                private UvBeanXX uv;
                private AqiBeanXX aqi;
                private WashCarBeanXX wash_car;
                private TravelBeanXX travel;

                public ColdBeanXX getCold() {
                    return cold;
                }

                public void setCold(ColdBeanXX cold) {
                    this.cold = cold;
                }

                public ClothesBeanXX getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesBeanXX clothes) {
                    this.clothes = clothes;
                }

                public UvBeanXX getUv() {
                    return uv;
                }

                public void setUv(UvBeanXX uv) {
                    this.uv = uv;
                }

                public AqiBeanXX getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBeanXX aqi) {
                    this.aqi = aqi;
                }

                public WashCarBeanXX getWash_car() {
                    return wash_car;
                }

                public void setWash_car(WashCarBeanXX wash_car) {
                    this.wash_car = wash_car;
                }

                public TravelBeanXX getTravel() {
                    return travel;
                }

                public void setTravel(TravelBeanXX travel) {
                    this.travel = travel;
                }

                public static class ColdBeanXX {
                    /**
                     * title : 少发
                     * desc : 无明显降温，感冒机率较低。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ClothesBeanXX {
                    /**
                     * title : 舒适
                     * desc : 建议穿长袖衬衫单裤等服装。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class UvBeanXX {
                    /**
                     * title : 最弱
                     * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class AqiBeanXX {
                    /**
                     * title : 良
                     * desc : 气象条件有利于空气污染物扩散。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class WashCarBeanXX {
                    /**
                     * title : 不宜
                     * desc : 有雨，雨水和泥水会弄脏爱车。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class TravelBeanXX {
                    /**
                     * title : 较不宜
                     * desc : 有降水，推荐您在室内进行休闲运动。
                     */

                    private String title;
                    private String desc;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }
        }

        public static class NowBean {
            /**
             * aqiDetail : {"co":0.38,"so2":8,"area":"丽江","o3":42,"no2":9,"area_code":"lijiang","quality":"优","aqi":19,"pm10":18,"pm2_5":12,"o3_8h":37,"primary_pollutant":""}
             * weather_code : 03
             * wind_direction : 西北风
             * temperature_time : 16:01
             * wind_power : 1级
             * aqi : 19
             * sd : 70%
             * weather_pic : http://appimg.showapi.com/images/weather/icon/day/03.png
             * weather : 阵雨
             * temperature : 21
             */

            private AqiDetailBean aqiDetail;
            private String weather_code;
            private String wind_direction;
            private String temperature_time;
            private String wind_power;
            private int aqi;
            private String sd;
            private String weather_pic;
            private String weather;
            private String temperature;

            public AqiDetailBean getAqiDetail() {
                return aqiDetail;
            }

            public void setAqiDetail(AqiDetailBean aqiDetail) {
                this.aqiDetail = aqiDetail;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getTemperature_time() {
                return temperature_time;
            }

            public void setTemperature_time(String temperature_time) {
                this.temperature_time = temperature_time;
            }

            public String getWind_power() {
                return wind_power;
            }

            public void setWind_power(String wind_power) {
                this.wind_power = wind_power;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getSd() {
                return sd;
            }

            public void setSd(String sd) {
                this.sd = sd;
            }

            public String getWeather_pic() {
                return weather_pic;
            }

            public void setWeather_pic(String weather_pic) {
                this.weather_pic = weather_pic;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public static class AqiDetailBean {
                /**
                 * co : 0.38
                 * so2 : 8
                 * area : 丽江
                 * o3 : 42
                 * no2 : 9
                 * area_code : lijiang
                 * quality : 优
                 * aqi : 19
                 * pm10 : 18
                 * pm2_5 : 12
                 * o3_8h : 37
                 * primary_pollutant :
                 */


                private double co;
                private int so2;
                private String area;
                private int o3;
                private int no2;
                private String area_code;
                private String quality;
                private int aqi;
                private int pm10;
                private int pm2_5;
                private int o3_8h;
                private String primary_pollutant;

                public double getCo() {
                    return co;
                }

                public void setCo(double co) {
                    this.co = co;
                }

                public int getSo2() {
                    return so2;
                }

                public void setSo2(int so2) {
                    this.so2 = so2;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public int getO3() {
                    return o3;
                }

                public void setO3(int o3) {
                    this.o3 = o3;
                }

                public int getNo2() {
                    return no2;
                }

                public void setNo2(int no2) {
                    this.no2 = no2;
                }

                public String getArea_code() {
                    return area_code;
                }

                public void setArea_code(String area_code) {
                    this.area_code = area_code;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public int getAqi() {
                    return aqi;
                }

                public void setAqi(int aqi) {
                    this.aqi = aqi;
                }

                public int getPm10() {
                    return pm10;
                }

                public void setPm10(int pm10) {
                    this.pm10 = pm10;
                }

                public int getPm2_5() {
                    return pm2_5;
                }

                public void setPm2_5(int pm2_5) {
                    this.pm2_5 = pm2_5;
                }

                public int getO3_8h() {
                    return o3_8h;
                }

                public void setO3_8h(int o3_8h) {
                    this.o3_8h = o3_8h;
                }

                public String getPrimary_pollutant() {
                    return primary_pollutant;
                }

                public void setPrimary_pollutant(String primary_pollutant) {
                    this.primary_pollutant = primary_pollutant;
                }
            }
        }
    }
}
