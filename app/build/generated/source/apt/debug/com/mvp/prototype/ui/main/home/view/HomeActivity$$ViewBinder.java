// Generated code from Butter Knife. Do not modify!
package com.mvp.prototype.ui.main.home.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HomeActivity$$ViewBinder<T extends com.mvp.prototype.ui.main.home.view.HomeActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492969, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131492969, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131492971, "field 'mNameEditText'");
    target.mNameEditText = finder.castView(view, 2131492971, "field 'mNameEditText'");
    view = finder.findRequiredView(source, 2131492973, "field 'mLatEditText'");
    target.mLatEditText = finder.castView(view, 2131492973, "field 'mLatEditText'");
    view = finder.findRequiredView(source, 2131492975, "field 'mLongEditText'");
    target.mLongEditText = finder.castView(view, 2131492975, "field 'mLongEditText'");
    view = finder.findRequiredView(source, 2131492976, "field 'mProgressBar'");
    target.mProgressBar = finder.castView(view, 2131492976, "field 'mProgressBar'");
    view = finder.findRequiredView(source, 2131492978, "field 'mEnterNo' and method 'onEnterNo'");
    target.mEnterNo = finder.castView(view, 2131492978, "field 'mEnterNo'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onEnterNo();
        }
      });
    view = finder.findRequiredView(source, 2131492977, "method 'onLocate'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onLocate();
        }
      });
  }

  @Override public void unbind(T target) {
    target.mToolbar = null;
    target.mNameEditText = null;
    target.mLatEditText = null;
    target.mLongEditText = null;
    target.mProgressBar = null;
    target.mEnterNo = null;
  }
}
