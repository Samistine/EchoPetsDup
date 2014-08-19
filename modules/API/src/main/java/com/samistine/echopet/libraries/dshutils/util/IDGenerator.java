/* 1:  */ package com.samistine.echopet.libraries.dshutils.util;
/* 2:  */ 
/* 3:  */ public class IDGenerator
/* 4:  */ {
/* 5:5 */   private static long lastId = -9223372036854775808L;
/* 6:  */   
/* 7:  */   public static long nextId()
/* 8:  */   {
/* 9:8 */     return ++lastId;
/* ::  */   }
/* ;:  */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.util.IDGenerator
 * JD-Core Version:    0.7.0.1
 */