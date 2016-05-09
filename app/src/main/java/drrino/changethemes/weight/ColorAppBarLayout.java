package drrino.changethemes.weight;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;
import android.view.View;
import drrino.changethemes.theme.ColorUiInterface;
import drrino.changethemes.utils.ViewAttributeUtils;

/**
 * Created by Coder on 16/5/9.
 */
public class ColorAppBarLayout extends AppBarLayout implements ColorUiInterface {
  private int attr_background = -1;

  public ColorAppBarLayout(Context context) {
    super(context);
  }

  public ColorAppBarLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.attr_background = ViewAttributeUtils.getBackgroundAttribute(attrs);
  }

  @Override public View getView() {
    return this;
  }

  @Override public void setTheme(Resources.Theme themeId) {
    if (attr_background != -1) {
      ViewAttributeUtils.applyBackgroundDrawable(this, themeId, attr_background);
    }
  }
}
