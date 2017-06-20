package com.daomaidaomai.islandtrading;

import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by LiuChao on 2017/6/18.
 */

@RunWith(AndroidJUnit4.class)
    public class IslandTradingThree_LoginTest extends ActivityInstrumentationTestCase2  {
        private Solo solo;

        private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "ui.Login";

        private static Class<?> launcherActivityClass;
        static{
            try {
                launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @SuppressWarnings("unchecked")
        public IslandTradingThree_LoginTest() throws ClassNotFoundException {
            super(launcherActivityClass);
        }


        @Before
        public void setUp() throws Exception {
            super.setUp();
            solo = new Solo(getInstrumentation(),getActivity());

        }

        @After
        public void tearDown() throws Exception {
            solo.finishOpenedActivities();
            super.tearDown();
        }
        @Test
        public void testLogin() {
            solo.typeText((EditText) solo.getView("R.id.login_user"),"liuchao520");
            solo.typeText((EditText) solo.getView("R.id.login_password"),"237017");
            solo.clickOnButton(R.id.loginhome);
            solo.assertCurrentActivity("登录未成功","ui.home");
        }
    }