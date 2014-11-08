package com.yahoo.autumnv.paintapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class DoodleActivity extends Activity {
	
	private enum DoodleColor {
		Red(Color.RED),
		Orange(Color.rgb(255, 162, 0)),
		Yellow(Color.YELLOW),
		Green(Color.GREEN),
		Blue(Color.BLUE),
		Purple(Color.rgb(162, 0, 255));
		
		private int color;
		private DoodleColor(int color) {
			this.color = color;
		}
		
		public int getColor() {
			return this.color;
		}
	}
	
	private enum DoodleWidth {
		Narrow(5),
		Medium(7),
		Wide(12);
		
		private int width;
		
		private DoodleWidth(int width) {
			this.width = width;
		}
		
		public int getWidth() {
			return this.width;
		}
	}
	
	private DoodleColor currentColor = DoodleColor.Purple;
	private DoodleWidth currentWidth = DoodleWidth.Medium;
	private boolean shouldClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doodle);
    }
    
    public void onRedClick(View v) {
    	this.setCurrentColor(DoodleColor.Red);
    }
    
    public void onOrangeClick(View v) {
    	this.setCurrentColor(DoodleColor.Orange);
    }
    
    public void onYellowClick(View v) {
    	this.setCurrentColor(DoodleColor.Yellow);
    }
    
    public void onGreenClick(View v) {
    	this.setCurrentColor(DoodleColor.Green);
    }
    
    public void onBlueClick(View v) {
    	this.setCurrentColor(DoodleColor.Blue);
    }
    
    public void onPurpleClick(View v) {
    	this.setCurrentColor(DoodleColor.Purple);
    }
    
    public void onNarrowClick(View v) {
    	this.setCurrentWidth(DoodleWidth.Narrow);
    }
    
    public void onMediumClick(View v) {
    	this.setCurrentWidth(DoodleWidth.Medium);
    }
    
    public void onWideClick(View v) {
    	this.setCurrentWidth(DoodleWidth.Wide);
    }
    
    public void onClearClick(View v) {
    	DoodleView doodleView = (DoodleView)findViewById(R.id.doodleView1);
    	doodleView.clearAll();
    }

	public int getCurrentColor() {
		return currentColor.getColor();
	}

	public void setCurrentColor(DoodleColor currentColor) {
		this.currentColor = currentColor;
	}

	public int getCurrentWidth() {
		return currentWidth.getWidth();
	}

	public void setCurrentWidth(DoodleWidth currentWidth) {
		this.currentWidth = currentWidth;
	}
}
