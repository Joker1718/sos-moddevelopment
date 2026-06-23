/*     */ package world.map.regions;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.Faction;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import world.WORLD;
/*     */ import world.region.RD;
/*     */ import world.region.Realm;
/*     */ 
/*     */ public class Region
/*     */   implements MAP_BOOLEAN, BOOSTABLE_O, INDEXED
/*     */ {
/*     */   private final short index;
/*  21 */   public final RegionInfo info = new RegionInfo();
/*     */   
/*     */   Region(int index) {
/*  24 */     this.index = (short)index;
/*  25 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  30 */     return this.index;
/*     */   }
/*     */   
/*     */   public boolean besieged() {
/*  34 */     return WORLD.BATTLES().besiged(this);
/*     */   }
/*     */   
/*     */   void save(FilePutter f) {
/*  38 */     this.info.save(f);
/*     */   }
/*     */   
/*     */   void load(FileGetter f) throws IOException {
/*  42 */     this.info.load(f);
/*     */   }
/*     */   
/*     */   void clear() {
/*  46 */     this.info.clear();
/*     */   }
/*     */   
/*     */   public Faction faction() {
/*  50 */     Realm realm = realm();
/*  51 */     if (realm != null)
/*  52 */       return realm.faction(); 
/*  53 */     return null;
/*     */   }
/*     */   
/*     */   public Realm realm() {
/*  57 */     return RD.REALM(this);
/*     */   }
/*     */   
/*     */   public COLOR color() {
/*  61 */     if (faction() != null)
/*  62 */       return (COLOR)faction().banner().colorBG(); 
/*  63 */     return COLOR.WHITE65;
/*     */   }
/*     */   
/*     */   public void fationSet(Faction f, boolean log) {
/*  67 */     RD.setFaction(this, f, log);
/*     */   }
/*     */   
/*     */   public void setCapitol() {
/*  71 */     RD.setCapitol(this);
/*     */   }
/*     */   
/*     */   public boolean capitol() {
/*  75 */     if (realm() == null)
/*  76 */       return false; 
/*  77 */     return (realm().capitol() == this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSetCapitol() {
/*  82 */     if (faction() == null) {
/*  83 */       return false;
/*     */     }
/*  85 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int cx() {
/*  90 */     return this.info.cx();
/*     */   }
/*     */   
/*     */   public int cy() {
/*  94 */     return this.info.cy();
/*     */   }
/*     */   
/*     */   public boolean active() {
/*  98 */     return (this.info.area() > 0 && (WORLD.REGIONS()).map.is(cx(), cy()));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     return String.valueOf(this.info.name()) + " " + String.valueOf(this.info.name()) + " " + cx() + " " + cy() + " " + this.info.area();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 108 */     return ((WORLD.REGIONS()).map.get(tile) == this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 113 */     return ((WORLD.REGIONS()).map.get(tx, ty) == this);
/*     */   }
/*     */ 
/*     */   
/*     */   public double boostableValue(BValue v) {
/* 118 */     return v.vGet(this);
/*     */   }
/*     */   
/*     */   public boolean isBesigeTile(int tx, int ty) {
/* 122 */     if (WORLD.REGIONS().centreEdgeTile().is(tx, ty) && 
/* 123 */       (WORLD.PATH()).map.is.is(tx, ty) && (WORLD.REGIONS()).centre.get(tx, ty) != this)
/*     */     {
/* 125 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 126 */         DIR d = (DIR)DIR.ALL.get(di);
/* 127 */         if (((WORLD.PATH()).map.can(tx, ty, d) & (((WORLD.REGIONS()).centre.get(tx + d.x(), ty + d.y()) == this) ? 1 : 0)) != 0) {
/* 128 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 134 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Region.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */