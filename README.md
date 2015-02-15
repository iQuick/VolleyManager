# VolleyManager

最近写一直在用Google的Volley做网络请求部分，但是Volley源码只有简单的通信，如果需要上传文件、图片时就需要时就稍微复杂了，于是自己就对Volley进入了简单的封装。

## 结构如下：
![结构](https://github.com/iQuick/VolleyManager/blob/master/art/1.jpg)

## 使用

### 网络请求

	private void request() {
		RequestParams params = new RequestParams();
		RequestManager.get("http://www.baidu.com", this, params, requestListener());
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

### 图片加载
	
	ImageCacheManager.loadImage(URL_IMAGE, ImageCacheManager.getImageListener(mImageView, null, null));

## 感谢
[panxw](https://github.com/panxw/android-volley-manager)