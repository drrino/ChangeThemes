package drrino.changethemes;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import drrino.changethemes.base.BaseActivity;
import drrino.changethemes.theme.Theme;
import drrino.changethemes.utils.ColorUiUtils;
import drrino.changethemes.utils.PreUtils;
import drrino.changethemes.utils.SystemUtils;
import drrino.changethemes.utils.ThemeUtils;
import drrino.changethemes.weight.ColorFloatingActionButton;

/**
 * Created by Coder on 16/5/9.
 */
public class MainActivity extends BaseActivity implements ColorChooserDialog.ColorCallback {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    assert toolbar != null;
    toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

    ColorFloatingActionButton fab = (ColorFloatingActionButton) findViewById(R.id.fab);

    assert fab != null;
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        new ColorChooserDialog.Builder(MainActivity.this, R.string.theme).customColors(
            R.array.colors, null).doneButton(R.string.done).cancelButton(R.string.cancel).show();
      }
    });

    //使用沉浸式
    View mStatusBar = findViewById(R.id.status_bar);
    assert mStatusBar != null;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      mStatusBar.setVisibility(View.VISIBLE);
      mStatusBar.getLayoutParams().height = SystemUtils.getStatusHeight(this);
      mStatusBar.setLayoutParams(mStatusBar.getLayoutParams());
    } else {
      mStatusBar.setVisibility(View.GONE);
    }
  }

  @Override
  public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {
    if (selectedColor == ThemeUtils.getThemeColor(this, R.attr.colorPrimary)) return;

    if (selectedColor == ContextCompat.getColor(this, R.color.colorBluePrimary)) {
      setTheme(R.style.BlueTheme);
      PreUtils.setCurrentTheme(this, Theme.Blue);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorRedPrimary)) {
      setTheme(R.style.RedTheme);
      PreUtils.setCurrentTheme(this, Theme.Red);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorBrownPrimary)) {
      setTheme(R.style.BrownTheme);
      PreUtils.setCurrentTheme(this, Theme.Brown);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorGreenPrimary)) {
      setTheme(R.style.GreenTheme);
      PreUtils.setCurrentTheme(this, Theme.Green);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorPurplePrimary)) {
      setTheme(R.style.PurpleTheme);
      PreUtils.setCurrentTheme(this, Theme.Purple);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorTealPrimary)) {
      setTheme(R.style.TealTheme);
      PreUtils.setCurrentTheme(this, Theme.Teal);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorPinkPrimary)) {
      setTheme(R.style.PinkTheme);
      PreUtils.setCurrentTheme(this, Theme.Pink);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorDeepPurplePrimary)) {
      setTheme(R.style.DeepPurpleTheme);
      PreUtils.setCurrentTheme(this, Theme.DeepPurple);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorOrangePrimary)) {
      setTheme(R.style.OrangeTheme);
      PreUtils.setCurrentTheme(this, Theme.Orange);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorIndigoPrimary)) {
      setTheme(R.style.IndigoTheme);
      PreUtils.setCurrentTheme(this, Theme.Indigo);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorLightGreenPrimary)) {
      setTheme(R.style.LightGreenTheme);
      PreUtils.setCurrentTheme(this, Theme.LightGreen);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorDeepOrangePrimary)) {
      setTheme(R.style.DeepOrangeTheme);
      PreUtils.setCurrentTheme(this, Theme.DeepOrange);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorLimePrimary)) {
      setTheme(R.style.LimeTheme);
      PreUtils.setCurrentTheme(this, Theme.Lime);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorBlueGreyPrimary)) {
      setTheme(R.style.BlueGreyTheme);
      PreUtils.setCurrentTheme(this, Theme.BlueGrey);
    } else if (selectedColor == ContextCompat.getColor(this, R.color.colorCyanPrimary)) {
      setTheme(R.style.CyanTheme);
      PreUtils.setCurrentTheme(this, Theme.Cyan);
    }

    final View rootView = getWindow().getDecorView();
    rootView.setDrawingCacheEnabled(true);
    rootView.buildDrawingCache(true);

    final Bitmap localBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
    rootView.setDrawingCacheEnabled(false);
    if (null != localBitmap && rootView instanceof ViewGroup) {
      final View tmpView = new View(getApplicationContext());
      tmpView.setBackground(new BitmapDrawable(getResources(), localBitmap));
      ViewGroup.LayoutParams params =
          new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
              ViewGroup.LayoutParams.MATCH_PARENT);
      ((ViewGroup) rootView).addView(tmpView, params);
      tmpView.animate().alpha(0).setDuration(400).setListener(new Animator.AnimatorListener() {
        @Override public void onAnimationStart(Animator animation) {
          ColorUiUtils.changeTheme(rootView, getTheme());
          System.gc();
        }

        @Override public void onAnimationEnd(Animator animation) {
          ((ViewGroup) rootView).removeView(tmpView);
          localBitmap.recycle();
        }

        @Override public void onAnimationCancel(Animator animation) {

        }

        @Override public void onAnimationRepeat(Animator animation) {

        }
      }).start();
    }
  }
}
