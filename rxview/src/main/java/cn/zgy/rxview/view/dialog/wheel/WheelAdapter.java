package cn.zgy.rxview.view.dialog.wheel;

/**
 * @author vondear
 * @deprecated Use WheelViewAdapter
 *
 * Wheel adapter interface
 */
public interface WheelAdapter {
	/**
	 * Gets items count
	 * @return the count of wheel items
	 */
    int getItemsCount();
	
	/**
	 * Gets a wheel item by index.
	 * 
	 * @param index the item index
	 * @return the wheel item text or null
	 */
    String getItem(int index);
	
	/**
	 * Gets maximum item length. It is used to determine the wheel width. 
	 * If -1 is returned there will be used the default wheel width.
	 * 
	 * @return the maximum item length or -1
	 */
    int getMaximumLength();
}
