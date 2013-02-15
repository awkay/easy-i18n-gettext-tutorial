package com.example;

import java.util.Locale;
import com.teamunify.i18n.I;
import com.teamunify.i18n.LanguageSetting;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    LanguageSetting.translationPackage = "com.example.translations";
    I.setLanguage(new Locale("en", "US"));
    A a = new A();
    B b = new B();
    a.foo();
    b.bar();
    I.setLanguage(new Locale("fr"));
    a.foo();
    b.bar();
  }

}
