package drrino.changethemes.utils;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import drrino.changethemes.theme.ColorUiInterface;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Coder on 16/5/9.
 */
public class ColorUiUtils {
  /**
   * 切换应用主题
   */
  public static void changeTheme(View rootView, Resources.Theme theme) {
    if (rootView instanceof ColorUiInterface) {
      ((ColorUiInterface) rootView).setTheme(theme);
      if (rootView instanceof ViewGroup) {
        int count = ((ViewGroup) rootView).getChildCount();
        for (int i = 0; i < count; i++) {
          changeTheme(((ViewGroup) rootView).getChildAt(i), theme);
        }
      }
      if (rootView instanceof AbsListView) {
        try {
          Field localField = AbsListView.class.getDeclaredField("mRecycler");
          localField.setAccessible(true);
          Method localMethod =
              Class.forName("android.widget.AbsListView$RecycleBin").getDeclaredMethod("clear");
          localMethod.setAccessible(true);
          localMethod.invoke(localField.get(rootView));
        } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e1) {
          e1.printStackTrace();
        }
      }
    } else {
      if (rootView instanceof ViewGroup) {
        int count = ((ViewGroup) rootView).getChildCount();
        for (int i = 0; i < count; i++) {
          changeTheme(((ViewGroup) rootView).getChildAt(i), theme);
        }
      }
      if (rootView instanceof AbsListView) {
        try {
          Field localField = AbsListView.class.getDeclaredField("mRecycler");
          localField.setAccessible(true);
          Method localMethod =
              Class.forName("android.widget.AbsListView$RecycleBin").getDeclaredMethod("clear");
          localMethod.setAccessible(true);
          localMethod.invoke(localField.get(rootView));
        } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e1) {
          e1.printStackTrace();
        }
      }
    }
  }
}
