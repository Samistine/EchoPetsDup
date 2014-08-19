/*  1:   */ package com.samistine.echopet.libraries.dshutils.util;
/*  2:   */ 
/*  3:   */ public class EnumUtil
/*  4:   */ {
/*  5:   */   public static boolean isEnumType(Class<? extends Enum> clazz, String s)
/*  6:   */   {
/*  7:   */     try
/*  8:   */     {
/*  9: 9 */       Enum.valueOf(clazz, s.toUpperCase());
/* 10:10 */       return true;
/* 11:   */     }
/* 12:   */     catch (Exception e) {}
/* 13:12 */     return false;
/* 14:   */   }
/* 15:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.util.EnumUtil
 * JD-Core Version:    0.7.0.1
 */