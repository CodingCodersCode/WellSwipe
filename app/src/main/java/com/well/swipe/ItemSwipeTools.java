package com.well.swipe;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;

import com.well.swipecomm.ItemInfo;

/**
 * Created by mingwei on 3/16/16.
 *
 *
 * 微博：     明伟小学生(http://weibo.com/u/2382477985)
 * Github:   https://github.com/gumingwei
 * CSDN:     http://blog.csdn.net/u013045971
 * QQ&WX：   721881283
 *
 *
 */
public class ItemSwipeTools extends ItemInfo {
    /**
     * 快捷开关的action
     */
    public String mAction;

    public Bitmap mDefaultIcon;

    public boolean isChecked;

    public ItemSwipeTools() {
        mType = SwipefreeSettings.BaseColumns.ITEM_TYPE_SWITCH;
    }

    public ItemSwipeTools(ItemSwipeTools switchitem) {
        super(switchitem);
        mAction = switchitem.mAction;
        mDefaultIcon = switchitem.mDefaultIcon;
    }

    public int delete(Context context) {
        ContentResolver resolver = context.getContentResolver();
        return resolver.delete(SwipefreeSettings.Favorites.CONTENT_URI, SwipefreeSettings.BaseColumns.ITEM_ACTION +
                "=?", new String[]{mAction});
    }

    public int deletedAll(Context context) {
        ContentResolver resolver = context.getContentResolver();
        return resolver.delete(SwipefreeSettings.Favorites.CONTENT_URI, SwipefreeSettings.BaseColumns.ITEM_TYPE +
                "=?", new String[]{String.valueOf(SwipefreeSettings.BaseColumns.ITEM_TYPE_SWITCH)});
    }

    public void insert(Context context, int index) {
        ContentResolver resolver = context.getContentResolver();
        resolver.insert(SwipefreeSettings.Favorites.CONTENT_URI, assembleContentValues(context, index));
    }

    public ContentValues assembleContentValues(Context context, int index) {
        ContentValues values = new ContentValues();
        values.put(SwipefreeSettings.BaseColumns.ITEM_TITLE, mTitle.toString());
        values.put(SwipefreeSettings.BaseColumns.ITEM_INDEX, index);
        values.put(SwipefreeSettings.BaseColumns.ITEM_TYPE, SwipefreeSettings.BaseColumns.ITEM_TYPE_SWITCH);
        values.put(SwipefreeSettings.BaseColumns.ITEM_ACTION, mAction);
        return values;
    }

    public void bulkInsert(Context context, ContentValues values[]) {
        ContentResolver resolver = context.getContentResolver();
        resolver.bulkInsert(SwipefreeSettings.Favorites.CONTENT_URI, values);
    }

}
