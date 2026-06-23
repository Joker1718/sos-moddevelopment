/*     */ package game.events.slave;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ final class UprisingSpot
/*     */   extends Coo
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   int signedUp;
/*     */   int amountTotal;
/*     */   int race;
/*     */   boolean valid = true;
/*     */   
/*     */   static UprisingSpot make(int mx, int my, int amountTotal, Race race) {
/*  44 */     UprisingSpot s = new UprisingSpot();
/*  45 */     s.amountTotal = amountTotal;
/*  46 */     s.race = race.index;
/*  47 */     if (setStart((COORDINATEE)s, mx, my, 32))
/*  48 */       return s; 
/*  49 */     return null;
/*     */   }
/*     */   
/*     */   static UprisingSpot make(FileGetter g) throws IOException {
/*  53 */     UprisingSpot s = new UprisingSpot();
/*  54 */     s.load(g);
/*  55 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   void makeDiv(Div d, int id) {
/*  60 */     if (!isPlacable(x(), y()) && 
/*  61 */       !setStart((COORDINATEE)this, x(), y(), 16)) {
/*  62 */       clear();
/*     */       
/*     */       return;
/*     */     } 
/*  66 */     d.settings().musteringSet(true);
/*     */ 
/*     */     
/*  69 */     int am = CLAMP.i(this.signedUp, 0, (Config.battle()).MEN_PER_DIVISION - d.menNrOf());
/*  70 */     d.info.menSet(am);
/*  71 */     d.info.bannerISet(RND.rInt((GAME.ARMIES()).banners.size()));
/*  72 */     d.info.name().clear().add((CharSequence)((Race)RACES.all().get(this.race)).info.armyNames.rnd());
/*  73 */     (GAME.ARMIES()).factors.init(d);
/*  74 */     int w = (int)Math.ceil(Math.sqrt(this.signedUp) / 2.0D); byte b; int i;
/*     */     ENTITY[] arrayOfENTITY;
/*  76 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/*  77 */       if (am == 0)
/*     */         break; 
/*  79 */       if (e instanceof Humanoid) {
/*  80 */         Humanoid a = (Humanoid)e;
/*  81 */         if ((a.race()).index == this.race && HPoll.Handler.isSlaveReadyForUprising(a) == id) {
/*  82 */           a.HTypeSet(HTYPES.ENEMY(), null, null);
/*  83 */           a.setDivision(d);
/*  84 */           am--;
/*  85 */           this.signedUp--;
/*  86 */           this.amountTotal--;
/*     */         } 
/*     */       }  b++; }
/*     */     
/*  90 */     DIR dir = DIR.NW;
/*     */     
/*  92 */     int x1 = (x() + dir.x() * w) * 64 + 32;
/*  93 */     int y1 = (y() + dir.y() * w) * 64 + 32;
/*  94 */     dir = DIR.NE;
/*  95 */     int x2 = x1 + dir.x() * w * 64;
/*  96 */     int y2 = y1 + dir.y() * w * 64;
/*     */     
/*  98 */     (GAME.ARMIES()).placer.deploy(d, x1, x2, y1, y2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 106 */     file.i(this.signedUp);
/* 107 */     file.i(this.amountTotal);
/* 108 */     file.i(this.race);
/* 109 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 114 */     this.signedUp = file.i();
/* 115 */     this.amountTotal = file.i();
/* 116 */     this.race = file.i();
/* 117 */     this.race = ((Race)RACES.all().getC(this.race)).index();
/* 118 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 123 */     this.signedUp = 0;
/* 124 */     this.amountTotal = 0;
/* 125 */     super.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean setStart(COORDINATEE res, int sx, int sy, int dist) {
/* 130 */     for (int i = 0; i < 100000; i++) {
/* 131 */       int distX = RND.rInt(dist + 1);
/* 132 */       int distY = dist + 1 - distX;
/* 133 */       int tx = (int)(sx + RND.rSign() * (distX + RND.rInt(1 + i)));
/* 134 */       int ty = (int)(sy + RND.rSign() * (distY + RND.rInt(1 + i)));
/* 135 */       if ((SETT.ENV()).map.SPACE.get(tx, ty) == 1.0D && isPlacable(tx, ty)) {
/* 136 */         res.set(tx, ty);
/* 137 */         return true;
/*     */       } 
/*     */     } 
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validate() {
/* 145 */     if ((SETT.ENV()).map.SPACE.get(x(), y()) < 1.0D || !isPlacable(x(), y())) {
/* 146 */       return setStart((COORDINATEE)this, THRONE.coo().x(), THRONE.coo().y(), 128);
/*     */     }
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isPlacable(int cx, int cy) {
/* 153 */     int amount = (Config.battle()).MEN_PER_DIVISION;
/* 154 */     int w = (int)Math.ceil(Math.sqrt(amount));
/*     */     
/* 156 */     for (int y = 0; y < w; y++) {
/* 157 */       for (int x = 0; x < w; x++) {
/* 158 */         if (!placable(cx - w / 2 + x, cy - w / 2 + y))
/* 159 */           return false; 
/*     */       } 
/*     */     } 
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean placable(int tx, int ty) {
/* 167 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/* 168 */       return false;
/*     */     }
/* 170 */     if ((SETT.PATH()).solidity.is(tx, ty) || !(SETT.PATH()).reachability.is(tx, ty)) {
/* 171 */       return false;
/*     */     }
/*     */     
/* 174 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\slave\UprisingSpot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */