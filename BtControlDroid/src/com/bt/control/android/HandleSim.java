package com.bt.control.android;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class HandleSim.
 */
public class HandleSim implements OnTouchListener {

	/** The H button up. */
	public Button HButtonUp;

	/** The H button down. */
	public Button HButtonDown;

	/** The H button left. */
	public Button HButtonLeft;

	/** The H button right. */
	public Button HButtonRight;

	/** The H button a. */
	public Button HButtonA;

	/** The H button b. */
	public Button HButtonB;

	/** The H switch. */
	public SeekBar HSwitch;

	/** The H text. */
	public TextView HText;

	/** The open. */
	public boolean open = false;

	/** The comm. */
	private final Communication comm;

	/** The Constant ENTER. */
	public static final byte ENTER = 0;

	/** The Constant UP. */
	public static final byte UP = 1;

	/** The Constant DOWN. */
	public static final byte DOWN = 2;

	/** The Constant LEFT. */
	public static final byte LEFT = 3;

	/** The Constant RIGHT. */
	public static final byte RIGHT = 4;

	/** The Constant A. */
	public static final byte A = 5;

	/** The Constant B. */
	public static final byte B = 6;

	/** The Constant HOLD. */
	public static final byte HOLD = 1;

	/** The Constant RELEASED. */
	public static final byte RELEASED = 2;

	/**
	 * Instantiates a new handle sim.
	 * 
	 * @param c
	 *            the c
	 */
	public HandleSim(Communication c) {
		comm = c;
	}

	/**
	 * Startto sim.
	 */
	public void StarttoSim() {
		HSwitch.setVisibility(SeekBar.VISIBLE);
		HText.setText("Slide to Enable");

		HButtonUp.setOnTouchListener(this);
		HButtonDown.setOnTouchListener(this);
		HButtonLeft.setOnTouchListener(this);
		HButtonRight.setOnTouchListener(this);
		HButtonA.setOnTouchListener(this);
		HButtonB.setOnTouchListener(this);

		HSwitch.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				if (progress == seekBar.getMax()) {
					HButtonUp.setEnabled(true);
					HButtonDown.setEnabled(true);
					HButtonLeft.setEnabled(true);
					HButtonRight.setEnabled(true);
					HButtonA.setEnabled(true);
					HButtonB.setEnabled(true);
					open = true;
				}
			
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnTouchListener#onTouch(android.view.View,
	 * android.view.MotionEvent)
	 */
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub

		return false;
	}

}
