package com.bt.control.server;

import java.awt.AWTException;
import java.awt.Robot;

// TODO: Auto-generated Javadoc
/**
 * The Class Executor.
 */
public class Executor {

	/** The robot for automating commands. */
	private static Robot r;

	/**
	 * Instantiates a new executor.
	 */
	public Executor() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Key click simulation.
	 * 
	 * @param key
	 *            the key on the keyboard to simulate. Simulates a key click
	 */
	public void KeyClickSim(int key) {

	}

	/**
	 * Key press.
	 * 
	 * @param key
	 *            the key on the keyboard to press and hold
	 */
	public void KeyPress(int key) {
		r.keyPress(key);
	}

	/**
	 * Key release.
	 * 
	 * @param key
	 *            the key on the keyboard to release
	 */
	public void KeyRelease(int key) {
		r.keyRelease(key);
	}

	/**
	 * Mouse click simulation.
	 * 
	 * @param button
	 *            the button on the mouse to simulate
	 */
	public void MouseClickSim(int button) {
		r.mousePress(button);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.mouseRelease(button);
	}

	/**
	 * Mouse move.
	 * 
	 * @param x
	 *            the x parameter of the mouse
	 * @param y
	 *            the y parameter of the mouse
	 * @param std
	 *            the factor to move the mouse
	 * @param data
	 *            the data from the phone
	 */
	public void MouseMove(double x, double y, double std, byte[] data) {

	}
}
