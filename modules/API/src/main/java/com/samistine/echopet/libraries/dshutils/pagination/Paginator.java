/*  1:   */ package com.samistine.echopet.libraries.dshutils.pagination;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ 
/*  5:   */ public class Paginator
/*  6:   */ {
/*  7: 8 */   private ArrayList<String> raw = new ArrayList();
/*  8:   */   private int perPage;
/*  9:   */   
/* 10:   */   public Paginator(String[] raw, int perPage)
/* 11:   */   {
/* 12:12 */     this.perPage = perPage;
/* 13:13 */     setRaw(raw);
/* 14:   */   }
/* 15:   */   
/* 16:   */   public Paginator(ArrayList<String> raw, int perPage)
/* 17:   */   {
/* 18:17 */     this.perPage = perPage;
/* 19:18 */     setRaw(raw);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void setRaw(String[] newRaw)
/* 23:   */   {
/* 24:22 */     for (String s : newRaw) {
/* 25:23 */       this.raw.add(s);
/* 26:   */     }
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setRaw(ArrayList<String> newRaw)
/* 30:   */   {
/* 31:28 */     this.raw = newRaw;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public ArrayList<String> getRaw()
/* 35:   */   {
/* 36:32 */     return this.raw;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public int getIndex()
/* 40:   */   {
/* 41:36 */     return (int)Math.ceil(this.raw.size() / this.perPage);
/* 42:   */   }
/* 43:   */   
/* 44:   */   public double getDoubleIndex()
/* 45:   */   {
/* 46:40 */     return Math.ceil(this.raw.size() / this.perPage);
/* 47:   */   }
/* 48:   */   
/* 49:   */   public String[] getPage(int pageNumber)
/* 50:   */   {
/* 51:44 */     int index = this.perPage * (Math.abs(pageNumber) - 1);
/* 52:45 */     ArrayList<String> list = new ArrayList();
/* 53:46 */     if (pageNumber <= getDoubleIndex()) {
/* 54:47 */       for (int i = index; i < index + this.perPage; i++) {
/* 55:48 */         if (this.raw.size() > i) {
/* 56:49 */           list.add(this.raw.get(i));
/* 57:   */         }
/* 58:   */       }
/* 59:   */     } else {
/* 60:53 */       return null;
/* 61:   */     }
/* 62:55 */     return (String[])list.toArray(new String[list.size()]);
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.pagination.Paginator
 * JD-Core Version:    0.7.0.1
 */