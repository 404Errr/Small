package typist;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Keyboard {
	private static String type =
			"The brown current ran swiftly out of the heart of darkness, bearing us down towards the sea with twice the speed of our upward progress; and Kurtz's life was running swiftly too, ebbing, ebbing out of his heart into the sea of inexorable time."
	;

	private Robot bot;

	public static void main(String... args) throws Exception {
		Keyboard keyboard = new Keyboard();
		Thread.sleep(1000);
		keyboard.type(type);
	}

	public Keyboard() throws AWTException {
		this.bot = new Robot();
	}

	public Keyboard(Robot robot) {
		this.bot = robot;
	}

	public void type(CharSequence chars) {
		for (int i = 0;i<chars.length();i++) {
			char character = chars.charAt(i);
			type(character);
		}
	}

	public void type(char character) {
		switch (character) {
		case 'a': type(KeyEvent.VK_A); break;
		case 'b': type(KeyEvent.VK_B); break;
		case 'c': type(KeyEvent.VK_C); break;
		case 'd': type(KeyEvent.VK_D); break;
		case 'e': type(KeyEvent.VK_E); break;
		case 'f': type(KeyEvent.VK_F); break;
		case 'g': type(KeyEvent.VK_G); break;
		case 'h': type(KeyEvent.VK_H); break;
		case 'i': type(KeyEvent.VK_I); break;
		case 'j': type(KeyEvent.VK_J); break;
		case 'k': type(KeyEvent.VK_K); break;
		case 'l': type(KeyEvent.VK_L); break;
		case 'm': type(KeyEvent.VK_M); break;
		case 'n': type(KeyEvent.VK_N); break;
		case 'o': type(KeyEvent.VK_O); break;
		case 'p': type(KeyEvent.VK_P); break;
		case 'q': type(KeyEvent.VK_Q); break;
		case 'r': type(KeyEvent.VK_R); break;
		case 's': type(KeyEvent.VK_S); break;
		case 't': type(KeyEvent.VK_T); break;
		case 'u': type(KeyEvent.VK_U); break;
		case 'v': type(KeyEvent.VK_V); break;
		case 'w': type(KeyEvent.VK_W); break;
		case 'x': type(KeyEvent.VK_X); break;
		case 'y': type(KeyEvent.VK_Y); break;
		case 'z': type(KeyEvent.VK_Z); break;
		case 'A': type(KeyEvent.VK_SHIFT, KeyEvent.VK_A); break;
		case 'B': type(KeyEvent.VK_SHIFT, KeyEvent.VK_B); break;
		case 'C': type(KeyEvent.VK_SHIFT, KeyEvent.VK_C); break;
		case 'D': type(KeyEvent.VK_SHIFT, KeyEvent.VK_D); break;
		case 'E': type(KeyEvent.VK_SHIFT, KeyEvent.VK_E); break;
		case 'F': type(KeyEvent.VK_SHIFT, KeyEvent.VK_F); break;
		case 'G': type(KeyEvent.VK_SHIFT, KeyEvent.VK_G); break;
		case 'H': type(KeyEvent.VK_SHIFT, KeyEvent.VK_H); break;
		case 'I': type(KeyEvent.VK_SHIFT, KeyEvent.VK_I); break;
		case 'J': type(KeyEvent.VK_SHIFT, KeyEvent.VK_J); break;
		case 'K': type(KeyEvent.VK_SHIFT, KeyEvent.VK_K); break;
		case 'L': type(KeyEvent.VK_SHIFT, KeyEvent.VK_L); break;
		case 'M': type(KeyEvent.VK_SHIFT, KeyEvent.VK_M); break;
		case 'N': type(KeyEvent.VK_SHIFT, KeyEvent.VK_N); break;
		case 'O': type(KeyEvent.VK_SHIFT, KeyEvent.VK_O); break;
		case 'P': type(KeyEvent.VK_SHIFT, KeyEvent.VK_P); break;
		case 'Q': type(KeyEvent.VK_SHIFT, KeyEvent.VK_Q); break;
		case 'R': type(KeyEvent.VK_SHIFT, KeyEvent.VK_R); break;
		case 'S': type(KeyEvent.VK_SHIFT, KeyEvent.VK_S); break;
		case 'T': type(KeyEvent.VK_SHIFT, KeyEvent.VK_T); break;
		case 'U': type(KeyEvent.VK_SHIFT, KeyEvent.VK_U); break;
		case 'V': type(KeyEvent.VK_SHIFT, KeyEvent.VK_V); break;
		case 'W': type(KeyEvent.VK_SHIFT, KeyEvent.VK_W); break;
		case 'X': type(KeyEvent.VK_SHIFT, KeyEvent.VK_X); break;
		case 'Y': type(KeyEvent.VK_SHIFT, KeyEvent.VK_Y); break;
		case 'Z': type(KeyEvent.VK_SHIFT, KeyEvent.VK_Z); break;
		case '`': type(KeyEvent.VK_BACK_QUOTE); break;
		case '0': type(KeyEvent.VK_0); break;
		case '1': type(KeyEvent.VK_1); break;
		case '2': type(KeyEvent.VK_2); break;
		case '3': type(KeyEvent.VK_3); break;
		case '4': type(KeyEvent.VK_4); break;
		case '5': type(KeyEvent.VK_5); break;
		case '6': type(KeyEvent.VK_6); break;
		case '7': type(KeyEvent.VK_7); break;
		case '8': type(KeyEvent.VK_8); break;
		case '9': type(KeyEvent.VK_9); break;
		case '-': type(KeyEvent.VK_MINUS); break;
		case '=': type(KeyEvent.VK_EQUALS); break;
		case '~': type(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE); break;
		case '!': type(KeyEvent.VK_SHIFT, KeyEvent.VK_1); break;
		case '@': type(KeyEvent.VK_AT); break;
		case '#': type(KeyEvent.VK_NUMBER_SIGN); break;
		case '$': type(KeyEvent.VK_DOLLAR); break;
		case '%': type(KeyEvent.VK_SHIFT, KeyEvent.VK_5); break;
		case '^': type(KeyEvent.VK_CIRCUMFLEX); break;
		case '&': type(KeyEvent.VK_AMPERSAND); break;
		case '*': type(KeyEvent.VK_ASTERISK); break;
		case '(': type(KeyEvent.VK_LEFT_PARENTHESIS); break;
		case ')': type(KeyEvent.VK_RIGHT_PARENTHESIS); break;
		case '_': type(KeyEvent.VK_UNDERSCORE); break;
		case '+': type(KeyEvent.VK_PLUS); break;
		case '\t': type(KeyEvent.VK_TAB); break;
		case '\n': type(KeyEvent.VK_ENTER); break;
		case '[': type(KeyEvent.VK_OPEN_BRACKET); break;
		case ']': type(KeyEvent.VK_CLOSE_BRACKET); break;
		case '\\': type(KeyEvent.VK_BACK_SLASH); break;
		case '{': type(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET); break;
		case '}': type(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET); break;
		case '|': type(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH); break;
		case ';': type(KeyEvent.VK_SEMICOLON); break;
		case ':': type(KeyEvent.VK_COLON); break;
		case '\'': type(KeyEvent.VK_QUOTE); break;
		case '"': type(KeyEvent.VK_QUOTEDBL); break;
		case ',': type(KeyEvent.VK_COMMA); break;
		case '<': type(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA); break;
		case '.': type(KeyEvent.VK_PERIOD); break;
		case '>': type(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD); break;
		case '/': type(KeyEvent.VK_SLASH); break;
		case '?': type(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH); break;
		case ' ': type(KeyEvent.VK_SPACE); break;
		}
	}

	private void type(int... keyCodes) {
		type(keyCodes, 0, keyCodes.length);
	}

	private void type(int[] keyCodes, int offset, int length) {
		if (length==0) return;
		bot.keyPress(keyCodes[offset]);
		type(keyCodes, offset+1, length - 1);
		bot.keyRelease(keyCodes[offset]);
	}

}