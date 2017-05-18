package com.aread.cn.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aread.cn.R;
import com.aread.cn.bean.WeatherInfoBean;
import com.aread.cn.utils.StringUtils;
import com.bumptech.glide.Glide;


public class WheatherDetialDialog extends Dialog implements View.OnClickListener{
	private Activity mContext;
	private ViewGroup mContentView;
	private TextView tvNowTemperature,tvNowCity,tvNowDate,tvNowSky,tvNowWind,tvNowContaminated,tvNowPM25;
	private TextView tvData1,tvData2,tvData3;
	private TextView tvTemperature1,tvTemperature2,tvTemperature3;
	private ImageView ivWeather1,ivWeather2,ivWeather3,nowWeatherPic;


	/**
	 *
	 * @param context
	 */

	public WheatherDetialDialog(Activity context) {
		super(context, R.style.AppDialogStyle);
		this.mContext = context;
		mContentView = (ViewGroup) getLayoutInflater().inflate(R.layout.item_dialog_aweather_detail, new RelativeLayout(context),true);
		mContentView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				dismiss();
			}
		});
		initView();
		this.setContentView(mContentView);
	}

	private void initView(){
		tvNowTemperature = (TextView) mContentView.findViewById(R.id.tvNowTemperature);
		tvNowCity = (TextView) mContentView.findViewById(R.id.tvNowCity);
		tvNowDate = (TextView) mContentView.findViewById(R.id.tvNowDate);
		tvNowSky = (TextView) mContentView.findViewById(R.id.tvNowSky);
		tvNowWind = (TextView) mContentView.findViewById(R.id.tvNowWind);
		tvNowContaminated = (TextView) mContentView.findViewById(R.id.tvNowContaminated);
		tvNowPM25 = (TextView) mContentView.findViewById(R.id.tvNowPM25);

		tvData1 = (TextView) mContentView.findViewById(R.id.tvData1);
		tvData2 = (TextView) mContentView.findViewById(R.id.tvData2);
		tvData3 = (TextView) mContentView.findViewById(R.id.tvData3);

		tvTemperature1 = (TextView) mContentView.findViewById(R.id.tvTemperature1);
		tvTemperature2 = (TextView) mContentView.findViewById(R.id.tvTemperature2);
		tvTemperature3 = (TextView) mContentView.findViewById(R.id.tvTemperature3);

		ivWeather1 = (ImageView) mContentView.findViewById(R.id.ivWeather1);
		ivWeather2 = (ImageView) mContentView.findViewById(R.id.ivWeather2);
		ivWeather3 = (ImageView) mContentView.findViewById(R.id.ivWeather3);
		nowWeatherPic = (ImageView) mContentView.findViewById(R.id.now_weather_pic);
	}

	public void initData(WeatherInfoBean data){
		tvNowDate.setText(StringUtils.getWheatherTimeStampDay() +""+StringUtils.getXingqi());
		if(data ==null)return;
		WeatherInfoBean.ShowapiResBodyBean.NowBean now = data.getShowapi_res_body().getNow();
		WeatherInfoBean.ShowapiResBodyBean.NowBean.AqiDetailBean aqiDetail = data.getShowapi_res_body().getNow().getAqiDetail();
		String area = aqiDetail.getArea();
		String pm2_5 = aqiDetail.getPm2_5()+"";
		tvNowCity.setText(area+"市");
		tvNowPM25.setText(pm2_5);
		Glide.with(mContext).load(now.getWeather_pic()).asBitmap().into(nowWeatherPic);

		String temperature = now.getTemperature();
		tvNowTemperature.setText(temperature);

		String weather = now.getWeather();
		tvNowSky.setText(weather);

		String wind_direction = now.getWind_direction();
		tvNowWind.setText(wind_direction);

		WeatherInfoBean.ShowapiResBodyBean.F1Bean f1 = data.getShowapi_res_body().getF1();
		String night_air_temperature_1 = f1.getNight_air_temperature();
		String day_air_temperature_1 = f1.getDay_air_temperature();
		String day_weather_pic_1 = f1.getDay_weather_pic();
		tvTemperature1.setText(night_air_temperature_1+"℃/"+day_air_temperature_1+"℃");
		Glide.with(mContext).load(day_weather_pic_1).asBitmap().into(ivWeather1);

		WeatherInfoBean.ShowapiResBodyBean.F2Bean f2 = data.getShowapi_res_body().getF2();
		String night_air_temperature_2 = f2.getNight_air_temperature();
		String day_air_temperature_2 = f2.getDay_air_temperature();
		String day_weather_pic_2 = f2.getDay_weather_pic();
		tvTemperature2.setText(night_air_temperature_2+"℃/"+day_air_temperature_2+"℃");
		Glide.with(mContext).load(day_weather_pic_2).asBitmap().into(ivWeather2);

		WeatherInfoBean.ShowapiResBodyBean.F3Bean f3 = data.getShowapi_res_body().getF3();
		String night_air_temperature_3 = f3.getNight_air_temperature();
		String day_air_temperature_3 = f3.getDay_air_temperature();
		String day_weather_pic_3 = f3.getDay_weather_pic();
		tvTemperature3.setText(night_air_temperature_3+"℃/"+day_air_temperature_3+"℃");
		Glide.with(mContext).load(day_weather_pic_3).asBitmap().into(ivWeather3);


	}

	@Override
	public void onClick(View view) {
//		if(view.getId() == R.id.tvAddTeamInputToScan){
//			return;
//		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		getWindow().setLayout(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		getWindow().getAttributes().dimAmount = 0.3f;
	}
}