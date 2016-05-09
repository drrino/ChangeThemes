package drrino.changethemes.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import drrino.changethemes.R;
import drrino.changethemes.theme.Theme;
import drrino.changethemes.utils.PreUtils;

/**
 * Created by Coder on 16/5/9.
 */
public class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    onPreCreate();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      setTranslucentStatus(true);
    }
  }

  private void onPreCreate() {
    Theme theme = PreUtils.getCurrentTheme(this);
    switch (theme) {
      case Blue:
        setTheme(R.style.BlueTheme);
      case Red:
        setTheme(R.style.RedTheme);
        break;
      case Brown:
        setTheme(R.style.BrownTheme);
        break;
      case Green:
        setTheme(R.style.GreenTheme);
        break;
      case Purple:
        setTheme(R.style.PurpleTheme);
        break;
      case Teal:
        setTheme(R.style.TealTheme);
        break;
      case Pink:
        setTheme(R.style.PinkTheme);
        break;
      case DeepPurple:
        setTheme(R.style.DeepPurpleTheme);
        break;
      case Orange:
        setTheme(R.style.OrangeTheme);
        break;
      case Indigo:
        setTheme(R.style.IndigoTheme);
        break;
      case LightGreen:
        setTheme(R.style.LightGreenTheme);
        break;
      case Lime:
        setTheme(R.style.LimeTheme);
        break;
      case DeepOrange:
        setTheme(R.style.DeepOrangeTheme);
        break;
      case Cyan:
        setTheme(R.style.CyanTheme);
        break;
      case BlueGrey:
        setTheme(R.style.BlueGreyTheme);
        break;
    }
  }

  @TargetApi(19)
  private void setTranslucentStatus(boolean on) {
    Window win = getWindow();
    WindowManager.LayoutParams winParams = win.getAttributes();
    final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
    if (on) {
      winParams.flags |= bits;
    } else {
      winParams.flags &= ~bits;
    }
    win.setAttributes(winParams);
  }
}
