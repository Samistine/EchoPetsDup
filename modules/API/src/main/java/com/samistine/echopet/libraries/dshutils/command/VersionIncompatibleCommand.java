/*  1:   */ package com.samistine.echopet.libraries.dshutils.command;
/*  2:   */ 
/*  3:   */ import org.bukkit.command.Command;
/*  4:   */ import org.bukkit.command.CommandExecutor;
/*  5:   */ import org.bukkit.command.CommandSender;
/*  6:   */ 
/*  7:   */ public class VersionIncompatibleCommand
/*  8:   */   implements CommandExecutor
/*  9:   */ {
/* 10:   */   private String cmdLabel;
/* 11:   */   private String pluginPrefix;
/* 12:   */   private String msg;
/* 13:   */   private String perm;
/* 14:   */   private String permMsg;
/* 15:   */   
/* 16:   */   public VersionIncompatibleCommand(String cmdLabel, String pluginPrefix, String msg, String perm, String permMsg)
/* 17:   */   {
/* 18:16 */     this.cmdLabel = cmdLabel;
/* 19:17 */     this.pluginPrefix = pluginPrefix;
/* 20:18 */     this.msg = msg;
/* 21:19 */     this.perm = perm;
/* 22:20 */     this.permMsg = permMsg;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
/* 26:   */   {
/* 27:25 */     if (commandSender.hasPermission(this.perm)) {
/* 28:26 */       commandSender.sendMessage(this.pluginPrefix + " " + this.msg);
/* 29:   */     } else {
/* 30:28 */       commandSender.sendMessage(this.pluginPrefix + " " + this.permMsg);
/* 31:   */     }
/* 32:30 */     return true;
/* 33:   */   }
/* 34:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.command.VersionIncompatibleCommand
 * JD-Core Version:    0.7.0.1
 */