package com.bt.control.server;

import java.awt.SystemTray;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class BluetoothServer.
 */
public class BluetoothServer {

	/**
	 * The OS Variable
	 * 
	 * 1: Windows; 2: Linux
	 */
	public static int os = 0;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments from the command line
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String osname = System.getProperty("os.name");
		if (!osname.contains("Windows")) {
			JOptionPane.showConfirmDialog(null,
					"Sorry! Please use a Windows OS. Implementation for "
							+ osname + " is on the process.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

		if (SystemTray.isSupported()) {
			@SuppressWarnings("unused")
			Tray tray = new Tray();
		}

		Communication comm = new Communication();
		comm.start();
	}

}
