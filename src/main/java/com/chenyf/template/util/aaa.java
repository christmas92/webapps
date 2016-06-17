package com.chenyf.template.util;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class aaa<T>
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 3688506614705500726L;
  public static final int DEFAULT_ITEMS_PER_PAGE = 15;
  public static final int ANOTHER_ITEMS_PER_PAGE = 10;
  public static final int DEFAULT_SLIDER_SIZE = 5;
  public static final int UNKNOWN_ITEMS = Integer.MAX_VALUE;
  private int pageNum = 0;
  private int totalPage = 0;
  private int itemsPerPage = 0;
  private List<T> list;
  
  public aaa()
  {
    this(0);
  }
  
  public aaa(int itemsPerPage)
  {
    this(itemsPerPage, Integer.MAX_VALUE);
  }
  
  public aaa(int itemsPerPage, int items)
  {
    this.totalPage = (items >= 0 ? items : 0);
    this.itemsPerPage = (itemsPerPage > 0 ? itemsPerPage : 
      15);
    this.pageNum = calcPage(0);
  }
  
  public int getPages()
  {
    return (int)Math.ceil(this.totalPage / this.itemsPerPage);
  }
  
  public int getPageNum()
  {
    return this.pageNum;
  }
  
  public int setPageNum(int pageNum)
  {
    return this.pageNum = calcPage(pageNum);
  }
  
  public int getItems()
  {
    return this.totalPage;
  }
  
  public int setItems(int items)
  {
    this.totalPage = (items >= 0 ? items : 0);
    setPageNum(this.pageNum);
    return this.totalPage;
  }
  
  public int getItemsPerPage()
  {
    return this.itemsPerPage;
  }
  
  public int setItemsPerPage(int itemsPerPage)
  {
    int tmp = this.itemsPerPage;
    
    this.itemsPerPage = (itemsPerPage > 0 ? itemsPerPage : 
      15);
    if (this.pageNum > 0) {
      setPageNum((int)((this.pageNum - 1) * tmp / this.itemsPerPage) + 1);
    }
    return this.itemsPerPage;
  }
  
  public int getOffset()
  {
    return this.pageNum > 0 ? this.itemsPerPage * (this.pageNum - 1) : 0;
  }
  
  public int getLength()
  {
    if (this.pageNum > 0) {
      return Math.min(this.itemsPerPage * this.pageNum, this.totalPage) - 
        this.itemsPerPage * (this.pageNum - 1);
    }
    return 0;
  }
  
  public int getBeginIndex()
  {
    if (this.pageNum > 0) {
      return this.itemsPerPage * (this.pageNum - 1) + 1;
    }
    return 0;
  }
  
  public int getEndIndex()
  {
    if (this.pageNum > 0) {
      return Math.min(this.itemsPerPage * this.pageNum, this.totalPage);
    }
    return 0;
  }
  
  public int setItem(int itemOffset)
  {
    return setPageNum(itemOffset / this.itemsPerPage + 1);
  }
  
  public int getFirstPage()
  {
    return calcPage(1);
  }
  
  public int getLastPage()
  {
    return calcPage(getPages());
  }
  
  public int getPreviousPage()
  {
    return calcPage(this.pageNum - 1);
  }
  
  @Deprecated
  public int getPrevious()
  {
    return this.pageNum == 0 ? 0 : this.pageNum - 1;
  }
  
  @Deprecated
  public int getNext()
  {
    return this.pageNum == getLastPage() ? 0 : this.pageNum + 1;
  }
  
  public int getPreviousPage(int n)
  {
    return calcPage(this.pageNum - n);
  }
  
  public int getNextPage()
  {
    return calcPage(this.pageNum + 1);
  }
  
  public int getNextPage(int n)
  {
    return calcPage(this.pageNum + n);
  }
  
  public boolean isDisabledPage(int page)
  {
    return (page < 1) || (page > getPages()) || (page == this.pageNum);
  }
  
  public int[] getSlider()
  {
    return getSlider(5);
  }
  
  public int[] getSlider(int width)
  {
    int pages = getPages();
    if ((pages < 1) || (width < 1)) {
      return new int[0];
    }
    if (width > pages) {
      width = pages;
    }
    int[] slider = new int[width];
    int first = this.pageNum - (width - 1) / 2;
    if (first < 1) {
      first = 1;
    }
    if (first + width - 1 > pages) {
      first = pages - width + 1;
    }
    for (int i = 0; i < width; i++) {
      slider[i] = (first + i);
    }
    return slider;
  }
  
  protected int calcPage(int page)
  {
    int pages = getPages();
    if (pages > 0) {
      return page > pages ? pages : page < 1 ? 1 : page;
    }
    return 0;
  }
  
  public Object clone()
  {
    try
    {
      return super.clone();
    }
    catch (CloneNotSupportedException e) {}
    return null;
  }
  
  public List<String> getSliderList()
  {
    List<String> list = new ArrayList();
    int[] slider = getSlider();
    for (int i = 0; i < slider.length; i++) {
      if (isDisabledPage(slider[i])) {
        list.add('[' + String.valueOf(slider[i]) + ']');
      } else {
        list.add(String.valueOf(slider[i]));
      }
    }
    return list;
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer("Paginator: page ");
    if (getPages() < 1)
    {
      sb.append(getPageNum());
    }
    else
    {
      int[] slider = getSlider();
      for (int i = 0; i < slider.length; i++)
      {
        if (isDisabledPage(slider[i])) {
          sb.append('[').append(slider[i]).append(']');
        } else {
          sb.append(slider[i]);
        }
        if (i < slider.length - 1) {
          sb.append('\t');
        }
      }
    }
    sb.append(" of ").append(getPages()).append(",\n");
    sb.append("    Showing items ").append(getBeginIndex()).append(" to ")
      .append(getEndIndex()).append(" (total ").append(getItems())
      .append(" items), ");
    sb.append("offset=").append(getOffset()).append(", length=")
      .append(getLength());
    
    return sb.toString();
  }
  
  public List<T> getList()
  {
    return this.list;
  }
  
  public void setList(List<T> list)
  {
    this.list = list;
  }
  
  public static void main(String[] args)
  {
    aaa<Object> pg = new aaa(10);
    pg.setItems(1355);
    pg.setPageNum(2);
    int[] slider = pg.getSlider(7);
    System.out.println(slider);
    int[] arrayOfInt1;
    int j = (arrayOfInt1 = slider).length;
    for (int i = 0; i < j; i++)
    {
      int j1 = arrayOfInt1[i];
      System.out.println(j1);
    }
    aaa<Object> p = new aaa();
    p.setPageNum(2);
    int beginIndex = p.getBeginIndex();
    System.out.println(beginIndex);
  }
}
