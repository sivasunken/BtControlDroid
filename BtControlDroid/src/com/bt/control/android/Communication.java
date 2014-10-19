package com.bt.control.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class Communication. used to create connection between pc and cellphone
 * can initialize the connection can send data through bluetooth connection
 */
public class Communication {
	// 4 connection state
	/** The Constant UNCONNECT. */
	public final static int UNCONNECT = 0;

	/** The Constant CONNECTING. */
	public final static int CONNECTING = 1;

	/** The Constant CONNECTED. */
	public final static int CONNECTED = 2;

	/** The Constant HOLD. */
	public final static int HOLD = 3;

	// for creating bluetooth communication
	/** The Constant MY_UUID. */
	private static final UUID MY_UUID = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB");

	/** The state. */
	public int state;

	/** The bt adapter. */
	public BluetoothAdapter btadapter;

	/** The connection thread. */
	private ConnectThread ct;

	/** The communication thread. */
	private CommThread cmt;

	/** The handler. */
	public Handler hn;

	/**
	 * Instantiates a new communication.
	 * 
	 * @param h
	 *            the handler
	 */
	public Communication(Handler h) {
		hn = h;
		btadapter = BluetoothAdapter.getDefaultAdapter();
		state = UNCONNECT;
	}

	/**
	 * Creates the conn.
	 * 
	 * @param DeviceAddress
	 *            the device address
	 */
	public synchronized void CreateConn(String DeviceAddress) {

	}

	/**
	 * Creates the comm.
	 * 
	 * @param socket
	 *            the socket
	 * @param device
	 *            the device
	 */
	public synchronized void CreateComm(BluetoothSocket socket,
			BluetoothDevice device) {
		// Cancel the thread that completed the connection
		if (ct != null) {
			ct.cancel();
			ct = null;
		}

		// Cancel any thread currently running a connection
		if (cmt != null) {
			cmt.cancel();
			cmt = null;
		}

		// Start the thread to manage the connection and perform transmissions
		cmt = new CommThread(socket);
		cmt.start();

		// Send the name of the connected device back to the UI Activity
		Message msg = hn.obtainMessage(1);
		Bundle bundle = new Bundle();
		bundle.putString("warning", "connect to " + device.getName()
				+ " successfully");
		msg.setData(bundle);
		hn.sendMessage(msg);
		state = CONNECTED;
	}

	/**
	 * Stop.
	 */
	public synchronized void stop() {

	}

	/**
	 * Pause.
	 */
	public synchronized void pause() {
		if (state == CONNECTED)
			state = HOLD;
		else if (state == HOLD)
			state = CONNECTED;
	}

	/**
	 * Write data.
	 * 
	 * @param data
	 *            the data
	 */
	public void writeData(byte[] data) {

	}

	/**
	 * Connection failed.
	 */
	public void connectionFailed() {
		state = UNCONNECT;
		// Send a failure message back to the Activity
		Message msg = hn.obtainMessage(3);
		Bundle bundle = new Bundle();
		bundle.putString("warning", "Unable to connect device");
		msg.setData(bundle);
		hn.sendMessage(msg);
	}

	/**
	 * Connection lost.
	 */
	public void connectionLost() {

	}

	/**
	 * The Class ConnectThread.
	 */
	public class ConnectThread extends Thread {

		/** The bts. */
		private final BluetoothSocket bts;

		/** The btd. */
		private final BluetoothDevice btd;

		/**
		 * Instantiates a new connect thread.
		 * 
		 * @param DeviceAddress
		 *            the device address
		 */
		public ConnectThread(String DeviceAddress) {
			btd = btadapter.getRemoteDevice(DeviceAddress);
			BluetoothSocket tmp = null;
			try {
				tmp = btd.createRfcommSocketToServiceRecord(MY_UUID);
			} catch (IOException e) {
				e.printStackTrace();
			}
			bts = tmp;
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
		 * Cancel.
		 */
		public void cancel() {
			try {
				bts.close();
			} catch (IOException e) {

			}
		}
	}

	/**
	 * The Class CommThread.
	 */
	public class CommThread extends Thread {

		/** The comm socket. */
		private final BluetoothSocket bts;

		/** The comm in stream. */
		private InputStream cis;

		/** The comm out stream. */
		private OutputStream cos;

		/**
		 * Instantiates a new comm thread.
		 * 
		 * @param mSocket
		 *            the m socket
		 */
		public CommThread(BluetoothSocket mSocket) {
			bts = null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Read();
			try {
				cis.close();
				cos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cancel();
			cmt = null;
		}

		/**
		 * Write.
		 * 
		 * @param sendbt
		 *            the sendbt
		 */
		public void Write(byte[] sendbt) {

		}

		/**
		 * Read.
		 */
		public void Read() {
			byte[] buffer = new byte[1024];
			while (true) {
				try {
					// Read from the InputStream
					cis.read(buffer);
					if (buffer[0] != 0)
						hn.sendEmptyMessage(6);
					else
						hn.sendEmptyMessage(7);
				} catch (IOException e) {
					connectionLost();
					break;
				}
			}
		}

		/**
		 * Cancel.
		 */
		public void cancel() {

		}
	}
}
