package com.wzx.andapp.shh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewDemo extends Activity {
	/** Called when the activity is first created. */
	private GridView gv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridviewdemo_main);

		// 通过findViewById方法获得GridView对象
		gv = (GridView) findViewById(R.id.GridView01);
		// 设置GridView的行数
		gv.setNumColumns(4);
		gv.setAdapter(new MyAdapter(this));
	}

	// 自定义适配器
	class MyAdapter extends BaseAdapter {
		// 图片id数组
		private Integer[] imgs = { R.drawable.img01, R.drawable.img02,
				R.drawable.img03, R.drawable.img04, R.drawable.img05,
				R.drawable.img01, R.drawable.img02, R.drawable.img03,
				R.drawable.img04, R.drawable.img05, R.drawable.img01,
				R.drawable.img02, R.drawable.img03, R.drawable.img04,
				R.drawable.img05 };
		// 上下文对象
		Context context;

		// 构造方法
		MyAdapter(Context context) {
			this.context = context;
		}

		// 获得数量
		public int getCount() {
			return imgs.length;
		}

		// 获得当前选项
		public Object getItem(int item) {
			return item;
		}

		// 获得当前选项id
		public long getItemId(int id) {
			return id;
		}

		// 创建View方法
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				// 实例化ImageView对象
				imageView = new ImageView(context);
				// 设置ImageView对象布局
				imageView.setLayoutParams(new GridView.LayoutParams(45, 45));
				// 设置边界对齐
				imageView.setAdjustViewBounds(false);
				// 设置刻度类型
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				// 设置间距
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}
			// 为ImageView设置图片资源
			imageView.setImageResource(imgs[position]);
			return imageView;
		}

	}
}