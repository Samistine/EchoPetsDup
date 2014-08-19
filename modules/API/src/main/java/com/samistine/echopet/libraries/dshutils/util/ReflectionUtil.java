/*  1:   */ package com.samistine.echopet.libraries.dshutils.util;
/*  2:   */ 
/*  3:   */ import java.lang.reflect.Field;
/*  4:   */ import java.lang.reflect.InvocationTargetException;
/*  5:   */ import java.lang.reflect.Method;
/*  6:   */ import java.util.List;
/*  7:   */ import org.bukkit.FireworkEffect;
/*  8:   */ import org.bukkit.Location;
/*  9:   */ import org.bukkit.World;
/* 10:   */ import org.bukkit.entity.Entity;
/* 11:   */ import org.bukkit.entity.Firework;
/* 12:   */ import org.bukkit.entity.Player;
/* 13:   */ import org.bukkit.inventory.meta.FireworkMeta;
/* 14:   */ 
/* 15:   */ public class ReflectionUtil
/* 16:   */ {
/* 17:   */   public static Method getMethod(Class<?> cl, String method)
/* 18:   */   {
/* 19:21 */     for (Method m : cl.getMethods()) {
/* 20:21 */       if (m.getName().equals(method)) {
/* 21:21 */         return m;
/* 22:   */       }
/* 23:   */     }
/* 24:22 */     return null;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public static Field getField(Class<?> cl, String field)
/* 28:   */   {
/* 29:26 */     for (Field f : cl.getFields()) {
/* 30:26 */       if (f.getName().equals(field)) {
/* 31:26 */         return f;
/* 32:   */       }
/* 33:   */     }
/* 34:27 */     return null;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public static Field getDeclaredField(Class<?> cl, String field_name)
/* 38:   */   {
/* 39:   */     try
/* 40:   */     {
/* 41:32 */       return cl.getDeclaredField(field_name);
/* 42:   */     }
/* 43:   */     catch (SecurityException e)
/* 44:   */     {
/* 45:35 */       e.printStackTrace();
/* 46:   */     }
/* 47:   */     catch (NoSuchFieldException e)
/* 48:   */     {
/* 49:37 */       e.printStackTrace();
/* 50:   */     }
/* 51:39 */     return null;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public static void setValue(Object instance, String fieldName, Object value)
/* 55:   */     throws Exception
/* 56:   */   {
/* 57:43 */     Field field = instance.getClass().getDeclaredField(fieldName);
/* 58:44 */     field.setAccessible(true);
/* 59:45 */     field.set(instance, value);
/* 60:   */   }
/* 61:   */   
/* 62:   */   public static void sendPacket(Location l, Object packet)
/* 63:   */   {
/* 64:49 */     sendPacket(l, packet, 20);
/* 65:   */   }
/* 66:   */   
/* 67:   */   public static void sendPacket(Location l, Object packet, int radius)
/* 68:   */   {
/* 69:53 */     if (!GeometryUtil.getNearbyEntities(l, radius).isEmpty()) {
/* 70:54 */       for (Entity e : GeometryUtil.getNearbyEntities(l, radius)) {
/* 71:55 */         if ((e != null) && ((e instanceof Player)))
/* 72:   */         {
/* 73:56 */           Player p = (Player)e;
/* 74:57 */           sendPacket(p, packet);
/* 75:   */         }
/* 76:   */       }
/* 77:   */     }
/* 78:   */   }
/* 79:   */   
/* 80:   */   public static void sendPacket(Player p, Object packet)
/* 81:   */   {
/* 82:64 */     Object nmsPlayer = null;
/* 83:   */     try
/* 84:   */     {
/* 85:66 */       nmsPlayer = getMethod(p.getClass(), "getHandle").invoke(p, new Object[0]);
/* 86:67 */       Object con = nmsPlayer.getClass().getField("playerConnection").get(nmsPlayer);
/* 87:68 */       getMethod(con.getClass(), "sendPacket").invoke(con, new Object[] { packet });
/* 88:   */     }
/* 89:   */     catch (IllegalAccessException e)
/* 90:   */     {
/* 91:70 */       e.printStackTrace();
/* 92:   */     }
/* 93:   */     catch (InvocationTargetException e)
/* 94:   */     {
/* 95:72 */       e.printStackTrace();
/* 96:   */     }
/* 97:   */     catch (NoSuchFieldException e)
/* 98:   */     {
/* 99:74 */       e.printStackTrace();
/* :0:   */     }
/* :1:   */   }
/* :2:   */   
/* :3:   */   public static void spawnFirework(Location l, FireworkEffect fe)
/* :4:   */   {
/* :5:79 */     Firework fw = (Firework)l.getWorld().spawn(l, Firework.class);
/* :6:80 */     FireworkMeta fwm = fw.getFireworkMeta();
/* :7:81 */     fwm.clearEffects();
/* :8:82 */     fwm.addEffect(fe);
/* :9:   */     try
/* ;0:   */     {
/* ;1:84 */       Field f = fwm.getClass().getDeclaredField("power");
/* ;2:85 */       f.setAccessible(true);
/* ;3:86 */       f.set(fwm, Integer.valueOf(-2));
/* ;4:   */     }
/* ;5:   */     catch (Exception e) {}
/* ;6:89 */     fw.setFireworkMeta(fwm);
/* ;7:   */   }
/* ;8:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.util.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */