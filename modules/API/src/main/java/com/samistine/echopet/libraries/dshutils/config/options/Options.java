/*  1:   */ package com.samistine.echopet.libraries.dshutils.config.options;
/*  2:   */ 
/*  3:   */ import com.samistine.echopet.libraries.dshutils.config.YAMLConfig;
/*  4:   */ 
/*  5:   */ public abstract class Options
/*  6:   */ {
/*  7:   */   protected YAMLConfig config;
/*  8:   */   
/*  9:   */   public Options(YAMLConfig config)
/* 10:   */   {
/* 11:11 */     this.config = config;
/* 12:12 */     setDefaults();
/* 13:   */   }
/* 14:   */   
/* 15:   */   public abstract void setDefaults();
/* 16:   */   
/* 17:   */   public YAMLConfig getConfig()
/* 18:   */   {
/* 19:18 */     return this.config;
/* 20:   */   }
/* 21:   */   
/* 22:   */   protected void set(String path, Object defObject, String... comments)
/* 23:   */   {
/* 24:22 */     this.config.set(path, this.config.get(path, defObject), comments);
/* 25:   */   }
/* 26:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.config.options.Options
 * JD-Core Version:    0.7.0.1
 */