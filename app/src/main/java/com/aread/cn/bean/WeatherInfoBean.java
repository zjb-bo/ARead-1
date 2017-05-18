package com.aread.cn.bean;

/**
 * Created by Administrator on 2017/5/18.
 */

public class WeatherInfoBean {

    @Override
    public String toString() {
        return "WeatherInfoBean{" +
                "showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                ", showapi_res_body=" + showapi_res_body +
                '}';
    }

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"time":"20160629113000","ret_code":0,"now":{"aqiDetail":{"co":0.38,"so2":8,"area":"丽江","o3":42,"no2":9,"area_code":"lijiang","quality":"优","aqi":19,"pm10":18,"pm2_5":12,"o3_8h":37,"primary_pollutant":""},"weather_code":"03","wind_direction":"西北风","temperature_time":"16:01","wind_power":"1级","aqi":19,"sd":"70%","weather_pic":"http://appimg.showapi.com/images/weather/icon/day/03.png","weather":"阵雨","temperature":"21"}}
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

        @Override
        public String toString() {
            return "ShowapiResBodyBean{" +
                    "time='" + time + '\'' +
                    ", ret_code=" + ret_code +
                    ", now=" + now +
                    '}';
        }

        /**
         * time : 20160629113000
         * ret_code : 0
         * now : {"aqiDetail":{"co":0.38,"so2":8,"area":"丽江","o3":42,"no2":9,"area_code":"lijiang","quality":"优","aqi":19,"pm10":18,"pm2_5":12,"o3_8h":37,"primary_pollutant":""},"weather_code":"03","wind_direction":"西北风","temperature_time":"16:01","wind_power":"1级","aqi":19,"sd":"70%","weather_pic":"http://appimg.showapi.com/images/weather/icon/day/03.png","weather":"阵雨","temperature":"21"}
         */



        private String time;
        private int ret_code;
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

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public static class NowBean {
            @Override
            public String toString() {
                return "NowBean{" +
                        "aqiDetail=" + aqiDetail +
                        ", weather_code='" + weather_code + '\'' +
                        ", wind_direction='" + wind_direction + '\'' +
                        ", temperature_time='" + temperature_time + '\'' +
                        ", wind_power='" + wind_power + '\'' +
                        ", aqi=" + aqi +
                        ", sd='" + sd + '\'' +
                        ", weather_pic='" + weather_pic + '\'' +
                        ", weather='" + weather + '\'' +
                        ", temperature='" + temperature + '\'' +
                        '}';
            }

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
                @Override
                public String toString() {
                    return "AqiDetailBean{" +
                            "co=" + co +
                            ", so2=" + so2 +
                            ", area='" + area + '\'' +
                            ", o3=" + o3 +
                            ", no2=" + no2 +
                            ", area_code='" + area_code + '\'' +
                            ", quality='" + quality + '\'' +
                            ", aqi=" + aqi +
                            ", pm10=" + pm10 +
                            ", pm2_5=" + pm2_5 +
                            ", o3_8h=" + o3_8h +
                            ", primary_pollutant='" + primary_pollutant + '\'' +
                            '}';
                }

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
