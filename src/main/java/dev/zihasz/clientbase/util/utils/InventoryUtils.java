package dev.zihasz.clientbase.util.utils;

import dev.zihasz.clientbase.util.Util;

public class InventoryUtils extends Util {

	public static final int convertClientSlotToServerSlot(int slot) {
		int var10000;
		if (0 <= slot) {
			if (8 >= slot) {
				var10000 = 36 + slot;
				return var10000;
			}
		}

		if (9 <= slot) {
			if (35 >= slot) {
				var10000 = slot;
				return var10000;
			}
		}

		if (36 <= slot) {
			if (39 >= slot) {
				var10000 = 39 - slot + 5;
				return var10000;
			}
		}

		if (slot != 40) {
			throw new IllegalArgumentException();
		} else {
			var10000 = 45;
			return var10000;
		}
	}

}
