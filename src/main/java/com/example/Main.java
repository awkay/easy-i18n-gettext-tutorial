package com.example;

import java.util.Locale;
import com.teamunify.i18n.EscapeFunction;
import com.teamunify.i18n.GlobalLanguageSettingsProvider;
import com.teamunify.i18n.I;
import com.teamunify.i18n.LanguageSetting;
import com.teamunify.i18n.ThreadLocalLanguageSettingsProvider;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {
    initI18N();
    
    I.setLanguage(new Locale("en", "US"));
    A a = new A();
    B b = new B();
    a.foo();
    b.bar();
    I.setLanguage(new Locale("fr"));
    a.foo();
    b.bar();

    // This one will screw up...
    System.out.println("Running two threads with global language settings...this will not work as expected.");
    doInThreads();
    
    I.setLanguageSettingsProvider(new ThreadLocalLanguageSettingsProvider());
    // This one will work correctly
    System.out.println("Running two threads with thread local language settings...this will be better");
    doInThreads();
  }

  private static void initI18N() {
    // Tell the system where to find translations
    LanguageSetting.translationPackage = "com.example.translations";
    // Use the same settings for all threads...
    I.setLanguageSettingsProvider(new GlobalLanguageSettingsProvider());
    // Do not escape translated characters at all
    I.setEscapeFunction(EscapeFunction.NoEscape);
  }

  public static void sleep() {
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {}
  }

  public static void doInThreads() throws InterruptedException {
    Thread ta = new Thread(new Runnable() {
      public void run() {
        I.setLanguage("en");
        for (int i = 0; i < 5; i++) {
          System.out.println(I.tr("Hello world from the English thread!"));
          sleep();
        }
      }
    });
    
    Thread tb = new Thread(new Runnable() {
      public void run() {
        I.setLanguage("fr");
        for (int i = 0; i < 5; i++) {
          System.out.println(I.tr("Hello world from the French thread!"));
          sleep();
        }
      }
    });
    
    ta.start();
    tb.start();
    
    ta.join();
    tb.join();
  }
}
