/**
 * 
 */
package com.bt.control.android;

import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

// TODO: Auto-generated Javadoc
/**
 * The Class MouseSim.
 * 
 * @author Sunken
 */
public class MouseSim implements OnGestureListener, OnDoubleTapListener,
		OnKeyListener {
	// the button to touch,scroll or tap
	/** The Constant RESERVED. */
	public static final byte RESERVED = 0;

	/** The Constant SCROLL. */
	public static final byte SCROLL = 1;

	/** The Constant SINGLETAP. */
	public static final byte SINGLETAP = 2;

	/** The Constant DOUBLETAP. */
	public static final byte DOUBLETAP = 3;

	/** The Constant RB_LONGPRESS. */
	public static final byte RB_LONGPRESS = 4;

	/** The panel. */
	public Button panel;

	/** The gd. */
	private final GestureDetector gd = new GestureDetector(this);

	/** The comm. */
	private final Communication comm;

	/**
	 * Instantiates a new mouse sim.
	 * 
	 * @param c
	 *            the c
	 */
	public MouseSim(Communication c) {
		comm = c;
	}

	/**
	 * Start sim.
	 */
	public void StartSim() {
		panel.setLongClickable(true);
		gd.setIsLongpressEnabled(true);
		panel.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				return gd.onTouchEvent(arg1);
			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnDoubleTapListener#onDoubleTap(android.
	 * view.MotionEvent)
	 */
	public boolean onDoubleTap(MotionEvent arg0) {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnDoubleTapListener#onDoubleTapEvent(android
	 * .view.MotionEvent)
	 */
	public boolean onDoubleTapEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnDoubleTapListener#onSingleTapConfirmed
	 * (android.view.MotionEvent)
	 */
	public boolean onSingleTapConfirmed(MotionEvent arg0) {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.GestureDetector.OnGestureListener#onDown(android.view.
	 * MotionEvent)
	 */
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.GestureDetector.OnGestureListener#onFling(android.view.
	 * MotionEvent, android.view.MotionEvent, float, float)
	 */
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnGestureListener#onLongPress(android.view
	 * .MotionEvent)
	 */
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		byte[] b = new byte[4];
		b[0] = ControllerClient.MOUSE_SIM;
		b[1] = RB_LONGPRESS;
		b[2] = RESERVED;
		b[3] = RESERVED;
		comm.writeData(b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnGestureListener#onScroll(android.view.
	 * MotionEvent, android.view.MotionEvent, float, float)
	 */
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnGestureListener#onShowPress(android.view
	 * .MotionEvent)
	 */
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.view.GestureDetector.OnGestureListener#onSingleTapUp(android.
	 * view.MotionEvent)
	 */
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnKeyListener#onKey(android.view.View, int,
	 * android.view.KeyEvent)
	 */
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
