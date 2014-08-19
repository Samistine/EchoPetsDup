/*  1:   */ package com.samistine.echopet.libraries.dshutils.inventory;
/*  2:   */ 
/*  3:   */ import java.util.Arrays;
/*  4:   */ import org.bukkit.entity.Player;
/*  5:   */ import org.bukkit.inventory.ItemStack;
/*  6:   */ import org.bukkit.inventory.meta.ItemMeta;
/*  7:   */ 
/*  8:   */ public class MenuIcon
/*  9:   */ {
/* 10:   */   private int slot;
/* 11:   */   private int materialId;
/* 12:   */   private int materialData;
/* 13:   */   private String name;
/* 14:   */   private String[] lore;
/* 15:   */   
/* 16:   */   public MenuIcon(int slot, int materialId, int materialData, String name, String... lore)
/* 17:   */   {
/* 18:19 */     this.slot = slot;
/* 19:20 */     this.materialId = materialId;
/* 20:21 */     this.materialData = materialData;
/* 21:22 */     this.name = name;
/* 22:23 */     this.lore = lore;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public int getSlot()
/* 26:   */   {
/* 27:27 */     return this.slot;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public int getMaterialId()
/* 31:   */   {
/* 32:31 */     return this.materialId;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public int getMaterialData()
/* 36:   */   {
/* 37:35 */     return this.materialData;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public String getName()
/* 41:   */   {
/* 42:39 */     return this.name;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public String[] getLore()
/* 46:   */   {
/* 47:43 */     return this.lore;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public ItemStack getIcon(Player viewer)
/* 51:   */   {
/* 52:47 */     ItemStack i = new ItemStack(getMaterialId(), 1, (short)getMaterialData());
/* 53:48 */     ItemMeta meta = i.getItemMeta();
/* 54:49 */     meta.setDisplayName(getName());
/* 55:50 */     if ((this.lore != null) && (this.lore.length > 0)) {
/* 56:51 */       meta.setLore(Arrays.asList(getLore()));
/* 57:   */     }
/* 58:53 */     i.setItemMeta(meta);
/* 59:54 */     return i;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void onClick(Player viewer) {}
/* 63:   */ }


/* Location:           C:\Users\Samuel\.m2\repository\com\dsh105\DSHUtils\1.0-SNAPSHOT\DSHUtils-1.0-SNAPSHOT.jar
 * Qualified Name:     com.dsh105.dshutils.inventory.MenuIcon
 * JD-Core Version:    0.7.0.1
 */