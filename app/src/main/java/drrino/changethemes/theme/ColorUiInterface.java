package drrino.changethemes.theme;

import android.content.res.Resources;
import android.view.View;

/**
 * 换肤接口
 * Created by Coder on 16/5/9.
 */
public interface ColorUiInterface {
    View getView();

    void setTheme(Resources.Theme themeId);
}
