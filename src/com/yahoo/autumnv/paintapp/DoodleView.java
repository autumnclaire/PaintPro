package com.yahoo.autumnv.paintapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DoodleView extends View {
	private class PaintPath {
		private Paint paint;
		private Path path;

		public PaintPath(Path path, Paint paint) {
			this.path = path;
			this.paint = paint;
		}

		public Paint getPaint() {
			return paint;
		}

		public Path getPath() {
			return path;
		}

	}


	private List<PaintPath> paintPaths = new ArrayList<PaintPath>();
	private DoodleActivity doodleActivity;
	private PaintPath currentPaintPath;

	public DoodleView(Context context) {
		super(context);
		doodleActivity = (DoodleActivity)context;
	}

	//This constructor is called if there is no style attribute; called by inflater
	public DoodleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// Here is where you load and store the attributes for the view
		doodleActivity = (DoodleActivity)context;

		paintPaths.add(setupPaintPath());
	}

	private PaintPath setupPaintPath() {
		Paint paint = new Paint();
		paint.setStyle(Style.STROKE);
		updateConfigurablePaintAttributes(paint);
		PaintPath paintPath = new PaintPath(new Path(), paint);
		return paintPath;
	}


	private void updateConfigurablePaintAttributes(Paint paint) {
		paint.setColor(doodleActivity.getCurrentColor());
		paint.setStrokeWidth(doodleActivity.getCurrentWidth());
	}

	//This constructor is called if a custom style is supplied; called by inflator
	public DoodleView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		//never initialize objects inside the onDraw method

		//Look at state (int, floats, text)
		//Use the state to create a visual representation
		//		canvas.drawCircle(50, 100, 100, paint);
		for (PaintPath paintPath : paintPaths) {
			canvas.drawPath(paintPath.getPath(), paintPath.getPaint());
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch(event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			currentPaintPath = setupPaintPath();
			paintPaths.add(currentPaintPath);
			currentPaintPath.getPath().moveTo(event.getX(), event.getY());
			postInvalidate();
			return true;
		case MotionEvent.ACTION_MOVE:
			currentPaintPath.getPath().lineTo(event.getX(), event.getY());
			postInvalidate();
			return true;
		case MotionEvent.ACTION_UP:
			return false;
		}
		return false;
	}

	public void clearAll() {
		this.paintPaths = new ArrayList<DoodleView.PaintPath>();
		postInvalidate();
	}


}
