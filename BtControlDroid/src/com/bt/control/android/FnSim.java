/**
 * 
 */
package com.bt.control.android;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

// TODO: Auto-generated Javadoc
/**
 * The Class FnSim.
 * 
 * @author Sunken
 */
public class FnSim implements OnClickListener {

	/** The Play. */
	public Button Play;

	/** The Exit. */
	public Button Exit;

	/** The Pageup. */
	public Button Pageup;

	/** The Pagedown. */
	public Button Pagedown;

	/** The black. */
	public Button black;

	/** The m play. */
	public Button mPlay;

	/** The Stop. */
	public Button Stop;

	/** The Volumeup. */
	public Button Volumeup;

	/** The Volumedown. */
	public Button Volumedown;

	/** The Mute. */
	public Button Mute;

	/** The Last. */
	public Button Last;

	/** The Next. */
	public Button Next;

	/** The Backward. */
	public Button Backward;

	/** The Forward. */
	public Button Forward;

	// indicate the general command type
	/** The Constant PPT. */
	public static final byte PPT = 1;

	/** The Constant MP. */
	public static final byte MP = 2;

	/** The Constant PLAY. */
	public static final byte PLAY = 1;

	/** The Constant EXIT. */
	public static final byte EXIT = 2;

	/** The Constant PAGEUP. */
	public static final byte PAGEUP = 3;

	/** The Constant PAGEDOWN. */
	public static final byte PAGEDOWN = 4;

	/** The Constant BLACK. */
	public static final byte BLACK = 5;

	/** The Constant MPLAY. */
	public static final byte MPLAY = 1;

	/** The Constant STOP. */
	public static final byte STOP = 2;

	/** The Constant VOLUMEUP. */
	public static final byte VOLUMEUP = 3;

	/** The Constant VOLUMEDOWN. */
	public static final byte VOLUMEDOWN = 4;

	/** The Constant MUTE. */
	public static final byte MUTE = 5;

	/** The Constant LAST. */
	public static final byte LAST = 6;

	/** The Constant NEXT. */
	public static final byte NEXT = 7;

	/** The Constant BACKWARD. */
	public static final byte BACKWARD = 8;

	/** The Constant FORWARD. */
	public static final byte FORWARD = 9;

	/** The comm. */
	private final Communication comm;

	/**
	 * Instantiates a new fn sim.
	 * 
	 * @param c
	 *            the c
	 */
	public FnSim(Communication c) {
		comm = c;
	}

	/**
	 * Start sim.
	 */
	public void StartSim() {
		Play.setOnClickListener(this);
		Exit.setOnClickListener(this);
		Pageup.setOnClickListener(this);
		Pagedown.setOnClickListener(this);
		black.setOnClickListener(this);

		mPlay.setOnClickListener(this);
		Stop.setOnClickListener(this);
		Volumeup.setOnClickListener(this);
		Volumedown.setOnClickListener(this);
		Mute.setOnClickListener(this);
		Last.setOnClickListener(this);
		Next.setOnClickListener(this);
		Backward.setOnClickListener(this);
		Forward.setOnClickListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the enable.
	 * 
	 * @param e
	 *            the new enable
	 */
	public void setEnable(boolean e) {
		Play.setEnabled(e);
		Exit.setEnabled(e);
		Pageup.setEnabled(e);
		Pagedown.setEnabled(e);
		black.setEnabled(e);

		mPlay.setEnabled(e);
		Stop.setEnabled(e);
		Volumeup.setEnabled(e);
		Volumedown.setEnabled(e);
		Mute.setEnabled(e);
		Last.setEnabled(e);
		Next.setEnabled(e);
		Backward.setEnabled(e);
		Forward.setEnabled(e);
	}
}
