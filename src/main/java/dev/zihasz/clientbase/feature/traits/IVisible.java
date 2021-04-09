package dev.zihasz.clientbase.feature.traits;

import dev.zihasz.clientbase.feature.ITrait;

public interface IVisible extends ITrait {

	boolean visible = true;

	boolean isVisible();
	void setVisible(boolean visible);

}
