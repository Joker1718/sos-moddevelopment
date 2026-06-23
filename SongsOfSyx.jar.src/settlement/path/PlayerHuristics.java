/*     */ package settlement.path;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import util.updating.TileUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PlayerHuristics
/*     */   implements PathGame.COST
/*     */ {
/*  22 */   private final byte[] counts = Alloc.bb(SETT.TAREA);
/*  23 */   public final MAP_DOUBLE getter = new MAP_DOUBLE()
/*     */     {
/*     */       public double get(int tx, int ty)
/*     */       {
/*  27 */         return get(tx + ty * SETT.TWIDTH);
/*     */       }
/*     */ 
/*     */       
/*     */       public double get(int tile) {
/*  32 */         return PlayerHuristics.I * (PlayerHuristics.this.counts[tile] & 0xFF);
/*     */       }
/*     */     };
/*     */   
/*  36 */   private final TileUpdater updater = new TileUpdater(SETT.TWIDTH, SETT.THEIGHT, 512.0D)
/*     */     {
/*     */       
/*     */       protected void update(int tx, int ty, int i, double timeSinceLast)
/*     */       {
/*  41 */         if (PlayerHuristics.this.counts[i] != 0) {
/*  42 */           PlayerHuristics.this.counts[i] = (byte)((PlayerHuristics.this.counts[i] & 0xFF) / 16);
/*     */         }
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */   
/*     */   public PlayerHuristics() {
/*  51 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  55 */           file.bs(PlayerHuristics.this.counts);
/*  56 */           PlayerHuristics.this.updater.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  61 */           file.bs(PlayerHuristics.this.counts);
/*  62 */           PlayerHuristics.this.updater.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  67 */           Arrays.fill(PlayerHuristics.this.counts, (byte)0);
/*  68 */           PlayerHuristics.this.updater.clear();
/*     */         }
/*     */       };
/*     */   }
/*     */   public void set(int tx, int ty) {
/*  73 */     int i = tx + ty * SETT.TWIDTH;
/*  74 */     if (this.counts[i] != -1) {
/*  75 */       this.counts[i] = (byte)((this.counts[i] & 0xFF) + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   void update(double ds) {
/*  80 */     this.updater.updateRandom(ds);
/*     */   }
/*     */   
/*     */   public double getCost(int fromX, int fromY, DIR d) {
/*  84 */     return getCost(fromX, fromY, fromX + d.x(), fromY + d.y());
/*     */   }
/*     */   
/*  87 */   private static double I = 0.001953125D;
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(int fromX, int fromY, int toX, int toY) {
/*  92 */     AVAILABILITY a = SETT.PATH().getAvailability(toX, toY);
/*  93 */     if (a.player < 0.0D) {
/*  94 */       return -1.0D;
/*     */     }
/*  96 */     if (fromX != toX && fromY != toY && (
/*  97 */       (SETT.PATH().getAvailability(fromX, toY)).player <= -1.0D || (SETT.PATH().getAvailability(toX, fromY)).player <= -1.0D)) {
/*  98 */       return -2.0D;
/*     */     }
/*     */ 
/*     */     
/* 102 */     int i = toX + toY * SETT.TWIDTH;
/* 103 */     double pen = 1.0D + ((this.counts[i] != 0) ? ((this.counts[i] & 0xFF) * I) : 0.0D);
/*     */     
/* 105 */     return a.player * pen + (SETT.PATH().getAvailability(fromX, fromY)).from;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\PlayerHuristics.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */