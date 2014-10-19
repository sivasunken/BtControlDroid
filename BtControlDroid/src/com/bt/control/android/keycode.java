package com.bt.control.android;

import java.util.HashMap;

import android.content.SharedPreferences;

// TODO: Auto-generated Javadoc
/**
 * The Class keycode.
 */
public class keycode {

	/** The V k_ back space. */
	public static int VK_BACK_SPACE = 8;

	/** The V k_ tab. */
	public static int VK_TAB = 9; // tab

	/** The V k_ enter. */
	public static int VK_ENTER = 10; // Enter

	/** The V k_ shift. */
	public static int VK_SHIFT = 16; // shift

	/** The V k_ control. */
	public static int VK_CONTROL = 17; // Ctrl

	/** The V k_ alt. */
	public static int VK_ALT = 18; // Alt

	/** The V k_ cap s_ lock. */
	public static int VK_CAPS_LOCK = 20;

	/** The V k_ escape. */
	public static int VK_ESCAPE = 27; // Esc

	/** The V k_ space. */
	public static int VK_SPACE = 32; //

	/** The V k_ left. */
	public static int VK_LEFT = 37;

	/** The V k_ up. */
	public static int VK_UP = 38;

	/** The V k_ right. */
	public static int VK_RIGHT = 39;

	/** The V k_ down. */
	public static int VK_DOWN = 40;

	/** The V k_ comma. */
	public static int VK_COMMA = 44; // ,

	/** The V k_ minus. */
	public static int VK_MINUS = 45; // -

	/** The V k_ period. */
	public static int VK_PERIOD = 46; // .

	/** The V k_ slash. */
	public static int VK_SLASH = 47; // /

	// number key
	/** The V k_0. */
	public static int VK_0 = 48;

	/** The V k_1. */
	public static int VK_1 = 49;

	/** The V k_2. */
	public static int VK_2 = 50;

	/** The V k_3. */
	public static int VK_3 = 51;

	/** The V k_4. */
	public static int VK_4 = 52;

	/** The V k_5. */
	public static int VK_5 = 53;

	/** The V k_6. */
	public static int VK_6 = 54;

	/** The V k_7. */
	public static int VK_7 = 55;

	/** The V k_8. */
	public static int VK_8 = 56;

	/** The V k_9. */
	public static int VK_9 = 57;

	/** The V k_ semicolon. */
	public static int VK_SEMICOLON = 59; // ;

	/** The V k_ equals. */
	public static int VK_EQUALS = 61;
	// alpha key
	/** The V k_ a. */
	public static int VK_A = 65;

	/** The V k_ b. */
	public static int VK_B = 66;

	/** The V k_ c. */
	public static int VK_C = 67;

	/** The V k_ d. */
	public static int VK_D = 68;

	/** The V k_ e. */
	public static int VK_E = 69;

	/** The V k_ f. */
	public static int VK_F = 70;

	/** The V k_ g. */
	public static int VK_G = 71;

	/** The V k_ h. */
	public static int VK_H = 72;

	/** The V k_ i. */
	public static int VK_I = 73;

	/** The V k_ j. */
	public static int VK_J = 74;

	/** The V k_ k. */
	public static int VK_K = 75;

	/** The V k_ l. */
	public static int VK_L = 76;

	/** The V k_ m. */
	public static int VK_M = 77;

	/** The V k_ n. */
	public static int VK_N = 78;

	/** The V k_ o. */
	public static int VK_O = 79;

	/** The V k_ p. */
	public static int VK_P = 80;

	/** The V k_ q. */
	public static int VK_Q = 81;

	/** The V k_ r. */
	public static int VK_R = 82;

	/** The V k_ s. */
	public static int VK_S = 83;

	/** The V k_ t. */
	public static int VK_T = 84;

	/** The V k_ u. */
	public static int VK_U = 85;

	/** The V k_ v. */
	public static int VK_V = 86;

	/** The V k_ w. */
	public static int VK_W = 87;

	/** The V k_ x. */
	public static int VK_X = 88;

	/** The V k_ y. */
	public static int VK_Y = 89;

	/** The V k_ z. */
	public static int VK_Z = 90;

	/** The V k_ ope n_ bracket. */
	public static int VK_OPEN_BRACKET = 91; // [

	/** The V k_ bac k_ slash. */
	public static int VK_BACK_SLASH = 92; // \

	/** The V k_ clos e_ bracket. */
	public static int VK_CLOSE_BRACKET = 93; // ]

	// function key
	/** The V k_ f1. */
	public static int VK_F1 = 112;

	/** The V k_ f2. */
	public static int VK_F2 = 113;

	/** The V k_ f3. */
	public static int VK_F3 = 114;

	/** The V k_ f4. */
	public static int VK_F4 = 115;

	/** The V k_ f5. */
	public static int VK_F5 = 116;

	/** The V k_ f6. */
	public static int VK_F6 = 117;

	/** The V k_ f7. */
	public static int VK_F7 = 118;

	/** The V k_ f8. */
	public static int VK_F8 = 119;

	/** The V k_ f9. */
	public static int VK_F9 = 120;

	/** The V k_ f10. */
	public static int VK_F10 = 121;

	/** The V k_ f11. */
	public static int VK_F11 = 122;

	/** The V k_ f12. */
	public static int VK_F12 = 123;

	/** The V k_ quote. */
	public static int VK_QUOTE = 222;

	/** The Constant KeyCode. */
	public final static HashMap<String, Integer> KeyCode = new HashMap<String, Integer>();
	static {

		KeyCode.put("[", VK_OPEN_BRACKET);
		KeyCode.put("\\", VK_BACK_SLASH);
		KeyCode.put("]", VK_CLOSE_BRACKET);
		KeyCode.put("F1", VK_F1);
		KeyCode.put("F2", VK_F2);
		KeyCode.put("F3", VK_F3);
		KeyCode.put("F4", VK_F4);
		KeyCode.put("F5", VK_F5);
		KeyCode.put("F6", VK_F6);
		KeyCode.put("F7", VK_F7);
		KeyCode.put("F8", VK_F8);
		KeyCode.put("F9", VK_F9);
		KeyCode.put("F10", VK_F10);
		KeyCode.put("F11", VK_F11);
		KeyCode.put("F12", VK_F12);
		KeyCode.put("'", VK_QUOTE);
	}

	/**
	 * Save setting.
	 * 
	 * @param SaveEditor
	 *            the save editor
	 * @return true, if successful
	 */
	public static boolean SaveSetting(SharedPreferences.Editor SaveEditor) {
		SaveEditor.putInt("keyup", VK_UP);
		SaveEditor.putInt("keydown", VK_DOWN);
		SaveEditor.putInt("keyleft", VK_LEFT);
		SaveEditor.putInt("keyright", VK_RIGHT);
		SaveEditor.putInt("keyA", VK_Z);
		SaveEditor.putInt("keyB", VK_X);
		SaveEditor.putInt("keyEnter", VK_ENTER);

		SaveEditor.putInt("UpPos", 10);
		SaveEditor.putInt("DownPos", 12);
		SaveEditor.putInt("LeftPos", 9);
		SaveEditor.putInt("RightPos", 11);
		SaveEditor.putInt("APos", 54);
		SaveEditor.putInt("BPos", 52);
		SaveEditor.putInt("EnterPos", 2);

		SaveEditor.putInt("mouseSet", 0);

		SaveEditor.commit();
		return true;
	}
}
