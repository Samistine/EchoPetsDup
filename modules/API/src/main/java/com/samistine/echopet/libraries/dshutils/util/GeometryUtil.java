/*  1:   */ package com.samistine.echopet.libraries.dshutils.util;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ import java.util.Random;
/*  6:   */ import org.bukkit.Location;
/*  7:   */ import org.bukkit.Material;
/*  8:   */ import org.bukkit.World;
/*  9:   */ import org.bukkit.block.Block;
/* 10:   */ import org.bukkit.entity.Entity;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ 
/* 13:   */ public class GeometryUtil
/* 14:   */ {
/* 15:   */   public static float generateRandomFloat(float min, float max)
/* 16:   */   {
/* 17:15 */     float f = min + StringUtil.r().nextFloat() * (1.0F + max - min);
/* 18:16 */     return StringUtil.r().nextBoolean() ? f : -f;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public static float generateRandomFloat()
/* 22:   */   {
/* 23:20 */     float f = StringUtil.r().nextFloat();
/* 24:21 */     return StringUtil.r().nextBoolean() ? f : -f;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public static List<Location> circle(Location loc, int r, int h, boolean hollow, boolean sphere, boolean includeAir)
/* 28:   */   {
/* 29:25 */     List<Location> blocks = new ArrayList();
/* 30:26 */     int cx = loc.getBlockX();
/* 31:27 */     int cy = loc.getBlockY();
/* 32:28 */     int cz = loc.getBlockZ();
/* 33:29 */     for (int x = cx - r; x <= cx + r; x++) {
/* 34:30 */       for (int z = cz - r; z <= cz + r; z++) {
/* 35:31 */         for (int y = sphere ? cy - r : cy; y < (sphere ? cy + r : cy + h); y++)
/* 36:   */         {
/* 37:32 */           double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? (cy - y) * (cy - y) : 0);
/* 38:33 */           if ((dist < r * r) && ((!hollow) || (dist >= (r - 1) * (r - 1))))
/* 39:   */           {
/* 40:34 */             Location l = new Location(loc.getWorld(), x, y, z);
/* 41:35 */             if ((includeAir) || (l.getBlock().getType() != Material.AIR)) {
/* 42:38 */               blocks.add(l);
/* 43:   */             }
/* 44:   */           }
/* 45:   */         }
/* 46:   */       }
/* 47:   */     }
/* 48:41 */     return blocks;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public static List<Entity> getNearbyEntities(Location l, int range)
/* 52:   */   {
/* 53:45 */     List<Entity> entities = new ArrayList();
/* 54:46 */     for (Entity entity : l.getWorld().getEntities()) {
/* 55:47 */       if (isInBorder(l, entity.getLocation(), range)) {
/* 56:48 */         entities.add(entity);
/* 57:   */       }
/* 58:   */     }
/* 59:51 */     return entities;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public static boolean isInBorder(Location center, Location l, int range)
/* 63:   */   {
/* 64:55 */     int x = center.getBlockX();int z = center.getBlockZ();
/* 65:56 */     int x1 = l.getBlockX();int z1 = l.getBlockZ();
/* 66:57 */     if ((x1 >= x + range) || (z1 >= z + range) || (x1 <= x - range) || (z1 <= z - range)) {
/* 67:58 */       return false;
/* 68:   */     }
/* 69:60 */     return true;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public static List<Player> getNearbyPlayers(Location l, int range)
/* 73:   */   {
/* 74:64 */     List<Player> players = new ArrayList();
/* 75:65 */     for (Entity e : getNearbyEntities(l, range)) {
/* 76:66 */       if ((e instanceof Player)) {
/* 77:67 */         players.add((Player)e);
/* 78:   */       }
/* 79:   */     }
/* 80:70 */     return players;
/* 81:   */   }
/* 82:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.util.GeometryUtil
 * JD-Core Version:    0.7.0.1
 */