package com.bt.control.android;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import android.app.Activity;
import android.app.TabActivity;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerClient.
 */
public class ControllerClient extends TabActivity implements
		OnTabChangeListener, OnKeyListener {

	/** The Constant KEY_SET. */
	public static final byte KEY_SET = 0;

	/** The Constant MOUSE_SIM. */
	public static final byte MOUSE_SIM = 1;

	/** The Constant KEY_SIM. */
	public static final byte KEY_SIM = 2;

	/** The Constant FN_SIM. */
	public static final byte FN_SIM = 3;

	/** The Constant HANDLE_SIM. */
	public static final byte HANDLE_SIM = 4;

	/** The Constant PAD_SIM. */
	public static final byte PAD_SIM = 5;

	/** The Left button lock. */
	public static boolean LeftButtonLock = false;

	// use to say key set
	/** The save. */
	public SharedPreferences save;

	/** The saveeditor. */
	public SharedPreferences.Editor saveeditor;

	// the sensation of the mouse function
	/** The mousesensation. */
	public int mousesensation;

	/** The maintab. */
	private TabHost maintab;

	public static int ctab;

	// classes used to remote control
	/** The comm. */
	private static Communication comm;

	/** The mouse simulation. */
	private MouseSim ms;

	/** The functions simulation. */
	private FnSim fs;

	/** The keyboard simulation. */
	private KeyboardSim ks;

	/** The handle simulation. */
	private HandleSim hs;

	/** The handler. */
	public Handler hn = new Handler() {
		@Override
		public void handleMessage(Message m) {
		}
	};

	/** The App title. */
	private TextView AppTitle;

	/** The Constant REQUEST_CONNECT_DEVICE. */
	private static final int REQUEST_CONNECT_DEVICE = 1;

	/** The Constant REQUEST_ENABLE_BT. */
	private static final int REQUEST_ENABLE_BT = 2;

	/** The Constant REQUEST_SET_KEY. */
	private static final int REQUEST_SET_KEY = 3;

	/** The Constant REQUEST_HELP. */
	private static final int REQUEST_HELP = 4;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.ActivityGroup#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

		save = getSharedPreferences("SaveKey", MODE_PRIVATE); // read the saved
																// setting keys

		// if this is the first time in booting app, it will create a server.jar
		// file in BT Controller folder
		if (!save.contains("first")) {
			saveeditor = save.edit();
			saveeditor.putInt("first", 1);
			saveeditor.commit();
			releaseFile();
		}

		// if no setting keys have been built, build them
		if (!save.contains("keyup")) {
			saveeditor = save.edit();
			keycode.SaveSetting(saveeditor);
		}

		maintab = this.getTabHost();
		// create all tabs
		create_tabhost();
		// set the title
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);

		comm = new Communication(hn);
		// if no bluetooth adapter, quit
		if (comm.btadapter == null) {
			Toast.makeText(this, "Bluetooth is not available",
					Toast.LENGTH_LONG).show();
			this.finish();
			return;

		}

		// if bluetooth device is not enabled ,quit
		if (!comm.btadapter.isEnabled()) {
			Intent enable = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enable, REQUEST_ENABLE_BT);
		}

		AppTitle = (TextView) findViewById(R.id.title_state);
	}

	/**
	 * Release file.
	 */
	public void releaseFile() {
		// get the state of sd card
		String sdstate = Environment.getExternalStorageState();
		if (sdstate.equals(Environment.MEDIA_MOUNTED)) {
			try {
				File sdfile = Environment.getExternalStorageDirectory();
				String dir = sdfile.getAbsolutePath() + File.separator
						+ "BT Controller";
				File dirfile = new File(dir);
				boolean flag = false;

				if (!dirfile.exists()) {
					flag = dirfile.mkdirs();
				}

				if (flag) {
					AssetManager am = getAssets();
					String[] files = am.list("");
					for (int i = 0; i < files.length; i++)
						if (files[i].contains(".")) {
							File myfile = new File(dir + File.separator
									+ files[i]);

							if (!myfile.exists())
								myfile.createNewFile();

							OutputStream out = new FileOutputStream(myfile);
							InputStream in;
							try {
								in = am.open(files[i]);
								byte[] buffer = new byte[1024];
								int length;
								while ((length = in.read(buffer)) > 0) {
									if (length == 1024)
										out.write(buffer);
									else
										out.write(buffer, 0, length);
								}
								in.close();
								out.close();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create_tabhost.
	 */
	private void create_tabhost() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		super.onStart();

		Display d = getWindowManager().getDefaultDisplay();
		int w = d.getWidth();
		int h = d.getHeight();

		ms = new MouseSim(comm);
		ms.panel = (Button) findViewById(R.id.panel);

		ks = new KeyboardSim(comm);
		ks.shift = (Button) findViewById(R.id.kShift);
		ks.alt = (Button) findViewById(R.id.kAlt);
		ks.ctrl = (Button) findViewById(R.id.kCtrl);

		fs = new FnSim(comm);
		fs.Play = (Button) findViewById(R.id.play);
		fs.Exit = (Button) findViewById(R.id.exit);
		fs.Pageup = (Button) findViewById(R.id.pageup);
		fs.Pagedown = (Button) findViewById(R.id.pagedown);
		fs.black = (Button) findViewById(R.id.black_switch);

		fs.mPlay = (Button) findViewById(R.id.play_switch);
		fs.Stop = (Button) findViewById(R.id.stop);
		fs.Volumeup = (Button) findViewById(R.id.volume_up);
		fs.Volumedown = (Button) findViewById(R.id.volume_down);
		fs.Mute = (Button) findViewById(R.id.mute);
		fs.Last = (Button) findViewById(R.id.last);
		fs.Next = (Button) findViewById(R.id.next);
		fs.Backward = (Button) findViewById(R.id.backward);
		fs.Forward = (Button) findViewById(R.id.forward);

		hs = new HandleSim(comm);
		hs.HButtonA = (Button) findViewById(R.id.Button_A);
		hs.HButtonB = (Button) findViewById(R.id.Button_B);
		hs.HButtonDown = (Button) findViewById(R.id.Button_Down);
		hs.HButtonUp = (Button) findViewById(R.id.Button_Up);
		hs.HButtonLeft = (Button) findViewById(R.id.Button_Left);
		hs.HButtonRight = (Button) findViewById(R.id.Button_Right);
		hs.HSwitch = (SeekBar) findViewById(R.id.handle_switch);
		hs.HText = (TextView) findViewById(R.id.switch_text);

		LayoutParams lp = ms.panel.getLayoutParams();
		lp.width = w;
		lp.height = h;
		ms.panel.setLayoutParams(lp);

		setViewWidth(ks.shift, (w - 20) / 3 - 4);
		setViewWidth(ks.alt, (w - 20) / 3 - 4);
		setViewWidth(ks.ctrl, (w - 20) / 3 - 4);

		setViewWidth(fs.Play, w / 2 - 20);
		setViewWidth(fs.Exit, w / 2 - 20);
		setViewWidth(fs.Pageup, w / 2 - 20);
		setViewWidth(fs.Pagedown, w / 2 - 20);
		setViewWidth(fs.black, w / 2 - 20);

		setViewWidth(fs.mPlay, w / 2 - 20);
		setViewWidth(fs.Stop, w / 2 - 20);
		setViewWidth(fs.Volumeup, (w - 20) / 3 - 4);
		setViewWidth(fs.Volumedown, (w - 20) / 3 - 4);
		setViewWidth(fs.Mute, (w - 20) / 3 - 4);
		setViewWidth(fs.Last, w / 2 - 20);
		setViewWidth(fs.Next, w / 2 - 20);
		setViewWidth(fs.Backward, w / 2 - 20);
		setViewWidth(fs.Forward, w / 2 - 20);

		setViewWidth(hs.HButtonA, 60);
		setViewWidth(hs.HButtonB, 60);
		setViewWidth(hs.HButtonDown, 60);
		setViewWidth(hs.HButtonUp, 60);
		setViewWidth(hs.HButtonLeft, 60);
		setViewWidth(hs.HButtonRight, 60);
		setViewWidth(hs.HSwitch, w / 2 - 20);
	}

	/**
	 * Sets the view width.
	 * 
	 * @param v
	 *            the v
	 * @param w
	 *            the w
	 */
	private void setViewWidth(View v, int w) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu m) {
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.option, m);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem mi) {
		return false;
	}

	/**
	 * Creates the sim.
	 */
	private void CreateSim() {
		// transfer the key setting
		TransSetKey();

		// initialize mouse simulate
		ms.StartSim();

		// initialize fn simulate
		fs.StartSim();

		// initialize handler simulate
		hs.StarttoSim();
	}

	// use to send the key set data to the server
	/**
	 * Trans set key.
	 */
	private void TransSetKey() {
		// TODO Auto-generated method stub
		byte[] b = new byte[33];
		b[0] = KEY_SET;
		byte[][] trans = new byte[8][4];

		TransferKey(save.getInt("keyup", -1), trans[0]);
		TransferKey(save.getInt("keydown", -1), trans[1]);
		TransferKey(save.getInt("keyleft", -1), trans[2]);
		TransferKey(save.getInt("keyright", -1), trans[3]);
		TransferKey(save.getInt("keyA", -1), trans[4]);
		TransferKey(save.getInt("keyB", -1), trans[5]);
		TransferKey(save.getInt("keyEnter", -1), trans[6]);

		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.position(0);
		buffer.putFloat((float) (0.5 * (save.getInt("mouseSet", -1) + 2)));
		buffer.position(0);
		buffer.get(trans[7]);

		for (int i = 0; i < 32;) {
			for (int j = 0; j < 4; j++) {
				b[i + 1] = trans[i / 4][j];
				i++;
			}
		}

		comm.writeData(b);
	}

	// put integer keycode into byte array which is used to transfer to the
	// server through bluetooth
	/**
	 * Transfer key.
	 * 
	 * @param keycode
	 *            the keycode
	 * @param trans
	 *            the trans
	 */
	public void TransferKey(int keycode, byte[] trans) {

	}

	// handle the result when the program comes back to the main activity from
	// other activities
	// two other activities : device list and set keys panel
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onActivityResult(int, int,
	 * android.content.Intent)
	 */
	@Override
	public void onActivityResult(int reqCode, int resCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(reqCode, resCode, data);
		switch (reqCode) {
		case REQUEST_CONNECT_DEVICE:
			if (resCode == Activity.RESULT_OK) {
				// Get the device MAC address
				String address = data.getExtras().getString(
						DeviceListActivity.EXTRA_DEVICE_ADDRESS);
				// Get the BLuetoothDevice object
				comm.CreateConn(address);
			}
			break;
		case REQUEST_ENABLE_BT:
			if (resCode == Activity.RESULT_CANCELED) {
				Toast.makeText(this, "Bluetooth is not enable",
						Toast.LENGTH_LONG).show();
				this.finish();
			}
			break;
		// once the modification is settled,send the key set to the server
		case REQUEST_SET_KEY:
			comm.pause();
			if (resCode == Activity.RESULT_OK) {
				if (comm.state == Communication.CONNECTED)
					TransSetKey();
			}
			break;
		case REQUEST_HELP:
			if (comm != null)
				comm.pause();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onKeyLongPress(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyLongPress(keyCode, event);
	}

	// quit the program when push back button
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onKeyUp(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_CALL) {
			if (ms != null)
				ms.onSingleTapConfirmed(null);
			LeftButtonLock = false;
			return true;
		}
		if (keyCode == KeyEvent.KEYCODE_BACK)
			this.finish();
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.ActivityGroup#onDestroy()
	 */
	@Override
	protected void onDestroy() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.DialogInterface.OnKeyListener#onKey(android.content.
	 * DialogInterface, int, android.view.KeyEvent)
	 */
	public boolean onKey(DialogInterface arg0, int arg1, KeyEvent arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
	 */
	public void onTabChanged(String arg0) {

	}

	public static Communication getComm() {
		return comm;
	}
}