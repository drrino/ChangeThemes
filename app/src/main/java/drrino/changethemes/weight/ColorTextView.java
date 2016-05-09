package drrino.changethemes.weight;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import drrino.changethemes.theme.ColorUiInterface;
import drrino.changethemes.utils.ViewAttributeUtils;

/**
 * Created by chengli on 15/6/8.
 */
public class ColorTextView extends TextView implements ColorUiInterface {

  private int attr_drawable = -1;
  private int attr_textColor = -1;
  private int attr_textLinkColor = -1;

  public ColorTextView(Context context) {
    super(context);
  }

  public ColorTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.attr_drawable = ViewAttributeUtils.getBackgroundAttribute(attrs);
    this.attr_textColor = ViewAttributeUtils.getTextColorAttribute(attrs);
    this.attr_textLinkColor = ViewAttributeUtils.getTextLinkColorAttribute(attrs);
  }

  public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.attr_drawable = ViewAttributeUtils.getBackgroundAttribute(attrs);
    this.attr_textColor = ViewAttributeUtils.getTextColorAttribute(attrs);
    this.attr_textLinkColor = ViewAttributeUtils.getTextLinkColorAttribute(attrs);
  }

  @Override public View getView() {
    return this;
  }

  @Override public void setTheme(Resources.Theme themeId) {
    if (attr_drawable != -1) {
      ViewAttributeUtils.applyBackgroundDrawable(this, themeId, attr_drawable);
    }
    if (attr_textColor != -1) {
      ViewAttributeUtils.applyTextColor(this, themeId, attr_textColor);
    }
    if (attr_textLinkColor != -1) {
      ViewAttributeUtils.applyTextLinkColor(this, themeId, attr_textLinkColor);
    }
  }
}
