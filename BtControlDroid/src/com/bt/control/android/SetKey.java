/**
 * 
 */
package com.bt.control.android;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;

// TODO: Auto-generated Javadoc
/**
 * The Class SetKey.
 * 
 * @author Sunken
 */
public class SetKey extends Activity {

	/** The spinner up. */
	private Spinner sUp;

	/** The spinner down. */
	private Spinner sDown;

	/** The spinner left. */
	private Spinner sLeft;

	/** The spinner right. */
	private Spinner sRight;

	/** The spinner a. */
	private Spinner sA;

	/** The spinner b. */
	private Spinner sB;

	/** The spinner enter. */
	private Spinner sEnter;

	/** The mouse seekbar. */
	private SeekBar mousesb;

	/** The button ok. */
	private Button bOK;

	/** The button cancel. */
	private Button bCancel;

	/** The Key up. */
	private int KeyUp;

	/** The Key down. */
	private int KeyDown;

	/** The Key left. */
	private int KeyLeft;

	/** The Key right. */
	private int KeyRight;

	/** The Key a. */
	private int KeyA;

	/** The Key b. */
	private int KeyB;

	/** The Key enter. */
	private int KeyEnter;

	/** The shared preferences key. */
	private SharedPreferences rkey;

	/** The shared preferences editor. */
	private SharedPreferences.Editor editor;

	/** The Key list. */
	ArrayList<String> KeyList = new ArrayList<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setkey);

		rkey = getSharedPreferences("SaveKey", MODE_PRIVATE);
		editor = rkey.edit();

		sUp = (Spinner) findViewById(R.id.SpinnerUp);
		sDown = (Spinner) findViewById(R.id.SpinnerDown);
		sLeft = (Spinner) findViewById(R.id.SpinnerLeft);
		sRight = (Spinner) findViewById(R.id.SpinnerRight);
		sA = (Spinner) findViewById(R.id.SpinnerA);
		sB = (Spinner) findViewById(R.id.SpinnerB);
		sEnter = (Spinner) findViewById(R.id.SpinnerEnter);
		mousesb = (SeekBar) findViewById(R.id.mouseSet);

		bOK = (Button) findViewById(R.id.ButtonSetOk);
		bCancel = (Button) findViewById(R.id.ButtonSetCancel);

		ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,
				R.array.list, android.R.layout.simple_spinner_item);
		ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		sUp.setAdapter(ad);
		sDown.setAdapter(ad);
		sLeft.setAdapter(ad);
		sRight.setAdapter(ad);
		sA.setAdapter(ad);
		sB.setAdapter(ad);
		sEnter.setAdapter(ad);

		sUp.setSelection(rkey.getInt("UpPos", -1));
		sDown.setSelection(rkey.getInt("DownPos", -1));
		sLeft.setSelection(rkey.getInt("LeftPos", -1));
		sRight.setSelection(rkey.getInt("RightPos", -1));
		sA.setSelection(rkey.getInt("APos", -1));
		sB.setSelection(rkey.getInt("BPos", -1));
		sEnter.setSelection(rkey.getInt("EnterPos", -1));

		mousesb.setProgress(rkey.getInt("mouseSet", 0));

		OnItemSelectedListener SpinnerListner = new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				// System.out.println(arg0.getId());
				switch (arg0.getId()) {
				case R.id.SpinnerUp:
					String sKeyUp = arg0.getItemAtPosition(arg2).toString();
					KeyUp = keycode.KeyCode.get(sKeyUp);
					break;
				case R.id.SpinnerDown:
					String sKeyDown = arg0.getItemAtPosition(arg2).toString();
					KeyDown = keycode.KeyCode.get(sKeyDown);
					break;
				case R.id.SpinnerLeft:
					String sKeyLeft = arg0.getItemAtPosition(arg2).toString();
					KeyLeft = keycode.KeyCode.get(sKeyLeft);
					break;
				case R.id.SpinnerRight:
					String sKeyRight = arg0.getItemAtPosition(arg2).toString();
					KeyRight = keycode.KeyCode.get(sKeyRight);
					break;
				case R.id.SpinnerA:
					String sKeyA = arg0.getItemAtPosition(arg2).toString();
					KeyA = keycode.KeyCode.get(sKeyA);
					break;
				case R.id.SpinnerB:
					String sKeyB = arg0.getItemAtPosition(arg2).toString();
					KeyB = keycode.KeyCode.get(sKeyB);
					break;
				case R.id.SpinnerEnter:
					String sKeyEnter = arg0.getItemAtPosition(arg2).toString();
					KeyEnter = keycode.KeyCode.get(sKeyEnter);
					break;
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		};

		sUp.setOnItemSelectedListener(SpinnerListner);
		sDown.setOnItemSelectedListener(SpinnerListner);
		sLeft.setOnItemSelectedListener(SpinnerListner);
		sRight.setOnItemSelectedListener(SpinnerListner);
		sA.setOnItemSelectedListener(SpinnerListner);
		sB.setOnItemSelectedListener(SpinnerListner);
		sEnter.setOnItemSelectedListener(SpinnerListner);

		bOK.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				editor.putInt("keyup", KeyUp);
				editor.putInt("keydown", KeyDown);
				editor.putInt("keyleft", KeyLeft);
				editor.putInt("keyright", KeyRight);
				editor.putInt("keyA", KeyA);
				editor.putInt("keyB", KeyB);
				editor.putInt("keyEnter", KeyEnter);

				editor.putInt("UpPos",
						sUp.getPositionForView(sUp.getSelectedView()));
				editor.putInt("DownPos",
						sDown.getPositionForView(sDown.getSelectedView()));
				editor.putInt("LeftPos",
						sLeft.getPositionForView(sLeft.getSelectedView()));
				editor.putInt("RightPos",
						sRight.getPositionForView(sRight.getSelectedView()));
				editor.putInt("APos",
						sA.getPositionForView(sA.getSelectedView()));
				editor.putInt("BPos",
						sB.getPositionForView(sB.getSelectedView()));
				editor.putInt("EnterPos",
						sEnter.getPositionForView(sEnter.getSelectedView()));
				editor.putInt("mouseSet", mousesb.getProgress());
				editor.commit();

				Intent i = new Intent();
				setResult(Activity.RESULT_OK, i);
				finish();
			}

		});

		bCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				setResult(Activity.RESULT_CANCELED, i);
				finish();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Display display = getWindowManager().getDefaultDisplay();

		int width = 0;
		setViewWidth(mousesb, width - 60);
		setViewWidth(bOK, width / 2 - 40);
		setViewWidth(bCancel, width / 2 - 40);
	}

	/**
	 * Sets the view width.
	 * 
	 * @param view
	 *            the view
	 * @param width
	 *            the width
	 */
	private void setViewWidth(View view, int width) {
		LayoutParams params = view.getLayoutParams();
		params.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyDown(int code, KeyEvent event) {
		if (code == KeyEvent.KEYCODE_BACK) {
			Intent i = new Intent();
			setResult(Activity.RESULT_CANCELED, i);
			finish();
		}
		return super.onKeyDown(code, event);
	}
}
