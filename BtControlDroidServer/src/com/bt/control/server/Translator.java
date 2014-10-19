package com.bt.control.server;

import java.nio.ByteBuffer;

// TODO: Auto-generated Javadoc
/**
 * The Class Translator.
 */
public class Translator {

	/** The alt flag. */
	public static boolean altFlag = false;

	/** The ctrl flag. */
	public static boolean ctrlFlag = false;

	/** The MOUSe set. */
	public static float MOUSE_SET = 1;

	/** The shift flag. */
	public static boolean shiftFlag = false;

	/** The executor module. */
	private final Executor exec;

	/** The Key a. */
	private int KeyA = 0;

	/** The Key b. */
	private int KeyB = 0;

	/** The Key down. */
	private int KeyDown = 0;

	/** The Key enter. */
	private int KeyEnter = 0;

	/** The Key left. */
	private int KeyLeft = 0;
	/** The Key right. */
	private int KeyRight = 0;
	/** The Key up. */
	private int KeyUp = 0;

	/**
	 * Instantiates a new translator.
	 * 
	 * @param c
	 *            the c
	 */
	public Translator(Communication c) {
		exec = new Executor();
	}

	/**
	 * Media Player Auto Selector
	 * 
	 * @return the media 1. Zoom Media Player 2. Windows Media Player 3. VLC
	 *         Media Player
	 */
	public int getMedia() {
		// get current tasks from windows operation

		return 0;
	}

	/**
	 * Gets the PPT.
	 * 
	 * @return the PPT whether power point is open or not
	 */
	public boolean getPPT() {
		// get current tasks from windows operation

		return false;

	}

	/**
	 * Sets the key value.
	 * 
	 * @param trans
	 *            the trans
	 */
	public void SetKeyValue(byte[][] trans) {
		ByteBuffer bb = ByteBuffer.allocate(4);

		bb.position(0);
		bb.put(trans[0]);
		KeyUp = bb.getInt(0);

		bb.position(0);
		bb.put(trans[1]);
		KeyDown = bb.getInt(0);

		bb.position(0);
		bb.put(trans[2]);
		KeyLeft = bb.getInt(0);

		bb.position(0);
		bb.put(trans[3]);
		KeyRight = bb.getInt(0);

		bb.position(0);
		bb.put(trans[4]);
		KeyA = bb.getInt(0);

		bb.position(0);
		bb.put(trans[5]);
		KeyB = bb.getInt(0);

		bb.position(0);
		bb.put(trans[6]);
		KeyEnter = bb.getInt(0);

		bb.position(0);
		bb.put(trans[7]);
		MOUSE_SET = bb.getFloat(0);
	}

	/**
	 * Simulate.
	 * 
	 * @param data
	 *            the data
	 * @param length
	 *            the length
	 */
	public void Simulate(byte[] data, int length) {

	}
}
