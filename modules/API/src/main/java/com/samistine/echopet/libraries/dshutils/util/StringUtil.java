/*  1:   */ package com.samistine.echopet.libraries.dshutils.util;
/*  2:   */ 
/*  3:   */ import java.util.Random;
/*  4:   */ import org.bukkit.ChatColor;
/*  5:   */ 
/*  6:   */ public class StringUtil
/*  7:   */ {
/*  8:   */   private static Random r;
/*  9:   */   
/* 10:   */   public static Random r()
/* 11:   */   {
/* 12:12 */     if (r == null) {
/* 13:13 */       r = new Random();
/* 14:   */     }
/* 15:15 */     return r;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public static boolean isInt(String string)
/* 19:   */   {
/* 20:   */     try
/* 21:   */     {
/* 22:20 */       Integer.parseInt(string);
/* 23:   */     }
/* 24:   */     catch (NumberFormatException ex)
/* 25:   */     {
/* 26:22 */       return false;
/* 27:   */     }
/* 28:24 */     return true;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public static String capitalise(String s)
/* 32:   */   {
/* 33:28 */     String finalString = "";
/* 34:29 */     if (s.contains(" "))
/* 35:   */     {
/* 36:30 */       StringBuilder builder = new StringBuilder();
/* 37:31 */       String[] sp = s.split(" ");
/* 38:32 */       for (String string : sp)
/* 39:   */       {
/* 40:33 */         string = string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
/* 41:34 */         builder.append(string);
/* 42:35 */         builder.append(" ");
/* 43:   */       }
/* 44:37 */       builder.deleteCharAt(builder.length() - 1);
/* 45:38 */       finalString = builder.toString();
/* 46:   */     }
/* 47:   */     else
/* 48:   */     {
/* 49:40 */       finalString = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
/* 50:   */     }
/* 51:42 */     return finalString;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public static String combineSplit(int startIndex, String[] string, String separator)
/* 55:   */   {
/* 56:46 */     if (string == null) {
/* 57:47 */       return "";
/* 58:   */     }
/* 59:49 */     StringBuilder builder = new StringBuilder();
/* 60:50 */     for (int i = startIndex; i < string.length; i++)
/* 61:   */     {
/* 62:51 */       builder.append(string[i]);
/* 63:52 */       builder.append(separator);
/* 64:   */     }
/* 65:54 */     builder.deleteCharAt(builder.length() - separator.length());
/* 66:55 */     return builder.toString();
/* 67:   */   }
/* 68:   */   
/* 69:   */   public static String replaceColoursWithString(String whyAmIDoingThis)
/* 70:   */   {
/* 71:61 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.BLACK + "", "&0");
/* 72:62 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.DARK_BLUE + "", "&1");
/* 73:63 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.DARK_GREEN + "", "&2");
/* 74:64 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.DARK_AQUA + "", "&3");
/* 75:65 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.DARK_RED + "", "&4");
/* 76:66 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.DARK_PURPLE + "", "&5");
/* 77:67 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.GOLD + "", "&6");
/* 78:68 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.GRAY + "", "&7");
/* 79:69 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.DARK_GRAY + "", "&8");
/* 80:70 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.BLUE + "", "&9");
/* 81:71 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.GREEN + "", "&a");
/* 82:72 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.AQUA + "", "&b");
/* 83:73 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.RED + "", "&c");
/* 84:74 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.LIGHT_PURPLE + "", "&d");
/* 85:75 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.YELLOW + "", "&e");
/* 86:76 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.WHITE + "", "&f");
/* 87:   */     
/* 88:78 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.MAGIC + "", "&k");
/* 89:79 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.BOLD + "", "&l");
/* 90:80 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.STRIKETHROUGH + "", "&m");
/* 91:81 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.UNDERLINE + "", "&n");
/* 92:82 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.ITALIC + "", "&o");
/* 93:83 */     whyAmIDoingThis = whyAmIDoingThis.replace(ChatColor.RESET + "", "&r");
/* 94:84 */     return whyAmIDoingThis;
/* 95:   */   }
/* 96:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */