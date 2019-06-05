package vn.codegym.springbootdatajpa.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

public class MyLocaleChangeInterceptor extends LocaleChangeInterceptor {

    public Locale parseLocaleValue(String localeValue) {
        return StringUtils.parseLocale(localeValue);
    }
}
