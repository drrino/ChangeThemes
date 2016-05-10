package drrino.changethemes.weight;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import drrino.changethemes.theme.ColorUiInterface;
import drrino.changethemes.utils.ViewAttributeUtils;

/**
 * Created by Coder on 16/5/10.
 */
public class ColorFloatingActionButton extends FloatingActionButton implements ColorUiInterface {

  private int attr_drawable = -1;

  public ColorFloatingActionButton(Context context) {
    super(context);
  }

  public ColorFloatingActionButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.attr_drawable = ViewAttributeUtils.getSrcAttribute(attrs);
  }

  public ColorFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.attr_drawable = ViewAttributeUtils.getSrcAttribute(attrs);
  }

  @Override public View getView() {
    return this;
  }

  @Override public void setTheme(Resources.Theme themeId) {
    if (attr_drawable != -1) {
      ViewAttributeUtils.applyImageDrawable(this, themeId, attr_drawable);
    }
  }
}
