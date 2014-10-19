package com.bt.control.server;

import java.io.IOException;
import java.io.OutputStream;

import javax.bluetooth.LocalDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnectionNotifier;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class Communication. The class that creates the connection to the phone.
 * It uses the bluetooth to create a StreamConnection.
 * 
 * @author Sunken
 */
public class Communication extends Thread {

	/** The server to create connection */
	private StreamConnectionNotifier server = null;

	/** The local device */
	private LocalDevice locdev = null;

	/** The output stream of the StremConnection to send the data */
	private OutputStream os;

	/**
	 * The translator
	 * 
	 * @see com.bt.control.server.Translator
	 */
	private final Translator trans;

	/**
	 * Instantiates a new communication.
	 */
	public Communication() {
		try {
			setLocalDevice(LocalDevice.getLocalDevice());
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null,
					"no bluetooth device, please exit the system!", "warning",
					JOptionPane.CLOSED_OPTION);
			System.exit(0);
		}

		try {
			server = (StreamConnectionNotifier) Connector
					.open("btspp://localhost:0000110100001000800000805F9B34FB");
		} catch (Exception e) {
			JOptionPane
					.showConfirmDialog(
							null,
							"bluetooth service is not available, please exit the system!",
							"warning", JOptionPane.CLOSED_OPTION);
			System.exit(0);
		}
		trans = new Translator(this);
	}

	/**
	 * Gets the local device.
	 * 
	 * @return locdev Current Local Device value
	 */
	public LocalDevice getLocalDevice() {
		return locdev;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

	}

	/**
	 * Send data.
	 * 
	 * @param data
	 *            the data to send to the phone
	 */
	public void SendData(byte[] data) {
		if (os != null) {
			try {
				os.write(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Sets the local device.
	 * 
	 * @param ld
	 *            the new local device to be set
	 */
	public void setLocalDevice(LocalDevice ld) {
		locdev = ld;
	}
}
