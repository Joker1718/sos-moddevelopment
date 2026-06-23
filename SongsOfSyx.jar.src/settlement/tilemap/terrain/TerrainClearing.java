/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
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
/*     */ public abstract class TerrainClearing
/*     */ {
/*     */   public boolean isStructure() {
/*  19 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean can();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needs() {
/*  37 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract RESOURCE clear1(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int clearAll(int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   public boolean canDestroy(int tx, int ty) {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public void destroy(int tx, int ty) {
/*  54 */     (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/*     */   }
/*     */   
/*     */   public double strength() {
/*  58 */     return 32000.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract SoundRace sound(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEasilyCleared() {
/*  71 */     return false;
/*     */   }
/*     */   
/*  74 */   static final TerrainClearing dummy = new TerrainClearing()
/*     */     {
/*     */       public boolean can()
/*     */       {
/*  78 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean needs() {
/*  83 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty) {
/*  88 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean canDestroy(int tx, int ty) {
/*  93 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void destroy(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public double strength() {
/* 104 */         return 0.0D;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/* 111 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/* 116 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isStructure() {
/* 121 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEasilyCleared() {
/* 126 */         return true;
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TerrainClearing.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */