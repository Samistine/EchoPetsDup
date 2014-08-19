/*  1:   */ package com.samistine.echopet.libraries.dshutils.logger;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.io.FileWriter;
/*  5:   */ import java.io.IOException;
/*  6:   */ import java.io.PrintWriter;
/*  7:   */ import java.text.SimpleDateFormat;
/*  8:   */ import java.util.Date;
/*  9:   */ import org.bukkit.ChatColor;
/* 10:   */ import org.bukkit.plugin.java.JavaPlugin;
/* 11:   */ 
/* 12:   */ public class Logger
/* 13:   */ {
/* 14:   */   private static File logFile;
/* 15:16 */   private static boolean enabled = false;
/* 16:   */   private static String logPrefix;
/* 17:   */   private static String fileName;
/* 18:   */   
/* 19:   */   public static void initiate(JavaPlugin plugin, String name, String prefix)
/* 20:   */   {
/* 21:21 */     logPrefix = prefix;
/* 22:22 */     fileName = name;
/* 23:23 */     File folder = plugin.getDataFolder();
/* 24:24 */     if (!folder.exists()) {
/* 25:25 */       folder.mkdir();
/* 26:   */     }
/* 27:28 */     File log = new File(plugin.getDataFolder(), fileName + ".log");
/* 28:29 */     if (!log.exists()) {
/* 29:   */       try
/* 30:   */       {
/* 31:31 */         log.createNewFile();
/* 32:   */       }
/* 33:   */       catch (IOException e)
/* 34:   */       {
/* 35:33 */         e.printStackTrace();
/* 36:   */       }
/* 37:   */     }
/* 38:36 */     logFile = log;
/* 39:37 */     enabled = true;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public static void log(LogLevel logLevel, String message, boolean logToConsole)
/* 43:   */   {
/* 44:41 */     if (enabled)
/* 45:   */     {
/* 46:42 */       if (logToConsole) {
/* 47:43 */         ConsoleLogger.log(logLevel, message);
/* 48:   */       }
/* 49:45 */       FileWriter fw = null;
/* 50:   */       try
/* 51:   */       {
/* 52:47 */         fw = new FileWriter(logFile, true);
/* 53:   */       }
/* 54:   */       catch (IOException e)
/* 55:   */       {
/* 56:49 */         e.printStackTrace();
/* 57:   */       }
/* 58:51 */       PrintWriter pw = new PrintWriter(fw);
/* 59:52 */       String date = new SimpleDateFormat("[dd/MM/yyyy]---[HH:mm:ss]").format(new Date());
/* 60:53 */       pw.println("\n" + date + logLevel.getPrefix() + " " + message + "\n");
/* 61:54 */       pw.flush();
/* 62:55 */       pw.close();
/* 63:   */     }
/* 64:   */   }
/* 65:   */   
/* 66:   */   public static void log(LogLevel logLevel, String message, Exception e, boolean logToConsole)
/* 67:   */   {
/* 68:60 */     if (enabled)
/* 69:   */     {
/* 70:61 */       if (logToConsole) {
/* 71:62 */         ConsoleLogger.stackTraceAlert(logLevel, message);
/* 72:   */       }
/* 73:64 */       FileWriter fw = null;
/* 74:   */       try
/* 75:   */       {
/* 76:66 */         fw = new FileWriter(logFile, true);
/* 77:   */       }
/* 78:   */       catch (IOException ioe)
/* 79:   */       {
/* 80:68 */         e.printStackTrace();
/* 81:   */       }
/* 82:70 */       PrintWriter pw = new PrintWriter(fw);
/* 83:71 */       String date = new SimpleDateFormat("[dd/MM/yyyy]---[HH:mm:ss]").format(new Date());
/* 84:72 */       pw.println("\n" + date + logLevel.getPrefix() + " " + message);
/* 85:   */       
/* 86:74 */       e.printStackTrace(pw);
/* 87:   */       
/* 88:76 */       pw.println("\n");
/* 89:   */       
/* 90:78 */       pw.flush();
/* 91:79 */       pw.close();
/* 92:   */     }
/* 93:   */   }
/* 94:   */   
/* 95:   */   public static String getFileName()
/* 96:   */   {
/* 97:84 */     return fileName;
/* 98:   */   }
/* 99:   */   
/* :0:   */   public static enum LogLevel
/* :1:   */   {
/* :2:88 */     NORMAL(ChatColor.GREEN + "[INFO]"),  SEVERE(ChatColor.RED + "[SEVERE]"),  WARNING(ChatColor.RED + "[WARNING]");
/* :3:   */     
/* :4:   */     private String prefix;
/* :5:   */     
/* :6:   */     private LogLevel(String prefix)
/* :7:   */     {
/* :8:95 */       this.prefix = prefix;
/* :9:   */     }
/* ;0:   */     
/* ;1:   */     public String getPrefix()
/* ;2:   */     {
/* ;3:99 */       return Logger.logPrefix + " " + this.prefix;
/* ;4:   */     }
/* ;5:   */   }
/* ;6:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.logger.Logger
 * JD-Core Version:    0.7.0.1
 */