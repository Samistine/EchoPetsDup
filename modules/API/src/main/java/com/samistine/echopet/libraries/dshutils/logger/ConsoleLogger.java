/*  1:   */ package com.samistine.echopet.libraries.dshutils.logger;
/*  2:   */ 
/*  3:   */ import com.samistine.echopet.libraries.dshutils.DSHPlugin;
/*  4:   */ import org.bukkit.Server;
/*  5:   */ import org.bukkit.command.ConsoleCommandSender;
/*  6:   */ 
/*  7:   */ public class ConsoleLogger
/*  8:   */ {
/*  9:   */   private static ConsoleCommandSender console;
/* 10:   */   
/* 11:   */   public static void initiate()
/* 12:   */   {
/* 13:13 */     console = DSHPlugin.getPluginInstance().getServer().getConsoleSender();
/* 14:   */   }
/* 15:   */   
/* 16:   */   public static void log(Logger.LogLevel logLevel, String message)
/* 17:   */   {
/* 18:17 */     console.sendMessage(logLevel.getPrefix() + " " + message);
/* 19:   */   }
/* 20:   */   
/* 21:   */   public static void log(String message)
/* 22:   */   {
/* 23:21 */     log(Logger.LogLevel.NORMAL, message);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public static void stackTraceAlert(Logger.LogLevel logLevel, String message)
/* 27:   */   {
/* 28:25 */     console.sendMessage(logLevel.getPrefix() + " " + message);
/* 29:26 */     console.sendMessage(logLevel.getPrefix() + " See the Log File for details [" + Logger.getFileName() + ".log].");
/* 30:   */   }
/* 31:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.logger.ConsoleLogger
 * JD-Core Version:    0.7.0.1
 */