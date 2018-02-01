package wang.androids.plugindev.lib.viewannotation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by Administrator on 2017/12/14.
 */

public class LayoutXMLParser {
    public void parser(Context context, int restId) {

        int count = 0;
        StringBuilder sb = new StringBuilder();
        Resources r = context.getResources();
        XmlResourceParser xrp = r.getXml(restId);
        try {

            while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
                // 判断事件类型是否为文档结束
                if (xrp.getEventType() == XmlResourceParser.START_TAG) {
                    // 判断事件类型是否为开始标志
                    String name = xrp.getName();
                    int attributeCount = xrp.getAttributeCount();
                    String attributeValue = xrp.getAttributeValue("id", "id");
                    if (name.equals("android:id")) {
//                        android.support.v7.widget.RecyclerView
                        name = xrp.getName();
                        Class clazz = Class.forName(name);
                        try {
                            Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }
                xrp.next();
                // 下一行
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
