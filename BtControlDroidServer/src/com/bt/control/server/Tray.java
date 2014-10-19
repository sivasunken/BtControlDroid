package com.bt.control.server;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.net.URL;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class Tray.
 */
public class Tray {

	/** The tray. */
	private SystemTray tray = null;

	/** The icon. */
	private TrayIcon icon = null;

	/** The exit. */
	private final MenuItem exit = new MenuItem("Exit");

	/** The about. */
	private final MenuItem about = new MenuItem("About");

	/**
	 * Instantiates a new tray.
	 */
	public Tray() {
		tray = SystemTray.getSystemTray();
		URL iurl = BluetoothServer.class.getResource("icon.jpg");

		ImageIcon i = new ImageIcon(iurl);
		PopupMenu menu = new PopupMenu();
		menu.add(about);
		menu.add(exit);
		icon = new TrayIcon(i.getImage(), "running", menu);
		try {
			tray.add(icon);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddListener();
	}

	/**
	 * Adds the listener.
	 */
	private void AddListener() {

	}
}
