/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HGROUP;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.home.house.HomeInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ final class UIHomeOdd
/*     */   extends PlacableMulti
/*     */ {
/*  30 */   private static CharSequence ¤¤name = "O-Mover";
/*  31 */   private static CharSequence ¤¤desc = "Oddjobbers will automatically move out if an employed subject needs their home. This tool manually moves random oddjobbers to desired housing.";
/*  32 */   private static CharSequence ¤¤prob = "Must be placed on a house with vacancies.";
/*  33 */   private static CharSequence ¤¤odd = "No oddjobbers to move!";
/*  34 */   private static CharSequence ¤¤oddNo = "There are no oddjobbers that can be moved into the specific house. They are either full, or their settings doesn't match the oddjobbers species and class."; private int updateTick;
/*     */   
/*     */   static {
/*  37 */     D.ts(UIHomeOdd.class);
/*     */   }
/*     */ 
/*     */   
/*  41 */   private int[][] oddjobbers = Alloc.i2(HCLASSES.ALL().size(), RACES.all().size());
/*     */   private int total; int ie; public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) { if (this.updateTick != GAME.updateI()) { this.updateTick = GAME.updateI(); this.total = 0; byte b; int i, arrayOfInt[][]; for (i = (arrayOfInt = this.oddjobbers).length, b = 0; b < i; ) { int[] arrayOfInt1 = arrayOfInt[b]; Arrays.fill(arrayOfInt1, 0); b++; }  for (HTYPE c : HTYPES.ALL()) { if (!c.isWorks()) continue;  for (Race r : RACES.all()) { int am = STATS.POP().pop(r, c); this.total += am; this.oddjobbers[c.CLASS.index()][r.index()] = this.oddjobbers[c.CLASS.index()][r.index()] + am; }  }  for (HCLASS c : HCLASSES.ALL()) { for (Race r : RACES.all()) { int am = (STATS.WORK()).EMPLOYED.stat().data(c).get(r); this.total -= am; this.oddjobbers[c.index()][r.index()] = this.oddjobbers[c.index()][r.index()] - am; }  }  }  if (this.total <= 0) return ¤¤odd;  HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty); if (h == null) return ¤¤prob;  if (h.occupants() >= h.occupantsMax())
/*     */       return ¤¤prob;  HGROUP.HTypeBits a = h.availability(); if (a == null)
/*     */       return ¤¤prob;  for (int ti = 0; ti < HGROUP.all().size(); ti++) { HGROUP t = (HGROUP)HGROUP.all().get(ti); if (t.race != null)
/*     */         if (this.oddjobbers[t.type.index()][t.race.index()] > 0)
/*  46 */           return null;   }  return ¤¤oddNo; } public UIHomeOdd() { super(¤¤name, ¤¤desc, (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.workshop, (SPRITE)(SPRITES.icons()).s.arrow_right));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     this.ie = 0; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 123 */     HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/*     */     
/* 125 */     if (h == null) {
/*     */       return;
/*     */     }
/* 128 */     if (tx == h.serviceX() && ty == h.serviceY()) {
/* 129 */       HGROUP.HTypeBits t = h.availability();
/* 130 */       if (t != null && h.occupants() < h.occupantsMax()) {
/* 131 */         ENTITY[] ee = SETT.ENTITIES().getAllEnts();
/* 132 */         for (int i = 0; i < ee.length; i++) {
/* 133 */           if (this.ie >= ee.length)
/* 134 */             this.ie = 0; 
/* 135 */           ENTITY e = ee[this.ie];
/* 136 */           if (e instanceof Humanoid) {
/* 137 */             Humanoid a = (Humanoid)e;
/* 138 */             if ((STATS.WORK()).EMPLOYED.get(a) == null && t.is(a)) {
/* 139 */               (STATS.HOME()).GETTER.set(a, (HOME)h);
/* 140 */               t = h.availability();
/* 141 */               if (t == null || h.occupants() >= h.occupantsMax()) {
/*     */                 break;
/*     */               }
/*     */             } 
/*     */           } 
/* 146 */           this.ie++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void placeInfo(GBox b, int oktiles, AREA a) {
/*     */     super.placeInfo(b, oktiles, a);
/*     */   }
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 155 */     return ((SETT.ROOMS()).HOME.is(fromX, fromY) && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomeOdd.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */