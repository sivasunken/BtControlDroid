/**
 * 
 */
package com.bt.control.android;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;

// TODO: Auto-generated Javadoc
/**
 * The Class KeyboardSim.
 * 
 * @author Sunken
 */
public class KeyboardSim implements OnKeyListener, OnClickListener {
	// Different types of Keys
	/** The Constant RESERVED. */
	public static final byte RESERVED = 0;

	/** The comm. */
	Communication comm;

	/** The et. */
	EditText et;

	/** The shift. */
	public Button shift;

	/** The alt. */
	public Button alt;

	/** The ctrl. */
	public Button ctrl;

	/** The Constant SHIFT. */
	public static final byte SHIFT = 0;

	/** The Constant ALT. */
	public static final byte ALT = 1;

	/** The Constant CTRL. */
	public static final byte CTRL = 2;

	/**
	 * Instantiates a new keyboard sim.
	 * 
	 * @param c
	 *            the c
	 */
	public KeyboardSim(Communication c) {
		comm = c;
	}

	/**
	 * Start sim.
	 * 
	 * @param e
	 *            the e
	 */
	public void StartSim(EditText e) {
		et = e;
		et.setOnKeyListener(this);
		shift.setOnClickListener(this);
		alt.setOnClickListener(this);
		ctrl.setOnClickListener(this);
	}

	/**
	 * Sets the enable.
	 * 
	 * @param b
	 *            the b
	 */
	public void SetEnable(boolean b) {
		shift.setEnabled(b);
		alt.setEnabled(b);
		ctrl.setEnabled(b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnKeyListener#onKey(android.view.View, int,
	 * android.view.KeyEvent)
	 */
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View v) {
		// TODO Auto-generated method stub
		byte[] b = new byte[4];
		b[0] = ControllerClient.KEY_SIM;

		switch (v.getId()) {
		case R.id.kShift:
			b[1] = 1;
			b[2] = SHIFT;
			b[3] = 0;
			break;
		case R.id.kAlt:
			b[1] = 1;
			b[2] = ALT;
			b[3] = 0;
			break;
		case R.id.kCtrl:
			b[1] = 1;
			b[2] = CTRL;
			b[3] = 0;
			break;
		}
		comm.writeData(b);
	}

}
