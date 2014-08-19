/*  1:   */ package com.samistine.echopet.libraries.dshutils.util;
/*  2:   */ 
/*  3:   */ import com.samistine.echopet.libraries.dshutils.logger.Logger;
/*  4:   */ import com.samistine.echopet.libraries.dshutils.logger.Logger.LogLevel;
/*  5:   */ import java.io.File;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.net.URI;
/*  8:   */ import java.net.URL;
/*  9:   */ import java.security.CodeSource;
/* 10:   */ import java.security.ProtectionDomain;
/* 11:   */ import java.util.jar.Attributes;
/* 12:   */ import java.util.jar.JarFile;
/* 13:   */ import java.util.jar.Manifest;
/* 14:   */ 
/* 15:   */ public class VersionUtil
/* 16:   */ {
/* 17:15 */   public static boolean b = false;
/* 18:   */   private static String PLUGIN_VERSION;
/* 19:   */   private static String MINECRAFT_VERSION;
/* 20:   */   private static String CRAFTBUKKIT_VERSION;
/* 21:   */   private static String NMS_PACKAGE;
/* 22:   */   
/* 23:   */   private static void updateVersions()
/* 24:   */   {
/* 25:   */     try
/* 26:   */     {
/* 27:23 */       String path = VersionUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
/* 28:24 */       Attributes a = getManifest(path).getMainAttributes();
/* 29:25 */       if (a.getValue("Plugin-Version") != null) {
/* 30:26 */         PLUGIN_VERSION = a.getValue("Plugin-Version");
/* 31:   */       }
/* 32:29 */       if (a.getValue("Minecraft-Version") != null) {
/* 33:30 */         MINECRAFT_VERSION = a.getValue("Minecraft-Version");
/* 34:   */       }
/* 35:32 */       if (a.getValue("CraftBukkit-Version") != null) {
/* 36:33 */         CRAFTBUKKIT_VERSION = a.getValue("CraftBukkit-Version");
/* 37:   */       }
/* 38:35 */       if (a.getValue("NMS-Package") != null) {
/* 39:36 */         NMS_PACKAGE = a.getValue("NMS-Package");
/* 40:   */       }
/* 41:   */     }
/* 42:   */     catch (Exception e)
/* 43:   */     {
/* 44:39 */       Logger.log(Logger.LogLevel.SEVERE, "Failed to obtain Minecraft Server version.", e, true);
/* 45:   */     }
/* 46:   */   }
/* 47:   */   
/* 48:   */   private static Manifest getManifest(String path)
/* 49:   */     throws IOException
/* 50:   */   {
/* 51:44 */     File jar = new File(path);
/* 52:45 */     JarFile jf = new JarFile(new File(path));
/* 53:46 */     Manifest mf = new JarFile(jar).getManifest();
/* 54:47 */     jf.close();
/* 55:48 */     return mf;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public static String getServerVersion()
/* 59:   */   {
/* 60:52 */     return org.bukkit.Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
/* 61:   */   }
/* 62:   */   
/* 63:   */   public static boolean compareVersions()
/* 64:   */   {
/* 65:56 */     return getNMSPackage().equalsIgnoreCase(getServerVersion());
/* 66:   */   }
/* 67:   */   
/* 68:   */   public static String getPluginVersion()
/* 69:   */   {
/* 70:60 */     if (!b)
/* 71:   */     {
/* 72:61 */       updateVersions();
/* 73:62 */       b = true;
/* 74:   */     }
/* 75:64 */     return PLUGIN_VERSION;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public static String getMinecraftVersion()
/* 79:   */   {
/* 80:68 */     if (!b)
/* 81:   */     {
/* 82:69 */       updateVersions();
/* 83:70 */       b = true;
/* 84:   */     }
/* 85:72 */     return MINECRAFT_VERSION;
/* 86:   */   }
/* 87:   */   
/* 88:   */   public static String getCraftBukkitVersion()
/* 89:   */   {
/* 90:76 */     if (!b)
/* 91:   */     {
/* 92:77 */       updateVersions();
/* 93:78 */       b = true;
/* 94:   */     }
/* 95:80 */     return CRAFTBUKKIT_VERSION;
/* 96:   */   }
/* 97:   */   
/* 98:   */   public static String getNMSPackage()
/* 99:   */   {
/* :0:84 */     if (!b)
/* :1:   */     {
/* :2:85 */       updateVersions();
/* :3:86 */       b = true;
/* :4:   */     }
/* :5:88 */     return NMS_PACKAGE;
/* :6:   */   }
/* :7:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.util.VersionUtil
 * JD-Core Version:    0.7.0.1
 */