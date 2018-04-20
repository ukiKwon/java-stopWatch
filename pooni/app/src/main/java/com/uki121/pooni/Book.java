package com.uki121.pooni;

import android.util.Log;

import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

class Book {
    final private int TITLE = 0, TOTAL_TIME = 1, EACH_TIME = 2, REST_TIME = 3, NUM_PROB = 4;
    final int MAX_CATEGORY =5;
    public String[] category;
    public Book(){};
    public Book(String[] _data)
    {
        /*TODO : BOOOK CONSTURCTOR */
        try {
            /*
            category = new String[MAX_CATEGORY];
            category[TITLE] = _data[TITLE];
            category[TOTAL_TIME] = _data[TOTAL_TIME];
            category[EACH_TIME] = _data[EACH_TIME];
            category[REST_TIME] = _data[REST_TIME];
            category[NUM_PROB] = _data[NUM_PROB];
            */
            category = new String[]{_data[TITLE],
                                    _data[TOTAL_TIME],
                                    _data[EACH_TIME],
                                    _data[REST_TIME],
                                    _data[NUM_PROB]};
        } catch (Exception e) {
            Log.d("BOOK_CONSTRUCTOR_EXCEPTION", e.getMessage());
        } catch (ExceptionInInitializerError e) {
            Log.d("BOOK_CONSTRUCTOR_INIT", e.getMessage());
        }
    }
    public Book(Book bs)
    {
        this.category = bs.category;
    }
    //Check a form of book regardless of its title
    final public boolean IsBookValid() {
        boolean ttflag = category[TOTAL_TIME] != null ? IsNumber(category[TOTAL_TIME]) : false,
                mptflag = category[TOTAL_TIME] != null ? IsRangeOf(category[TOTAL_TIME], category[EACH_TIME]) : false,
                rtflag = category[TOTAL_TIME] != null ? IsRangeOf(category[TOTAL_TIME], category[REST_TIME]) : true,
                nopflag = category[NUM_PROB] != null ? IsValidNum(category[NUM_PROB]) : true;
        return ttflag && mptflag && rtflag && nopflag;
    }
    //Check whether it is a number
    public boolean IsNumber(String _str)
    {
        try {
            return Pattern.matches("^[0-9]*$", _str);
        } catch (Exception e) {
            Log.d("Book_PatternCheck", e.getMessage());
            return false;
        }
    }
    public boolean IsRangeOf(String base, String target)
    {
        try {
            int a = Integer.parseInt(base), b = Integer.parseInt(target);
            boolean c1 = IsNumber(target), c2 = a > b;
            //c1 is true -> baseTime is number
            //c2 is true -> baseTime > targetTime
            return c1 && c2;
        } catch (Exception e) {
            Log.d("Book_RangeCheck ", e.getMessage());
            return false;
        }
    }
    public boolean IsValidNum(String _target)
    {
        try {
            boolean c1 = IsNumber(_target), c2 = Integer.parseInt(_target) > 0;
            //c1 is true -> c1 is number
            //c2 is true -> c2 > 0
            return c1 && c2;//c1 && c2 is true -> target is valid
        } catch (Exception e) {
            Log.d("Book_NumCheck ", e.getMessage());
            return false;
        }
    }
    /* essential function */
    public void setTitle(String _title) {
        this.category[TITLE] = _title;
    }
    public final String getTitle() {
        return category[TITLE];
    }
    public void setTotal(String _totalTime) {
        this.category[TOTAL_TIME] = _totalTime;
    }
    public final String getTotal() {
        return category[TOTAL_TIME];
    }
    public void setMaxper(String _maxtimePer) {
        this.category[EACH_TIME] = _maxtimePer;
    }
    public final String getMaxper() {
        return category[EACH_TIME];
    }
    public final String[] getBook() {
        System.out.println("Book_title " + category[TITLE]);
        for (int i=1; i<MAX_CATEGORY; ++i) {
            System.out.println("book_info : " + category[i]);
        }
        System.out.println("\n");
        return category;
    }
};