/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TIndoors
/*     */   implements MAP_BOOLEAN
/*     */ {
/*  19 */   private final Bitmap2D reservable = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */   private int x;
/*     */   
/*  22 */   final SAVABLE saver = new SAVABLE()
/*     */     {
/*     */       public void save(FilePutter file)
/*     */       {
/*  26 */         TIndoors.this.reservable.save(file);
/*     */       }
/*     */ 
/*     */       
/*     */       public void load(FileGetter file) throws IOException {
/*  31 */         TIndoors.this.reservable.load(file);
/*     */       }
/*     */ 
/*     */       
/*     */       public void clear() {
/*  36 */         TIndoors.this.reservable.clear();
/*     */       }
/*     */     };
/*     */   private int y;
/*     */   boolean remove(int tx, int ty) {
/*  41 */     if (is(tx, ty)) {
/*  42 */       this.x = tx;
/*  43 */       this.y = ty;
/*  44 */       if (this.service.findableReservedCanBe()) {
/*  45 */         this.service.findableReserve();
/*  46 */         return false;
/*     */       } 
/*  48 */       this.reservable.set(tx, ty, false);
/*  49 */       return true;
/*     */     } 
/*  51 */     this.reservable.set(tx, ty, false);
/*  52 */     return false;
/*     */   }
/*     */   
/*     */   void add(int tx, int ty, boolean reserved) {
/*  56 */     if (is(tx, ty)) {
/*  57 */       this.x = tx;
/*  58 */       this.y = ty;
/*  59 */       this.service.findableReserveCancel();
/*  60 */       if (reserved)
/*  61 */         this.service.findableReserve(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public FINDABLE findable(int tx, int ty) {
/*  66 */     if (is(tx, ty)) {
/*  67 */       this.x = tx;
/*  68 */       this.y = ty;
/*  69 */       return this.service;
/*     */     } 
/*  71 */     return null;
/*     */   }
/*     */   
/*  74 */   private final FINDABLE service = new FINDABLE()
/*     */     {
/*     */ 
/*     */       
/*     */       public int x()
/*     */       {
/*  80 */         return TIndoors.this.x;
/*     */       }
/*     */ 
/*     */       
/*     */       public int y() {
/*  85 */         return TIndoors.this.y;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean findableReservedCanBe() {
/*  90 */         return TIndoors.this.reservable.is(TIndoors.this.x + TIndoors.this.y * SETT.TWIDTH);
/*     */       }
/*     */ 
/*     */       
/*     */       public void findableReserve() {
/*  95 */         if (!findableReservedCanBe()) {
/*  96 */           throw new RuntimeException();
/*     */         }
/*     */         
/*  99 */         (SETT.PATH()).finders.indoor.report(this, -1);
/* 100 */         TIndoors.this.reservable.set(TIndoors.this.x + TIndoors.this.y * SETT.TWIDTH, false);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean findableReservedIs() {
/* 105 */         return !TIndoors.this.reservable.is(TIndoors.this.x + TIndoors.this.y * SETT.TWIDTH);
/*     */       }
/*     */ 
/*     */       
/*     */       public void findableReserveCancel() {
/* 110 */         if (findableReservedIs()) {
/* 111 */           TIndoors.this.reservable.set(TIndoors.this.x + TIndoors.this.y * SETT.TWIDTH, true);
/* 112 */           (SETT.PATH()).finders.indoor.report(this, 1);
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 120 */     return (SETT.TERRAIN().get(tile).roofIs() && ((SETT.PATH()).availability.get(tile)).player > 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 125 */     return (SETT.TERRAIN().get(tx, ty).roofIs() && ((SETT.PATH()).availability.get(tx, ty)).player > 0.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TIndoors.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */