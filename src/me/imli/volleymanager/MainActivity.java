package me.imli.volleymanager;

import com.android.volley.VolleyError;

import me.imli.volleymanager.volley.ImageCacheManager;
import me.imli.volleymanager.volley.RequestListener;
import me.imli.volleymanager.volley.RequestManager;
import me.imli.volleymanager.volley.RequestParams;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private String URL_IMAGE = "http://www.nen.com.cn/73749755317977088/20071206/89244_92713.jpg";
	
	private String URL_BAIDU = "http://www.baidu.com";
	
	private TextView mTextView;
	
	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTextView = (TextView) findViewById(R.id.text);
		mImageView = (ImageView) findViewById(R.id.image);
		
		ImageCacheManager.loadImage(URL_IMAGE, ImageCacheManager.getImageListener(mImageView, null, null));
		
		post(URL_BAIDU, requestListener());
	}
	
	private RequestListener requestListener() {
		return new RequestListener() {
			
			@Override
			public void requestSuccess(String json) {
				mTextView.setText(json);
			}
			
			@Override
			public void requestError(VolleyError e) {
				e.printStackTrace();
			}
		};
	}

	
	
	@Override
	protected void onDestroy() {
		RequestManager.cancelAll(this);
		super.onDestroy();
	}
	
	/**
	 * 
	 * @param url
	 * @param l
	 */
	protected void get(String url, RequestListener l) {
		get(url, null, l);
	}
	
	/**
	 * 
	 * @param url
	 * @param params
	 * @param l
	 */
	protected void get(String url, RequestParams params, RequestListener l) {
		RequestManager.get(url, this, params, l);
	}
	
	/**
	 * 
	 * @param url
	 * @param l
	 */
	protected void post(String url, RequestListener l) {
		post(url, null, l);
	}
	
	/**
	 * 
	 * @param url
	 * @param params
	 * @param l
	 */
	protected void post(String url, RequestParams params, RequestListener l) {
		RequestManager.post(url, this, params, l);
	}
}
