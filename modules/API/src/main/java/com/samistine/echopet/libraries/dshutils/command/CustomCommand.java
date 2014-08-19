/*  1:   */ package com.samistine.echopet.libraries.dshutils.command;
/*  2:   */ 
/*  3:   */ import com.samistine.echopet.libraries.dshutils.DSHPlugin;
/*  4:   */ import java.util.List;
/*  5:   */ import org.apache.commons.lang.Validate;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandException;
/*  8:   */ import org.bukkit.command.CommandExecutor;
/*  9:   */ import org.bukkit.command.CommandSender;
/* 10:   */ import org.bukkit.command.TabCompleter;
/* 11:   */ import org.bukkit.plugin.PluginDescriptionFile;
/* 12:   */ 
/* 13:   */ public class CustomCommand
/* 14:   */   extends Command
/* 15:   */ {
/* 16:   */   private CommandExecutor executor;
/* 17:   */   private TabCompleter completer;
/* 18:   */   
/* 19:   */   public CustomCommand(String name)
/* 20:   */   {
/* 21:15 */     super(name);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean execute(CommandSender arg0, String arg1, String[] arg2)
/* 25:   */   {
/* 26:20 */     if (this.executor != null) {
/* 27:21 */       this.executor.onCommand(arg0, this, arg1, arg2);
/* 28:   */     }
/* 29:23 */     return false;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setExecutor(CommandExecutor exe)
/* 33:   */   {
/* 34:27 */     this.executor = exe;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setTabCompleter(TabCompleter completer)
/* 38:   */   {
/* 39:31 */     this.completer = completer;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public TabCompleter getTabCompleter()
/* 43:   */   {
/* 44:35 */     return this.completer;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public List<String> tabComplete(CommandSender sender, String alias, String[] args)
/* 48:   */     throws CommandException, IllegalArgumentException
/* 49:   */   {
/* 50:40 */     Validate.notNull(sender, "Sender cannot be null");
/* 51:41 */     Validate.notNull(args, "Arguments cannot be null");
/* 52:42 */     Validate.notNull(alias, "Alias cannot be null");
/* 53:   */     
/* 54:44 */     List<String> completions = null;
/* 55:   */     try
/* 56:   */     {
/* 57:46 */       if (this.completer != null) {
/* 58:47 */         completions = this.completer.onTabComplete(sender, this, alias, args);
/* 59:   */       }
/* 60:49 */       if ((completions == null) && ((this.executor instanceof TabCompleter))) {
/* 61:50 */         completions = ((TabCompleter)this.executor).onTabComplete(sender, this, alias, args);
/* 62:   */       }
/* 63:   */     }
/* 64:   */     catch (Throwable ex)
/* 65:   */     {
/* 66:53 */       StringBuilder message = new StringBuilder();
/* 67:54 */       message.append("Unhandled exception during tab completion for command '/").append(alias).append(' ');
/* 68:55 */       for (String arg : args) {
/* 69:56 */         message.append(arg).append(' ');
/* 70:   */       }
/* 71:58 */       message.deleteCharAt(message.length() - 1).append("' in plugin ").append(DSHPlugin.getPluginInstance().getDescription().getFullName());
/* 72:59 */       throw new CommandException(message.toString(), ex);
/* 73:   */     }
/* 74:62 */     if (completions == null) {
/* 75:63 */       return super.tabComplete(sender, alias, args);
/* 76:   */     }
/* 77:65 */     return completions;
/* 78:   */   }
/* 79:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.command.CustomCommand
 * JD-Core Version:    0.7.0.1
 */