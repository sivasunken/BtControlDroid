package com.bt.control.android;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// TODO: Auto-generated Javadoc
/**
 * The Class DeviceListActivity.
 */
public class DeviceListActivity extends Activity {

	/** The EXTR a_ devic e_ address. */
	public static String EXTRA_DEVICE_ADDRESS = "device_address";

	/** The bta. */
	private BluetoothAdapter bta;

	/** The paireddev. */
	private ArrayAdapter<String> paireddev;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);

		// Setup the window
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.connect);

		// Set result CANCELED in case user backs out
		setResult(Activity.RESULT_CANCELED);

		// Initialize array adapters for parired devices
		paireddev = new ArrayAdapter<String>(this, R.layout.device);

		// Find and Set up ListView for paired devices
		ListView pairlv = (ListView) findViewById(R.id.paired_devices);
		pairlv.setAdapter(paireddev);

		// get local bt adapter
		bta = BluetoothAdapter.getDefaultAdapter();

		// get set of currently paired devices

		Set<BluetoothDevice> pds = bta.getBondedDevices();

		// if there are paired devices, add each one to array
		if (pds.size() > 0) {
			pairlv.setOnItemClickListener(devcl);
			for (BluetoothDevice d : pds)
				paireddev.add(d.getName() + "\n" + d.getAddress());
		} else {
			String nodev = getResources().getText(R.string.none_paired)
					.toString();
			paireddev.add(nodev);
		}
	}

	/** The devcl. */
	private final OnItemClickListener devcl = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {

		}

	};
}
