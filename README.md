# Collapsing-Toolbar-Tutorial

We'll design this type of sample Android App using Collapsing Toolbar Layout:

<img src="https://raw.githubusercontent.com/hasancse91/Collapsing-Toolbar-Tutorial/master/Data/image.gif" width="250" height="444" />

### Prepare Gradle
First of all add these dependencies to your gradle file: 
```
dependencies {
    ...
    compile 'com.android.support:design:26.0.0-alpha1'
    ...
   }
```
Here I used version `26.0.0-alpha1` and it's the latest version (till 26th July, 2017), you should use the latest version.

### XML prepare
Your XML file should contain a `CoordinatorLayout` to you `CollapsingToolbarLayout`.

Inside `CoordinatorLayout` take two widgets `AppBarLayout` and `NestedScrollView` as siblings. `AppBarLayout` contains a widget `CollapsingToolbarLayout`. Inside it I took an `ImageView` and my custom `Toolbar`.

`NestedScrollView` holds our rest of the contents. I used only a `TextView` to show an article.

### Java class modification

[AppBarStateChangeListener](https://github.com/hasancse91/Collapsing-Toolbar-Tutorial/blob/master/collapsing-toolbar-layout/app/src/main/java/com/hellohasan/collapsingtoolbarlayoutpractice/AppBarStateChangeListener.java) is an abstract class. It helps to listen the state change of `AppBarLayout`.

Inside the `onCreate()` method of `MainActivity` we can listen the state change by this method and take action:

```
appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
    @Override
    public void onStateChanged(AppBarLayout appBarLayout, State state) {
        if(state.equals(State.COLLAPSED)) {
            toolbar.setBackgroundResource(R.drawable.custom_toolbar);
            Toast.makeText(getApplicationContext(), "COLLAPSED", Toast.LENGTH_SHORT).show();
        }
        else if (state.equals(State.EXPANDED)) {
            toolbar.setBackgroundResource(R.color.transparent);
            Toast.makeText(getApplicationContext(), "EXPANDED", Toast.LENGTH_SHORT).show();
        }
        else if ((state.equals(State.IDLE))){
            Toast.makeText(getApplicationContext(), "IDLE", Toast.LENGTH_SHORT).show();
        }
    }
});
```

To get the whole project please clone it and run at your machine. If you see any error please let me know or send pull request.

Thank you. :-)
